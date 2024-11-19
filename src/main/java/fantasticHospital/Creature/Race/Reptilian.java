package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.Race.Race;

public class Reptilian extends Creature implements Vip {

    private static final Race race = Race.REPTILIAN;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique des Reptiliens lorsqu'ils attendent
        System.out.println("The Reptilian waits with a cold, calculating gaze...");
    }

    public Reptilian(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Reptilian
    public static void main(String[] args) {
        // Création d'un Reptilian avec des attributs fictifs
        Reptilian reptilian = new Reptilian(
                "Skrillex",   // nom
                true,         // sexe (true pour masculin)
                90.0,         // poids en kg
                2.2,          // taille en mètres
                120,          // âge (les Reptiliens sont souvent très vieux)
                true          // indicateur de moral (true pour morale élevée)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + reptilian.getName());
        System.out.println("Race: " + reptilian.getRace());
        System.out.println("Poids: " + reptilian.getWeight() + " kg");
        System.out.println("Taille: " + reptilian.getHeight() + " m");
        System.out.println("Morale: " + (reptilian.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        reptilian.waiting();  // L'appel de la méthode waiting de l'interface Vip
        reptilian.rage();     // L'appel de la méthode rage héritée de Creature
        reptilian.getIll("Toxic Shock");  // Appel de la méthode getIll de Creature
        reptilian.heal("Toxic Shock");  // Appel de la méthode heal de Creature
        reptilian.scream();  // Appel de la méthode scream de Creature
        reptilian.die();     // Appel de la méthode die de Creature
    }
}
