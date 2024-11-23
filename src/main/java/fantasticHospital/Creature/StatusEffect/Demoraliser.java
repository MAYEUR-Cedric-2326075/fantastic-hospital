package fantasticHospital.Creature.StatusEffect;

import java.util.Set;

public interface Demoraliser<T> {
    int rateOfDemoralisation = 10;
    void demoralize(Set<T> objects);
    void demoralize(T object);
}
