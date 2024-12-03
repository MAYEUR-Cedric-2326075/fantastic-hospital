package fantasticHospital.Hospital.MedicalService.Races.Quarantine;
import fantasticHospital.Disease.Races.Contaminater.BeastmanSicknessContaminator;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;

public  class MedicalServiceQuarantineBeastman extends QuarantineMedicalService<BeastmanSicknessContaminator> {

    public MedicalServiceQuarantineBeastman(String name){
        super(name);
    }

    public MedicalServiceQuarantineBeastman(){
        super();
    }
    public MedicalServiceQuarantineBeastman(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(BeastmanSicknessContaminator patient:getPatients()){
            patient.waiting(getNumberOfPatientNow()>1);
        }
    }
}
