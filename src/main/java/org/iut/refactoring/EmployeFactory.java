package org.iut.refactoring;

import java.util.UUID;

public class EmployeFactory {

    public static Employe creerEmploye(String type, String nom, double salaireBase, int experience, String division) {
        String id = UUID.randomUUID().toString();
        return switch (type.toUpperCase()) {
            case "DEVELOPPEUR" -> new Developpeur(id, nom, salaireBase, experience, division);
            case "CHEF DE PROJET" -> new ChefDeProjet(id, nom, salaireBase, experience, division);
            case "STAGIAIRE" -> new Stagiaire(id, nom, salaireBase, experience, division);
            default -> throw new IllegalArgumentException("Type d'employé inconnu: " + type);
        };
    }
}