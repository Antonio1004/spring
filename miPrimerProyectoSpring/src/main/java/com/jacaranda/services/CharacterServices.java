package com.jacaranda.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.model.Character;

@Service
public class CharacterServices {

    private static List<Character> list = new ArrayList<>();

    public List<Character> getCharacter() {
        // Inicializar la lista si está vacía
        if (list.isEmpty()) {
            list.add(new Character("1", "Antonio", "Rios", "8888", "Sevilla", 19));
            list.add(new Character("2", "Pepe", "Perez", "7777", "Lora", 49));
            list.add(new Character("3", "Luis", "Montes", "4444", "Écija", 30));
            list.add(new Character("4", "Leo", "Messi", "1010", "Miami", 35));
        }
        return list;
    }

    public boolean deleteCharacterById(int id) {
        // Buscar y eliminar el elemento con el ID especificado
        return list.removeIf(character -> Integer.parseInt(character.getId()) == id);
    }

    public boolean addCharacter(Character c) {
        return list.add(c);
    }
}
