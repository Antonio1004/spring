package com.jacaranda.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.jacaranda.model.Person;

@Controller
public class ControllerMain {
	//Esto tiene que estar en una carpeta a la misma altura que la aplicación principal
	@GetMapping({"/", "index.html"})
	public String Welcome(Model model, @RequestParam() Optional<String> name) {
		/*
		 * Puedes usar o el Optional<E> o el param=value, required = false etc...*/
		Person p = new Person();
		p.setName("Antonio");
		p.setSurname("Rios");
		model.addAttribute("person", p);
		model.addAttribute("age", 20);
		if (name.orElse("Desconocido").equals("Anto")) {
			model.addAttribute("nombre", "The GOAT");
		} else {
			model.addAttribute("nombre", name.orElse("Desconocido"));
		}
		
		
		
		return "index";
	}
	

	
}
