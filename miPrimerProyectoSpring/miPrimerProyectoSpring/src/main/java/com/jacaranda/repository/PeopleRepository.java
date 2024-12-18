package com.jacaranda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jacaranda.model.Character;

public interface PeopleRepository extends JpaRepository<Character, Integer> {

}
