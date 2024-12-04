package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Race.PoorRace;

public class Beastman extends CreatureSexualised implements PoorWaiter/*, Contaminator*/ {

    // Race spécifique
    private static PoorRace race=new PoorRace(
            "Beastman",50,40,5,15,50,15,30);
/*
String raceName,
                    int rateOfMoralitybeginningSream,
                    int rateOfMoralityBeginningRage,
                    int youngAge,int adultAge,int oldAge,
                    int rateOfReductionWithPeaple, int rateOfReductionWithoutPeaple
 */

    @Override
    public PoorRace getRace() {
        return race;
    }
    @Override
    public void waiting(boolean isAlone) {
        if (isAlone)
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithoutPeaple());
        else
            this.setMoralityRate(getMoralityRate() - getRace().getRateOfReductionWithPeaple());

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
    public Beastman(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public String toString() {
        return super.toString() + ", race=" + getRace().getRaceName();
    }
}
