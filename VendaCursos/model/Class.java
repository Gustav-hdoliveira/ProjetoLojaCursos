/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

import com.example.VendaCursos.services.StringDivider;
import java.util.ArrayList;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class Class {
    int id_class;
    String title;
    ArrayList<Integer> text;
    double price;
    
    public Class(String title, String textFull, int chunks, int opcion, double price) {
        this.title = title;
        text = new ArrayList<>();
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

    public double getPrice() {
        return price;
    }

    
}
