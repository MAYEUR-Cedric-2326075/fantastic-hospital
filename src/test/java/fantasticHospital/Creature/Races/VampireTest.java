package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.VipRace;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Vampire
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);

        // Vérification des attributs de base
        assertEquals("Dracula", vampire.getName());
        assertTrue(vampire.getGender());
        assertEquals(75.0, vampire.getWeight());
        assertEquals(1.85, vampire.getHeight());
        assertEquals(500, vampire.getAge());

        // Vérification de la race
        VipRace race = vampire.getRace();
        assertEquals("Vampire", race.getRaceName());
        assertEquals(50, race.getRateOfMoralitybeginningSream());
        assertEquals(40, race.getRateOfMoralityBeginningRage());
        assertEquals(30, race.getRateOfReduction());
    }

    @Test
    void testWaiting() {
        // Création d'un Vampire avec une moralité initiale
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);
        vampire.setMoralityRate(100);

        // Réduction de la moralité après attente
        vampire.waiting();
        assertEquals(70, vampire.getMoralityRate()); // 100 - 30
    }

    @Test
    void testIsInRage() {
        // Création d'un Vampire avec une moralité initiale
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);

        // Test dans l'état de rage
        vampire.setMoralityRate(35);
        assertTrue(vampire.isInRage(), "Vampire should be in rage when morality is below rage threshold");

        // Test hors de l'état de rage
        vampire.setMoralityRate(45);
        assertFalse(vampire.isInRage(), "Vampire should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Vampire avec une moralité initiale
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);

        // Test en train de crier
        vampire.setMoralityRate(45);
        assertTrue(vampire.isScreaming(), "Vampire should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        vampire.setMoralityRate(35);
        assertFalse(vampire.isScreaming(), "Vampire should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        vampire.setMoralityRate(55);
        assertFalse(vampire.isScreaming(), "Vampire should not be screaming when morality is too high");
    }

    @Test
    void testRegenerate() {
        // Création d'un Vampire initialement mort
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);
        vampire.setAlive(false);

        // Régénération
        vampire.regenerate();
        assertTrue(vampire.isAlive(), "Vampire should be alive after regeneration");
    }

    @Test
    void testDemoralizeSingleCreature() {
        // Création d'un Vampire et d'une créature cible
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);
        Creature target = new Vampire("Target", false, 60.0, 1.75, 300);
        target.setMoralityRate(60);

        // Vampire démoralise la créature cible
        vampire.demoralize(target);
        assertEquals(50, target.getMoralityRate(), "Target's morality should decrease by 10");
    }

    @Test
    void testDemoralizeMultipleCreatures() {
        // Création d'un Vampire et de plusieurs créatures cibles
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);
        Creature target1 = new Vampire("Target1", false, 60.0, 1.75, 300);
        Creature target2 = new Vampire("Target2", false, 65.0, 1.80, 350);

        target1.setMoralityRate(60);
        target2.setMoralityRate(50);

        Set<Creature> targets = new HashSet<>();
        targets.add(target1);
        targets.add(target2);

        // Vampire démoralise les créatures
        vampire.demoralize(targets);

        assertEquals(50, target1.getMoralityRate(), "Target1's morality should decrease by 10");
        assertEquals(40, target2.getMoralityRate(), "Target2's morality should decrease by 10");
    }

    @Test
    void testToString() {
        // Création d'un Vampire
        Vampire vampire = new Vampire("Dracula", true, 75.0, 1.85, 500);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Dracula', gender=Male, weight=75.0, height=1.85, age=500, moralityRate=100, alive=true}, race=Vampire";
        assertEquals(expected, vampire.toString());
    }
}