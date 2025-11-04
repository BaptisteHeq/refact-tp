package org.iut.refactoring;

public class Stagiaire extends Employe {
    public Stagiaire(String id, String nom, double salaireBase, int experience, String division) {
        super(id, nom, salaireBase, experience, division);
    }

    @Override
    public double calculSalaire() {
        return salaireBase * 0.6;
    }

    @Override
    public double calculBonus() {
        return 0;
    }
}
