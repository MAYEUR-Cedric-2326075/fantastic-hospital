package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Race.PoorRace;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeastmanTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Beastman
        Beastman beastman = new Beastman("Lionel", true, 80.5, 1.75, 25);

        // Vérification des attributs de base
        assertEquals("Lionel", beastman.getName());
        assertTrue(beastman.getGender());
        assertEquals(80.5, beastman.getWeight());
        assertEquals(1.75, beastman.getHeight());
        assertEquals(25, beastman.getAge());

        // Vérification de la race
        PoorRace race = beastman.getRace();
        assertEquals("Beastman", race.getRaceName());
        assertEquals(50, race.getRateOfMoralitybeginningSream());
        assertEquals(40, race.getRateOfMoralityBeginningRage());
        assertEquals(5, race.getRateOfReductionWithPeaple());
        assertEquals(15, race.getRateOfReductionWithoutPeaple());
    }

    @Test
    void testWaiting() {
        // Création d'un Beastman avec une moralité initiale
        Beastman beastman = new Beastman("Lionel", true, 80.5, 1.75, 25);
        beastman.setMoralityRate(100);

        // Test lorsque Beastman est seul
        beastman.waiting(true);
        assertEquals(85, beastman.getMoralityRate()); // 100 - 15

        // Test lorsque Beastman n'est pas seul
        beastman.waiting(false);
        assertEquals(80, beastman.getMoralityRate()); // 85 - 5
    }

    @Test
    void testIsInRage() {
        // Création d'un Beastman avec une moralité initiale
        Beastman beastman = new Beastman("Lionel", true, 80.5, 1.75, 25);
        beastman.setMoralityRate(30); // Entre les seuils de rage et de scream

        // Vérification des conditions de rage
        assertTrue(beastman.isInRage(), "Beastman should be in rage when morality is below rage threshold");

        // Vérification avec une moralité plus haute
        beastman.setMoralityRate(50);
        assertFalse(beastman.isInRage(), "Beastman should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Beastman avec une moralité initiale
        Beastman beastman = new Beastman("Lionel", true, 80.5, 1.75, 25);

        // Test lorsque la moralité est entre les seuils de scream et de rage
        beastman.setMoralityRate(45);
        assertTrue(beastman.isScreaming(), "Beastman should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        beastman.setMoralityRate(35);
        assertFalse(beastman.isScreaming(), "Beastman should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        beastman.setMoralityRate(60);
        assertFalse(beastman.isScreaming(), "Beastman should not be screaming when morality is too high");
    }

    @Test
    void testToString() {
        // Création d'un Beastman
        Beastman beastman = new Beastman("Lionel", true, 80.5, 1.75, 25);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Lionel', gender=Male, weight=80.5, height=1.75, age=25, moralityRate=100, alive=true}, race=Beastman";
        assertEquals(expected, beastman.toString());
    }
}