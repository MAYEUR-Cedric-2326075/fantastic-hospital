package fantasticHospital.Hospital.MedicalService.Races.Regular;
import fantasticHospital.Disease.Races.Regular.ElfSickness;
import fantasticHospital.Hospital.MedicalService.MedicalService;

public class MedicalServiceElf extends MedicalService<ElfSickness> {

    public MedicalServiceElf(String name){
        super(name);
    }

    public MedicalServiceElf(){
        super();
    }
    public MedicalServiceElf(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(ElfSickness patient:getPatients()){
            patient.waiting();
        }
    }
}
