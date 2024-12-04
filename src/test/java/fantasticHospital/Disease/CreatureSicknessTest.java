package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import fantasticHospital.Disease.Races.Contaminater.BeastmanSicknessContaminator;
import fantasticHospital.Disease.TypeOfPatient.CreatureSicknessContaminator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreatureSicknessTest {

    private Disease DRS;
    private Beastman beastman;
    private CreatureSicknessContaminator beastmanDisease;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        beastmanDisease = new BeastmanSicknessContaminator(beastman);
    }

    @Test
    void getDiseaseName() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        assertEquals("[Dépendance aux réseaux sociaux]", beastmanDisease.getAllDiseaseNames().toString());
    }

    @Test
    void getCreatureName() {
        assertEquals("Tormak", beastmanDisease.getCreature().getName());
    }

    @Test
    void getCurrentLevel() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        assertEquals(2, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void decreaseLevel() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        beastmanDisease.decreaseLevel(DRS);
        assertEquals(1, beastmanDisease.getCurrentLevel(DRS));
    }
    @Test
    void increaseLevel() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        beastmanDisease.increaseLevel(DRS);
        assertEquals(3, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void minLevel() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 1);
        beastmanDisease.decreaseLevel(DRS);
        assertEquals(1, beastmanDisease.getCurrentLevel(DRS));
    }
    @Test
    void maxLevel() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 5);
        beastmanDisease.increaseLevel(DRS);
        assertEquals(5, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void healDisease() {
        CreatureSicknessContaminator beastmanDisease2 = new BeastmanSicknessContaminator(beastman);
        Disease TEST = new Disease("maladie des tests unitaires", "TEST", 5);

        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        beastmanDisease2.addDiseaseCurrentLevel(TEST, 2);
        beastmanDisease.addDiseaseCurrentLevel(TEST, 2);

        beastmanDisease.cured(DRS);
        assertEquals(beastmanDisease.getAllDiseaseNames(),beastmanDisease.getAllDiseaseNames());
    }
    @Test
    void healAllDisease() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        Disease TEST = new Disease("maladie des tests unitaires", "TEST", 5);
        beastmanDisease.addDiseaseCurrentLevel(TEST, 2);
        beastmanDisease.cured();
        assertEquals(new ArrayList<>(),beastmanDisease.getAllDiseaseNames());
    }

}