package com.example.COnline.repositories;

import com.example.COnline.Entitys.MangaGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaGenreRepository extends JpaRepository<MangaGenre, Long> {
}