package com.project.Vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Vendor.entities.Vendor;
import com.project.Vendor.services.VendorService;

@Controller
public class AppController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
	
	@GetMapping(value = "/home")
	public String home(Model model) {
        List<Vendor> vendors = vendorService.getAll();
        
        model.addAttribute("vendors", vendors);

        return "home";  
    }
	
	@GetMapping(value = "/add")
	public String add() {
        return "add";  
    }
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Vendor vendor = vendorService.findById(id);
        model.addAttribute("vendor", vendor);
        return "edit";  
    }
}
