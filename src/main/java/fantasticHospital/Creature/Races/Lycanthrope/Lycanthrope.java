package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.*;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.PoorFertileRace;
import fantasticHospital.Tools.Randomizer;

public abstract class  Lycanthrope extends Creature implements PoorWaiter, Aging, Randomizer {
//Static
    //Private

    private static PoorFertileRace race = new PoorFertileRace(
            "Lycanthrope", 20, 15, 20,
            40, 60, 10, 20, 30
    );

    //Protected

    //Public
    public static Pack PACK = new Pack();
    public PoorFertileRace getRace() {return race;}
//Abstract
    public abstract boolean isAlpha();
    public abstract boolean isMale();
    public abstract boolean isFemale();
//Instance
    //Private
    private final String identification;
    private  int strength;
    private  int impetuosity;
    public abstract void quitThePack();
    public abstract void joinThePack();
    protected Lycanthrope(){
        super("name", 0, 0, 0);
        this.impetuosity = 0;
        this.strength = 0;
        String identification = generateRandomName(15);
        this.identification = generateUniqueIdentification();
    }

    private String generateUniqueIdentification() {
        String id = generateRandomName(15);
        /*
        while (PACK.isInPack(id)) {
            id = generateRandomName(15);
        }
        */
        return id;
    }
    public abstract boolean getGender();
    public abstract boolean challengeAlpha();
    // Constructeur
    //Protected
    protected Lycanthrope(String name, double weight, double height, int age
            ,int strength,int impetuosity){
        super(name, weight, height, age);
        this.impetuosity = impetuosity;
        this.strength = strength;
        String identification = generateRandomName(15);
        /*
        while(PACK.isInPack(this))
            identification=generateRandomName(15);

         */
        this.identification = identification;
    }
    protected String getIdentification(){return identification;}


    //Public
    public Lycanthrope(String name, double weight, double height,
                       int age ,int strength,int impetuosity,boolean loneWolf) {
        this(name,weight,height,age,strength,impetuosity);
    }
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
        PACK.removeLycanthrope(this);
    }
    @Override
    public boolean isInRage(){return this.getMoralityRate()<race.getRateOfMoralityBeginningRage()&&
            this.isAlive()&&
            this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }
    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningScream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }


    public int getImpetuosity() {return impetuosity;}
    public void setImpetuosity(int impetuosity) {
        this.impetuosity = impetuosity;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDomanationFactor() {return strength+impetuosity;}
    @Override
    public String toString() {
        return "Lycanthrope {" +
                "name='" + this.getName() + '\'' +
                ", identification='" + identification + '\'' +
                ", age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", height=" + this.getHeight() +
                ", strength=" + strength +
                ", impetuosity=" + impetuosity +
                ", moralityRate=" + this.getMoralityRate() +
                ", alive=" + this.isAlive() +
                ", alpha=" + this.isAlpha() +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Si c'est la même instance
        if (obj == null || getClass() != obj.getClass()) return false; // Vérifie le type de l'objet
        Lycanthrope other = (Lycanthrope) obj;
        return identification.equals(other.identification); // Compare les identifications
    }

    @Override
    public int hashCode() {
        return identification.hashCode(); // Génère le hash basé sur l'identification
    }






}
