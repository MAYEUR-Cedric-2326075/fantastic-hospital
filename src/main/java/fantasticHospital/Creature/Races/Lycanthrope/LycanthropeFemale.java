package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.Reproduiser;
import fantasticHospital.Tools.Randomizer;

import java.util.HashSet;
import java.util.Set;

public class LycanthropeFemale extends Lycanthrope {

    // Constructeur
    public LycanthropeFemale(String name, double weight, double height, int age, int strength, int dominationExercised, int impetuosity) {
        super(name, weight, height, age);
        this.setStrength(strength);
        this.setDominationExercised(dominationExercised);
        this.setImpetuosity(impetuosity);
    }

    // Vérifie si la femelle est fertile
    public boolean isFertiled() {
        return Lycanthrope.getRace().isFertiled();
    }
    public boolean isFemale() {return true;}
    public boolean isMale() {return false;}


}
