package com.ileriJava.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import com.ileriJava.model.FaultRecords;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Personal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personalid", nullable = false)
    private Long personalid;


    //Personelde Aslında Birtane Userdir personelin hangi user bilgisine sahip olduğunu tutar
    @OneToOne
    @JoinColumn(name = "Userid", referencedColumnName = "userid")
    private User userid;
}
