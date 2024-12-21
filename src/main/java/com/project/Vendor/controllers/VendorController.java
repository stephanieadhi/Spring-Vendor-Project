package com.project.Vendor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.project.Vendor.entities.Vendor;
import com.project.Vendor.services.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@PostMapping(value = "/vendor/add")
	public RedirectView addVendor(@RequestParam String vendorname) {
		vendorService.add(vendorname);
		return new RedirectView("/home");
    }
	
	@PutMapping(value = "/vendor/edit")
	public ResponseEntity<String> editVendor(@RequestBody Vendor vendor) {
	    vendorService.edit(vendor);
	    return ResponseEntity.ok("Vendor Updated Successfully");
	}
	
//	@DeleteMapping(value = "/delete")
//	public RedirectView delete(@RequestParam Long id) {
//		vendorService.delete(id);
//		return new RedirectView("/home");
//	}
	
	 @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteVendor(@RequestParam Long id) {
        try {
            vendorService.delete(id);
            return new ResponseEntity<>("Vendor deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting vendor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
