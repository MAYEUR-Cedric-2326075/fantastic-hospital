
package fantasticHospital.Disease.Races.Regular;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Races.Reptilian;
import fantasticHospital.Creature.Races.Zombie;
import fantasticHospital.Disease.TypeOfPatient.*;

public class ZombieSickness  extends CreatureSickness implements PoorWaiter {
    public ZombieSickness(Zombie creature) {
        super(creature);
    }
    @Override
    public Zombie getCreature(){return (Zombie)super.getCreature();}

    @Override
    public void waiting(boolean isAlone) {
        getCreature().waiting(isAlone);
        this.getSeeker();
    }
}
