package org.iut.refactoring;

public class Developpeur extends Employe {
    public Developpeur(String id, String nom, double salaireBase, int experience, String division) {
        super(id, nom, salaireBase, experience, division);
    }

    @Override
    public double calculSalaire() {
        double s = salaireBase * 1.2;
        if (experience > 5) s *= 1.15;
        if (experience > 10) s *= 1.05;
        return s;
    }

    @Override
    public double calculBonus() {
        double b = salaireBase * 0.1;
        if (experience > 5) b *= 1.5;
        return b;
    }
}
