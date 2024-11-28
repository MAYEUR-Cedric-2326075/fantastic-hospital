package fantasticHospital.Creature.Races.Lycanthrope;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Pack {


    private TreeSet<Lycanthrope> ranking;

    // Constructeur
    public Pack() {
        this.ranking = new TreeSet<>(new LycanthropeSorter());
    }
    public int size(){return this.ranking.size();}
    public  boolean isInPack(String id){
        for(Lycanthrope l : ranking){
            if(l.getIdentification().equals(id)){
                return true;
            }
        }
        return false;
    }
    public  Lycanthrope getAlphaMale(){
        if(!ranking.isEmpty()){
            for(Lycanthrope l : ranking){
                if(l.isMale()){
                    return l;
                }
            }
        }
        return null;
    }
    public  Lycanthrope getAlphaDFemale(){
        if(!ranking.isEmpty()){
            for(Lycanthrope l : ranking){
                if(l.isFemale()){
                    return l;
                }
            }
        }
        return null;
    }







    // Méthode pour ajouter un Lycanthrope au pack
    public void addLycanthrope(Lycanthrope lycanthrope) {
        ranking.add(lycanthrope);

    }
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        ranking.remove(lycanthrope);

    }

    public void display() {
        System.out.println("Pack size: " + this.size());
        System.out.println("Ranking of Lycanthropes:");

        int rank = 1;
        for (Lycanthrope lycanthrope : ranking) {
            System.out.println(rank++ + ". " + lycanthrope.getName() +
                    " (Type: " + (lycanthrope.isMale() ? "Male" : "Female") + ", " +
                    "Domination: " + lycanthrope.getDominationExercised() + ")");
        }

        // Afficher l'Alpha Mâle
        Lycanthrope alphaMale = getAlphaMale();
        if (alphaMale != null) {
            System.out.println("Alpha Male: " + alphaMale.getName());
        } else {
            System.out.println("No Alpha Male in the pack.");
        }

        // Afficher l'Alpha Femelle
        Lycanthrope alphaFemale = getAlphaDFemale();
        if (alphaFemale != null) {
            System.out.println("Alpha Female: " + alphaFemale.getName());
        } else {
            System.out.println("No Alpha Female in the pack.");
        }
    }


}
