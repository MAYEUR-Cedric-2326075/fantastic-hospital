package fantasticHospital.Creature.Race;

public class PoorRace extends Race {
    // Attributs spécifiques à PoorRace
    private int rateOfReductionWithPeaple;
    private int rateOfReductionWithoutPeaple;

    // Constructeur
    public PoorRace(String raceName,
                    int rateOfMoralitybeginningSream,
                    int rateOfMoralityBeginningRage,
                    int youngAge,int adultAge,int oldAge,
                    int rateOfReductionWithPeaple, int rateOfReductionWithoutPeaple) {
        super(raceName, rateOfMoralitybeginningSream, rateOfMoralityBeginningRage,youngAge,adultAge,oldAge);
        this.rateOfReductionWithPeaple = rateOfReductionWithPeaple;
        this.rateOfReductionWithoutPeaple = rateOfReductionWithoutPeaple;
    }

    // Getters et Setters pour les attributs spécifiques
    public int getRateOfReductionWithPeaple() {
        return rateOfReductionWithPeaple;
    }

    public void setRateOfReductionWithPeaple(int rateOfReductionWithPeaple) {
        this.rateOfReductionWithPeaple = rateOfReductionWithPeaple;
    }

    public int getRateOfReductionWithoutPeaple() {
        return rateOfReductionWithoutPeaple;
    }

    public void setRateOfReductionWithoutPeaple(int rateOfReductionWithoutPeaple) {
        this.rateOfReductionWithoutPeaple = rateOfReductionWithoutPeaple;
    }

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "PoorRace{" +
                "raceName='" + getRaceName() + '\'' +
                ", rateOfMoralitybeginningSream=" + getRateOfMoralityBeginningScream() +
                ", rateOfMoralityBeginningRage=" + getRateOfMoralityBeginningRage() +
                ", rateOfReductionWithPeaple=" + rateOfReductionWithPeaple +
                ", rateOfReductionWithoutPeaple=" + rateOfReductionWithoutPeaple +
                '}';
    }
}
