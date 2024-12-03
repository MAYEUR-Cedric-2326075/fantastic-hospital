package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Tools.Randomizer;
import java.util.HashSet;

public abstract class MedicalService<Patient extends CreatureSickness> implements Randomizer {

    private String name;
    private int budget;
    private  static int maxCreature=100;
    private  static int startingBudjet=100000;
    private final static String defaultName="unnamedMedicalService";
    private HashSet<Patient> patients = new HashSet<>();
    protected HashSet<Creature> getCreaturesPresentNow() {
        HashSet<Creature> creatures = new HashSet<>();
        for (Patient patient : patients) {
            creatures.add(patient.getCreature());
        }
        return creatures;
    }
    public  int getNumberOfPatientNow(){return patients.size();}
    public int getNumberOfPatientMax(){return MedicalService.maxCreature;}
    public boolean isEmpty(){return patients.isEmpty();}
    public HashSet<Patient> getPatients(){return patients;}
    public boolean addPatient(Patient creatureSickness){
        return (getNumberOfPatientNow()< getNumberOfPatientMax())&&patients.add(creatureSickness);
    }
    public boolean removePatient(Patient creatureSickness){
        return !isEmpty()&&patients.remove(creatureSickness);
    }

    public MedicalService(String name){
        this.name = name;
        this.budget = startingBudjet;
    }

    public MedicalService(){
        this.name = MedicalService.defaultName;
        this.budget = MedicalService.startingBudjet;
    }

    public MedicalService(String name,int budget){
        this.name = name;
        this.budget = budget;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}
    public int getBudget() {return budget;}
    public void setBudget(int budget) {this.budget = budget;}

    protected boolean isFull(){return getNumberOfPatientNow()== getNumberOfPatientMax();}

    public void reviewBudget(int budget){this.budget =getBudget()-budget;}
    protected Patient getRandomPatient() {return patients.stream().findFirst().orElse(null);}
    public abstract void waiting();
    //public abstract boolean healCreatures();


    @Override
    public String toString(){return "String de servide";}



}
