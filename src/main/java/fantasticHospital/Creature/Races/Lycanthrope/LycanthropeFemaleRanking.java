package fantasticHospital.Creature.Races.Lycanthrope;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class LycanthropeFemaleRanking {
    private TreeSet<LycanthropeFemale> ranking;
    public LycanthropeFemaleRanking() {
        // Utilisation du comparateur pour trier les Lycanthropes
        this.ranking = new TreeSet<>(new LycanthropeSorter());
    }
    public int size(){
        return this.ranking.size();
    }
    public LycanthropeFemale getFirst(){return this.ranking.first();}
    // Ajouter un compétiteur
    public void addLycanthrope(LycanthropeFemale lycanthrope) {
        ranking.add(lycanthrope);
    }
    public boolean isInRanking(LycanthropeFemale lycanthrope) {
        for(Lycanthrope l : ranking){
            if(l.equals(lycanthrope.getIdentification()))
                return true;
        }
        return false;
    }
    public int getRank(LycanthropeFemale lycanthrope) {
        int rank = 1;
        for (LycanthropeFemale l : ranking) {
            if (l.equals(lycanthrope))
                return rank;
            rank++;
        }
        return -1;
    }
    public void removeLycanthrope(LycanthropeFemale lycanthrope) {
        ranking.remove(lycanthrope);
    }


}
