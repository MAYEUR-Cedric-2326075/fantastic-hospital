package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureDiseaseTest {

    private Disease DRS;
    private Beastman beastman;
    private CreatureSickness beastmanDisease;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        beastmanDisease = new CreatureSickness(beastman);
        beastmanDisease.addDiseaseCurrentLevel(DRS, 2);
    }

    /*
    @Test
    void getDiseaseName() {
        assertEquals("[Dépendance aux réseaux sociaux]", beastmanDisease.getAllDiseaseNames());
    }
    */

    @Test
    void getCreatureName() {
        assertEquals("Tormak", beastmanDisease.getCreature().getName());
    }

    @Test
    void getCurrentLevel() {
        assertEquals(2, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void decreaseLevel() {
        beastmanDisease.decreaseLevel(DRS);
        assertEquals(1, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void increaseLevel() {
        beastmanDisease.increaseLevel(DRS);
        assertEquals(3, beastmanDisease.getCurrentLevel(DRS));
    }

    @Test
    void minLevel() {
        CreatureSickness beastmanDisease2 = new CreatureSickness(beastman);
        beastmanDisease2.addDiseaseCurrentLevel(DRS, 1);
        beastmanDisease2.decreaseLevel(DRS);
        assertEquals(1, beastmanDisease2.getCurrentLevel(DRS));
    }
    @Test
    void maxLevel() {
        CreatureSickness beastmanDisease3 = new CreatureSickness(beastman);
        beastmanDisease3.addDiseaseCurrentLevel(DRS, 5);
        beastmanDisease3.increaseLevel(DRS);
        assertEquals(5, beastmanDisease3.getCurrentLevel(DRS));
    }
}