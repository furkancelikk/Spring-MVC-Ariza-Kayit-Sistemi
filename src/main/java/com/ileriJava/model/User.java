package com.ileriJava.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "kullaniciadi", nullable = false)
    private String kullaniciadi;
    @Column(name = "ad", nullable = false)
    private String ad;
    @Column(name = "soyad", nullable = false)
    private String soyad;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "sifre", nullable = false)
    private String sifre;
    @Column(name = "sistemrol", nullable = false)
    private String sistemrol;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getKullaniciadi() {
        return kullaniciadi;
    }
    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public String getSistemrol() {
        return sistemrol;
    }
    public void setSistemrol(String sistemrol) {
        this.sistemrol = sistemrol;
    }

}