package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.MedicalService.Employe.Doctor;
import fantasticHospital.Tools.Randomizer;
import java.util.HashSet;

public abstract class MedicalService<Patient extends CreatureSickness> implements Randomizer {

    private String name;
    private int budget;
    private  static  final int maxCreature=100;
    private static final int startingBudjet=100000;
    private static final int budgetNonexistent = 200;
    private static final int budgetMediocre = 1000;
    private static final int budgetInsufficient = 5000;
    private static final int budgetWeak = 20000;

    private final static String defaultName="unnamedMedicalService";
    private HashSet<Patient> patients = new HashSet<>();
    public HashSet<Creature> getCreaturesPresentNow() {
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
    public boolean addPatient(HashSet<Patient> creatureSickness){
        for (Patient patient : creatureSickness) {
            if(!addPatient(patient))
                return false;
        }
        return true;
    }
    public boolean cured(Doctor doctor, Patient patient){
        if(!isEmpty())
            return doctor.heal(patient);
        return false;
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

    public boolean isFull(){return getNumberOfPatientNow()== getNumberOfPatientMax();}

    public void reviewBudget(int budget){this.budget =getBudget()-budget;}
    protected Patient getRandomPatient() {return patients.stream().findFirst().orElse(null);}
    public abstract void waiting();
    //public abstract boolean healCreatures();


    @Override
    public String toString(){return "String de servide";}
    public HashSet<Patient> removeDeads(){
        HashSet<Patient> dead = new HashSet<Patient>();
        for (Patient creatureSickness:patients) {
            if (creatureSickness.getCreature().isAlive()) {
                dead.add(creatureSickness);
                patients.remove(creatureSickness);
            }
        }
        return dead;
    }

    // Méthode pour obtenir la catégorie du budget
    public String getBudgetCategory() {
        if (budget < budgetNonexistent) {
            return "Inexistant";
        } else if (budget < budgetMediocre) {
            return "Médiocre";
        } else if (budget < budgetInsufficient) {
            return "Insuffisant";
        } else if (budget < budgetWeak) {
            return "Faible";
        } else {
            return "Acceptable";
        }
    }



}
