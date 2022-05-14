package com.example.demo.utils;


public class Utils {

    public static int[] contar(String cad){
        String vocales = "aeiou";
        String consonantes = "bcdfghjklmnñpqrstvwxyz";
        int[] num = {0, 0};
        int cadLength = cad.length();
        for(int i = 0; i<cadLength; i++){
            String letra = Character.toString(cad.charAt(i));
            if(vocales.contains(letra)) num[0]++;
            if(consonantes.contains(letra)) num[1]++;
        }
        return num;
    }

    public static String transformaTexto(String texto){
        char[] cadena = texto.toCharArray();
        for(int i=0; i<cadena.length; i++){
            if(Math.random()<0.5) cadena[i] = Character.toUpperCase(cadena[i]);           
        }
        
        return new String(cadena);
    }
}
