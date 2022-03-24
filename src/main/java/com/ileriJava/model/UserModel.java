package com.ileriJava.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "User")
@EqualsAndHashCode(callSuper = true)
public class UserModel extends  BaseEntity{


        @Column(name = "NAME")
        private String name;


        @Column(name = "SURNAME")
        private Long surname;

}
