package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.StatusEffect.Regenerator;
import fantasticHospital.Creature.Race.PoorRace;

public class Zombie extends CreatureSexualised implements PoorWaiter, Regenerator {

    // Race spécifique
    private static PoorRace race = new PoorRace("Zombie", 40, 20,1,2,3 ,10, 20);

    public static PoorRace getRace() {
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
            this.getMoralityRate() < race.getRateOfMoralityBeginningScream();
    }


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

    // Constructeur
    public Zombie(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }
}
