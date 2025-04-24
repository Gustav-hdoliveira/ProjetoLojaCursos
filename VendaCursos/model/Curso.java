/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class Curso {
    int id_curso;
    String titulo;
    String[] texto;
    int preco;
    
    public Curso(int id_curso, String titulo, String[] texto, int preco) {
        this.id_curso = id_curso;
        this.titulo = titulo;
        this.texto = texto;
        this.preco = preco;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String[] texto) {
        this.texto = texto;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getId_curso() {
        return id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getTexto() {
        return texto;
    }

    public int getPreco() {
        return preco;
    }

    
}
