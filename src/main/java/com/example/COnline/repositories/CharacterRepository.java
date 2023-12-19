package com.example.COnline.repositories;

import com.example.COnline.Entitys.Character;
import com.example.COnline.Entitys.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}