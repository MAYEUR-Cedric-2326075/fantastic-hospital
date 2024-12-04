package fantasticHospital.Creature.Races.Lycanthrope;
import java.util.Comparator;//LycanthropeFemale
public class LycanthropeSorter implements Comparator<LycanthropeFemale>{
    @Override
    public int compare(LycanthropeFemale l1, LycanthropeFemale l2) {
        return Integer.compare(l2.getBeauty(), l1.getBeauty());
    }
}
