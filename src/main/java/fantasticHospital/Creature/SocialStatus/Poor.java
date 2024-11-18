package fantasticHospital.roles;

/**
 * Interface Poor
 */
public interface Poor {

    /**
     * Demande une aide supplémentaire.
     */
    void requestAid();

    /**
     * Subit une diminution plus rapide du moral.
     */
    void loseMoralQuickly();

    /**
     * Accède à des zones de quarantaine ou d'aide.
     */
    void accessAssistanceArea();
}
