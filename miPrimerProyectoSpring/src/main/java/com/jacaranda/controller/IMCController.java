package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.IMCCalculator;

@Controller
public class IMCController {

	@GetMapping({"imc.html"})
	public String Calculator(Model model, 
	@RequestParam(required = false) String height,
	@RequestParam(required = false) String weight) {
		
		IMCCalculator imc = new IMCCalculator();
		try {
			
			imc.setHeight(Float.valueOf(height));
			imc.setWeight(Float.valueOf(weight));
			model.addAttribute("imc", imc.calculateIMC());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "imc";
	}
	
}
