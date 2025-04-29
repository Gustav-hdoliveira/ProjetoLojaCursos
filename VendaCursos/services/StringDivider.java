/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.services;

import java.util.ArrayList;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class StringDivider {
    
    public static ArrayList<String> divideString(String text, int chunkSize) {
        ArrayList<String> NewChunks = null;
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("Chunk size must be greater than 0");
        }

        int numChunks = (int) Math.ceil((double) text.length() / chunkSize);
        String[] chunks = new String[numChunks];

        for (int i = 0; i < numChunks; i++) {
            int startIndex = i * chunkSize;
            int endIndex = Math.min(startIndex + chunkSize, text.length());
            chunks[i] = text.substring(startIndex, endIndex);
            NewChunks.add(chunks[i]);
        }

        return NewChunks;
    }
}
