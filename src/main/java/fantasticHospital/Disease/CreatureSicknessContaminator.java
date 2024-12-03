package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import fantasticHospital.Creature.Races.Lycanthrope;
import fantasticHospital.Creature.Races.Orc;
import fantasticHospital.Creature.Races.Vampire;

public class CreatureSicknessContaminator extends CreatureSickness{
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
    public void contaminate(CreatureSickness creatureSickness) {
        creatureSickness.addDiseaseCurrentLevel(randomDisease());
    }

}