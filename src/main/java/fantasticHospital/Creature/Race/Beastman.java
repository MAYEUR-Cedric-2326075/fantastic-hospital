package fantasticHospital.Creature.Race;

import java.util.List;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Poor;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Race.Race;


public class Beastman extends Creature implements Poor, Contaminator{

    // Race spécifique
    private static final Race race = Race.BEASTMAN;
    @Override
    public Race getRace() {
        return race;
    }
/*
    @Override
    public void setRace(Race race) {
        this.race = race;
    }
*/
    @Override
    public void waiting() {
        System.out.println("The Poor Beastman is waiting in the dirt...");
    }
    public void contaminate(Creature creature){}
    public Beastman(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    public static void main(String[] args) {
        // Création d'un Beastman avec des attributs fictifs
        Beastman beastman = new Beastman(
                "Tormak",   // nom
                true,       // sexe (true pour masculin)
                80.5,       // poids en kg
                2.1,        // taille en mètres
                25,         // âge
                true        // indicateur de moral (true pour morale élevée)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + beastman.getName());
        System.out.println("Race: " + beastman.getRace());
        System.out.println("Poids: " + beastman.getWeight() + " kg");
        System.out.println("Taille: " + beastman.getHeight() + " m");
        System.out.println("Morale: " + (beastman.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        beastman.waiting();  // L'appel de la méthode waiting de l'interface Poor
        beastman.rage();     // L'appel de la méthode rage héritée de Creature
        beastman.getIll("Fever");  // Appel de la méthode getIll de Creature
        beastman.heal("Fever");  // Appel de la méthode heal de Creature
        beastman.scream();  // Appel de la méthode scream de Creature
        beastman.die();     // Appel de la méthode die de Creature
        beastman.contaminate(beastman);  // Appel de la méthode contaminate
    }
}
