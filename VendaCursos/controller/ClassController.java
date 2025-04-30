/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.controller;

import com.example.VendaCursos.model.ClassDAO;
import com.example.VendaCursos.model.Course;
import java.util.ArrayList;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ClassController {
    ClassDAO DAO = new ClassDAO();
    
    public boolean registerClass(String title, ArrayList<String> text, double price, int chunks){
        Course Ncourse = new Course(title, price);
        Ncourse.setFullArrayText(text, chunks);
        return DAO.registerClass(Ncourse);
    }
    
    public ArrayList<Course> getClasses(){
        return DAO.getClasses();
    }
    
    public ArrayList<Course> getClassByTitle(String title){
        return DAO.getClassByTitle(title);
    }
    
    public Course getClassById(Course course){
         ArrayList<Course> courses = DAO.getClassById(course.getId_class());
         return courses.get(0);
    }
}
