package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.VipRace;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {

    @Test
    void testConstructorAndGetRace() {
        // Création d'un Elf
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);

        // Vérification des attributs de base
        assertEquals("Legolas", elf.getName());
        assertTrue(elf.getGender());
        assertEquals(70.0, elf.getWeight());
        assertEquals(1.85, elf.getHeight());
        assertEquals(100, elf.getAge());

        // Vérification de la race
        VipRace race = elf.getRace();
        assertEquals("Elf", race.getRaceName());
        assertEquals(20, race.getRateOfMoralitybeginningSream());
        assertEquals(10, race.getRateOfMoralityBeginningRage());
        assertEquals(30, race.getRateOfReduction());
    }

    @Test
    void testWaiting() {
        // Création d'un Elf avec une moralité initiale
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);
        elf.setMoralityRate(50);

        // Réduction de la moralité après avoir attendu
        elf.waiting();
        assertEquals(20, elf.getMoralityRate()); // 50 - 30
    }

    @Test
    void testIsInRage() {
        // Création d'un Elf avec une moralité initiale
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);

        // Test dans l'état de rage
        elf.setMoralityRate(5);
        assertTrue(elf.isInRage(), "Elf should be in rage with morality below rage threshold");

        // Test hors de l'état de rage
        elf.setMoralityRate(15);
        assertFalse(elf.isInRage(), "Elf should not be in rage with morality above threshold");
    }

    @Test
    void testIsScreaming() {
        // Création d'un Elf avec une moralité initiale
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);

        // Test en train de crier
        elf.setMoralityRate(15);
        assertTrue(elf.isScreaming(), "Elf should be screaming with morality in screaming range");

        // Test lorsque la moralité est trop basse
        elf.setMoralityRate(5);
        assertFalse(elf.isScreaming(), "Elf should not be screaming when morality is too low");

        // Test lorsque la moralité est trop haute
        elf.setMoralityRate(25);
        assertFalse(elf.isScreaming(), "Elf should not be screaming when morality is too high");
    }

    @Test
    void testDemoralizeSingleCreature() {
        // Création d'un Elf et d'une créature cible
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);
        Creature target = new Elf("Target", false, 60.0, 1.65, 50);
        target.setMoralityRate(50);

        // Elf démoralise la créature cible
        elf.demoralize(target);
        assertEquals(40, target.getMoralityRate(), "Target's morality should decrease by 20");
    }

    @Test
    void testDemoralizeMultipleCreatures() {
        // Création d'un Elf et de plusieurs créatures cibles
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);
        Creature target1 = new Elf("Target1", false, 60.0, 1.65, 50);
        Creature target2 = new Elf("Target2", false, 65.0, 1.70, 55);

        target1.setMoralityRate(50);
        target2.setMoralityRate(40);

        Set<Creature> targets = new HashSet<>();
        targets.add(target1);
        targets.add(target2);

        // Elf démoralise les créatures
        elf.demoralize(targets);

        assertEquals(40, target1.getMoralityRate(), "Target1's morality should decrease by 10");
        assertEquals(30, target2.getMoralityRate(), "Target2's morality should decrease by 10");
    }

    @Test
    void testToString() {
        // Création d'un Elf
        Elf elf = new Elf("Legolas", true, 70.0, 1.85, 100);

        // Vérification de la chaîne retournée
        String expected = "Creature{name='Legolas', gender=Male, weight=70.0, height=1.85, age=100, moralityRate=100, alive=true}, race=Elf";
        assertEquals(expected, elf.toString());
    }
}