package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Tools.Randomizer;

public class LycanthropeMale extends Lycanthrope implements Randomizer {

    // Constructeur
    // Constructeur
    public LycanthropeMale(String name, double weight, double height,
                             int age ,int strength,int impetuosity,boolean loneWolf)  {
        super(name, weight, height, age,strength,impetuosity,loneWolf);
        if(!loneWolf)
            PACK.addLycanthrope(this);
    }
    public  boolean getGender(){return true;}
    public boolean challengeAlpha(){return PACK.challenge(this,PACK.getAlphaMale());}
    // Constructeur
    public LycanthropeMale(String name, double weight, double height,
                                int age ,int strength,int impetuosity){
        this(name, weight, height, age,strength,impetuosity,false);
    }
    public boolean isFertiled() {return this.getRace().isFertiled();}
    public boolean isFemale() {return false;}
    public boolean isMale() {return true;}
    public boolean isAlpha() {return PACK.isAlpha(this);}
    @Override
    public String toString() {
        return super.toString().replace("}", "") + // Réutilise et modifie le toString de Lycanthrope
                ", type='Male'" + // Ajoute une indication explicite du sexe
                '}';
    }
    public void joinThePack(){
        if(!PACK.isInPack(this))
            PACK.addLycanthrope(this);
    }
    public void quitThePack(){
        if(PACK.isInPack(this))
            PACK.removeLycanthrope(this);
    }
}
