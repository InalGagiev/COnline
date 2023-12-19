package com.example.COnline.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="MangaList")
@Table(name="mangaList")
public class MangaList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @CreationTimestamp
    private LocalDateTime date_created;
    @ManyToOne
    private Users user;
}
