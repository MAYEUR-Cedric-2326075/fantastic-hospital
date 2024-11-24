package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.VipWaiter;
import fantasticHospital.Creature.Race.VipRace;

public class Reptilian extends Creature implements VipWaiter {

    // Race spécifique
    private static  VipRace race = new VipRace("Reptilian", 25,1,2,3, 15, 30);

    public static VipRace getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(this.getMoralityRate() - getRace().getRateOfReduction());
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

    // Constructeur
    public Reptilian(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }
}
