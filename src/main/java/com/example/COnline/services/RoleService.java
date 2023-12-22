package com.example.COnline.services;

import com.example.COnline.Entitys.Roles;
import com.example.COnline.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RolesRepository roleRepository;

    public Roles getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}