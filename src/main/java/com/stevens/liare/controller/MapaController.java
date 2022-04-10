package com.stevens.liare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mapa")
public class MapaController {
	private Logger logger = LoggerFactory.getLogger(CategoriaController.class);	
	
	@GetMapping("view")
	public String viewMapa() {
		
		System.out.println("entro mapas");
		
		return "app/mapa/map :: fragMapa";

	}

}
