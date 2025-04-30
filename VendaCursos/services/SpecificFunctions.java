/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.services;

import com.example.VendaCursos.model.Course;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author PC GAMER
 */
public class SpecificFunctions {
    public static ArrayList<String> textCompacter(String text, String text1, String text2, String text3, String text4, String text5){
        ArrayList<String> textArray = new ArrayList<>();
        textArray.add(text); textArray.add(text1); textArray.add(text2); textArray.add(text3); textArray.add(text4); textArray.add(text5);
        return textArray;
    }
    
    public static int checkChunks(String text, String text1, String text2, String text3, String text4, String text5){
        int i = 0;
        int chunks = 0;
        ArrayList<String> textArray = new ArrayList<>();
        textArray.add(text); textArray.add(text1); textArray.add(text2); textArray.add(text3); textArray.add(text4); textArray.add(text5);
        while(i < textArray.size()){
            if("".equals(textArray.get(i))){
                chunks++;
            }
            i++;
        }
        return i;
    }
    
    public static ArrayList<String> returnTitles(ArrayList<Course> array){
        int i = 0;
        ArrayList<String> titles = new ArrayList<>();
        while(i < array.size()){
            Course course = array.get(i);
            titles.add(course.getTitle());
            i++;
        }
        return titles;
    }
    
    public static void configChunks(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e, JTextField f, Course course){
        switch(course.getChunks()) {
            case 1:
                a.setText((String) course.getText().get(0));
                break;
            case 2:
                a.setText((String) course.getText().get(0));
                b.setText((String) course.getText().get(1));
    // code block
                break;
            case 3:
                a.setText((String) course.getText().get(0));
                b.setText((String) course.getText().get(1));
                c.setText((String) course.getText().get(2));
                
                break;
           case 4:
               a.setText((String) course.getText().get(0));
               b.setText((String) course.getText().get(1));
               c.setText((String) course.getText().get(2));
               d.setText((String) course.getText().get(3));
                
                break;
           case 5:
               a.setText((String) course.getText().get(0));
               b.setText((String) course.getText().get(1));
               c.setText((String) course.getText().get(2));
               d.setText((String) course.getText().get(3));
               e.setText((String) course.getText().get(4));
                
                break;
           case 6:
               a.setText((String) course.getText().get(0));
               b.setText((String) course.getText().get(1));
               c.setText((String) course.getText().get(2));
               d.setText((String) course.getText().get(3));
               e.setText((String) course.getText().get(4));
               f.setText((String) course.getText().get(5));
                
                break;
            default:
                a.setText("error");
    // code block
}
    }
}
