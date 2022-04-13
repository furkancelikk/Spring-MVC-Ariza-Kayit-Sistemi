package com.ileriJava.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Long userid;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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