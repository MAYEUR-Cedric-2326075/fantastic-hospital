
package fantasticHospital.Creature.Races.Lycanthrope;
public class LycanthropeTest {
    public static void testLycanthropesRanking() {
        LycanthropeMale male1 = new LycanthropeMale("Male1", 70.0, 175.0, 4,
                80, 30, 30);
        LycanthropeMale male2 = new LycanthropeMale("Male2", 75.0, 180.0,
                5, 90, 25, 35);
        System.out.println("Rank after creation must be 1 male1 =" + male1.getRank());
        System.out.println("Rank after creation must be 2 male2 =" + male2.getRank());
        male2.setDominationExercised(40);
        System.out.println("Rank after modification must be 1 male2 =" + male2.getRank());
        System.out.println("Rank after modification must be 2 male1 =" + male1.getRank());
    }

    public static void testLycanthropesAlpha() {
        // Création des Lycanthropes normaux
        LycanthropeMale male1 = new LycanthropeMale("Male1", 70.0,
                175.0, 4, 80, 20, 30,false);
        LycanthropeMale male2 = new LycanthropeMale("Male2", 75.0, 180.0,
                5, 90, 25, 35,false);
        LycanthropeFemale female1 = new LycanthropeFemale("Female1", 65.0, 165.0,
                3, 70, 15, 25,false);
        LycanthropeFemale female2 = new LycanthropeFemale("Female2", 68.0, 170.0,
                4, 85, 18, 28,false);

        Lycanthrope.PACK.display();
        Lycanthrope.PACK.getAlphaDFemale();


    }

    public static void main(String[] args) {
        testLycanthropesAlpha();
    }
}
