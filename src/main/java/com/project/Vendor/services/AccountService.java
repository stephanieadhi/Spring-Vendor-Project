package com.project.Vendor.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.Vendor.entities.Account;
import com.project.Vendor.repositories.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountRepository.findByUsername(username);
		
		if (account.isPresent()) {
			var accountObj = account.get();
			return User.builder()
					.username(accountObj.getusername())
					.password(accountObj.getPassword())
					.build();
		}else {
			throw new UsernameNotFoundException(username);
		}
	}

}
