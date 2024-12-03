package fantasticHospital.Hospital.MedicalService.TypeOfMedicalService;

import fantasticHospital.Disease.TypeOfPatient.CreatureSicknessContaminator;
import fantasticHospital.Hospital.MedicalService.MedicalService;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;

import java.util.HashSet;

// Spécialisation : Quarantine
public abstract class QuarantineMedicalService<T extends CreatureSicknessContaminator> extends MedicalService<T> {
//public abstract class QuarantineMedicalService extends MedicalService<CreatureSickness> {

    // Constantes pour les calculs
    private static final float ratioBudgetIsolation = 0.25f; // Ratio pour calculer le coût d'isolation
    private static final float maxRateOfIsolation = 1.0f; // Taux d'isolation maximum (100%)
    private static final float minRateOfIsolation = 0.0f; // Taux d'isolation minimum (0%)

    public QuarantineMedicalService(String name){
        super(name);
    }

    public QuarantineMedicalService(){
        super();
    }
    public QuarantineMedicalService(String name,int budget){
        super(name,budget);
    }
    // Getter pour obtenir le taux d'isolation basé sur le budget
    public float getRateOfIsolation() {
        return Math.min(maxRateOfIsolation, Math.max(minRateOfIsolation, computeRateOfIsolation(getBudget())));
    }

    // Méthode pour calculer le taux d'isolation en fonction du budget
    private static float computeRateOfIsolation(int budget) {
        return budget * ratioBudgetIsolation / 100000.0f; // Ajustement sur une échelle donnée
    }

    // Revue du budget prenant en compte le coût d'isolation
    @Override
    public void reviewBudget(int budgetAdjustment) {
        // Calcul du coût lié à l'isolation
        float isolationCost = ratioBudgetIsolation * budgetAdjustment;
        // Ajustement du budget global
        super.reviewBudget(budgetAdjustment - (int) isolationCost);
        // Mise à jour du taux d'isolation
        reviewIsolation(isolationCost);
    }

    // Méthode privée pour gérer les ajustements du taux d'isolation
    private void reviewIsolation(float isolationCost) {
        float newRateOfIsolation = getRateOfIsolation() + (isolationCost / 100000.0f); // Exemple d'ajustement
        if (newRateOfIsolation > maxRateOfIsolation) {
            System.out.println("Taux d'isolation atteint son maximum !");
        } else if (newRateOfIsolation < minRateOfIsolation) {
            System.out.println("Taux d'isolation trop bas !");
        }
    }

    // Méthode toString pour afficher l'état du service
    @Override
    public String toString() {
        return super.toString()
                + ", Taux d'isolation: " + (getRateOfIsolation() * 100) + "%";
    }
    public HashSet<T> moveHealfy(){
        HashSet<T> healfy = new HashSet<>();
        for (T creatureSickness:getPatients()) {
            if (creatureSickness.isHealthy()) {
                getPatients().add( creatureSickness);
                getPatients().remove(creatureSickness);
            }
        }
        return healfy;
    }
}
