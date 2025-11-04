package org.iut.refactoring;

public abstract class Employe implements SalaireCalculable {
    protected final String id;
    protected final String nom;
    protected final double salaireBase;
    protected final int experience;
    protected final String division;

    protected Employe(String id, String nom, double salaireBase, int experience, String division) {
        this.id = id;
        this.nom = nom;
        this.salaireBase = salaireBase;
        this.experience = experience;
        this.division = division;
    }

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getDivision() { return division; }
    public int getExperience() { return experience; }
    public double getSalaireBase() { return salaireBase; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - Exp: %d ans", id, nom, division, experience);
    }
}
