package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Race.PoorRace;

public class Lycanthrope extends Creature implements PoorWaiter {

    // Race spécifique
    private static PoorRace race = new PoorRace("Lycanthrope", 20, 15, 10, 20);

    @Override
    public PoorRace getRace() {
        return race;
    }

    @Override
    public void waiting(boolean isAlone) {
        if (isAlone) {
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithoutPeaple());
        } else {
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithPeaple());
        }
    }
    @Override
    public boolean isInRage(){return this.getMoralityRate()<race.getRateOfMoralityBeginningRage()&&
            this.isAlive()&&
            this.getMoralityRate() < race.getRateOfMoralitybeginningSream();
    }

    // Vérifier si le Beastman est en train de crier
    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralitybeginningSream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }

    // Constructeur
    public Lycanthrope(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    /*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Lycanthropes
        System.out.println(this.getName() + " contaminates " + creature.getName() + " with lycanthropy.");
    }
    */
}
