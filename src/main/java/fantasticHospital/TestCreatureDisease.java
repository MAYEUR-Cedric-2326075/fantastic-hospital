package fantasticHospital;

import fantasticHospital.Creature.Races.*;
import fantasticHospital.Disease.CreatureSickness;
import fantasticHospital.Disease.CreatureSicknessContaminator;
import fantasticHospital.Disease.Disease;

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
/*
        //test de CreatureDisease
        CreatureDisease beastmanDisease = new CreatureDisease(FOMO, beastman, 2);
        System.out.println("les maladie de " + beastman.getName() + " : " + beastmanDisease.getDisease().getShortName() + " de niveau " + beastmanDisease.getCurrentLevel());
        beastmanDisease.decreaseLevel();
        System.out.println("les maladie de " + beastman.getName() + " : " + beastmanDisease.getDisease().getShortName() + " de niveau " + beastmanDisease.getCurrentLevel());


/*
        Beastman beastman2 = new Beastman("cedric", true, 80.5, 2.1, 20);
        beastman2.addDisease(ZPL, 4);
        beastman2.addDisease(FOMO, 2);
        beastman2.showDisease();
        beastman2.getDiseaseList().get(0).decreaseLevel();
        beastman2.showDisease();
*/

        /*
        Beastman beastman3 = new Beastman("nicolas", true, 80.5, 2.1, 2);
        CreatureSickness test = new CreatureSickness(beastman3);
        System.out.println(test.getCreature().getName());
        System.out.println(test.getDiseaseCurrentLevel());
        test.addDiseaseCurrentLevel(FOMO);
        test.showDisease();
        test.addDiseaseCurrentLevel(ZPL, 5);
        test.showDisease();
         */

        CreatureSicknessContaminator beastmanDisease = new CreatureSicknessContaminator(beastman);
        CreatureSicknessContaminator beastmanDisease2 = new CreatureSicknessContaminator(beastman);
        //ajout de 2 maladies
        beastmanDisease.addDiseaseCurrentLevel(ZPL, 5);
        beastmanDisease.addDiseaseCurrentLevel(FOMO);
        //  -1 niv de ZPL

        beastmanDisease.decreaseLevel(ZPL);
        System.out.println(beastmanDisease.getAllDiseaseNames());
        beastmanDisease.heal(ZPL);
        System.out.println("test : " + beastmanDisease.getAllDiseaseNames());
        //beastmanDisease.showDisease();

        beastmanDisease.contaminate(beastmanDisease2);
        System.out.println("Maladie de Beastman2 : " + beastmanDisease2.getAllDiseaseNames());


    }
}
