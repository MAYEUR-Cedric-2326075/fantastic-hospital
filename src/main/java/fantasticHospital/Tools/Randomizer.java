package fantasticHospital.Tools;

/**
 * Interface utilitaire pour générer des noms et des nombres aléatoires.
 */
public interface Randomizer {


    default String generateRandomName(int length) {
        StringBuilder name = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            name.append(characters.charAt(randomIndex));
        }
        return name.toString();
    }

    default int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    default boolean generateRandomBoolean() {
        return Math.random() < 0.5;
    }
    default float generateRandomFloat(float min, float max) {
        return (float) (Math.random() * (max - min)) + min;
    }

}
