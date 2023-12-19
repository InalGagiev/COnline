package com.example.COnline.repositories;

import com.example.COnline.Entitys.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
}