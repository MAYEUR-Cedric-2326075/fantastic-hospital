package fantasticHospital.Creature.Race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoorRaceTest {

    @Test
    void testConstructorAndGetters() {
        // Initialisation d'un objet PoorRace
        PoorRace poorRace = new PoorRace("Poor", 10, 20, 30, 40);

        // Vérification des valeurs initiales
        assertEquals("Poor", poorRace.getRaceName());
        assertEquals(10, poorRace.getRateOfMoralitybeginningSream());
        assertEquals(20, poorRace.getRateOfMoralityBeginningRage());
        assertEquals(30, poorRace.getRateOfReductionWithPeaple());
        assertEquals(40, poorRace.getRateOfReductionWithoutPeaple());
    }

    @Test
    void testSetters() {
        // Initialisation d'un objet PoorRace
        PoorRace poorRace = new PoorRace("Poor", 10, 20, 30, 40);

        // Modification des attributs via setters
        poorRace.setRateOfReductionWithPeaple(50);
        poorRace.setRateOfReductionWithoutPeaple(60);

        // Vérification des nouvelles valeurs
        assertEquals(50, poorRace.getRateOfReductionWithPeaple());
        assertEquals(60, poorRace.getRateOfReductionWithoutPeaple());
    }

    @Test
    void testIsVip() {
        // Initialisation d'un objet PoorRace
        PoorRace poorRace = new PoorRace("Poor", 10, 20, 30, 40);

        // Vérification de la méthode isVip()
        assertFalse(poorRace.isVip(), "PoorRace should not be a VIP");
    }

    @Test
    void testToString() {
        // Initialisation d'un objet PoorRace
        PoorRace poorRace = new PoorRace("Poor", 10, 20, 30, 40);

        // Vérification de la chaîne retournée par toString
        String expected = "PoorRace{raceName='Poor', rateOfMoralitybeginningSream=10, " +
                "rateOfMoralityBeginningRage=20, rateOfReductionWithPeaple=30, " +
                "rateOfReductionWithoutPeaple=40}";
        assertEquals(expected, poorRace.toString());
    }

}