package fantasticHospital.Hospital.MedicalService.Races.Cryp;
import fantasticHospital.Disease.Races.Contaminater.VampireSiknessContaminator;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;

public  class MedicalServiceVampireCrypt extends CryptMedicalService<VampireSiknessContaminator> {

    public MedicalServiceVampireCrypt(String name){
        super(name);
    }

    public MedicalServiceVampireCrypt(){
        super();
    }
    public MedicalServiceVampireCrypt(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(VampireSiknessContaminator vampireSiknessContaminator:getPatients()){
            vampireSiknessContaminator.waiting();
        }
    }
}
