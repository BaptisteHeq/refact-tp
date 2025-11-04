package org.iut.refactoring;

public class EmployeFactory {

    public static Employe creerEmploye(String type, String id, String nom, double salaireBase, int experience, String division) {
        return switch (type.toUpperCase()) {
            case "DEVELOPPEUR" -> new Developpeur(id, nom, salaireBase, experience, division);
            case "CHEF DE PROJET" -> new ChefDeProjet(id, nom, salaireBase, experience, division);
            case "STAGIAIRE" -> new Stagiaire(id, nom, salaireBase, experience, division);
            default -> throw new IllegalArgumentException("Type d'employé inconnu: " + type);
        };
    }

    public static Employe creerEmploye(String type, String nom, double salaireBase, int experience, String division) {
        return creerEmploye(type, java.util.UUID.randomUUID().toString(), nom, salaireBase, experience, division);
    }
}
