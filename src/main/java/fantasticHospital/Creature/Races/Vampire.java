package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Race.VipRace;

import java.util.Set;

public class Vampire extends CreatureSexualised implements VipWaiter, Regenerator, Demoraliser<Creature> {

    // Race spécifique
    private static VipRace race = new VipRace("Vampire", 50, 1,2,3,40, 30);


    public static VipRace getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate() - getRace().getRateOfReduction());
    }
    @Override
    public boolean isInRage(){return this.getMoralityRate()<race.getRateOfMoralityBeginningRage()&&
            this.isAlive()&&
            this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }

    // Vérifier si le Beastman est en train de crier
    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningScream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }

    @Override
    public void regenerate() {
        this.setAlive(true);
    }

    @Override
    public void demoralize(Creature creature) {
        creature.setMoralityRate(creature.getMoralityRate() - Demoraliser.rateOfDemoralisation);
    }

    @Override
    public void demoralize(Set<Creature> creatures) {
        for (Creature creature : creatures) {
            creature.setMoralityRate(creature.getMoralityRate() - Demoraliser.rateOfDemoralisation);
        }
    }

    // Constructeur
    public Vampire(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    /*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Vampires
        System.out.println(this.getName() + " infects " + creature.getName() + " with its dark curse.");
    }
    */
}
