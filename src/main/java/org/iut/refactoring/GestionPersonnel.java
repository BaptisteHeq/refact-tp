package org.iut.refactoring;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GestionPersonnel {

    private final List<Employe> employes = new ArrayList<>();
    private final List<String> logs = new ArrayList<>();

    public Employe ajouteEmploye(String type, String nom, double salaireBase, int experience, String division) {
        Employe e = EmployeFactory.creerEmploye(type, nom, salaireBase, experience, division);
        employes.add(e);
        logs.add(LocalDateTime.now() + " - Ajout employé: " + nom);
        return e;
    }

    public Optional<Employe> trouverEmploye(String id) {
        return employes.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public boolean promouvoirEmploye(String id, String nouveauType) {
        Optional<Employe> opt = trouverEmploye(id);
        if (opt.isEmpty()) return false;

        Employe ancien = opt.get();
        Employe nouveau = EmployeFactory.creerEmploye(nouveauType, ancien.getNom(), ancien.getSalaireBase(), ancien.getExperience(), ancien.getDivision());
        employes.remove(ancien);
        employes.add(nouveau);
        logs.add(LocalDateTime.now() + " - Promotion de " + ancien.getNom() + " vers " + nouveauType);
        return true;
    }

    public List<Employe> getEmployesParDivision(String division) {
        return employes.stream()
                .filter(e -> e.getDivision().equalsIgnoreCase(division))
                .collect(Collectors.toList());
    }

    public double calculSalaire(String id) {
        return trouverEmploye(id).map(Employe::calculSalaire).orElse(0.0);
    }

    public double calculBonus(String id) {
        return trouverEmploye(id).map(Employe::calculBonus).orElse(0.0);
    }

    public Map<String, Long> rapportParDivision() {
        return employes.stream()
                .collect(Collectors.groupingBy(Employe::getDivision, Collectors.counting()));
    }

    public List<String> getLogs() {
        return List.copyOf(logs);
    }

    public List<Employe> getEmployes() {
        return List.copyOf(employes);
    }
}
