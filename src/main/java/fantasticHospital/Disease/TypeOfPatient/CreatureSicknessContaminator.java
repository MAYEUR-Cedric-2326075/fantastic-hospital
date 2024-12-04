package fantasticHospital.Disease.TypeOfPatient;

import fantasticHospital.Creature.Races.Beastman;
import fantasticHospital.Creature.Races.Lycanthrope.Lycanthrope;
import fantasticHospital.Creature.Races.Orc;
import fantasticHospital.Creature.Races.Vampire;
import fantasticHospital.Disease.Behavior.Contaminator;


public abstract class CreatureSicknessContaminator extends CreatureSickness implements Contaminator<CreatureSickness> {
    //classe fille de CreatureSickness

    //constructeurs
    public CreatureSicknessContaminator(Beastman creature) {
        super(creature);
    }
    public CreatureSicknessContaminator(Orc creature) {
        super(creature);
    }
    public CreatureSicknessContaminator(Lycanthrope creature) {
        super(creature);
    }
    public CreatureSicknessContaminator(Vampire creature) {
        super(creature);
    }

    //permet de contaminer une créature passer en paramètre
    public boolean contaminate(CreatureSickness creatureSickness) {
        if(!creatureSickness.getCreature().equals(this.getCreature())){
            creatureSickness.addDiseaseCurrentLevel(randomDisease());
            return true;
        }
        return false;
    }
}
