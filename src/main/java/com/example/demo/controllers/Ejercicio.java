package com.example.demo.controllers;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.example.demo.models.Pet;
import com.example.demo.models.TranslatedText;
import com.example.demo.services.PetService;
import com.example.demo.services.TranslatorService;
import com.example.demo.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ejercicio {

    @Autowired
    PetService petService;

    @Autowired
    TranslatorService translatorService;
    
    // http://localhost:8080/
    @GetMapping("/")
    public String greet(){
        return "Bienvenido al servidor backend";
    }

    
    
    // http://localhost:8080/contar/????
    @GetMapping("/contar/{texto}")
    public String contar(@PathVariable String texto){
        int[] numLetras = Utils.contar(texto); 
        texto = MessageFormat.format("{0} tiene {1} vocales y {2} consonantes" , texto, numLetras[0], numLetras[1]);
        return texto;
    }
    

    // http://localhost:8080/listar
    @GetMapping("/listar")
    public String petList(){
        ArrayList<Pet> pets = petService.getAllPets();
        String listado = "";
        for(Pet pet : pets){
            listado += pet.getName();
            listado += "<br/>";
        }
        return listado;
    }

    // http://localhost:8080/guarda
    @GetMapping("/guarda")
    public String addPet(@RequestParam String nombre){
        //insert into joke(text) values ("texto")
        Pet pet = new Pet();
        pet.setName(nombre);
        petService.savePet(pet);
        return "Mascota registrada correctamente";
    }
    
    // http://localhost:8080/????
    @GetMapping("/{texto}")
    public String frase(@PathVariable String texto){
        texto = Utils.transformaTexto(texto);
        return texto;
    }

    // http://localhost:8080/traduce/????
    @GetMapping("/traduce/{texto}")
    public String getTranslation(@PathVariable String texto){
        TranslatedText t = translatorService.getTranslationFromAPI(texto);
        return t.responseData.translatedText;
    }

}
