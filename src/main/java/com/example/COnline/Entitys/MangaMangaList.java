package com.example.COnline.Entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="MangaMangaList")
@Table(name="mangaMangaList")
public class MangaMangaList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private MangaList mangaList;

    @ManyToOne
    private Manga manga;
}
