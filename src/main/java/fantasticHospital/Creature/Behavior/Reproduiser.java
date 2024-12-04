package fantasticHospital.Creature.Behavior;

import java.util.Set;

public interface Reproduiser<Specie> {
    Set<Specie> reproduiseLitter(int numberOfChildren);
    Set<Specie> reproduiseLitter(Set<String> name, int numberOfChildren);
    Specie reproduise();
    Specie reproduise(String name);
}
