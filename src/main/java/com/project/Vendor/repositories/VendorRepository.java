package com.project.Vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vendor.entities.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

}
