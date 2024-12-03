package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.StatusEffect.Demoraliser;
import fantasticHospital.Creature.Race.VipRace;

import java.util.Set;

public class Elf extends Creature implements VipWaiter, Demoraliser<Creature> {

    // Race spécifique
    private static VipRace race = new VipRace("Elf", 20, 10, 30);

    @Override
    public VipRace getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate() - getRace().getRateOfReduction());
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

    @Override
    public void demoralize(Set<Creature> creatures) {
        for (Creature creature : creatures) {
            creature.setMoralityRate(creature.getMoralityRate() - Demoraliser.rateOfDemoralisation);
        }
    }

    @Override
    public void demoralize(Creature creature) {
        creature.setMoralityRate(creature.getMoralityRate() - Demoraliser.rateOfDemoralisation);
    }

    // Constructeur
    public Elf(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", race=" + getRace().getRaceName();
    }
}
