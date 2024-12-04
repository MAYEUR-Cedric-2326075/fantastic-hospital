package fantasticHospital.Disease;

import fantasticHospital.Creature.Races.Beastman;
import fantasticHospital.Disease.Races.Contaminater.BeastmanSicknessContaminator;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureSicknessContaminatorTest {

    private Disease DRS;
    private Beastman beastman;
    private CreatureSickness beastmanDisease;
    @BeforeEach
    void setUp() {
        DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        beastman = new Beastman("Tormak", true, 80.5, 2.1, 25);
        beastmanDisease = new BeastmanSicknessContaminator(beastman);
    }

    @Test
    void contaminate() {
        BeastmanSicknessContaminator beastmanDisease2 = new BeastmanSicknessContaminator(beastman);
        beastmanDisease2.contaminate(beastmanDisease);
        assertNotNull(beastmanDisease.getAllDiseaseNames());
    }

}