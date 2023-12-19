package com.example.COnline.repositories;

import com.example.COnline.Entitys.Character;
import com.example.COnline.Entitys.MangaMangaList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaMangaListRepository extends JpaRepository<MangaMangaList, Long> {
}