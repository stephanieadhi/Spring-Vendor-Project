package com.project.Vendor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vendor.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Optional<Account> findByUsername(String username);
	
	boolean existsByUsername(String username);
}
