package fantasticHospital.Hospital.MedicalService.Races.Quarantine;
import fantasticHospital.Disease.Races.Contaminater.OrcSicknessContaminator;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.QuarantineMedicalService;

public class MedicalServiceOrcQuarantine extends QuarantineMedicalService<OrcSicknessContaminator> {

    public MedicalServiceOrcQuarantine(String name){
        super(name);
    }

    public MedicalServiceOrcQuarantine(){
        super();
    }
    public MedicalServiceOrcQuarantine(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(OrcSicknessContaminator patient:getPatients()){
            patient.waiting(getNumberOfPatientNow()>1);
            if(!patient.isHealthy()&&getNumberOfPatientNow()>1)
                patient.contaminate(getRandomPatient());
        }
    }
}
