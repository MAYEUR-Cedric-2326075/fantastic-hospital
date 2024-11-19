package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Poor;
import fantasticHospital.Creature.StatusEffect.Contaminator;
import fantasticHospital.Creature.Race.Race;

public class Orc extends Creature implements Poor, Contaminator {

    // Race spécifique
    private static final Race race = Race.ORC;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        System.out.println("The Poor Orc is waiting in the mud...");
    }

    @Override
    public void contaminate(Creature creature) {
        System.out.println("The Orc contaminates the creature with its foul aura.");
    }

    public Orc(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    public static void main(String[] args) {
        // Création d'un Orc avec des attributs fictifs
        Orc orc = new Orc(
                "Grommash",  // nom
                true,        // sexe (true pour masculin)
                110.0,       // poids en kg
                2.4,         // taille en mètres
                35,          // âge
                false        // indicateur de moral (false pour morale basse)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + orc.getName());
        System.out.println("Race: " + orc.getRace());
        System.out.println("Poids: " + orc.getWeight() + " kg");
        System.out.println("Taille: " + orc.getHeight() + " m");
        System.out.println("Morale: " + (orc.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        orc.waiting();  // L'appel de la méthode waiting de l'interface Poor
        orc.rage();     // L'appel de la méthode rage héritée de Creature
        orc.getIll("Plague");  // Appel de la méthode getIll de Creature
        orc.heal("Plague");  // Appel de la méthode heal de Creature
        orc.scream();  // Appel de la méthode scream de Creature
        orc.die();     // Appel de la méthode die de Creature
        orc.contaminate(orc);  // Appel de la méthode contaminate
    }
}
