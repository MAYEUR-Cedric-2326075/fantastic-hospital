package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Race.PoorRace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Lycanthrope
        Lycanthrope lycanthrope = new Lycanthrope("Fenrir", true, 85.0, 1.90, 30);

        // Vérification des attributs de base
        assertEquals("Fenrir", lycanthrope.getName());
        assertTrue(lycanthrope.getGender());
        assertEquals(85.0, lycanthrope.getWeight());
        assertEquals(1.90, lycanthrope.getHeight());
        assertEquals(30, lycanthrope.getAge());

        // Vérification de la race
        PoorRace race = lycanthrope.getRace();
        assertEquals("Lycanthrope", race.getRaceName());
        assertEquals(20, race.getRateOfMoralitybeginningSream());
        assertEquals(15, race.getRateOfMoralityBeginningRage());
        assertEquals(10, race.getRateOfReductionWithPeaple());
        assertEquals(20, race.getRateOfReductionWithoutPeaple());
    }

    @Test
    void testWaiting() {
        // Création d'un Lycanthrope avec une moralité initiale
        Lycanthrope lycanthrope = new Lycanthrope("Fenrir", true, 85.0, 1.90, 30);
        lycanthrope.setMoralityRate(50);

        // Test lorsque Lycanthrope est seul
        lycanthrope.waiting(true);
        assertEquals(30, lycanthrope.getMoralityRate()); // 50 - 20

        // Test lorsque Lycanthrope n'est pas seul
        lycanthrope.waiting(false);
        assertEquals(20, lycanthrope.getMoralityRate()); // 30 - 10
    }

    @Test
    void testIsInRage() {
        // Création d'un Lycanthrope avec une moralité initiale
        Lycanthrope lycanthrope = new Lycanthrope("Fenrir", true, 85.0, 1.90, 30);

        // Test dans l'état de rage
        lycanthrope.setMoralityRate(10);
        assertTrue(lycanthrope.isInRage(), "Lycanthrope should be in rage when morality is below rage threshold");

        // Test hors de l'état de rage
        lycanthrope.setMoralityRate(25);
        assertFalse(lycanthrope.isInRage(), "Lycanthrope should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Lycanthrope avec une moralité initiale
        Lycanthrope lycanthrope = new Lycanthrope("Fenrir", true, 85.0, 1.90, 30);

        // Test en train de crier
        lycanthrope.setMoralityRate(18);
        assertTrue(lycanthrope.isScreaming(), "Lycanthrope should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        lycanthrope.setMoralityRate(10);
        assertFalse(lycanthrope.isScreaming(), "Lycanthrope should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        lycanthrope.setMoralityRate(25);
        assertFalse(lycanthrope.isScreaming(), "Lycanthrope should not be screaming when morality is too high");
    }

    @Test
    void testToString() {
        // Création d'un Lycanthrope
        Lycanthrope lycanthrope = new Lycanthrope("Fenrir", true, 85.0, 1.90, 30);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Fenrir', gender=Male, weight=85.0, height=1.9, age=30, moralityRate=100, alive=true}, race=Lycanthrope";
        assertEquals(expected, lycanthrope.toString());
    }
}