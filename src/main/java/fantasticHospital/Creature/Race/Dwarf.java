package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.SocialStatus.Vip;

public class Dwarf extends Creature implements VipWaiter {

    private static final Race race = Race.DWARF;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate()- Vip.tauxOfReduction);
    }

    public Dwarf(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

}
