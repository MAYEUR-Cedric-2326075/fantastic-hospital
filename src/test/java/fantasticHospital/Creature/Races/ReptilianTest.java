package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Race.VipRace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReptilianTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Reptilian
        Reptilian reptilian = new Reptilian("Rex", true, 120.0, 2.5, 40);

        // Vérification des attributs de base
        assertEquals("Rex", reptilian.getName());
        assertTrue(reptilian.getGender());
        assertEquals(120.0, reptilian.getWeight());
        assertEquals(2.5, reptilian.getHeight());
        assertEquals(40, reptilian.getAge());

        // Vérification de la race
        VipRace race = reptilian.getRace();
        assertEquals("Reptilian", race.getRaceName());
        assertEquals(25, race.getRateOfMoralitybeginningSream());
        assertEquals(15, race.getRateOfMoralityBeginningRage());
        assertEquals(30, race.getRateOfReduction());
    }

    @Test
    void testWaiting() {
        // Création d'un Reptilian avec une moralité initiale
        Reptilian reptilian = new Reptilian("Rex", true, 120.0, 2.5, 40);
        reptilian.setMoralityRate(50);

        // Réduction de la moralité après attente
        reptilian.waiting();
        assertEquals(20, reptilian.getMoralityRate()); // 50 - 30
    }

    @Test
    void testIsInRage() {
        // Création d'un Reptilian avec une moralité initiale
        Reptilian reptilian = new Reptilian("Rex", true, 120.0, 2.5, 40);

        // Test dans l'état de rage
        reptilian.setMoralityRate(10);
        assertTrue(reptilian.isInRage(), "Reptilian should be in rage when morality is below rage threshold");

        // Test hors de l'état de rage
        reptilian.setMoralityRate(20);
        assertFalse(reptilian.isInRage(), "Reptilian should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Reptilian avec une moralité initiale
        Reptilian reptilian = new Reptilian("Rex", true, 120.0, 2.5, 40);

        // Test en train de crier
        reptilian.setMoralityRate(20);
        assertTrue(reptilian.isScreaming(), "Reptilian should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        reptilian.setMoralityRate(10);
        assertFalse(reptilian.isScreaming(), "Reptilian should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        reptilian.setMoralityRate(30);
        assertFalse(reptilian.isScreaming(), "Reptilian should not be screaming when morality is too high");
    }

    @Test
    void testToString() {
        // Création d'un Reptilian
        Reptilian reptilian = new Reptilian("Rex", true, 120.0, 2.5, 40);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Rex', gender=Male, weight=120.0, height=2.5, age=40, moralityRate=100, alive=true}, race=Reptilian";
        assertEquals(expected, reptilian.toString());
    }
}