package com.akioandrei.workshopspringbootWalletControl.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.akioandrei.workshopspringbootWalletControl.Entity.Transaction;
import com.akioandrei.workshopspringbootWalletControl.Entity.User;
import com.akioandrei.workshopspringbootWalletControl.Repository.TransactionRepository;
import com.akioandrei.workshopspringbootWalletControl.Repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	@Override
	public void run(String... args) throws Exception{
		
		User u1 = new User(null, "Akio Andrei", "akio@gmail.com", "1234", "1234");
		
		User u2 = new User(null, "Leoni", "leoni@gmail.com", "4321", "4321");
		
		User u3 = new User(null, "Maikola", "maikola@gmail.com", "2468", "2468");
		
		Transaction t1 = new Transaction(null,"Restaurante", -69.79, Instant.parse("2022-03-19T21:53:07Z"), u1);
		Transaction t2 = new Transaction(null,"Salário", 1300.00, Instant.parse("2022-03-04T03:00:07Z"), u1);
		Transaction t3 = new Transaction(null,"Pix", 99.59, Instant.parse("2022-03-21T20:42:07Z"), u2);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		transactionRepository.saveAll(Arrays.asList(t1,t2,t3));
	}
	
}
