package fantasticHospital.Hospital.MedicalService.TypeOfMedicalService;

import fantasticHospital.Hospital.MedicalService.MedicalService;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Disease.Races.Contaminater.VampireSiknessContaminator;

import java.util.HashSet;

public abstract class CryptMedicalService<T extends CreatureSickness> extends MedicalService<T> {
//public abstract class CryptMedicalService extends MedicalService<CreatureSickness> {

    // Constantes pour les calculs
    private static final float minTemperature = 0.0f;
    private static final float maxTemperature = 50.0f;
    private static final float perfectTemperature = 20.0f; // Température idéale
    private static final float ratioTemperatureVentilation = 0.5f; // Influence de la température
    private static final float ratioVentilationBudget = 0.5f; // Part du budget allouée à la ventilation


    public CryptMedicalService(String name){
        super(name);
    }

    public CryptMedicalService(){
        super();
    }
    public CryptMedicalService(String name,int budget){
        super(name,budget);
    }
    // Méthode pour calculer le niveau de ventilation basé sur le budget
    private static int computationVentilation(int budget) {
        return (int) (budget * ratioVentilationBudget);
    }

    // Méthode pour calculer les coûts liés à la température
    private static float computationTemperature(int budget) {
        int ventilation = computationVentilation(budget);
        return (float) (Math.abs(perfectTemperature - ventilation) * ratioTemperatureVentilation);
    }

    // Getter pour obtenir le niveau de ventilation actuel
    public int getVentilationLevel() {
        return computationVentilation(getBudget());
    }

    // Getter pour obtenir la température actuelle simulée
    public float getCurrentTemperature() {
        return perfectTemperature; // Simulé ici comme constante, peut être dynamique si besoin
    }

    // Revue du budget prenant en compte les coûts calculés
    @Override
    public void reviewBudget(int budgetAdjustment) {
        int ventilationCost = computationVentilation(getBudget() + budgetAdjustment);
        float temperatureCost = computationTemperature(getBudget() + budgetAdjustment);
        int totalCost = ventilationCost + (int) temperatureCost;

        super.reviewBudget(budgetAdjustment - totalCost); // Ajuste le budget après calcul des coûts
    }

    // toString pour afficher les informations de la crypte
    @Override
    public String toString() {
        int ventilationLevel = getVentilationLevel();
        float currentTemperature = getCurrentTemperature();

        return super.toString()
                + ", Température actuelle: " + currentTemperature + "°C"
                + ", Niveau de ventilation: " + ventilationLevel + "%";
    }
    public HashSet<T> removeLivings(){
        HashSet<T> livings = new HashSet<T>();
        for (T creatureSickness:getPatients()) {
            if (!creatureSickness.getCreature().isAlive()) {
                getPatients().add( creatureSickness);
                getPatients().remove(creatureSickness);
            }
        }
        return livings;
    }
}
