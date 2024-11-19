package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Poor;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Race.Race;

public class Zombie extends Creature implements Poor, Regenerator {

    private static final Race race = Race.ZOMBIE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique d'attente des Zombies
        System.out.println("The Zombie is waiting in the graveyard, sluggish and slow...");
    }

    @Override
    public void regenerate() {
        // Comportement spécifique de régénération des Zombies
        System.out.println("The Zombie regenerates slowly, parts of its body stitching together...");
    }

    public Zombie(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Zombie
    public static void main(String[] args) {
        // Création d'un Zombie avec des attributs fictifs
        Zombie zombie = new Zombie(
                "Zorg",     // nom
                false,      // sexe (false pour masculin, représenté par un zombie)
                70.0,       // poids en kg
                1.8,        // taille en mètres
                30,         // âge
                false       // indicateur de moral (false pour moral bas, typique d'un zombie)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + zombie.getName());
        System.out.println("Race: " + zombie.getRace());
        System.out.println("Poids: " + zombie.getWeight() + " kg");
        System.out.println("Taille: " + zombie.getHeight() + " m");
        System.out.println("Morale: " + (zombie.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        zombie.waiting();  // L'appel de la méthode waiting de l'interface Poor
        zombie.rage();     // L'appel de la méthode rage héritée de Creature
        zombie.getIll("Decay");  // Appel de la méthode getIll de Creature
        zombie.heal("Decay");  // Appel de la méthode heal de Creature
        zombie.scream();  // Appel de la méthode scream de Creature
        zombie.die();     // Appel de la méthode die de Creature
        zombie.regenerate();  // Appel de la méthode regenerate
    }
}
