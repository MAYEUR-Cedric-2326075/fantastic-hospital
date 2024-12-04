package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Behavior.Fertiled;

import java.time.LocalDate;

public class PoorFertileRace extends PoorRace implements Fertiled {

    // Attributs spécifiques à la fertilité
    private LocalDate fertiledBegining;
    private int fertiledDurationInDays;

    // Constructeur
    public PoorFertileRace(String raceName, int rateOfMoralitybeginningSream, int rateOfMoralityBeginningRage,
                           int youngAge, int adultAge, int oldAge,
                           int rateOfReductionWithPeaple, int rateOfReductionWithoutPeaple,
                           int fertiledDurationInDays) {
        super(raceName, rateOfMoralitybeginningSream, rateOfMoralityBeginningRage, youngAge, adultAge, oldAge,
                rateOfReductionWithPeaple, rateOfReductionWithoutPeaple);
        this.fertiledDurationInDays = fertiledDurationInDays;
    }

    // Implémentation des méthodes de l'interface Fertiled
    @Override
    public boolean isFertiled() {
        if (fertiledBegining == null || fertiledDurationInDays <= 0) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return !today.isBefore(fertiledBegining) && !today.isAfter(getFertiledEnd());
    }
    @Override
    public void setFertiledBegining(LocalDate fertiledBegining) {
        this.fertiledBegining = fertiledBegining;
    }
    @Override
    public void setFertiledDuration(int durationInDays) {
        this.fertiledDurationInDays = durationInDays;
    }
    @Override
    public LocalDate getFertiledBegining() {
        return fertiledBegining;
    }
    @Override
    public LocalDate getFertiledEnd() {
        if (fertiledBegining == null || fertiledDurationInDays <= 0) {
            return null;
        }
        return fertiledBegining.plusDays(fertiledDurationInDays);
    }

    @Override
    public boolean isFertilityActive(LocalDate date) {
        if (fertiledBegining == null || fertiledDurationInDays <= 0) {
            return false;
        }
        return !date.isBefore(fertiledBegining) && !date.isAfter(getFertiledEnd());
    }
    // Redéfinition de toString pour inclure les informations de fertilité
    @Override
    public String toString() {
        return super.toString() +
                ", Fertility{" +
                "fertiledBegining=" + fertiledBegining +
                ", fertiledDurationInDays=" + fertiledDurationInDays +
                ", fertiledEnd=" + getFertiledEnd() +
                '}';
    }
}
