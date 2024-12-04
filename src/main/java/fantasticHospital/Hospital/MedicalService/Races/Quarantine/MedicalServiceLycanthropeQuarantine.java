package fantasticHospital.Hospital.MedicalService.Races.Quarantine;
import fantasticHospital.Disease.Races.Contaminater.LycanthropeSicknessContaminator;
import fantasticHospital.Hospital.MedicalService.TypeOfMedicalService.*;
import fantasticHospital.Creature.Races.Lycanthrope.Lycanthrope;

public class MedicalServiceLycanthropeQuarantine extends QuarantineMedicalService<LycanthropeSicknessContaminator> {

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
            if(!patient.isHealthy()&&getNumberOfPatientNow()>1)
                patient.contaminate(getRandomPatient());
            if(generateRandomBooleanWithProbability(0.3))
                addPatient(new LycanthropeSicknessContaminator(Lycanthrope.PACK.reproduice()));
            if(generateRandomBooleanWithProbability(0.3))
                getRandomPatient().getCreature().challengeAlpha();
        }
    }
}
