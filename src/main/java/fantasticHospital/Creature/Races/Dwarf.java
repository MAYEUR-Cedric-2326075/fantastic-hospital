package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Race.PoorRace;
import fantasticHospital.Creature.Race.VipRace;

public class Dwarf extends CreatureSexualised implements VipWaiter {

    // Race spécifique
    private static final VipRace race = new VipRace("Dwarf", 70,1,2,3 ,60, 20);


    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate() - getRace().getRateOfReduction());
    }

    public static VipRace getRace() {
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
}
