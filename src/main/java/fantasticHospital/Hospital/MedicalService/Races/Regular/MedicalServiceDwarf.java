package fantasticHospital.Hospital.MedicalService.Races.Regular;
import fantasticHospital.Disease.Races.Regular.DwarfSickness;
import fantasticHospital.Hospital.MedicalService.MedicalService;

public class MedicalServiceDwarf extends MedicalService<DwarfSickness> {

    public MedicalServiceDwarf(String name){
        super(name);
    }

    public MedicalServiceDwarf(){
        super();
    }
    public MedicalServiceDwarf(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(DwarfSickness patient:getPatients()){
            patient.waiting();
        }
    }
}
