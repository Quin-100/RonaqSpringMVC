package com.ronaq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Register {
	
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/register")
	public String loadregister(Model model) {
		model.addAttribute("user", new User());
		//model.addAttribute("listState",getStateList());
		return "register";
	}
	
	// For add and update person both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	//@ExceptionHandler({ CustomException.class })
	public String addUser(@ModelAttribute("user") User u,BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {			
				if (u.getId() == null || u.getId() == 0) {
						// new user, add it		
						//User user = handleFileUpload(result, fileUpload, u);					
						
						this.userService.createUser(u);
				} else {
						// existing person, call update
						//this.employeeDetailsService.updateEmployeeDetails(p);
				}
				return "redirect:/register";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
		return "register";

	}			
	
    /*public User handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload, User u) {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){                  
                System.out.println("Saving file: " + aFile.getOriginalFilename()); 
                u.setPhoto(aFile.getBytes());                             
            }
        }  
        return u;
    }  */
	
	
}

