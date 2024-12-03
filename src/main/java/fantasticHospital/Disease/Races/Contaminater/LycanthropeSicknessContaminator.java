package fantasticHospital.Disease.Races.Contaminater;

import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Races.Lycanthrope;
import fantasticHospital.Creature.Races.Vampire;
import fantasticHospital.Disease.TypeOfPatient.CreatureSicknessContaminator;

public class LycanthropeSicknessContaminator extends CreatureSicknessContaminator implements PoorWaiter {
    public LycanthropeSicknessContaminator(Lycanthrope creature) {
        super(creature);
    }
    @Override
    public Lycanthrope getCreature(){return (Lycanthrope)super.getCreature();}

    @Override
    public void waiting(boolean isAlone) {
        getCreature().waiting(isAlone);
        getSeeker();
    }
}
