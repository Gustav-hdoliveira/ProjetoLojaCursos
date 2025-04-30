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
public class Course {
    int id_class;
    String title;
//    String fullText;
    ArrayList<String> text;
    int chunks;
    double price;
    
    public Course(String title, double price) {
        this.title = title;
        text = new ArrayList<>();
        this.price = price;
    }

    public void setid_class(int id_class) {
        this.id_class = id_class;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTextArray(String textFull, int chunks) {
        text = StringDivider.divideString(textFull, chunks);
        this.chunks = chunks;
    }
    
    public void setFullArrayText(ArrayList<String> array, int chunks){
        text = array;
        this.chunks = chunks;
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

    public ArrayList getText() {
        return text;
    }

    public double getPrice() {
        return price;
    }

    public int getChunks(){
        return chunks;
    }
}
