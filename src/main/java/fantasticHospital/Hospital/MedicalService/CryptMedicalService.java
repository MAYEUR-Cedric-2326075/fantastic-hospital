package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Disease.CreatureSickness;
import java.util.HashSet;

// Spécialisation : Crypt
class CryptMedicalService extends MedicalService {

    public CryptMedicalService(String name) {
        super(name);
    }

    public CryptMedicalService(String name, int budget) {
        super(name, budget);
    }

    @Override
    public boolean isCrypt() {
        return true;
    }
}


