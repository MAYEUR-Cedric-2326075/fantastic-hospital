package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.Race.Race;

public class Dwarf extends Creature implements Vip {

    private static final Race race = Race.DWARF;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        // Comportement spécifique des Nains lorsqu'ils attendent
        System.out.println("The Dwarf is waiting patiently, with a proud stance...");
    }

    public Dwarf(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    // Main pour tester la classe Dwarf
    public static void main(String[] args) {
        // Création d'un Dwarf avec des attributs fictifs
        Dwarf dwarf = new Dwarf(
                "Thorin",   // nom
                true,       // sexe (true pour masculin)
                85.0,       // poids en kg
                1.4,        // taille en mètres (les Nains sont souvent plus petits)
                150,        // âge (les Nains vivent longtemps)
                true        // indicateur de moral (true pour morale élevée)
        );

        // Affichage de l'état initial
        System.out.println("Nom: " + dwarf.getName());
        System.out.println("Race: " + dwarf.getRace());
        System.out.println("Poids: " + dwarf.getWeight() + " kg");
        System.out.println("Taille: " + dwarf.getHeight() + " m");
        System.out.println("Morale: " + (dwarf.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel des comportements
        dwarf.waiting();  // L'appel de la méthode waiting de l'interface Vip
        dwarf.rage();     // L'appel de la méthode rage héritée de Creature
        dwarf.getIll("Cold");  // Appel de la méthode getIll de Creature
        dwarf.heal("Cold");  // Appel de la méthode heal de Creature
        dwarf.scream();  // Appel de la méthode scream de Creature
        dwarf.die();     // Appel de la méthode die de Creature
    }
}
