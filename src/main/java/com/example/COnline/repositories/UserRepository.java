package com.example.COnline.repositories;
import com.example.COnline.Entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Role> findByUsername(String name);
}