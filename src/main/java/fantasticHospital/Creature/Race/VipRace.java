package fantasticHospital.Creature.Race;

public class VipRace extends Race {
    // Attribut spécifique à VipRace
    private int rateOfReduction;

    // Constructeur
    public VipRace(String raceName, int rateOfMoralitybeginningSream,
                   int youngAge,int adultAge,int oldAge,
                   int rateOfMoralityBeginningRage, int rateOfReduction) {
        super(raceName, rateOfMoralitybeginningSream, rateOfMoralityBeginningRage,youngAge,adultAge,oldAge);
        this.rateOfReduction = rateOfReduction;
    }

    // Getter et Setter pour l'attribut spécifique
    public int getRateOfReduction() {
        return rateOfReduction;
    }

    public void setRateOfReduction(int rateOfReduction) {
        this.rateOfReduction = rateOfReduction;
    }

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "VipRace{" +
                "raceName='" + getRaceName() + '\'' +
                ", rateOfMoralitybeginningSream=" + getRateOfMoralityBeginningScream() +
                ", rateOfMoralityBeginningRage=" + getRateOfMoralityBeginningRage() +
                ", rateOfReduction=" + rateOfReduction +
                '}';
    }
}
