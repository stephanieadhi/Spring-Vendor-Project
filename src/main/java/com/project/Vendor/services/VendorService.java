package com.project.Vendor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vendor.entities.Vendor;
import com.project.Vendor.repositories.VendorRepository;

import jakarta.transaction.Transactional;

@Service
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;
	
	public Vendor findById(Long id) {
		return vendorRepository.findById(id).get();
	}
	
	public List<Vendor> getAll(){
		return vendorRepository.findAll();
	}
	
	@Transactional
	public void add(String vendorname){
		Vendor vendor = new Vendor();
	    vendor.setVendorname(vendorname);
		vendorRepository.save(vendor);
	}

	@Transactional
	public void edit(Vendor vendor) {
		Vendor editedVendor = findById(vendor.getId());
		if (editedVendor == null) {
	        throw new RuntimeException("Vendor with ID " + vendor.getId() + " does not exist.");
	    }
		editedVendor.setVendorname(vendor.getVendorname());
		vendorRepository.save(editedVendor);
	}

	@Transactional
	public void delete(Long id) {
		Vendor deletedVendor = findById(id);
		if (deletedVendor == null) {
	        throw new RuntimeException("Vendor with ID " + id + " does not exist.");
	    }
		vendorRepository.delete(deletedVendor);
	}
}
