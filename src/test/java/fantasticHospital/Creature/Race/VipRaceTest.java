package fantasticHospital.Creature.Race;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VipRaceTest {

    @Test
    void testConstructorAndGetters() {
        // Instanciation d'un objet VipRace
        VipRace vipRace = new VipRace("VIP", 15, 25, 35);

        // Vérification des valeurs initiales
        assertEquals("VIP", vipRace.getRaceName());
        assertEquals(15, vipRace.getRateOfMoralitybeginningSream());
        assertEquals(25, vipRace.getRateOfMoralityBeginningRage());
        assertEquals(35, vipRace.getRateOfReduction());
    }

    @Test
    void testSetters() {
        // Instanciation d'un objet VipRace
        VipRace vipRace = new VipRace("VIP", 15, 25, 35);

        // Modification des attributs via setters
        vipRace.setRateOfMoralitybeginningSream(20);
        vipRace.setRateOfMoralityBeginningRage(30);
        vipRace.setRateOfReduction(40);
        vipRace.setRaceName("NewVIP");

        // Vérification des nouvelles valeurs
        assertEquals(20, vipRace.getRateOfMoralitybeginningSream());
        assertEquals(30, vipRace.getRateOfMoralityBeginningRage());
        assertEquals(40, vipRace.getRateOfReduction());
        assertEquals("NewVIP", vipRace.getRaceName());
    }

    @Test
    void testIsVip() {
        // Instanciation d'un objet VipRace
        VipRace vipRace = new VipRace("VIP", 15, 25, 35);

        // Vérification de la méthode isVip()
        assertFalse(vipRace.isVip(), "VipRace should not be a VIP");
    }

    @Test
    void testToString() {
        // Instanciation d'un objet VipRace
        VipRace vipRace = new VipRace("VIP", 15, 25, 35);

        // Vérification de la chaîne retournée par toString
        String expected = "VipRace{raceName='VIP', rateOfMoralitybeginningSream=15, rateOfMoralityBeginningRage=25, rateOfReduction=35}";
        assertEquals(expected, vipRace.toString());
    }

}