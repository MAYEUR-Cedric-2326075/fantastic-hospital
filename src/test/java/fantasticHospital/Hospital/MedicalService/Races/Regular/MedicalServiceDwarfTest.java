package fantasticHospital.Hospital.MedicalService.Races.Regular;

import fantasticHospital.Creature.Races.Dwarf;
import fantasticHospital.Disease.Races.Regular.DwarfSickness;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MedicalServiceDwarfTest {

    private MedicalServiceDwarf medicalServiceDwarf;
    private DwarfSickness dwarfSickness1;
    private DwarfSickness dwarfSickness2;

    @BeforeEach
    void setUp() {
        // Initialisation du service médical et des patients
        medicalServiceDwarf = new MedicalServiceDwarf("Dwarf Medical Service", 50000);

        Dwarf dwarf1 = new Dwarf("Gloin", true, 80.0, 1.4, 140);
        Dwarf dwarf2 = new Dwarf("Oin", false, 75.0, 1.3, 145);

        dwarfSickness1 = new DwarfSickness(dwarf1);
        dwarfSickness2 = new DwarfSickness(dwarf2);
    }

    @Test
    void testAddPatient() {
        // Ajouter un patient au service
        boolean added = medicalServiceDwarf.addPatient(dwarfSickness1);
        assertTrue(added, "The patient should be added successfully.");
        assertEquals(1, medicalServiceDwarf.getNumberOfPatientNow(), "The number of patients should be 1.");
    }

    @Test
    void testRemovePatient() {
        // Ajouter et retirer un patient
        medicalServiceDwarf.addPatient(dwarfSickness1);
        boolean removed = medicalServiceDwarf.removePatient(dwarfSickness1);
        assertTrue(removed, "The patient should be removed successfully.");
        assertEquals(0, medicalServiceDwarf.getNumberOfPatientNow(), "The number of patients should be 0.");
    }

    @Test
    void testIsFull() {
        // Test de la limite du nombre maximum de patients
        for (int i = 0; i < medicalServiceDwarf.getNumberOfPatientMax(); i++) {
            Dwarf tempDwarf = new Dwarf("Dwarf" + i, true, 80.0, 1.4, 140);
            DwarfSickness tempSickness = new DwarfSickness(tempDwarf);
            medicalServiceDwarf.addPatient(tempSickness);
        }
        assertTrue(medicalServiceDwarf.isFull(), "The service should be full after adding the maximum number of patients.");
    }

    @Test
    void testWaiting() {
        // Test de la méthode `waiting`
        medicalServiceDwarf.addPatient(dwarfSickness1);
        medicalServiceDwarf.addPatient(dwarfSickness2);

        int initialMorality1 = dwarfSickness1.getCreature().getMoralityRate();
        int initialMorality2 = dwarfSickness2.getCreature().getMoralityRate();

        medicalServiceDwarf.waiting();

        assertEquals(initialMorality1 - dwarfSickness1.getCreature().getRace().getRateOfReduction(),
                dwarfSickness1.getCreature().getMoralityRate(),
                "The morality rate of the first patient should decrease.");
        assertEquals(initialMorality2 - dwarfSickness2.getCreature().getRace().getRateOfReduction(),
                dwarfSickness2.getCreature().getMoralityRate(),
                "The morality rate of the second patient should decrease.");
    }

    @Test
    void testBudgetManagement() {
        // Test de la gestion du budget
        int initialBudget = medicalServiceDwarf.getBudget();
        int expense = 5000;
        medicalServiceDwarf.reviewBudget(expense);

        assertEquals(initialBudget - expense, medicalServiceDwarf.getBudget(), "The budget should decrease by the expense amount.");
    }

    @Test
    void testToString() {
        // Test de la méthode `toString`
        String serviceInfo = medicalServiceDwarf.toString();
        assertNotNull(serviceInfo, "The toString method should return a non-null string.");
    }

}
