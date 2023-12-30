package com.projectXCCM.composix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projectXCCM.composix.model.Utilisateur;



public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {

    Utilisateur findByEmail(String email);
}
