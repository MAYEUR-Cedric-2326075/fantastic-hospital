package fantasticHospital.Creature;

import java.util.List;

public abstract class Creature {

    private String name;
    private boolean gender;
    private double weight;
    private double height;
    private int age;
    private boolean moraleIndicator;
    //private List<CreatureDisaese> diseasesList;

    public Creature(String name, boolean gender, double weight, double height, int age, boolean moraleIndicator) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.moraleIndicator = moraleIndicator;
        //this.diseasesList = diseasesList;
    }

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

    public boolean getMoraleIndicator() {
        return moraleIndicator;
    }

    public void setMoraleIndicator(boolean moraleIndicator) {
        this.moraleIndicator = moraleIndicator;
    }
/*
    public List<String> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(List<String> diseasesList) {
        this.diseasesList = diseasesList;
    }

 */
    public abstract void waiting();
    public abstract void getAngry();
    public abstract void fallIll();
    public abstract void beTreated();
    public abstract void die();

}
