package fantasticHospital.Hospital.MedicalService.Races.Regular;
import fantasticHospital.Disease.Races.Regular.ReptilianSickness;
import fantasticHospital.Hospital.MedicalService.MedicalService;

public class MedicalServiceReptilian extends MedicalService<ReptilianSickness> {

    public MedicalServiceReptilian(String name){
        super(name);
    }

    public MedicalServiceReptilian(){
        super();
    }
    public MedicalServiceReptilian(String name,int budget){
        super(name,budget);
    }
    @Override
    public void waiting(){
        for(ReptilianSickness patient:getPatients()){
            patient.waiting();
        }
    }
}
