package fantasticHospital.Creature.Races.Lycanthrope;

import fantasticHospital.Creature.Behavior.Reproduiser;
import fantasticHospital.Creature.Behavior.TraitInheritance;
import fantasticHospital.Tools.Randomizer;

import java.util.HashSet;
import java.util.Set;


public class LycanthropeFemale extends Lycanthrope implements TraitInheritance<Lycanthrope> {

    private static LycanthropeFemaleRanking ranking = new LycanthropeFemaleRanking();
    private int beauty;
    // Constructeur
    public LycanthropeFemale(String name, double weight, double height,
    int age ,int strength,int dominationExercised,int impetuosity,boolean loneWolf,int beauty)  {
        super(name, weight, height, age,strength,impetuosity,loneWolf);
        if(!loneWolf)
            PACK.addLycanthrope(this);
        this.beauty = beauty;
    }
    // Constructeur
    public LycanthropeFemale(String name, double weight, double height,
    int age ,int strength,int dominationExercised,int impetuosity,int beauty){
        this(name, weight, height, age,strength,dominationExercised,impetuosity,false,beauty);
    }
    // Vérifie si la femelle est fertile
    public boolean isFertiled() {
        return Lycanthrope.getRace().isFertiled();
    }

    @Override
    public void inheritTraits(Lycanthrope child, Lycanthrope otherParent) {
        // Introduire de l'aléatoire dans les héritages
        double randomnessWeight = this.generateRandomFloat(-0.5f, 1.5f);
        double randomnessHeight = this.generateRandomFloat(-0.5f, 1.5f);
        double randomnessStrength = this.generateRandomFloat(-0.5f, 1.5f);
        double randomnessImpetuosity = this.generateRandomFloat(-0.5f, 1.5f);

        // Calculer les caractéristiques de l'enfant
        double childWeight = ((this.getWeight() + otherParent.getWeight()) / 2) * randomnessWeight;
        double childHeight = ((this.getHeight() + otherParent.getHeight()) / 2) * randomnessHeight;
        int childStrength = (int) (((this.getStrength() + otherParent.getStrength()) / 2) * randomnessStrength);
        int childImpetuosity = (int) (((this.getImpetuosity() + otherParent.getImpetuosity()) / 2) * randomnessImpetuosity);

        // Mettre à jour les attributs de l'enfant
        child.setWeight(Math.max(childWeight, 1.0)); // S'assurer que le poids est positif
        child.setHeight(Math.max(childHeight, 1.0)); // S'assurer que la taille est positive
        child.setStrength(Math.max(childStrength, 1)); // S'assurer que la force est positive
        child.setImpetuosity(Math.max(childImpetuosity, 1)); // S'assurer que l'impétuosité est positive
        child.setAge(0); // L'enfant commence à 0 an
    }
    public boolean isFemale() {return true;}
    public boolean isMale() {return false;}
    public boolean isAlpha() {return PACK.isAlpha(this);}
    public int getRank() {return ranking.getRank(this);}
    public int getBeauty() {return beauty;}
    public void setBeauty(int beauty) {this.beauty = beauty;}
    @Override
    public String toString() {
        return super.toString().replace("}", "") + // Réutilise et modifie le toString de Lycanthrope
                ", beauty=" + beauty +
                ", rank=" + this.getRank() +
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
