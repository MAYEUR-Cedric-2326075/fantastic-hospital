package fantasticHospital.Disease;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Races.*;
import java.util.*;

public class CreatureSickness {
    private Creature creature;
    Map<Disease, Integer> diseaseCurrentLevel = new HashMap<>();
    private static final List<Disease> diseases = new ArrayList<>();

    static {
        diseases.add(new Disease("Maladie débilitante chronique", "MDC", 5));
        diseases.add(new Disease("fear of missing out", "FOMO", 5));
        diseases.add(new Disease("Dépendance aux réseaux sociaux", "DRS", 5));
        diseases.add(new Disease("Porphyrie érythropoïétique congénitale", "PEC", 5));
        diseases.add(new Disease("Zoopathie paraphrénique lycanthropique", "ZPL", 5));
        diseases.add(new Disease("Blight of Gloom", "BG", 5));
    }

    protected CreatureSickness(Creature creature) {
        this.creature = creature;
    }

    public CreatureSickness(Elf creature) {
        this.creature = creature;
    }
    public CreatureSickness(Dwarf creature) {
        this.creature = creature;
    }
    public CreatureSickness(Reptilian creature) {
        this.creature = creature;
    }
    public CreatureSickness(Zombie creature) {
        this.creature = creature;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setDiseaseCurrentLevel(Map<Disease, Integer> diseaseCurrentLevel) {
        this.diseaseCurrentLevel = diseaseCurrentLevel;
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
        Iterator<Map.Entry<Disease, Integer>> iterator = diseaseCurrentLevel.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Disease, Integer> element = iterator.next();
            System.out.println("Maladie : " + element.getKey().getShortName() + ", Niveau : " + element.getValue());
        }
    }

    public Set<Disease> getDisease(){//Renvoie un set avec les maladies
        return diseaseCurrentLevel.keySet();
    }
    public List<String> getAllDiseaseNames() {
        List<String> diseaseNames = new ArrayList<>();
        Iterator<Map.Entry<Disease, Integer>> iterator = diseaseCurrentLevel.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Disease, Integer> element = iterator.next();
            diseaseNames.add(element.getKey().getName());
        }
        return diseaseNames;
    }

    public void heal(){
        diseaseCurrentLevel.clear();
    }
    public void heal(Disease disease){
        diseaseCurrentLevel.remove(disease);
    }

    public static Disease randomDisease() {
        Random random = new Random();
        int index = random.nextInt(diseases.size()); // Génère un index aléatoire
        return diseases.get(index); // Retourne la maladie correspondante
    }

}
