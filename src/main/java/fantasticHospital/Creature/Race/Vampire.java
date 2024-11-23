package fantasticHospital.Creature.Race;
import fantasticHospital.Creature.SocialStatus.Vip;
import fantasticHospital.Creature.StatusEffect.*;
import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Behavior.VipWaiter;

public class Vampire extends Creature implements VipWaiter, Regenerator, Demoraliser/*, Contaminator*/ {

    private static final Race race = Race.VAMPIRE;

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public void waiting() {
        this.setMoralityRate(getMoralityRate()- Vip.tauxOfReduction);
    }

    @Override
    public void regenerate() {
        this.setAlive(true);
    }

    @Override
    public void demoralize(Creature creature) {
        creature.setMoralityRate(creature.getMoralityRate()-Demoraliser.tauxOfDemoralisation);
    }
/*
    @Override
    public void contaminate(Creature creature) {
        // Comportement spécifique de contamination des Vampires
        System.out.println("The Vampire infects " + creature.getName() + " with its dark curse!");
    }
*/
    public Vampire(String name, boolean gender, double weight, double height, int age) {
        super(name, gender, weight, height, age);
    }


}
