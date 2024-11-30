package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Disease.CreatureSickness;
import java.util.HashSet;


// Spécialisation : Quarantine
class QuarantineMedicalService extends MedicalService {

    public QuarantineMedicalService(String name) {
        super(name);
    }

    public QuarantineMedicalService(String name, int budget) {
        super(name, budget);
    }

    @Override
    public boolean isQuarantine() {
        return true;
    }
}