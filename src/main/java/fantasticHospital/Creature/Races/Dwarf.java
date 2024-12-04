package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Race.PoorRace;
import fantasticHospital.Creature.Race.VipRace;

public class Dwarf extends CreatureSexualised implements VipWaiter {

    // Race spécifique
    private static final VipRace race = new VipRace("Dwarf", 70, 25,60,100, 20,42);


    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate() - getRace().getRateOfReduction());
    }
    @Override
    public VipRace getRace() {
        return race;
    }

    @Override
    public boolean isInRage(){return this.getMoralityRate()<race.getRateOfMoralityBeginningRage()&&
            this.isAlive()&&
            this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }


    @Override
    public boolean isScreaming() {
        return this.getMoralityRate() < race.getRateOfMoralityBeginningScream()
                && this.isAlive()
                && this.getMoralityRate() > race.getRateOfMoralityBeginningRage();
    }

    // Constructeur
    public Dwarf(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", race=" + getRace().getRaceName();
    }

}
