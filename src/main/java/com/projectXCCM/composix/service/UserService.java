package com.projectXCCM.composix.service;

import com.projectXCCM.composix.model.User;
import com.projectXCCM.composix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository utilisateurRepository;

    public User enregistrerUtilisateur(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<User> obtenirTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public User obtenirUtilisateurParId(String id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public User obtenirUtilisateurParEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null);
    }

    public User mettreAjourUtilisateur(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void supprimerUtilisateur(String id) {
        utilisateurRepository.deleteById(id);
    }
}
