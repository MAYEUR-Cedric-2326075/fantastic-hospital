package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.StatusEffect.Contaminator;

public class Beastman extends Creature implements PoorWaiter/*, Contaminator*/ {

    // Race spécifique
    private static final Race race = Race.BEASTMAN;

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
        System.out.println(this.getName() + " contamine " + creature.getName());
        // Ajoutez une logique ici pour appliquer un effet de contamination.
    }
*/

    // Constructeur
    public Beastman(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

}
