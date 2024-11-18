package fantasticHospital.Disease;

import com.fantasticHospital.Creature;

public class CreatureDisease {

    private Disease disease;
    private com.fantasticHospital.Creature creature;
    private int currentLevel;

    public CreatureDisease(Disease disease, Creature creature, int currentLevel) {
        this.disease = disease;
        this.creature = creature;
        this.currentLevel = currentLevel;
    }

    public void addDisease(CreatureDisease disease) {
        creature.setDiseasesList(creature.getDiseasesList().add(disease));
    }

    /*
    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void decreaseLevel() {
        setCurrentLevel(getCurrentLevel() -1);
    }
    public void increaseLevel() {
        setCurrentLevel(getCurrentLevel() +1);
    }
    public boolean isLethal() {
        if (getCurrentLevel() > getMaxLevel()) {
            return true;
        }else{
            return false;
        }
    }*/

}
