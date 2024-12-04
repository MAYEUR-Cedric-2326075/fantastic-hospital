
package fantasticHospital.Disease.Races.Contaminater;

import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Races.Vampire;
import fantasticHospital.Disease.TypeOfPatient.CreatureSicknessContaminator;

public class VampireSiknessContaminator extends CreatureSicknessContaminator implements VipWaiter {
    public VampireSiknessContaminator(Vampire creature) {
        super(creature);
    }
    @Override
    public Vampire getCreature(){return (Vampire)super.getCreature();}

    @Override
    public void waiting() {
        getCreature().waiting();
        getSeeker();
    }
}
