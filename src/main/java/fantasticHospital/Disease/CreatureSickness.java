package fantasticHospital.Disease;

import fantasticHospital.Creature.Creature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreatureSickness {
    private Creature creature;
    Map<Disease, Integer> diseaseCurrentLevel = new HashMap<>();

    public CreatureSickness(Creature creature) {
        this.creature = creature;
        this.diseaseCurrentLevel = diseaseCurrentLevel;
    }

    public Creature getCreature() {
        return creature;
    }

    public Map<Disease, Integer> getDiseaseCurrentLevel() {
        return diseaseCurrentLevel;
    }

    public void addDiseaseCurrentLevel(Disease disease, int currentLevel) {
        diseaseCurrentLevel.put(disease, currentLevel);
    }
    public void addDiseaseCurrentLevel(Disease disease) {
        diseaseCurrentLevel.put(disease, 1);
    }

    public int getCurrentLevel(Disease disease) {
        return diseaseCurrentLevel.get(disease);
    }

    private void setCurrentLevel(Disease disease, int currentLevel) {
        diseaseCurrentLevel.put(disease, currentLevel);
    }

    public void decreaseLevel(Disease disease) {
        if (getCurrentLevel(disease) <= 1){
            System.out.println("niveau minimum atteint");
        }else{
            setCurrentLevel(disease, getCurrentLevel(disease) -1);
        }
    }

    public void increaseLevel(Disease disease) {
        if (getCurrentLevel(disease) >= disease.getMaxLevel()){
            creature.die();
        }else{
            setCurrentLevel(disease, getCurrentLevel(disease) +1);
        }
    }

    public void showDisease() {//usage similaire a un toString
        System.out.println("Nom : " + creature.getName());
        for (Map.Entry<Disease, Integer> entry : diseaseCurrentLevel.entrySet()) {
            String key = entry.getKey().getShortName();
            Integer value = entry.getValue();
            System.out.println("Maladie : " + key + ", Niveau : " + value);
        }
    }

    public Set<Disease> getDisease(){//Renvoie un set avec les maladies
        return diseaseCurrentLevel.keySet();
    }
}
