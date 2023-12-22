package com.example.COnline.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

import javax.management.relation.Role;
import java.util.Collection;

import java.time.LocalDateTime;


@NoArgsConstructor
@Entity(name="Users")
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Roles> roles;
    @CreationTimestamp
    private LocalDateTime date_created;

    public Long getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

}
