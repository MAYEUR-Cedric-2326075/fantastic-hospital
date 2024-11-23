package fantasticHospital.Creature;

import fantasticHospital.Creature.Behavior.*;
import fantasticHospital.Creature.Race.Race;
public abstract class Creature implements  Rager, Perishable, Screamer{

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getMoralityRate() {
        return moralityRate;
    }
    public void setMoralityRate(int moralityRate) {
        this.moralityRate = moralityRate;
    }
    public boolean isAlive(){return Alive;}
    public void setAlive(boolean isAlive){this.Alive =isAlive;}



    //private abstract Race2 race;
    private String name;
    private boolean gender;
    private double weight;
    private double height;
    private int age;
    private int moralityRate;
    private boolean Alive;

    //private static Race2 race;

    public Creature(String name, boolean gender, double weight, double height, int age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moralityRate = 100;
        this.Alive = true;
        //this.diseasesList = diseasesList;
    }
    // Méthode abstraite pour obtenir la race (implémentée dans les sous-classes)
    public abstract Race getRace();
    //public  abstract void setRace(Race2 race);

/*
    @Override
    public void rage() {
        // Comportement par défaut
        System.out.println("The creature is raging furiously!");
    }
*/


    @Override
    public void die() {
        // Comportement par défaut
        System.out.println("The creature has perished...");
    }


/*
    public List<String> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(List<String> diseasesList) {
        this.diseasesList = diseasesList;
    }

 */
    /*
    public abstract void waiting();
    public abstract void getAngry();
    public abstract void fallIll();
    public abstract void beTreated();
    public abstract void die();
     */

}
