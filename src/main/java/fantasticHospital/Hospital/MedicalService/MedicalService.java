package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.PoorRace;
import fantasticHospital.Creature.Race.VipRace;
import fantasticHospital.Creature.Races.*;
import fantasticHospital.Disease.CreatureSickness;
import fantasticHospital.Disease.CreatureSicknessContaminator;
import fantasticHospital.Tools.Randomizer;
import java.util.HashSet;
import java.util.ArrayList;

public class MedicalService implements Randomizer {

    private String name;
    private int budget;
    private HashSet<CreatureSickness> patients = new HashSet<>();

    public MedicalService(String name){
        this.name = name;
        this.budget = 100000;
    }
    public MedicalService(){
        this.name = "NoName";
        this.budget = 100000;
    }
    public int size(){return this.patients.size();}
    public MedicalService(String name,int budget){
        this.name = name;
        this.budget = budget;
    }
    public boolean isEmpty(){
        return patients.isEmpty();
    }

    public String getName() {
        return name;
    }
    public boolean isCrypt(){return false;}
    public boolean isQuarantine(){return false;}
    public void setName(String name) {this.name=name;}
    public int getBudget() {return budget;}
    public void setBudget(int budget) {this.budget = budget;}
    public HashSet<CreatureSickness> getPatients() {return patients;}
    public void addPatient(CreatureSickness creatureSickness){patients.add(creatureSickness);}
    public void removeatient(CreatureSickness creatureSickness){patients.remove(creatureSickness);}
    public void reeviewBudget(int budget){this.budget =getBudget()-budget;}
    public CreatureSickness getRandomPatient() {
        if (patients.isEmpty())
            return null;
        return patients.stream().findFirst().orElse(null);
    }
    //public HashSet getPatients(){}
    public void waiting(){
        for (CreatureSickness creatureSickness : patients) {
            if(creatureSickness.getCreature().getRace().isVip()){
                if(creatureSickness.getCreature().getRace().isVip()){
                    switch (creatureSickness.getCreature().getRace().getRaceName()){
                        case "Elf":
                            //Elf elf=(Elf)getCreatures();
                    }


                }
            }
        }
    }
    private HashSet getCreatures(){
        HashSet creatures = new HashSet();
        for (CreatureSickness creatureSickness : patients) {
            creatures.add(creatureSickness.getCreature());
        }
        return creatures;
    }
    @Override
    public String toString(){return "String de servide";}


}
