package fantasticHospital.Creature.Behavior;

import java.util.Set;

public interface Reproduiser<T1,T2> {
    Set<T1> reproduiseLitter(T2 t2);
    Set<T1> reproduiseLitter(T2 t2,Set<String> name);
    T1 reproduise(T2 t2);
    T1 reproduise(T2 t2,String name);
}
