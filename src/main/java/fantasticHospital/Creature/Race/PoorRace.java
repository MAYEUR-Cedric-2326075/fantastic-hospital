package fantasticHospital.Creature.Race;

public class PoorRace extends Race {
    // Attributs spécifiques à PoorRace
    private int rateOfReductionWithPeaple;
    private int rateOfReductionWithoutPeaple;

    // Constructeur
    public PoorRace(String raceName, int rateOfMoralitybeginningSream, int rateOfMoralityBeginningRage,
                    int rateOfReductionWithPeaple, int rateOfReductionWithoutPeaple) {
        super(raceName, rateOfMoralitybeginningSream, rateOfMoralityBeginningRage);
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
    public boolean isVip(){return false;}

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "PoorRace{" +
                "raceName='" + getRaceName() + '\'' +
                ", rateOfMoralitybeginningSream=" + getRateOfMoralitybeginningSream() +
                ", rateOfMoralityBeginningRage=" + getRateOfMoralityBeginningRage() +
                ", rateOfReductionWithPeaple=" + rateOfReductionWithPeaple +
                ", rateOfReductionWithoutPeaple=" + rateOfReductionWithoutPeaple +
                '}';
    }
}
