package com.akioandrei.workshopspringbootWalletControl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akioandrei.workshopspringbootWalletControl.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
