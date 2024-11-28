package fantasticHospital.Creature.Races.Lycanthrope;
import fantasticHospital.Creature.Races.Lycanthrope.*;

import fantasticHospital.Tools.Randomizer;

public class LycanthropeMale extends Lycanthrope implements Randomizer {

    // Constructeur
    // Constructeur
    public LycanthropeMale(String name, double weight, double height,
                             int age ,int strength,int dominationExercised
            ,int impetuosity,boolean loneWolf)  {
        super(name, weight, height, age,strength,dominationExercised,impetuosity,loneWolf);
    }
    // Constructeur
    protected LycanthropeMale(String name, double weight, double height,
                                int age ,int strength,int dominationExercised,int impetuosity){
        super(name, weight, height, age,strength,dominationExercised,impetuosity);
    }
    public boolean isFertiled() {return Lycanthrope.getRace().isFertiled();}
    public boolean isFemale() {return false;}
    public boolean isMale() {return true;}
    public boolean isAlpha() {return this.getIdentification()==PACK.getAlphaMale().getIdentification();}
/*
    @Override
    public boolean isAlpha() {
        return this.equals(PACK.getAlphaMale());
    }
*/

}
