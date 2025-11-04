package org.iut.refactoring;

import java.util.Map;

public class GestionApp {
    public static void main(String[] args) {

        GestionPersonnel app = new GestionPersonnel();

        // Ajout des employés
        Employe alice = app.ajouteEmploye("DEVELOPPEUR", "Alice", 50000, 6, "IT");
        Employe bob = app.ajouteEmploye("CHEF DE PROJET", "Bob", 60000, 4, "RH");
        Employe charlie = app.ajouteEmploye("STAGIAIRE", "Charlie", 20000, 0, "IT");
        Employe dan = app.ajouteEmploye("DEVELOPPEUR", "Dan", 55000, 12, "IT");

        // Calculs individuels
        System.out.println("Salaire de " + alice.getNom() + ": " + app.calculSalaire(alice.getId()) + " €");
        System.out.println("Bonus de " + alice.getNom() + ": " + app.calculBonus(alice.getId()) + " €");

        // Rapport par division (ancien "generationRapport")
        System.out.println("\n=== RAPPORT SALAIRE (Division IT) ===");
        app.getEmployesParDivision("IT").forEach(e ->
                System.out.println(e.getNom() + ": " + e.calculSalaire() + " €")
        );

        System.out.println("\n=== RAPPORT PAR DIVISION ===");
        Map<String, Long> rapport = app.rapportParDivision();
        rapport.forEach((division, count) ->
                System.out.println(division + ": " + count + " employés")
        );

        // Promotion
        System.out.println("\n--- Promotion de Alice ---");
        boolean promoOk = app.promouvoirEmploye(alice.getId(), "CHEF DE PROJET");
        if (promoOk) {
            System.out.println("Promotion réussie !");
            System.out.println("Nouveau salaire de Alice: " + app.calculSalaire(alice.getId()) + " €");
        }

        // Logs
        System.out.println("\n=== LOGS ===");
        app.getLogs().forEach(System.out::println);
    }
}
