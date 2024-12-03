package fantasticHospital.Disease.Races.Regular;
import fantasticHospital.Creature.Races.Reptilian;
import fantasticHospital.Disease.TypeOfPatient.*;
import fantasticHospital.Creature.Behavior.VipWaiter;

public class ReptilianSickness  extends CreatureSickness implements VipWaiter {
    public ReptilianSickness(Reptilian creature) {
        super(creature);
    }
    @Override
    public Reptilian getCreature(){return (Reptilian)super.getCreature();}

    @Override
    public void waiting() {
        getCreature().waiting();
        getSeeker();
    }
}
