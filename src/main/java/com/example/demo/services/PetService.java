package com.example.demo.services;

import java.util.ArrayList;


import com.example.demo.models.Pet;
import com.example.demo.repositories.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }

    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> pets = (ArrayList<Pet>) petRepository.findAll();
        return pets;
    }
}
