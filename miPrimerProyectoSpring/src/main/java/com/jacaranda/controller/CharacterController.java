package com.jacaranda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		return "addPeople";
	}
	
	@PostMapping("/character/add")
	public String addCharactersPost(Model model, @ModelAttribute Character p) {
		
		if (!characterService.addCharacter(p)) {
			model.addAttribute("msg", "error al añadir");
		} else {
			model.addAttribute("msg", "La persona" +p.getName()+" se ha añadido");
		}
		
		model.addAttribute("character", new Character());
		return "addPeople";
	}
	@GetMapping("/character/delete/{id}")
    public String deleteCharacter(@PathVariable("id") int id, Model model) {
        if (characterService.deleteCharacterById(id)) {
            model.addAttribute("msg", "El personaje ha sido eliminado correctamente.");
        } else {
            model.addAttribute("msg", "Error al intentar eliminar el personaje.");
        }
        
        // Recarga la lista actualizada
        List<Character> listCharacters = characterService.getCharacter();
        model.addAttribute("list", listCharacters);

        return "listCharacter";
    }

	
	
}
