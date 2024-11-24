package fantasticHospital.Creature.Behavior;

public interface Aging {
    public AgeCategory getAgeCategory();
    public enum AgeCategory {
        JEUNE,  // Pour les jeunes
        ADULTE, // Pour les adultes
        VIEUX   // Pour les vieux
    }
}
