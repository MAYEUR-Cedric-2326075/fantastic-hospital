package fantasticHospital.Disease;

import fantasticHospital.Creature.Race.Beastman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureDiseaseTest {

    private Disease DRS;
    private Beastman beastman;
    private CreatureDisease beastmanDisease;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        beastmanDisease = new CreatureDisease(DRS, beastman, 2);
    }

    @Test
    void getDiseaseName() {
        assertEquals("Dépendance aux réseaux sociaux", beastmanDisease.getDisease().getName());
    }

    @Test
    void getCreatureName() {
        assertEquals("Tormak", beastmanDisease.getCreature().getName());
    }

    @Test
    void getCurrentLevel() {
        assertEquals(2, beastmanDisease.getCurrentLevel());
    }

    @Test
    void decreaseLevel() {
        beastmanDisease.decreaseLevel();
        assertEquals(1, beastmanDisease.getCurrentLevel());
    }

    @Test
    void increaseLevel() {
        beastmanDisease.increaseLevel();
        assertEquals(3, beastmanDisease.getCurrentLevel());
    }

    @Test
    void minLevel() {
        CreatureDisease beastmanDisease2 = new CreatureDisease(DRS, beastman, 1);
        beastmanDisease2.decreaseLevel();
        assertEquals(1, beastmanDisease2.getCurrentLevel());
    }
    @Test
    void maxLevel() {
        CreatureDisease beastmanDisease3 = new CreatureDisease(DRS, beastman, 5);
        beastmanDisease3.increaseLevel();
        assertEquals(5, beastmanDisease3.getCurrentLevel());
    }
}