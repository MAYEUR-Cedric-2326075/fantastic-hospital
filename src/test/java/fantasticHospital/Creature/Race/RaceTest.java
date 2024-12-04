package fantasticHospital.Creature.Race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    // Classe stub pour tester Race
    static class RaceStub extends Race {
        public RaceStub(String raceName, int rateOfMoralitybeginningSream, int rateOfMoralityBeginningRage) {
            super(raceName, rateOfMoralitybeginningSream, rateOfMoralityBeginningRage);
        }

        @Override
        public boolean isVip() {
            return true;
        }
    }

    @Test
    void testConstructorAndGetters() {
        // Instanciation via la classe stub
        Race race = new RaceStub("StubRace", 10, 20);

        // Vérification des valeurs initiales
        assertEquals("StubRace", race.getRaceName());
        assertEquals(10, race.getRateOfMoralitybeginningSream());
        assertEquals(20, race.getRateOfMoralityBeginningRage());
    }

    @Test
    void testSetters() {
        // Instanciation via la classe stub
        Race race = new RaceStub("StubRace", 10, 20);

        // Modification des attributs via setters
        race.setRateOfMoralitybeginningSream(15);
        race.setRateOfMoralityBeginningRage(25);
        race.setRaceName("NewStubRace");

        // Vérification des nouvelles valeurs
        assertEquals(15, race.getRateOfMoralitybeginningSream());
        assertEquals(25, race.getRateOfMoralityBeginningRage());
        assertEquals("NewStubRace", race.getRaceName());
    }

    @Test
    void testToString() {
        // Instanciation via la classe stub
        Race race = new RaceStub("StubRace", 10, 20);

        // Vérification de la chaîne retournée par toString
        String expected = "Race{raceName='StubRace', rateOfMoralitybeginningSream=10, rateOfMoralityBeginningRage=20}";
        assertEquals(expected, race.toString());
    }

    @Test
    void testIsVip() {
        // Instanciation via la classe stub
        Race race = new RaceStub("StubRace", 10, 20);

        // Vérification de la méthode isVip()
        assertTrue(race.isVip(), "RaceStub should be a VIP");
    }
}