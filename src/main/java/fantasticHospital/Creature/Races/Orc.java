package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Race.PoorRace;

public class Orc extends CreatureSexualised implements PoorWaiter {

    // Race spécifique
    private static final PoorRace race = new PoorRace("Orc", 40, 30, 8, 20,30,5,25);

    @Override
    public PoorRace getRace() {
        return race;
    }
    @Override
    public void waiting(boolean isAlone) {
        int reductionRate = isAlone ? race.getRateOfReductionWithoutPeaple() : race.getRateOfReductionWithPeaple();
        this.setMoralityRate(this.getMoralityRate() - reductionRate);
    }

    @Override
    public boolean isInRage() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningRage() &&
                this.isAlive() &&
                this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }

    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningScream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }
    // Constructeur
    public Orc(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", race=" + getRace().getRaceName();
    }
}
