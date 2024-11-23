package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.StatusEffect.*;

public class Zombie extends Creature implements PoorWaiter, Regenerator {
    private static final Race race = Race.ZOMBIE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting(boolean isAlone) {
        if (isAlone) {
            this.setMoralityRate(getMoralityRate() - PoorWaiter.tauxOfReductionWithoutPeaple);
        } else {
            this.setMoralityRate(getMoralityRate() - PoorWaiter.tauxOfReductionWithPeaple);
        }
    }

    @Override
    public void regenerate() {
        this.setAlive(true);
    }

    public Zombie(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }


}
