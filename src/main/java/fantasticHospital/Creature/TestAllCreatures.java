package fantasticHospital.Creature;

import fantasticHospital.Creature.Races.*;
import fantasticHospital.Creature.Races.Lycanthrope.Lycanthrope;

public class TestAllCreatures {

    public static void main(String[] args) {
        testBeastman();
        testElf();
        testDwarf();
        testOrc();
        //testLycanthrope();
        testReptilian();
        testVampire();
        testZombie();
    }

    private static void testBeastman() {
        System.out.println("=== Test Beastman ===");
        Beastman beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        System.out.println("Nom : " + beastman.getName());
        System.out.println("Race : " + Beastman.getRace());
        System.out.println("Moralité initiale : " + beastman.getMoralityRate());
        beastman.waiting(true); // Attente seul
        System.out.println("Moralité après attente seul : " + beastman.getMoralityRate());
        beastman.waiting(false); // Attente en groupe
        System.out.println("Moralité après attente en groupe : " + beastman.getMoralityRate());
        System.out.println();
    }

    private static void testElf() {
        System.out.println("=== Test Elf ===");
        Elf elf = new Elf("Elarion", true, 70.0, 1.9, 120);
        System.out.println("Nom : " + elf.getName());
        System.out.println("Race : " + Elf.getRace());
        System.out.println("Moralité initiale : " + elf.getMoralityRate());
        elf.waiting(); // Attente
        System.out.println("Moralité après attente : " + elf.getMoralityRate());
        Beastman beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        elf.demoralize(beastman); // Elf démoralise un Beastman
        System.out.println("Moralité du Beastman après démoralisation : " + beastman.getMoralityRate());
        System.out.println();
    }

    private static void testDwarf() {
        System.out.println("=== Test Dwarf ===");
        Dwarf dwarf = new Dwarf("Borin", true, 90.0, 1.5, 50);
        System.out.println("Nom : " + dwarf.getName());
        System.out.println("Race : " + Dwarf.getRace());
        System.out.println("Moralité initiale : " + dwarf.getMoralityRate());
        dwarf.waiting(); // Attente
        System.out.println("Moralité après attente : " + dwarf.getMoralityRate());
        System.out.println();
    }

    private static void testOrc() {
        System.out.println("=== Test Orc ===");
        Orc orc = new Orc("Gorak", true, 120.0, 2.0, 35);
        System.out.println("Nom : " + orc.getName());
        System.out.println("Race : " + Orc.getRace());
        System.out.println("Moralité initiale : " + orc.getMoralityRate());
        orc.waiting(true); // Attente seul
        System.out.println("Moralité après attente seul : " + orc.getMoralityRate());
        orc.waiting(false); // Attente en groupe
        System.out.println("Moralité après attente en groupe : " + orc.getMoralityRate());
        System.out.println();
    }
/*
    private static void testLycanthrope() {
        System.out.println("=== Test Lycanthrope ===");
        Lycanthrope lycanthrope = new Lycanthrope("Lyco", true, 95.0, 1.8, 40);
        System.out.println("Nom : " + lycanthrope.getName());
        System.out.println("Race : " + Lycanthrope.getRace());
        System.out.println("Moralité initiale : " + lycanthrope.getMoralityRate());
        lycanthrope.waiting(true); // Attente seul
        System.out.println("Moralité après attente seul : " + lycanthrope.getMoralityRate());
        lycanthrope.waiting(false); // Attente en groupe
        System.out.println("Moralité après attente en groupe : " + lycanthrope.getMoralityRate());
        System.out.println();
    }
*/
    private static void testReptilian() {
        System.out.println("=== Test Reptilian ===");
        Reptilian reptilian = new Reptilian("Rex", false, 70.0, 1.6, 60);
        System.out.println("Nom : " + reptilian.getName());
        System.out.println("Race : " + Reptilian.getRace());
        System.out.println("Moralité initiale : " + reptilian.getMoralityRate());
        reptilian.waiting(); // Attente
        System.out.println("Moralité après attente : " + reptilian.getMoralityRate());
        System.out.println();
    }

    private static void testVampire() {
        System.out.println("=== Test Vampire ===");
        Vampire vampire = new Vampire("Dracul", true, 75.0, 1.85, 500);
        System.out.println("Nom : " + vampire.getName());
        System.out.println("Race : " + Vampire.getRace());
        System.out.println("Moralité initiale : " + vampire.getMoralityRate());
        vampire.waiting(); // Attente
        System.out.println("Moralité après attente : " + vampire.getMoralityRate());
        vampire.regenerate(); // Régénération
        System.out.println("Le Vampire est vivant après régénération : " + vampire.isAlive());
        Elf elf = new Elf("Elarion", true, 70.0, 1.9, 120);
        vampire.demoralize(elf); // Vampire démoralise un Elf
        System.out.println("Moralité de l'Elf après démoralisation : " + elf.getMoralityRate());
        System.out.println();
    }

    private static void testZombie() {
        System.out.println("=== Test Zombie ===");
        Zombie zombie = new Zombie("Zarg", false, 90.0, 1.8, 45);
        System.out.println("Nom : " + zombie.getName());
        System.out.println("Race : " + Zombie.getRace());
        System.out.println("Moralité initiale : " + zombie.getMoralityRate());
        zombie.waiting(false); // Attente en groupe
        System.out.println("Moralité après attente en groupe : " + zombie.getMoralityRate());
        zombie.regenerate(); // Régénération
        System.out.println("Le Zombie est vivant après régénération : " + zombie.isAlive());
        System.out.println();
    }
}
