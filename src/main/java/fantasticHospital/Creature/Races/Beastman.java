package fantasticHospital.Creature.Races;

import fantasticHospital.Creature.Behavior.Aging;
import fantasticHospital.Creature.CreatureSexualised;
import fantasticHospital.Creature.Behavior.PoorWaiter;
import fantasticHospital.Creature.Race.PoorRace;

public class Beastman extends CreatureSexualised implements PoorWaiter,Aging /*, Contaminator*/ {

    // Race spécifique
    private static PoorRace race=
            new PoorRace("Beastman",50,40,15,25,40,5,15);


    @Override
    public AgeCategory getAgeCategory() {
        int age = this.getAge();
        if (age <= race.getYoungAge())
            return AgeCategory.JEUNE;
        else {
            if (age <=race.getOldAge())
                return AgeCategory.ADULTE;
            return AgeCategory.VIEUX;
        }
    }


    public static PoorRace getRace() {
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

}
