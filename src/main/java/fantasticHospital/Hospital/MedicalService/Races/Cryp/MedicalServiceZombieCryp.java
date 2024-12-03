package fantasticHospital.Hospital.MedicalService.Races.Cryp;
import fantasticHospital.Disease.Races.Regular.ZombieSickness;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;

public abstract class MedicalServiceZombieCryp extends CryptMedicalService<ZombieSickness> {

    public MedicalServiceZombieCryp(String name){
        super(name);
    }

    public MedicalServiceZombieCryp(){
        super();
    }
    public MedicalServiceZombieCryp(String name,int budget){
        super(name,budget);
    }

    @Override
    public void waiting(){
        for(ZombieSickness patient:getPatients()){
            patient.waiting(getNumberOfPatientNow()>1);
        }
    }
}
