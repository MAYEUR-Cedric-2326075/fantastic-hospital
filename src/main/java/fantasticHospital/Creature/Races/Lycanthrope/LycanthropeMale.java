package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Tools.Randomizer;

public class LycanthropeMale extends Lycanthrope implements Randomizer {

    // Constructeur
    public LycanthropeMale(String name, double weight, double height, int age, int strength, int dominationExercised, int impetuosity) {
        super(name, weight, height, age);
        this.setStrength(strength);
        this.setDominationExercised(dominationExercised);
        this.setImpetuosity(impetuosity);
    }

    // Vérifie si le mâle est fertile
    public boolean isFertiled() {
        return Lycanthrope.getRace().isFertiled();
    }
    public boolean isFemale() {return true;}
    public boolean isMale() {return false;}

    public LycanthropeFemale reproduiseWith(LycanthropeFemale female) {
        if (!this.isFertiled() || !female.isFertiled()) {
            throw new IllegalStateException("Reproduction impossible : l'un ou les deux parents ne sont pas fertiles.");
        }

        String childName = generateRandomName(8); // Nom aléatoire
        double childWeight = (this.getWeight() + female.getWeight()) / 2;
        double childHeight = (this.getHeight() + female.getHeight()) / 2;
        int childAge = 0; // Les enfants naissent avec un âge de 0
        int childStrength = (this.getStrength() + female.getStrength()) / 2;
        int childDominationExercised = 0; // Pas de domination initiale
        int childImpetuosity = (this.getImpetuosity() + female.getImpetuosity()) / 2;

        return new LycanthropeFemale(
                childName,
                childWeight,
                childHeight,
                childAge,
                childStrength,
                childDominationExercised,
                childImpetuosity
        );
    }

    /**
     * Reproduction avec une femelle avec un nom spécifique pour le descendant.
     *
     * @param female La femelle avec laquelle se reproduire.
     * @param name   Le nom à donner au descendant.
     * @return Un descendant unique généré avec un nom spécifique.
     */
    public LycanthropeFemale reproduiseWith(LycanthropeFemale female, String name) {
        if (!this.isFertiled() || !female.isFertiled()) {
            throw new IllegalStateException("Reproduction impossible : l'un ou les deux parents ne sont pas fertiles.");
        }

        double childWeight = (this.getWeight() + female.getWeight()) / 2;
        double childHeight = (this.getHeight() + female.getHeight()) / 2;
        int childAge = 0; // Les enfants naissent avec un âge de 0
        int childStrength = (this.getStrength() + female.getStrength()) / 2;
        int childDominationExercised = 0; // Pas de domination initiale
        int childImpetuosity = (this.getImpetuosity() + female.getImpetuosity()) / 2;

        return new LycanthropeFemale(
                name,
                childWeight,
                childHeight,
                childAge,
                childStrength,
                childDominationExercised,
                childImpetuosity
        );
    }

    // Représentation textuelle
    @Override
    public String toString() {
        return "LycanthropeMale{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", strength=" + getStrength() +
                ", dominationExercised=" + getDominationExercised() +
                ", impetuosity=" + getImpetuosity() +
                ", rank=" + getRank() +
                '}';
    }
}
