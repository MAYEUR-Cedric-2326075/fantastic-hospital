package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.StatusEffect.Contaminator;

public class Lycanthrope extends Creature implements PoorWaiter/*, Contaminator*/ {

    private static final Race race = Race.LYCANTHROPE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting(boolean isAlone) {
        if (isAlone)
            this.setMoralityRate(getMoralityRate() - PoorWaiter.tauxOfReductionWithoutPeaple);
        else
            this.setMoralityRate(getMoralityRate() - PoorWaiter.tauxOfReductionWithPeaple);
    }
/*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Lycanthropes
        System.out.println("The Lycanthrope contaminates the creature with lycanthropy...");
    }
*/
    public Lycanthrope(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

}
