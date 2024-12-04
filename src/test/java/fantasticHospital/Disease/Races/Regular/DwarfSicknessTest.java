
package fantasticHospital.Disease.Races.Regular;

import fantasticHospital.Creature.Races.Dwarf;
import fantasticHospital.Disease.Disease;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DwarfSicknessTest {

    private Dwarf dwarf;
    private CreatureSickness dwarfSickness;

    @BeforeEach
    void setUp() {
        // Création d'un nain et initialisation de ses maladies
        dwarf = new Dwarf("Gimli", true, 80.0, 1.4, 140);
        dwarfSickness = new CreatureSickness(dwarf) {};
    }

    @Test
    void getCreature() {
        // Vérifie que la créature associée est correcte
        assertEquals(dwarf, dwarfSickness.getCreature(), "The associated creature should be the initialized dwarf.");
    }

    @Test
    void addAndRetrieveDisease() {
        // Ajout d'une maladie et vérification de sa présence
        Disease disease = new Disease("Test Disease", "TD", 5);
        dwarfSickness.addDiseaseCurrentLevel(disease);

        assertTrue(dwarfSickness.getDisease().contains(disease), "The disease should be added to the creature.");
        assertEquals(1, dwarfSickness.getCurrentLevel(disease), "The initial disease level should be 1.");
    }

    @Test
    void increaseAndDecreaseDiseaseLevel() {
        // Test de l'augmentation et de la diminution du niveau de maladie
        Disease disease = new Disease("Test Disease", "TD", 5);
        dwarfSickness.addDiseaseCurrentLevel(disease);

        dwarfSickness.increaseLevel(disease);
        assertEquals(2, dwarfSickness.getCurrentLevel(disease), "The disease level should increase by 1.");

        dwarfSickness.decreaseLevel(disease);
        assertEquals(1, dwarfSickness.getCurrentLevel(disease), "The disease level should decrease by 1.");
    }

    @Test
    void healDisease() {
        // Test de la guérison d'une maladie spécifique
        Disease disease = new Disease("Test Disease", "TD", 5);
        dwarfSickness.addDiseaseCurrentLevel(disease);

        dwarfSickness.cured(disease);
        assertFalse(dwarfSickness.getDisease().contains(disease), "The disease should be removed after healing.");
    }

    @Test
    void healAllDiseases() {
        // Test de la guérison de toutes les maladies
        Disease disease1 = new Disease("Disease 1", "D1", 5);
        Disease disease2 = new Disease("Disease 2", "D2", 5);

        dwarfSickness.addDiseaseCurrentLevel(disease1);
        dwarfSickness.addDiseaseCurrentLevel(disease2);

        dwarfSickness.cured();
        assertTrue(dwarfSickness.isHealthy(), "The creature should be healthy after healing all diseases.");
    }

    @Test
    void randomDiseaseGeneration() {
        // Test de la génération d'une maladie aléatoire
        Disease randomDisease = CreatureSickness.randomDisease();
        assertNotNull(randomDisease, "The random disease should not be null.");
        assertTrue(randomDisease.getName().length() > 0, "The random disease should have a valid name.");
    }

    @Test
    void getAllDiseaseNames() {
        // Test de la récupération des noms de maladies
        Disease disease1 = new Disease("Disease 1", "D1", 5);
        Disease disease2 = new Disease("Disease 2", "D2", 5);

        dwarfSickness.addDiseaseCurrentLevel(disease1);
        dwarfSickness.addDiseaseCurrentLevel(disease2);

        Set<String> diseaseNames = Set.copyOf(dwarfSickness.getAllDiseaseNames());
        assertTrue(diseaseNames.contains("Disease 1"), "Disease 1 should be in the list of names.");
        assertTrue(diseaseNames.contains("Disease 2"), "Disease 2 should be in the list of names.");
    }
}
