package fantasticHospital.Disease.Behavior;

import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;

public interface Contaminator<Being extends CreatureSickness> {
    boolean contaminate(Being being);
}
