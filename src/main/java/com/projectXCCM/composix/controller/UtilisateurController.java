package com.projectXCCM.composix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projectXCCM.composix.model.Utilisateur;
import com.projectXCCM.composix.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/enregistrer")
    public Utilisateur enregistrerUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.enregistrerUtilisateur(utilisateur);
    }

    @GetMapping("/tous")
    public List<Utilisateur> obtenirTousLesUtilisateurs() {
        return utilisateurService.obtenirTousLesUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur obtenirUtilisateurParId(@PathVariable String id) {
        return utilisateurService.obtenirUtilisateurParId(id);
    }

    @PutMapping("/mettre-a-jour")
    public Utilisateur mettreAjourUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.mettreAjourUtilisateur(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void supprimerUtilisateur(@PathVariable String id) {
        utilisateurService.supprimerUtilisateur(id);
    }
}
