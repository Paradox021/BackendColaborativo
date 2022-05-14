package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.models.Pet;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{
    
}
