package fantasticHospital.Creature.Races.Lycanthrope;
import fantasticHospital.Creature.Races.Lycanthrope.LycanthropeFemale;
import fantasticHospital.Creature.Behavior.Reproduiser;
import fantasticHospital.Tools.Randomizer;

import java.util.HashSet;
import java.util.Set;

public class LycanthropeAlphaFemale extends LycanthropeFemale implements Reproduiser<LycanthropeFemale, LycanthropeMale>{
    // Constructeur
    public LycanthropeAlphaFemale(LycanthropeFemale lycanthropeFemale) {
        super(
                lycanthropeFemale.getName(),
                lycanthropeFemale.getWeight(),
                lycanthropeFemale.getHeight(),
                lycanthropeFemale.getAge(),
                lycanthropeFemale.getStrength(),
                lycanthropeFemale.getDominationExercised(),
                lycanthropeFemale.getImpetuosity()
        );
    }

    //private float getLuck(){return  1;}

    @Override
    public LycanthropeFemale reproduise(LycanthropeMale father, String name) {
        if (!this.isFertiled() || !father.isFertiled()) {
            throw new IllegalStateException("Reproduction impossible: one or both parents are infertile.");
        }
        // Create the child with placeholder values
        LycanthropeFemale child = new LycanthropeFemale(name, 0, 0, 0, 0, 0, 0);
        // Use inheritTraits to update the child's traits based on both parents
        inheritTraits(child, father);
        return child;
    }


    @Override
    public LycanthropeFemale reproduise(LycanthropeMale father) {
        String randomName = generateRandomName(generateRandomNumber(3, 20));
        return reproduise(father, randomName);
    }
    @Override
    public Set<LycanthropeFemale> reproduiseLitter(LycanthropeMale father) {
        int litterSize = generateRandomNumber(1, 3); // Number of offspring
        Set<LycanthropeFemale> litter = new HashSet<>();

        for (int i = 0; i < litterSize; i++) {
            litter.add(reproduise(father)); // Use random names
        }

        return litter;
    }

    @Override
    public Set<LycanthropeFemale> reproduiseLitter(LycanthropeMale father, Set<String> names) {
        if (names.isEmpty())
            throw new IllegalArgumentException("At least one name must be provided for the litter.");
        Set<LycanthropeFemale> litter = new HashSet<>();
        for (String name : names)
            litter.add(reproduise(father, name));
        return litter;
    }
}
