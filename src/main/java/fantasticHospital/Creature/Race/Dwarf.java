package fantasticHospital.Creature.Race;

import java.util.List;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.StatusEffect.Regenerator;

public class Dwarf extends Creature implements Regenerator {

    public Dwarf(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        super(name, gender, weight, height, age, moraleIndicator);
    }

    @Override
    public void regenerate() {
        // Implementation of regeneration behavior
        System.out.println(this.getName() + " is regenerating.");
    }

    @Override
    public void waiting() {
        // Implement waiting behavior
    }

    @Override
    public void getAngry() {
        // Implement angry behavior
    }

    @Override
    public void fallIll() {
        // Implement fall ill behavior
    }

    @Override
    public void beTreated() {
        // Implement be treated behavior
    }

    @Override
    public void die() {
        // Implement die behavior
    }
    public static void main(String[] args) {

        // Création d'un Beastman avec des attributs fictifs
        Beastman beastman = new Beastman(
                "Tormak",   // nom
                true,       // sexe (true pour masculin)
                80.5,       // poids en kg
                2.1,        // taille en mètres
                25,         // âge
                true      // indicateur de moral (true pour morale élevée)

        );

        // Affichage de l'état initial
        System.out.println("Nom: " + beastman.getName());
        System.out.println("Age: " + beastman.getAge() + " ans");
        System.out.println("Poids: " + beastman.getWeight() + " kg");
        System.out.println("Taille: " + beastman.getHeight() + " m");
        //System.out.println("Maladies: " + beastman.getDiseasesList());
        System.out.println("Morale: " + (beastman.getMoraleIndicator() ? "Haut" : "Bas"));
        System.out.println();

        // Appel de la méthode 'regenerate' qui implémente l'interface 'Regenerator'
        beastman.regenerate();  // Le Beastman se régénère

        // Test d'autres comportements (par exemple, 'waiting', 'getAngry', etc.)
        beastman.waiting();
        beastman.getAngry();
        beastman.fallIll();
        beastman.beTreated();
        beastman.die();
    }
}
