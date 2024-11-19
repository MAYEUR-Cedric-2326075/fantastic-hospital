package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Race.Race;

public class Vampire extends Creature implements Vip, Regenerator, Demoralizer, Contaminator {

    private static final Race race = Race.VAMPIRE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique d'attente des Vampires
        System.out.println("The Vampire waits in the darkness, always vigilant...");
    }

    @Override
    public void regenerate() {
        // Comportement spécifique de régénération des Vampires
        System.out.println("The Vampire regenerates its wounds with a sinister aura...");
    }

    @Override
    public void demoralize() {
        // Comportement spécifique de démoralisation des Vampires
        System.out.println("The Vampire uses its dark charm to demoralize " + "!");
    }

    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Vampires
        System.out.println("The Vampire infects " + creature.getName() + " with its dark curse!");
    }

    public Vampire(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Vampire
    public static void main(String[] args) {
        // Création d'un Vampire avec des attributs fictifs
        Vampire vampire = new Vampire(
                "Dracula",  // nom
                true,       // sexe (true pour masculin)
                75.0,       // poids en kg
                1.9,        // taille en mètres
                400,        // âge (environ 400 ans, typique d'un vampire)
                true        // indicateur de moral (true pour morale élevée)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + vampire.getName());
        System.out.println("Race: " + vampire.getRace());
        System.out.println("Poids: " + vampire.getWeight() + " kg");
        System.out.println("Taille: " + vampire.getHeight() + " m");
        System.out.println("Morale: " + (vampire.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        vampire.waiting();  // L'appel de la méthode waiting de l'interface Vip
        vampire.regenerate(); // L'appel de la méthode regenerate de l'interface Regenerator
        vampire.demoralize();  // L'appel de la méthode demoralize de l'interface Demoralizer
        vampire.contaminate(vampire);  // L'appel de la méthode contaminate de l'interface Contaminator
        vampire.rage(); // L'appel de la méthode rage héritée de Creature
        vampire.getIll("Bloodthirst"); // Appel de la méthode getIll de Creature
        vampire.heal("Bloodthirst"); // Appel de la méthode heal de Creature
        vampire.scream(); // Appel de la méthode scream de Creature
        vampire.die(); // Appel de la méthode die de Creature
    }
}
