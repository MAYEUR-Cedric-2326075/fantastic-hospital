package com.fantasticHospital;

import fantasticHospital.Creature.Creature;

import java.util.List;

public class MedicalService {

    private String name;
    private int area;
    private int maxCreature;
    private int nbPresentCreature;
    private List<Creature> presentCreature;
    private enum budget { inexistant, médiocre, insuffisant, faible };

    public MedicalService(String name, int area, int maxCreature, int nbPresentCreature, List<Creature> presentCreature) {
        this.name = name;
        this.area = area;
        this.maxCreature = maxCreature;
        this.nbPresentCreature = nbPresentCreature;
        this.presentCreature = presentCreature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getMaxCreature() {
        return maxCreature;
    }

    public void setMaxCreature(int maxCreature) {
        this.maxCreature = maxCreature;
    }

    public int getNbPresentCreature() {
        return nbPresentCreature;
    }

    public void setNbPresentCreature(int nbPresentCreature) {
        this.nbPresentCreature = nbPresentCreature;
    }

    public List<Creature> getPresentCreature() {
        return presentCreature;
    }

    public void setPresentCreature(List<Creature> presentCreature) {
        this.presentCreature = presentCreature;
    }
}
