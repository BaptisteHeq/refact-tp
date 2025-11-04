package org.iut.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonnelTest {

    private GestionPersonnel gp;

    @BeforeEach
    public void setup() {
        gp = new GestionPersonnel();
    }

    @Test
    public void testAjoutSalarie() {
        gp.ajouteSalarie("DEVELOPPEUR", "Alice", 3000, 4, "Dev");
        assertEquals(1, gp.employes.size());
        assertTrue(gp.salairesEmployes.size() > 0);
        assertTrue(gp.logs.size() > 0);
    }

    @Test
    public void testCalculSalaireDeveloppeur() {
        gp.ajouteSalarie("DEVELOPPEUR", "Bob", 3000, 6, "Dev");
        Object[] emp = gp.employes.get(0);
        double salaire = gp.calculSalaire((String) emp[0]);
        // 3000 * 1.2 * 1.15 = 4140
        assertEquals(4140, salaire, 0.01);
    }

    @Test
    public void testCalculSalaireChefDeProjet() {
        gp.ajouteSalarie("CHEF DE PROJET", "Claire", 4000, 5, "Management");
        Object[] emp = gp.employes.get(0);
        double salaire = gp.calculSalaire((String) emp[0]);
        // 4000 * 1.5 * 1.1 + 5000 = 11600
        assertEquals(11600, salaire, 0.01);
    }

    @Test
    public void testCalculSalaireStagiaire() {
        gp.ajouteSalarie("STAGIAIRE", "David", 2000, 1, "Dev");
        Object[] emp = gp.employes.get(0);
        double salaire = gp.calculSalaire((String) emp[0]);
        // 2000 * 0.6 = 1200
        assertEquals(1200, salaire, 0.01);
    }

    @Test
    public void testPromotionEmploye() {
        gp.ajouteSalarie("STAGIAIRE", "Emma", 1500, 2, "Dev");
        Object[] emp = gp.employes.get(0);
        gp.avancementEmploye((String) emp[0], "DEVELOPPEUR");
        assertEquals("DEVELOPPEUR", gp.employes.get(0)[1]);
        double salaire = gp.salairesEmployes.get(emp[0]);
        assertEquals(1500 * 1.2, salaire, 0.01);
    }

    @Test
    public void testCalculBonusAnnuel() {
        gp.ajouteSalarie("DEVELOPPEUR", "Frank", 3000, 6, "Dev");
        Object[] emp = gp.employes.get(0);
        double bonus = gp.calculBonusAnnuel((String) emp[0]);
        // 3000 * 0.1 * 1.5 = 450
        assertEquals(450, bonus, 0.01);
    }

    @Test
    public void testGetEmployesParDivision() {
        gp.ajouteSalarie("DEVELOPPEUR", "Alice", 3000, 4, "Dev");
        gp.ajouteSalarie("CHEF DE PROJET", "Claire", 4000, 5, "Management");
        gp.ajouteSalarie("STAGIAIRE", "David", 2000, 1, "Dev");

        assertEquals(2, gp.getEmployesParDivision("Dev").size());
        assertEquals(1, gp.getEmployesParDivision("Management").size());
    }

    @Test
    public void testEmployeIntrouvable() {
        double salaire = gp.calculSalaire("fake-id");
        assertEquals(0, salaire);
        double bonus = gp.calculBonusAnnuel("fake-id");
        assertEquals(0, bonus);
    }

}
