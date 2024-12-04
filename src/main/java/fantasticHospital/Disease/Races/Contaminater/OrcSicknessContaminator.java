package fantasticHospital.Disease.Races.Contaminater;

import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Races.Orc;
import fantasticHospital.Disease.TypeOfPatient.CreatureSicknessContaminator;

public class OrcSicknessContaminator extends CreatureSicknessContaminator implements PoorWaiter {
    public OrcSicknessContaminator(Orc creature) {
        super(creature);
    }
    @Override
    public Orc getCreature(){return (Orc)super.getCreature();}

    @Override
    public void waiting(boolean isAlone) {
        getCreature().waiting(isAlone);
        getSeeker();
    }
}
