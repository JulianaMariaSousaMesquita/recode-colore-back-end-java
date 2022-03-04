package com.herokuapp.colorebackend.Colore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping
	public String getHello() {
		return "Estou funcionando!";
	}
}
