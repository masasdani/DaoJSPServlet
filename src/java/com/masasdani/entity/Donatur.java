/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.entity;

/**
 *
 * @author badak
 */
public class Donatur {
    int id;
    String nama;
    String Alamat;

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}
