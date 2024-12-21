package com.project.Vendor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Vendor.entities.Account;
import com.project.Vendor.repositories.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping(value = "/addacc", consumes = "application/json")
	public ResponseEntity<String> addAccount(@RequestBody Account account) {
	    if (accountRepository.existsByUsername(account.getusername())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body("Error: Username '" + account.getusername() + "' already exists.");
	    }

	    account.setPassword(passwordEncoder.encode(account.getPassword()));
	    accountRepository.save(account);
	    return ResponseEntity.ok("Account Added Successfully");
	}
}
