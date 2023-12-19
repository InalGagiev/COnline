package com.example.COnline.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="MangaCharacter")
@Table(name="mangaGenre")
public class MangaCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Character character;

    @ManyToOne
    private Manga manga;
}