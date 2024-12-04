package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Race.PoorRace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrcTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Orc
        Orc orc = new Orc("Gorbag", true, 95.0, 1.90, 35);

        // Vérification des attributs de base
        assertEquals("Gorbag", orc.getName());
        assertTrue(orc.getGender());
        assertEquals(95.0, orc.getWeight());
        assertEquals(1.90, orc.getHeight());
        assertEquals(35, orc.getAge());

        // Vérification de la race
        PoorRace race = orc.getRace();
        assertEquals("Orc", race.getRaceName());
        assertEquals(40, race.getRateOfMoralitybeginningSream());
        assertEquals(30, race.getRateOfMoralityBeginningRage());
        assertEquals(8, race.getRateOfReductionWithPeaple());
        assertEquals(20, race.getRateOfReductionWithoutPeaple());
    }

    @Test
    void testWaiting() {
        // Création d'un Orc avec une moralité initiale
        Orc orc = new Orc("Gorbag", true, 95.0, 1.90, 35);
        orc.setMoralityRate(50);

        // Test lorsque l'Orc est seul
        orc.waiting(true);
        assertEquals(30, orc.getMoralityRate()); // 50 - 20

        // Test lorsque l'Orc n'est pas seul
        orc.waiting(false);
        assertEquals(22, orc.getMoralityRate()); // 30 - 8
    }

    @Test
    void testIsInRage() {
        // Création d'un Orc avec une moralité initiale
        Orc orc = new Orc("Gorbag", true, 95.0, 1.90, 35);

        // Test dans l'état de rage
        orc.setMoralityRate(20);
        assertTrue(orc.isInRage(), "Orc should be in rage when morality is below rage threshold");

        // Test hors de l'état de rage
        orc.setMoralityRate(35);
        assertFalse(orc.isInRage(), "Orc should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Orc avec une moralité initiale
        Orc orc = new Orc("Gorbag", true, 95.0, 1.90, 35);

        // Test en train de crier
        orc.setMoralityRate(35);
        assertTrue(orc.isScreaming(), "Orc should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        orc.setMoralityRate(20);
        assertFalse(orc.isScreaming(), "Orc should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        orc.setMoralityRate(50);
        assertFalse(orc.isScreaming(), "Orc should not be screaming when morality is too high");
    }

    @Test
    void testToString() {
        // Création d'un Orc
        Orc orc = new Orc("Gorbag", true, 95.0, 1.90, 35);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Gorbag', gender=Male, weight=95.0, height=1.9, age=35, moralityRate=100, alive=true}, race=Orc";
        assertEquals(expected, orc.toString());
    }
}