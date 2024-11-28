package fantasticHospital.Creature.Races.Lycanthrope;
import fantasticHospital.Creature.Races.Lycanthrope.LycanthropeFemale;
import fantasticHospital.Creature.Behavior.Reproduiser;
import fantasticHospital.Tools.Randomizer;

import java.util.HashSet;
import java.util.Set;

public class LycanthropeAlphaMale extends LycanthropeFemale implements Reproduiser<LycanthropeFemale, LycanthropeMale>{
    // Constructeur
    public LycanthropeAlphaMale(LycanthropeFemale lycanthropeFemale) {
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

    @Override
    public LycanthropeFemale reproduise(LycanthropeMale father, String name) {
        if (!this.isFertiled() || !father.isFertiled()) {
            throw new IllegalStateException("Reproduction impossible: one or both parents are infertile.");
        }

        // Create the child with placeholder values
        LycanthropeFemale child = new LycanthropeFemale(name, 0, 0, 0,
                0, 0, 0,generateRandomBoolean());

        // Use inheritTraits to update the child's traits based on both parents
        inheritTraits(child, father);

        return child;
    }

    /**
     * Creates a single offspring with a random name.
     */
    @Override
    public LycanthropeFemale reproduise(LycanthropeMale father) {
        String randomName = generateRandomName(generateRandomNumber(3, 20));
        return reproduise(father, randomName);
    }

    /**
     * Creates a litter of offspring with random names.
     */
    @Override
    public Set<LycanthropeFemale> reproduiseLitter(LycanthropeMale father) {
        int litterSize = generateRandomNumber(1, 3); // Number of offspring
        Set<LycanthropeFemale> litter = new HashSet<>();

        for (int i = 0; i < litterSize; i++) {
            litter.add(reproduise(father)); // Use random names
        }

        return litter;
    }

    /**
     * Creates a litter of offspring with specified names.
     */
    @Override
    public Set<LycanthropeFemale> reproduiseLitter(LycanthropeMale father, Set<String> names) {
        if (names.size() < 1) {
            throw new IllegalArgumentException("At least one name must be provided for the litter.");
        }

        Set<LycanthropeFemale> litter = new HashSet<>();
        for (String name : names) {
            litter.add(reproduise(father, name));
        }

        return litter;
    }


}
