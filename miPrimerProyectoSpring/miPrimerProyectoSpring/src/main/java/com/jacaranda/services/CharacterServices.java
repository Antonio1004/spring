package com.jacaranda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Character;
import com.jacaranda.repository.PeopleRepository;

@Service
public class CharacterServices {

	@Autowired
	PeopleRepository peopleRepository;
	
	public List<Character> getCharacter() {
		

		
		return peopleRepository.findAll();
	}
	
	public Character addCharacter(Character c) {
		Character result=null;
		try {
			result=peopleRepository.save(c);
			
		} catch (Exception e) {
			// TOD exception
		}
		return result;
	}
	
	public Character getCharacter(Integer characterID)  throws Exception {
		Character c = new Character();
		c=peopleRepository.findById(characterID).orElse(null);
		if(c==null) throw new Exception("Persona no encontrada");
		return c;
		
	}
	
	public void deleteCharacter(Character c) {
		peopleRepository.delete(c);
	}
	
	
}
