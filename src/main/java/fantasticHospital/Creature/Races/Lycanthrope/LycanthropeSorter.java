package fantasticHospital.Creature.Races.Lycanthrope;
import java.util.Comparator;
public class LycanthropeSorter implements Comparator<Lycanthrope>{
    @Override
    public int compare(Lycanthrope l1, Lycanthrope l2) {
        return Integer.compare(l2.getDominationExercised(), l1.getDominationExercised());
    }
    /*
    public int compare(Lycanthrope l1, Lycanthrope l2) {
        return Integer.compare(l2.getStrength(), l1.getStrength());
    }
    */


}
