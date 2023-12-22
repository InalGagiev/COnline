package com.example.COnline.services;

import com.example.COnline.Entitys.Roles;
import com.example.COnline.Entitys.Users;
import com.example.COnline.Models.requests.RegistrationDto;
import com.example.COnline.repositories.RolesRepository;
import com.example.COnline.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RolesRepository roleRepository;

    private final RoleService roleService;

    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public Users createNewUser(RegistrationDto registrationUserDto) {
        Users user = new Users();
        user.setName(registrationUserDto.getUsername());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(registrationUserDto.getPassword());
        user.setRoles(List.of(roleService.getUserRole()));
        return userRepository.save(user);
    }

}