package com.ileriJava.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSONEL")
@Getter
@Setter
public class Personel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Category> categories;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
