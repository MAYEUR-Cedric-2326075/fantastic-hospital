package fantasticHospital.Disease.Races.Regular;
import fantasticHospital.Creature.Races.Dwarf;
import fantasticHospital.Creature.Races.Vampire;
import fantasticHospital.Disease.TypeOfPatient.*;
import fantasticHospital.Creature.Behavior.VipWaiter;

public class DwarfSickness  extends CreatureSickness implements VipWaiter {
    public DwarfSickness(Dwarf creature) {
        super(creature);
    }
    @Override
    public Dwarf getCreature(){return (Dwarf)super.getCreature();}

    @Override
    public void waiting() {
        getCreature().waiting();
        getSeeker();
    }
}
