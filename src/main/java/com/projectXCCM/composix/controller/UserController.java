package com.projectXCCM.composix.controller;

import com.projectXCCM.composix.model.User;
import com.projectXCCM.composix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService utilisateurService;

    @PostMapping("/register")
    public User enregistrerUtilisateur(@RequestBody User utilisateur) {
        return utilisateurService.enregistrerUtilisateur(utilisateur);
    }

    @GetMapping("/")
    public List<User> obtenirTousLesUtilisateurs() {
        return utilisateurService.obtenirTousLesUtilisateurs();
    }

//    @GetMapping("/get/{id}")
//    public User obtenirUtilisateurParId(@PathVariable String id) {
//        return utilisateurService.obtenirUtilisateurParId(id);
//    }
    @GetMapping("/get/{email}")
    public User obtenirUtilisateurParEmail(@PathVariable String email) {
        return utilisateurService.obtenirUtilisateurParEmail(email);
    }

    @PutMapping("/update")
    public User mettreAjourUtilisateur(@RequestBody User utilisateur) {
        return utilisateurService.mettreAjourUtilisateur(utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerUtilisateur(@PathVariable String id) {
        utilisateurService.supprimerUtilisateur(id);
    }
}
