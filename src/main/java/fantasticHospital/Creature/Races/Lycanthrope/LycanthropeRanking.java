package fantasticHospital.Creature.Races.Lycanthrope;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class LycanthropeRanking{
    private TreeSet<Lycanthrope> ranking;
    public LycanthropeRanking() {
        // Utilisation du comparateur pour trier les Lycanthropes
        this.ranking = new TreeSet<>(new LycanthropeSorter());
    }
    // Ajouter un compétiteur
    public void addLycanthrope(Lycanthrope lycanthrope) {
        ranking.add(lycanthrope);
    }
    public boolean isInRanking(Lycanthrope lycanthrope) {
        for(Lycanthrope l : ranking){
            if(l.equals(lycanthrope.getIdentification()))
                return true;
        }
        return false;
    }



    public int getRank(Lycanthrope lycanthrope) {
        int rank = 1;
        for (Lycanthrope l : ranking) {
            if (l.equals(lycanthrope))
                return rank;
            rank++;
        }
        return -1;
    }
    public void removeLycanthrope(Lycanthrope lycanthrope) {
        ranking.remove(lycanthrope);
    }

    public List<Lycanthrope> getRanking() {
        return new ArrayList<>(ranking);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classement des Lycanthropes:\n");
        int rank = 1;
        for (Lycanthrope lycanthrope : ranking) {
            sb.append(rank++)
                    .append(". ")
                    .append(lycanthrope.getName())
                    .append(" - Domination: ")
                    .append(lycanthrope.getDominationExercised())
                    .append("\n");
        }
        return sb.toString();
    }
}
