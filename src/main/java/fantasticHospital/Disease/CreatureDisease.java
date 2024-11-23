package fantasticHospital.Disease;


import fantasticHospital.Creature.Creature;

public class CreatureDisease {

    private Disease disease;
    private Creature creature;
    private int currentLevel;

    public CreatureDisease(Disease disease, Creature creature, int currentLevel) {
        this.disease = disease;
        this.creature = creature;
        this.currentLevel = currentLevel;
    }

    public Disease getDisease() {
        return disease;
    }

    public Creature getCreature() {
        return creature;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    private void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void decreaseLevel() {
        if (getCurrentLevel() <= 1){
            System.out.println("niveau minimum atteint");
        }else{
            setCurrentLevel(getCurrentLevel() -1);
        }
    }

    public void increaseLevel() {
        if (getCurrentLevel() >= disease.getMaxLevel()){
            creature.die();
        }else{
            setCurrentLevel(getCurrentLevel() +1);
        }
    }

}
