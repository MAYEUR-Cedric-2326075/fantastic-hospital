package fantasticHospital.Creature.Races.Lycanthrope;

import java.util.HashSet;

public class LycanthropeTest {

    // Test pour valider le classement des Lycanthropes et l'ajout des membres
    public static void testLycanthropesRanking() {

    }

    // Test pour valider la gestion des Alphas et des défis
    public static void testLycanthropesAlpha() {
        System.out.println("=== Test: Lycanthropes Alpha Management ===");



        // Créer des Lycanthropes mâles
        LycanthropeMale male1 = new LycanthropeMale("Fenrir", 90, 180, 30, 100
                , 1);
        LycanthropeMale male3= new LycanthropeMale("Skoll", 85, 175, 28, 600
                , 101);
        LycanthropeMale male2 = new LycanthropeMale("Machine", 85, 175, 28, 200
                , 101);

        // Créer des Lycanthropes femelles
        LycanthropeFemale female2 = new LycanthropeFemale("Luna", 65, 165, 22
                , 75, 8, 35,520);
        LycanthropeFemale female1 = new LycanthropeFemale("Hati", 70, 170, 25
                , 80, 10, 30,100);

        LycanthropeFemale female3 = new LycanthropeFemale("Mada", 65, 165, 22
                , 75, 8, 35,50);
        Lycanthrope.PACK.moveMembers(2,male1);
        Lycanthrope.PACK.moveMembers(6,male2);
        //System.out.println("=== Test: Lycanthropes Alpha Management ==="+Lycanthrope.PACK.toString());
        //Lycanthrope.PACK.challenge(male2,male1);
        //Lycanthrope.PACK.challengeAlpha(male3);
        System.out.println("=== Test: Lycanthropes Alpha Management ==="+Lycanthrope.PACK.toString());


    }

    public static void main(String[] args) {
        testLycanthropesRanking();
        testLycanthropesAlpha();
    }
}
