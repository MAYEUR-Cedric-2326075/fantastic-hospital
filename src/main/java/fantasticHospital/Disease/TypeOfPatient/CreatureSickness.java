package fantasticHospital.Disease.TypeOfPatient;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Races.*;
import fantasticHospital.Disease.Disease;
import fantasticHospital.Tools.Randomizer;

import java.util.*;

public abstract class CreatureSickness implements Randomizer {
    private Creature creature;
    Map<Disease, Integer> diseaseCurrentLevel = new HashMap<>();//contien les information sur les maladies qui touche les créatures
    private static final List<Disease> diseases = new ArrayList<>(); //contient toutes les maladies
    //ajoute toutes les maladies a "diseases"
    static {
        diseases.add(new Disease("Maladie débilitante chronique", "MDC", 5));
        diseases.add(new Disease("fear of missing out", "FOMO", 5));
        diseases.add(new Disease("Dépendance aux réseaux sociaux", "DRS", 5));
        diseases.add(new Disease("Porphyrie érythropoïétique congénitale", "PEC", 5));
        diseases.add(new Disease("Zoopathie paraphrénique lycanthropique", "ZPL", 5));
        diseases.add(new Disease("Blight of Gloom", "BG", 5));
    }

    //constructeurs
    protected CreatureSickness(Creature creature) {
        this.creature = creature;
    }
    public CreatureSickness(Beastman creature) {
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

    //getter et setter
    public Creature getCreature() {
        return creature;
    }
    public Map<Disease, Integer> getDiseaseCurrentLevel() {
        return diseaseCurrentLevel;
    }

    //methodes
    //rencoie le niveau de la maladie placer en paramètre
    public int getCurrentLevel(Disease disease) {
        return diseaseCurrentLevel.get(disease);
    }
    //modifie le level d'une maladie
    private void setCurrentLevel(Disease disease, int currentLevel) {
        diseaseCurrentLevel.put(disease, currentLevel);
    }
    //ajoute une maladie avec un level custom
    public void addDiseaseCurrentLevel(Disease disease, int currentLevel) {
        diseaseCurrentLevel.put(disease, currentLevel);
    }
    //ajoute une maladie avec un level = 1
    public void addDiseaseCurrentLevel(Disease disease) {
        diseaseCurrentLevel.put(disease, 1);
    }
    //baisse le level de la maladie de 1
    public void decreaseLevel(Disease disease) {
        if (getCurrentLevel(disease) <= 1){
            System.out.println("niveau minimum atteint");
        }else{
            setCurrentLevel(disease, getCurrentLevel(disease) -1);
        }
    }
    //augmente le level de la maladie de 1
    public void increaseLevel(Disease disease) {
        if (getCurrentLevel(disease) >= disease.getMaxLevel()){
            creature.die();
        }else{
            setCurrentLevel(disease, getCurrentLevel(disease) +1);
        }
    }
    //usage similaire a un toString qui affiche les maladies d'une créatureMalade
    public void showDisease() {
        System.out.println("Nom : " + creature.getName());
        Iterator<Map.Entry<Disease, Integer>> iterator = diseaseCurrentLevel.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Disease, Integer> element = iterator.next();
            System.out.println("Maladie : " + element.getKey().getShortName() + ", Niveau : " + element.getValue());
        }
    }
    //Renvoie un set avec les maladies d'une CréatureMalade
    public Set<Disease> getDisease(){
        return diseaseCurrentLevel.keySet();
    }
    //Renvoie une liste avec les nom de toute les maladies d'une CréatureMalade
    public List<String> getAllDiseaseNames() {
        List<String> diseaseNames = new ArrayList<>();
        Iterator<Map.Entry<Disease, Integer>> iterator = diseaseCurrentLevel.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Disease, Integer> element = iterator.next();
            diseaseNames.add(element.getKey().getName());
        }
        return diseaseNames;
    }
    //soigne toute les maladies
    public void heal(){
        diseaseCurrentLevel.clear();
    }
    //soigne la maladie passer en paramètre
    public void heal(Disease disease){
        diseaseCurrentLevel.remove(disease);
    }
    //génère une maladie au hasard parmi la liste "diseases"
    public static Disease randomDisease() {
        Random random = new Random();
        int index = random.nextInt(diseases.size()); // Génère un index aléatoire
        return diseases.get(index); // Retourne la maladie correspondante
    }

    public int getNbOfDisease(){
        if(isHealthy())
            return 0;
        return diseaseCurrentLevel.size();

    }
    public boolean isHealthy(){
        return diseaseCurrentLevel.isEmpty();
    }

    public boolean getSeeker(){
        if(!isHealthy()){
            int nbOfSicknessThatIncrease=generateRandomNumber(0,getNbOfDisease());
            for(int i=0;i<nbOfSicknessThatIncrease;i++)
                increaseLevel(randomDisease());
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Creature{name='" + getCreature().getName() + "', gender=" + (getCreature().getGender() ? "Male" : "Female") + ", weight=" + getCreature().getWeight() +
                ", height=" + getCreature().getHeight() + ", age=" + getCreature().getAge() + ", moralityRate=" + getCreature().getMoralityRate() + "}";
    }

    //public abstract void waiting();

}
