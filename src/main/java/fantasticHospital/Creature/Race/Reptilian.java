package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.SocialStatus.Vip;

public class Reptilian extends Creature implements VipWaiter{

    private static final Race race = Race.REPTILIAN;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate()- Vip.tauxOfReduction);
    }


    public Reptilian(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }


}
