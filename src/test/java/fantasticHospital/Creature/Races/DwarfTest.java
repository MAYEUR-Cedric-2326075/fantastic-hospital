package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DwarfTest {

    private Dwarf dwarf;

    @BeforeEach
    void setUp() {
        // Initialisation d'un nain pour les tests
        dwarf = new Dwarf("Thorin", true, 70.5, 1.45, 195);
    }

    @Test
    void waiting() {
        // Test de la méthode waiting
        int initialMoralityRate = dwarf.getMoralityRate();
        dwarf.waiting();
        int reducedMoralityRate = initialMoralityRate - dwarf.getRace().getRateOfReduction();
        assertEquals(reducedMoralityRate, dwarf.getMoralityRate(), "Morality rate should decrease after waiting.");
    }

    @Test
    void testGetRace() {
        // Test que la race est bien définie
        assertNotNull(dwarf.getRace(), "Race should not be null.");
        assertEquals("Dwarf", dwarf.getRace().getRaceName(), "Race name should be 'Dwarf'.");
    }

    @Test
    void testIsInRage() {
        // Test du comportement en cas de rage
        dwarf.setMoralityRate(dwarf.getRace().getRateOfMoralityBeginningRage() - 1); // Forcer la moralité en-dessous du seuil
        assertTrue(dwarf.isInRage(), "Dwarf should be in rage when morality rate is below threshold.");
    }

    @Test
    void testIsScreaming() {
        // Test du comportement en cas de cri
        dwarf.setMoralityRate(dwarf.getRace().getRateOfMoralitybeginningSream() - 1); // Entre rage et cri
        assertTrue(dwarf.isScreaming(), "Dwarf should be screaming when morality rate is below scream threshold but above rage threshold.");
    }
}
