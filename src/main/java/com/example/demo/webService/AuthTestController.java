package com.example.demo.webService;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/auth")
public class AuthTestController {


    @GetMapping("/fournisseur")
    @PreAuthorize("hasRole('ROLE_FOURNISSEUR')")
    public String fournisseurAccess() {
        return "Fournisseur Content.";
    }

    @GetMapping("/artist")
    @PreAuthorize("hasRole('ROLE_ARTIST')")
    public String artistAccess() {
        return "artist Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/consultant")
    @PreAuthorize("hasRole('ROLE_CONSULTANT')")
    public String consultantAccess() {
        return "consultant Board.";
    }

    @GetMapping("/gestionnaire")
    @PreAuthorize("hasRole('ROLE_GESTIONNAIRE')")
    public String gestionnaireAccess() {
        return "gestionnaire Board.";
    }


}
