package fantasticHospital.Creature.Race;

public abstract class Race {
    // Attributs privés
    private int rateOfMoralitybeginningSream;
    private int rateOfMoralityBeginningRage;
    private String raceName;


    // Constructeur
    public Race(String raceName, int rateOfMoralitybeginningSream, int rateOfMoralityBeginningRage) {
        this.raceName = raceName;
        this.rateOfMoralitybeginningSream = rateOfMoralitybeginningSream;
        this.rateOfMoralityBeginningRage = rateOfMoralityBeginningRage;
    }

    // Getters et Setters
    public int getRateOfMoralitybeginningSream() {
        return rateOfMoralitybeginningSream;
    }

    public void setRateOfMoralitybeginningSream(int rateOfMoralitybeginningSream) {
        this.rateOfMoralitybeginningSream = rateOfMoralitybeginningSream;
    }

    public int getRateOfMoralityBeginningRage() {
        return rateOfMoralityBeginningRage;
    }

    public void setRateOfMoralityBeginningRage(int rateOfMoralityBeginningRage) {
        this.rateOfMoralityBeginningRage = rateOfMoralityBeginningRage;
    }

    public String getRaceName() {
        return raceName;
    }
    public abstract boolean isVip();

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }



    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "Race{" +
                "raceName='" + raceName + '\'' +
                ", rateOfMoralitybeginningSream=" + rateOfMoralitybeginningSream +
                ", rateOfMoralityBeginningRage=" + rateOfMoralityBeginningRage +
                '}';
    }
}
