package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CreatureSicknessTest {

    private Disease DRS;
    private Beastman beastman;
    private CreatureSickness beastmanDisease;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        beastmanDisease = new CreatureSickness(beastman);
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
        CreatureSickness beastmanDisease2 = new CreatureSickness(beastman);
        Disease TEST = new Disease("maladie des tests unitaires", "TEST", 5);

        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        beastmanDisease2.addDiseaseCurrentLevel(TEST, 2);
        beastmanDisease.addDiseaseCurrentLevel(TEST, 2);

        beastmanDisease.heal(DRS);
        assertEquals(beastmanDisease.getAllDiseaseNames(),beastmanDisease.getAllDiseaseNames());
    }
    @Test
    void healAllDisease() {
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
        Disease TEST = new Disease("maladie des tests unitaires", "TEST", 5);
        beastmanDisease.addDiseaseCurrentLevel(TEST, 2);
        beastmanDisease.heal();
        assertEquals(new ArrayList<>(),beastmanDisease.getAllDiseaseNames());
    }
}