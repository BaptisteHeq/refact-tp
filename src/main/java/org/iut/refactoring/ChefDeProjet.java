package org.iut.refactoring;

public class ChefDeProjet extends Employe {
    public ChefDeProjet(String id, String nom, double salaireBase, int experience, String division) {
        super(id, nom, salaireBase, experience, division);
    }

    @Override
    public double calculSalaire() {
        double s = salaireBase * 1.5;
        if (experience > 3) s *= 1.1;
        return s + 5000;
    }

    @Override
    public double calculBonus() {
        double b = salaireBase * 0.2;
        if (experience > 3) b *= 1.3;
        return b;
    }
}
