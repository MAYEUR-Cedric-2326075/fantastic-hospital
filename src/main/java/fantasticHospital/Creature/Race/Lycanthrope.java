package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Poor;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Race.Race;

public class Lycanthrope extends Creature implements Poor, Contaminator {

    private static final Race race = Race.LYCANTHROPE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique d'attente des Lycanthropes
        System.out.println("The Poor Lycanthrope is waiting under the full moon...");
    }

    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Lycanthropes
        System.out.println("The Lycanthrope contaminates the creature with lycanthropy...");
    }

    public Lycanthrope(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Lycanthrope
    public static void main(String[] args) {
        // Création d'un Lycanthrope avec des attributs fictifs
        Lycanthrope lycanthrope = new Lycanthrope(
                "Lycara",    // nom
                true,        // sexe (true pour masculin)
                75.0,        // poids en kg
                1.85,        // taille en mètres
                30,          // âge
                false        // indicateur de moral (false pour morale basse)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + lycanthrope.getName());
        System.out.println("Race: " + lycanthrope.getRace());
        System.out.println("Poids: " + lycanthrope.getWeight() + " kg");
        System.out.println("Taille: " + lycanthrope.getHeight() + " m");
        System.out.println("Morale: " + (lycanthrope.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        lycanthrope.waiting();  // L'appel de la méthode waiting de l'interface Poor
        lycanthrope.rage();     // L'appel de la méthode rage héritée de Creature
        lycanthrope.getIll("Lycanthropy");  // Appel de la méthode getIll de Creature
        lycanthrope.heal("Lycanthropy");  // Appel de la méthode heal de Creature
        lycanthrope.scream();  // Appel de la méthode scream de Creature
        lycanthrope.die();     // Appel de la méthode die de Creature
        lycanthrope.contaminate(lycanthrope);  // Appel de la méthode contaminate
    }
}
