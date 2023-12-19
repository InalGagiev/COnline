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
@Entity(name="Manga")
@Table(name="manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String age_limit;
    private String chapters;
    private String description;
    @CreationTimestamp
    private LocalDateTime date_created;
    private String release_type;
    @ManyToOne
    private Author author;
}
