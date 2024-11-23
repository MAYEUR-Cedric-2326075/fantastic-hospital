package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.StatusEffect.Contaminator;

public class Orc extends Creature implements PoorWaiter/*, Contaminator*/ {

    // Race spécifique
    private static final Race race = Race.ORC;

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
/*
    @Override
    public void contaminate(Creature creature) {
        System.out.println("The Orc contaminates the creature with its foul aura.");
    }
*/
    public Orc(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }


}
