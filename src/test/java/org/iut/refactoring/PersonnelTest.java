package org.iut.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonnelTest {

    GestionPersonnel gp;

    @BeforeEach
    void setup() {
        gp = new GestionPersonnel();
    }

    @Test
    void testAjoutEtSalaireDeveloppeur() {
        Employe e = gp.ajouteEmploye("DEVELOPPEUR", "Alice", 3000, 6, "Dev");
        assertEquals(4140, gp.calculSalaire(e.getId()), 0.01);
    }

    @Test
    void testPromotionEmploye() {
        Employe e = gp.ajouteEmploye("STAGIAIRE", "Bob", 2000, 2, "Dev");
        gp.promouvoirEmploye(e.getId(), "DEVELOPPEUR");
        double salaire = gp.calculSalaire(e.getId()); // nouveau calcul
        assertTrue(salaire > 0);
    }

    @Test
    void testCalculBonusChef() {
        Employe e = gp.ajouteEmploye("CHEF DE PROJET", "Claire", 4000, 4, "Management");
        assertEquals(1040, gp.calculBonus(e.getId()), 0.01); // 4000 * 0.2 * 1.3
    }

    @Test
    void testRapportParDivision() {
        gp.ajouteEmploye("DEVELOPPEUR", "A", 3000, 4, "Dev");
        gp.ajouteEmploye("STAGIAIRE", "B", 1500, 1, "Dev");
        gp.ajouteEmploye("CHEF DE PROJET", "C", 4000, 6, "Management");
        Map<String, Long> rapport = gp.rapportParDivision();
        assertEquals(2, rapport.get("Dev"));
        assertEquals(1, rapport.get("Management"));
    }
}
