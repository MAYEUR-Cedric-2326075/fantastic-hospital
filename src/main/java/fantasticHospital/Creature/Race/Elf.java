package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Race.Race;

public class Elf extends Creature implements Vip, Demoralizer {

    private static final Race race = Race.ELF;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique d'attente des Elfes
        System.out.println("The Elf is waiting in their grand hall, enjoying the luxury...");
    }

    @Override
    public void demoralize() {
        // Comportement spécifique de démoralisation des Elfes
        System.out.println("The Elf demoralizes the creature with their cold and calculating stare...");
    }

    public Elf(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Elf
    public static void main(String[] args) {
        // Création d'un Elfe avec des attributs fictifs
        Elf elf = new Elf(
                "Elrond",    // nom
                true,        // sexe (true pour masculin)
                70.0,        // poids en kg
                1.75,        // taille en mètres
                150,         // âge
                true         // indicateur de moral (true pour morale élevée)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + elf.getName());
        System.out.println("Race: " + elf.getRace());
        System.out.println("Poids: " + elf.getWeight() + " kg");
        System.out.println("Taille: " + elf.getHeight() + " m");
        System.out.println("Morale: " + (elf.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        elf.waiting();  // L'appel de la méthode waiting de l'interface Vip
        elf.rage();     // L'appel de la méthode rage héritée de Creature
        elf.getIll("Nausea");  // Appel de la méthode getIll de Creature
        elf.heal("Nausea");  // Appel de la méthode heal de Creature
        elf.scream();  // Appel de la méthode scream de Creature
        elf.die();     // Appel de la méthode die de Creature
        elf.demoralize();  // Appel de la méthode demoralize
    }
}
