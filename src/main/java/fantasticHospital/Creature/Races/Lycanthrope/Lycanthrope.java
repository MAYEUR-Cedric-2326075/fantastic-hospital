package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.Aging;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.PoorFertileRace;
import fantasticHospital.Tools.Randomizer;

public abstract class  Lycanthrope extends Creature implements PoorWaiter, Aging, Randomizer {

    // Classe de gestion du classement
    private static LycanthropeRanking ranking = new LycanthropeRanking();

    // Race spécifique aux Lycanthropes
    private static PoorFertileRace race = new PoorFertileRace(
            "Lycanthrope", 20, 15, 20, 40, 60, 10, 20, 30
    );

    protected void inheritTraits(Lycanthrope child, Lycanthrope secondParent) {
        // Introduce randomness in inheritance using generateRandomFloat
        double randomnessWeight = generateRandomFloat(-0.5f, 1.5f);
        double randomnessHeight = generateRandomFloat(-0.5f, 1.5f);
        double randomnessStrength = generateRandomFloat(-0.5f, 1.5f);
        double randomnessImpetuosity = generateRandomFloat(-0.5f, 1.5f);

        // Calculate the child's traits with randomness
        double childWeight = ((this.getWeight() + secondParent.getWeight()) / 2) * randomnessWeight;
        double childHeight = ((this.getHeight() + secondParent.getHeight()) / 2) * randomnessHeight;
        int childStrength = (int) (((this.getStrength() + secondParent.getStrength()) / 2) * randomnessStrength);
        int childDominationExercised = 0; // No initial domination
        int childImpetuosity = (int) (((this.getImpetuosity() + secondParent.getImpetuosity()) / 2) * randomnessImpetuosity);

        // Update the child's attributes
        child.setWeight(Math.max(childWeight, 1.0)); // Ensure weight is positive
        child.setHeight(Math.max(childHeight, 1.0)); // Ensure height is positive
        child.setStrength(Math.max(childStrength, 1)); // Ensure strength is positive
        child.setDominationExercised(childDominationExercised);
        child.setImpetuosity(Math.max(childImpetuosity, 1)); // Ensure impetuosity is positive
        child.setAge(0); // Newborn age
    }




    private  int strength;
    private  int dominationExercised;
    private  int impetuosity;


    // Calcul du rang du Lycanthrope
    public int getRank() {
        return ranking.getRank(this);
    }

    public  int getLevel(){
        if(getAgeCategory()==AgeCategory.JEUNE)
            return strength+dominationExercised+getRank()+1;
        else{
            if(getAgeCategory()==AgeCategory.ADULTE)
                return strength+dominationExercised+getRank()+3;

        }
        return strength+dominationExercised+getRank();

    }
    public int getImpetuosity() {
        return impetuosity;
    }
    public abstract boolean isMale();
    public abstract boolean isFemale();
    public void setImpetuosity(int impetuosity) {
        this.impetuosity = impetuosity;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getDominationExercised() {
        return dominationExercised;
    }
    public void setDominationExercised(int dominationExercised) {
        this.dominationExercised = dominationExercised;
        ranking.updateScore(this, dominationExercised);
    }
    int getDomanationFactor(Lycanthrope other) {return this.getDominationExercised()-other.getDominationExercised();}
    public static PoorFertileRace getRace() {return race;}
    @Override
    public AgeCategory getAgeCategory() {
        int age = this.getAge();
        if (age <= race.getYoungAge())
            return AgeCategory.JEUNE;
        else {
            if (age <=race.getOldAge())
                return AgeCategory.ADULTE;
            return AgeCategory.VIEUX;
        }
    }

    @Override
    public void waiting(boolean isAlone) {
        if (isAlone) {
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithoutPeaple());
        } else {
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithPeaple());
        }
    }
    @Override
    public void die() {
        this.setAlive(false);
    }
    @Override
    public boolean isInRage(){return this.getMoralityRate()<race.getRateOfMoralityBeginningRage()&&
            this.isAlive()&&
            this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }

    // Vérifier si le Beastman est en train de crier
    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningScream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }

    // Constructeur
    public Lycanthrope(String name, double weight, double height, int age) {
        super(name, weight, height, age);
        Lycanthrope.ranking.addLycanthrope(this);

    }
    @Override
    public void setAlive(boolean alive) {
        if(!alive&&isAlive()){
            super.setAlive(alive);
            Lycanthrope.ranking.removeLycanthrope(this);
        }
        else{
            if(alive&&!isAlive()){
                super.setAlive(false);
                Lycanthrope.ranking.addLycanthrope(this);;
            }
        }

    }

    /*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Lycanthropes
        System.out.println(this.getName() + " contaminates " + creature.getName() + " with lycanthropy.");
    }
    */
}
