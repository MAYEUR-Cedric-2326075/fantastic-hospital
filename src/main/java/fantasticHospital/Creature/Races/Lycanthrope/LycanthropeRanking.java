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

    public void updateScore(Lycanthrope lycanthrope, int newDominationExercised) {
        if (ranking.contains(lycanthrope))
            ranking.remove(lycanthrope);
        lycanthrope.setDominationExercised(newDominationExercised);
        ranking.add(lycanthrope);
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
