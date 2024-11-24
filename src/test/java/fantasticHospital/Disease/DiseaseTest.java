package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiseaseTest {

    private Disease DRS;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        Beastman beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
    }

    @Test
    void getName() {
        assertEquals("Dépendance aux réseaux sociaux", DRS.getName());
    }

    @Test
    void getShortName() {
        assertEquals("DRS", DRS.getShortName());
    }

    @Test
    void getMaxLevel() {
        assertEquals(5, DRS.getMaxLevel());
    }
}