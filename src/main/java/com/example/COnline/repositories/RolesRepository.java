package com.example.COnline.repositories;

import com.example.COnline.Entitys.Manga;
import com.example.COnline.Entitys.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}