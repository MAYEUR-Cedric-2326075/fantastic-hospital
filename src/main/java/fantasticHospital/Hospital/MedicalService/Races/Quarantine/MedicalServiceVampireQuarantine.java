package fantasticHospital.Hospital.MedicalService.Races.Quarantine;
import fantasticHospital.Disease.Races.Contaminater.VampireSiknessContaminator;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;

public  class MedicalServiceVampireQuarantine extends QuarantineMedicalService<VampireSiknessContaminator> {

    public MedicalServiceVampireQuarantine(String name){
        super(name);
    }

    public MedicalServiceVampireQuarantine(){
        super();
    }
    public MedicalServiceVampireQuarantine(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(VampireSiknessContaminator vampireSiknessContaminator:getPatients()){
            vampireSiknessContaminator.waiting();
        }
    }
}
