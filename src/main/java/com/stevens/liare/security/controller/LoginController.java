package com.stevens.liare.security.controller;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {	
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MessageSource messageSource;	
	
	
	@GetMapping({"/","/login"})
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash, Locale locale) {
	
		logger.info("login========="+principal);
		
		if(principal != null) {
			logger.info("inicio========="); 
			flash.addFlashAttribute("info", messageSource.getMessage("text.login.already", null, locale));			
			return "redirect:/inicio";			
		}

		if(error != null) {
			model.addAttribute("error", messageSource.getMessage("text.login.error", null, locale));				
		}

		if(logout != null) {
			model.addAttribute("success", messageSource.getMessage("text.login.logout", null, locale));			
		}

		return "login";
	}


	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model,Authentication authentication,
			HttpServletRequest request) {	
		
		logger.info("inicio========="); 

		return "app/inicio";
		//return "index";
	}
	
	
	@RequestMapping(value = "/error_403", method = RequestMethod.GET)
	public String error_403(Model model) {		
		return "redirect:/error403";				
	}	
	
	@RequestMapping(value = "/error403", method = RequestMethod.GET)
	public String error403(Model model) {	
		
		logger.info("error 403========="); 

		return "error_403";
		
	}

}
