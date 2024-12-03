package fantasticHospital.Disease.Races.Contaminater;

import fantasticHospital.Creature.Races.Beastman;
import fantasticHospital.Creature.Races.Vampire;
import fantasticHospital.Disease.TypeOfPatient.*;
import fantasticHospital.Creature.Behavior.PoorWaiter;

public class BeastmanSicknessContaminator extends  CreatureSicknessContaminator implements PoorWaiter{
    public BeastmanSicknessContaminator(Beastman creature) {
        super(creature);
    }
    @Override
    public Beastman getCreature(){return (Beastman)super.getCreature();}

    @Override
    public void waiting(boolean isAlone) {
        getCreature().waiting(isAlone);
        getSeeker();
    }


}
