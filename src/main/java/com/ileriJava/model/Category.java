package com.ileriJava.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author furkancelik
 **/

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", columnDefinition = "TEXT")
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    // rolü personel olan ve kategori ile ilgilenecek personel
    // bir personel birden fazla kategoriye bakabilir o nedenle many to one
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User personnel;
}
