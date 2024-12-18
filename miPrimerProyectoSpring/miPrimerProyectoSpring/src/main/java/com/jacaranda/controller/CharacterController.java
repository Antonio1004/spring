package com.jacaranda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Character;
import com.jacaranda.services.CharacterServices;
@Controller	
public class CharacterController {

	@Autowired
	CharacterServices characterService;
	@GetMapping("/character")
	public String listCharacter (Model model) {
		
		List<Character> listCharacters = characterService.getCharacter();
		model.addAttribute("list", listCharacters);
		return "listCharacter";
	}
	
	@GetMapping("/character/add")
	public String addCharacterGet(Model model) {
		model.addAttribute("character", new Character());
		model.addAttribute("action", "add");
		model.addAttribute("enable", true);
		
		return "addPeople";
	}
	
	@PostMapping("/character/add")
	public String addCharactersPost(Model model, @ModelAttribute Character p) {
		Character newPeople=characterService.addCharacter(p);
		
		if (newPeople==null) {
			model.addAttribute("msg", "error al añadir");
		} else {
			model.addAttribute("msg", "La persona " +p.getName()+" se ha añadido");
		}
		
		model.addAttribute("character", new Character());
		return "addPeople";
	}
	
	@GetMapping("/character/delete")
	public String deleteCharactersGET(Model model, @RequestParam Integer id)  {
		try {
		    Character c = characterService.getCharacter(id); // Obtén los datos del personaje
		    characterService.deleteCharacter(c);
		} catch (Exception e	) {
			// TODO: handle exception
		}
		return null;
	    
	    
	}

	
	
}
