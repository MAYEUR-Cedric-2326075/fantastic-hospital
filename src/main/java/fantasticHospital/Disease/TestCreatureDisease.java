package fantasticHospital.Disease;

import fantasticHospital.Creature.Race.Beastman;

public class TestCreatureDisease {

    public static void main(String[] args) {
        //je cree toutes les maladies
        Disease MDC = new Disease("Maladie débilitante chronique", "MDC", 5);
        Disease FOMO = new Disease("fear of missing out", "FOMO", 5);
        Disease DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        Disease PEC = new Disease("Porphyrie érythropoïétique congénitale", "PEC", 5);
        Disease ZPL = new Disease("Zoopathie paraphrénique lycanthropique", "ZPL", 5);
        Disease BG = new Disease("Blight of Gloom", "BG", 5);

        //je cree une creature
        Beastman beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);

        //test de CreatureDisease
        CreatureDisease beastmanDisease = new CreatureDisease(FOMO, beastman, 2);
        System.out.println("les maladie de " + beastman.getName() + " : " + beastmanDisease.getDisease().getShortName() + " de niveau " + beastmanDisease.getCurrentLevel());
        beastmanDisease.decreaseLevel();
        System.out.println("les maladie de " + beastman.getName() + " : " + beastmanDisease.getDisease().getShortName() + " de niveau " + beastmanDisease.getCurrentLevel());

    }
}
