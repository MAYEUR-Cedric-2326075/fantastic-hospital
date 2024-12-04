package fantasticHospital.Creature.Race;

import fantasticHospital.Creature.Behavior.Aging;

public class Race{
    // Attributs privés
    private int rateOfMoralityBeginningScream;
    private int rateOfMoralityBeginningRage;
    private  int youngAge;
    private  int oldAge;
    private  int adultAge;

    private String raceName;


    // Constructeur
    public Race(String raceName, int rateOfMoralityBeginningScream, int rateOfMoralityBeginningRage, int youngAge,int adultAge,int oldAge) {
        this.raceName = raceName;
        this.rateOfMoralityBeginningScream = rateOfMoralityBeginningScream;
        this.rateOfMoralityBeginningRage = rateOfMoralityBeginningRage;
        this.youngAge = youngAge;
        this.oldAge = oldAge;
        this.adultAge=adultAge;
    }

    // Getters et Setters
    public int getRateOfMoralityBeginningScream() {
        return rateOfMoralityBeginningScream;
    }

    public void setRateOfMoralityBeginningScream(int rateOfMoralityBeginningScream) {
        this.rateOfMoralityBeginningScream = rateOfMoralityBeginningScream;
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

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getYoungAge() {
        return youngAge;
    }

    public void setYoungAge(int youngAge) {
        this.youngAge = youngAge;
    }

    public int getAdultAge() {
        return adultAge;
    }

    public void setAdultAge(int adultAge) {
        this.adultAge = adultAge;
    }

    public int getOldAge() {
        return oldAge;
    }

    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "Race{" +
                "raceName='" + raceName + '\'' +
                ", rateOfMoralityBeginningScream=" + rateOfMoralityBeginningScream +
                ", rateOfMoralityBeginningRage=" + rateOfMoralityBeginningRage +
                ", youngAge=" + youngAge +
                ", adultAge=" + adultAge +
                ", oldAge=" + oldAge +
                '}';
    }
}
