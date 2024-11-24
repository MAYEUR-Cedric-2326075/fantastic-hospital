package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.Aging;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.PoorRace;

public class Lycanthrope extends Creature implements PoorWaiter, Aging {

    // Race spécifique
    private static LycanthropeRanking ranking = new LycanthropeRanking();
    private static PoorRace race = new PoorRace("Lycanthrope", 20,
            15,20,40,60, 10, 20);
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
    public static PoorRace getRace() {return race;}
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
    public Lycanthrope(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
        Lycanthrope.ranking.addLycanthrope(this);

    }

    /*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Lycanthropes
        System.out.println(this.getName() + " contaminates " + creature.getName() + " with lycanthropy.");
    }
    */
}
