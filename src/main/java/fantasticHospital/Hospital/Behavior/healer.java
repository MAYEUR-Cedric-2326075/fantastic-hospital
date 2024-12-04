package fantasticHospital.Hospital.Behavior;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
public interface healer<C extends CreatureSickness> {
    default  boolean heal(C creatureSickness) {
        if (creatureSickness != null) {
            creatureSickness.cured();
            return true;
        }
        return false;
    }
}
