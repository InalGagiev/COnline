package com.example.COnline.repositories;

import com.example.COnline.Entitys.MangaCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaCharacterRepository extends JpaRepository<MangaCharacter, Long> {
}