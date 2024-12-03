package fantasticHospital.Disease.Races.Regular;
import fantasticHospital.Creature.Races.Dwarf;
import fantasticHospital.Creature.Races.Elf;
import fantasticHospital.Disease.TypeOfPatient.*;
import fantasticHospital.Creature.Behavior.VipWaiter;

public class ElfSickness  extends CreatureSickness implements VipWaiter {
    public ElfSickness(Elf creature) {
        super(creature);
    }
    @Override
    public Elf getCreature(){return (Elf)super.getCreature();}

    @Override
    public void waiting() {
        getCreature().waiting();
        getSeeker();
    }

}
