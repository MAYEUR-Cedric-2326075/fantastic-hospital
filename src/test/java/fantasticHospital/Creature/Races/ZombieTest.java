package fantasticHospital.Creature.Races;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZombieTest {

    private Zombie zombie;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un zombie pour chaque test
        zombie = new Zombie("TestZombie", true, 70.0, 1.80, 30);
    }

    @Test
    public void testGetRace() {
        assertNotNull(zombie.getRace(), "La race du zombie ne devrait pas être nulle");
        assertEquals("Zombie", zombie.getRace().getRaceName(), "Le nom de la race devrait être 'Zombie'");
    }

    @Test
    public void testWaitingAlone() {
        double initialMoralityRate = zombie.getMoralityRate();
        zombie.waiting(true);
        assertEquals(initialMoralityRate - zombie.getRace().getRateOfReductionWithoutPeaple(),
                zombie.getMoralityRate(), "Le taux de moralité doit diminuer de la réduction sans personnes.");
    }

    @Test
    public void testWaitingWithPeople() {
        double initialMoralityRate = zombie.getMoralityRate();
        zombie.waiting(false);
        assertEquals(initialMoralityRate - zombie.getRace().getRateOfReductionWithPeaple(),
                zombie.getMoralityRate(), "Le taux de moralité doit diminuer de la réduction avec des personnes.");
    }

    @Test
    public void testIsInRageTrue() {
        zombie.setMoralityRate(zombie.getRace().getRateOfMoralityBeginningRage() - 1);
        assertTrue(zombie.isInRage(), "Le zombie devrait être en rage lorsque la moralité est inférieure au seuil de rage.");
    }

    @Test
    public void testIsInRageFalse() {
        zombie.setMoralityRate(zombie.getRace().getRateOfMoralityBeginningRage() + 1);
        assertFalse(zombie.isInRage(), "Le zombie ne devrait pas être en rage lorsque la moralité est supérieure au seuil de rage.");
    }

    @Test
    public void testIsScreamingTrue() {
        zombie.setMoralityRate(zombie.getRace().getRateOfMoralitybeginningSream() - 1);
        assertTrue(zombie.isScreaming(), "Le zombie devrait crier lorsque la moralité est inférieure au seuil de cri.");
    }

    @Test
    public void testIsScreamingFalse() {
        zombie.setMoralityRate(zombie.getRace().getRateOfMoralitybeginningSream() + 1);
        assertFalse(zombie.isScreaming(), "Le zombie ne devrait pas crier lorsque la moralité est au-dessus du seuil de cri.");
    }

    @Test
    public void testRegenerate() {
        zombie.setAlive(false);  // Le zombie est censé être mort initialement.
        zombie.regenerate();
        assertTrue(zombie.isAlive(), "Le zombie devrait être vivant après la régénération.");
    }

    @Test
    public void testToString() {
        String expectedString = "Creature{name='TestZombie', gender=Male, weight=70.0, height=1.8, age=30, moralityRate=100, alive=true}, race=Zombie";
        assertEquals(expectedString, zombie.toString(), "La méthode toString() devrait retourner une chaîne correctement formatée.");
    }
}