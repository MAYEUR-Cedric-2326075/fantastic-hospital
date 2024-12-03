package fantasticHospital.Hospital.MedicalService.Races.Quarantine;
import fantasticHospital.Disease.Races.Contaminater.LycanthropeSicknessContaminator;
import fantasticHospital.Disease.Races.Regular.ZombieSickness;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;
        import fantasticHospital.Disease.Races.*;

public abstract class MedicalServiceLycanthropeQuarantine extends QuarantineMedicalService<LycanthropeSicknessContaminator> {

    public MedicalServiceLycanthropeQuarantine(String name){
        super(name);
    }

    public MedicalServiceLycanthropeQuarantine(){
        super();
    }
    public MedicalServiceLycanthropeQuarantine(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(LycanthropeSicknessContaminator patient:getPatients()){
            patient.waiting(getNumberOfPatientNow()>1);
        }
    }
}
