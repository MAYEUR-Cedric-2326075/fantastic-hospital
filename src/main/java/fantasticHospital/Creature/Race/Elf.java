package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.StatusEffect.*;

public class Elf extends Creature implements VipWaiter, Demoraliser {

    private static final Race race = Race.ELF;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate()- Vip.tauxOfReduction);
    }


    @Override
    public void demoralize(Creature creature) {
        creature.setMoralityRate(creature.getMoralityRate()-Demoraliser.tauxOfDemoralisation);
    }

    public Elf(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }


}
