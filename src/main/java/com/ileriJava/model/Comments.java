package com.ileriJava.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Comments")
@Getter
@Setter
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    //yorumun oluşturulma zamanını tutar
    @Column(name = "CREATION_TIME", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationTime;


    //yorumun içeriğini belirtir
    @Column(name = "CONTEXT", nullable = false, columnDefinition = "TEXT")
    private String context;


    //Bir Kullanıcı birden fazla yorum oluşturabilir
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    //Bir Başlıkta Birden fazla yorum olabilir yorumun hangi başlık altında olduğunu söyler
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FAULT_ID", referencedColumnName = "ID")
    private FaultRecords faultRecord;
}
