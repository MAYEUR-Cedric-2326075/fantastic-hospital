package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.MedicalService.Employe.Doctor;
import fantasticHospital.Tools.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Patient> patients=new ArrayList<Patient>();;
    public List<Creature> getCreaturesPresentNow() {
        List<Creature> creatures = new ArrayList<>();
        for (Patient patient : patients) {
            creatures.add(patient.getCreature());
        }
        return creatures;
    }
    public  int getNumberOfPatientNow(){
        if(patients!=null)
            return patients.size();
        return 0;
    }

    public int getNumberOfPatientMax(){
        if(patients!=null)
            return MedicalService.maxCreature;
        return 0;
    }
    public boolean isEmpty(){return patients.isEmpty();}
    public List<Patient> getPatients(){return patients;}
    public boolean addPatient(Patient creatureSickness){
        return (getNumberOfPatientNow()< getNumberOfPatientMax())&&patients.add(creatureSickness);
    }
    public boolean addPatient(List<Patient> creatureSickness){
        for (Patient patient : creatureSickness) {
            if(!addPatient(patient))
                return false;
        }
        return true;
    }
    public boolean addPatient(HashSet<Patient> creatureSicknessSet) {
        for (Patient patient : creatureSicknessSet) {
            if (!addPatient(patient)) {
                return false;
            }
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
        patients = new ArrayList<Patient>();
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
    public List<Patient> removeAndReturnDeceasedPatients() {
        List<Patient> deceasedPatients = new ArrayList<>();
        patients.removeIf(patient -> {
            if (!patient.getCreature().isAlive()) {
                deceasedPatients.add(patient);
                return true;
            }
            return false;
        });
        return deceasedPatients;
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
    public Patient getSpecificPatient(java.util.function.Predicate<Patient> condition) {
        for (Patient patient : patients) {
            if (condition.test(patient)) {
                return patient;
            }
        }
        return null;
    }



}
