package com.herokuapp.colorebackend.Colore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping
	public String getHello() {
		return "Estou funcionando! Acesse Front-End = https://colore-front-end.herokuapp.com/";
	}
}
