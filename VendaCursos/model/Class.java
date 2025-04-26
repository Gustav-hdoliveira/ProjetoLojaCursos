/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

import com.example.VendaCursos.services.StringDivider;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class Class {
    int id_class;
    String title;
    String[] text;
    int price;
    
    public Class(int id_class, String title, String textFull, double chunks, int price) {
        this.id_class = id_class;
        this.title = title;
        text = StringDivider.divideString(textFull, chunks);
        this.price = price;
    }

    public void setid_class(int id_class) {
        this.id_class = id_class;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public int getId_class() {
        return id_class;
    }

    public String getTitle() {
        return title;
    }

    public String[] getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    
}
