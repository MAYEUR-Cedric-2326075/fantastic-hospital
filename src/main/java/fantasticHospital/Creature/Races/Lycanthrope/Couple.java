package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.Reproduiser;
import fantasticHospital.Creature.Behavior.TraitInheritance;
import fantasticHospital.Tools.Randomizer;
import java.util.HashSet;
import java.util.Set;

public class Couple<Specie, SpecieMale extends Specie, SpecieFemale extends TraitInheritance<Specie>>
        implements Reproduiser<Specie>, Randomizer {
    // Instance variables
    private SpecieMale male;
    private SpecieFemale female;
    private static final String defaultName="NoName";
    // Constructor
    public Couple(SpecieMale male, SpecieFemale female) {
        this.male = male;
        this.female = female;
    }

    // Methods from Reproduiser
    @Override
    public Set<Specie> reproduiseLitter(int numberOfChildren) {
        Set<Specie> litter = new HashSet<>();
        Set<String> names = new HashSet<>();
        for (int i = 0; i < numberOfChildren; i++) {
            names.add(Couple.defaultName);
        }
        return reproduiseLitter(names,numberOfChildren);
    }

    @Override
    public Set<Specie> reproduiseLitter(Set<String> names, int numberOfChildren) {
        Set<Specie> litter = new HashSet<>();
        for (String name : names) {
            litter.add(reproduise(name));
        }
        return litter;
    }

    @Override
    public Specie reproduise() {
        return createOffspring(Couple.defaultName);
    }

    @Override
    public Specie reproduise(String name) {
        return createOffspring(name);
    }

    private Specie createOffspring(String name) {
        try {
            Specie offspring = (Specie) male.getClass().getDeclaredConstructor().newInstance();
            female.inheritTraits(offspring, male);
            return offspring;
        }
        catch (Exception e){
            throw new RuntimeException("Impossible de créer un descendant", e);
        }
    }


    // Getters and Setters
    public SpecieMale getMale() {
        return male;
    }

    public void setMale(SpecieMale male) {
        this.male = male;
    }

    public SpecieFemale getFemale() {
        return female;
    }

    public void setFemale(SpecieFemale female) {
        this.female = female;
    }
}
