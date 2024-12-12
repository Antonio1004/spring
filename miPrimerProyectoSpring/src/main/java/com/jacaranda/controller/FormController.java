package com.jacaranda.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Calculator;

@Controller
public class FormController {

	@GetMapping({"form.html"})
	public String Operation(Model model,
	@RequestParam(required = false, defaultValue = "0") String n1,
	@RequestParam(required = false, defaultValue = "0") String n2) {
		
		Calculator c = new Calculator();
		try {
			c.setN1(Integer.valueOf(n1));
			c.setN2(Integer.valueOf(n2));
			model.addAttribute("answer", c.sumar());
		} catch (Exception e) {
			
		}
		
		
		
		return "form";
	}
}
