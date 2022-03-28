package com.akioandrei.workshopspringbootWalletControl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.akioandrei.workshopspringbootWalletControl.Entity.Transaction;
import com.akioandrei.workshopspringbootWalletControl.Repository.TransactionRepository;
import com.akioandrei.workshopspringbootWalletControl.Resource.Exceptions.DatabaseException;
import com.akioandrei.workshopspringbootWalletControl.Service.Exception.ResourceNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public List<Transaction> findAll() {
		return repository.findAll();
	}

	public Transaction findByID(Long id) {
		Optional<Transaction> obj = repository.findById(id);
		return obj.get();
	}

	public Transaction insert(Transaction obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
