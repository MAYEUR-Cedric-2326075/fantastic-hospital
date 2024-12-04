package fantasticHospital.Hospital;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Races.*;
import fantasticHospital.Disease.Races.Contaminater.BeastmanSicknessContaminator;
import fantasticHospital.Disease.Races.Contaminater.LycanthropeSicknessContaminator;
import fantasticHospital.Disease.Races.Contaminater.OrcSicknessContaminator;
import fantasticHospital.Disease.Races.Contaminater.VampireSiknessContaminator;
import fantasticHospital.Disease.Races.Regular.DwarfSickness;
import fantasticHospital.Disease.Races.Regular.ElfSickness;
import fantasticHospital.Disease.Races.Regular.ReptilianSickness;
import fantasticHospital.Disease.Races.Regular.ZombieSickness;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.MedicalService.Employe.Doctor;
import fantasticHospital.Hospital.MedicalService.MedicalService;
import fantasticHospital.Hospital.MedicalService.Races.Cryp.MedicalServiceZombieCryp;
import fantasticHospital.Hospital.MedicalService.Races.Quarantine.MedicalServiceLycanthropeQuarantine;
import fantasticHospital.Hospital.MedicalService.Races.Quarantine.MedicalServiceOrcQuarantine;
import fantasticHospital.Hospital.MedicalService.Races.Quarantine.MedicalServiceQuarantineBeastman;
import fantasticHospital.Hospital.MedicalService.Races.Quarantine.MedicalServiceVampireQuarantine;
import fantasticHospital.Hospital.MedicalService.Races.Regular.MedicalServiceDwarf;
import fantasticHospital.Hospital.MedicalService.Races.Regular.MedicalServiceElf;
import fantasticHospital.Hospital.MedicalService.Races.Regular.MedicalServiceReptilian;



import java.util.*;

public class Hospital {

    private String name;
    private int maxMedicalServices;
    private int maxPatients;
    private int maxDeaths;
    private List<MedicalService> medicalServices;
    private HashMap<Doctor, Boolean> doctorsAvailability;
    private int maxActionPoints;
    private int currentActionPoints;
    private List<Creature> deadCreatures = new ArrayList<>();
    private List<CreatureSickness> creatureSicknesses;
    public Hospital(String name, int maxMedicalServices, int maxPatients, int maxDeaths) {
        this.name = name;
        this.maxMedicalServices = maxMedicalServices;
        this.maxPatients = maxPatients;
        this.maxDeaths = maxDeaths;
        this.medicalServices = generateMedicalServicies();
        this.doctorsAvailability = new HashMap<Doctor, Boolean>();
    }
    public boolean addDoctor(Doctor doctor) {
        if(!doctorsAvailability.containsKey(doctor)) {
            doctorsAvailability.put(doctor, false);
            return false;
        }
        return true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxPatients() {
        return maxPatients;
    }
    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }
    public int getMaxDeaths() {
        return maxDeaths;
    }
    public void setMaxDeaths(int maxDeaths) {
        this.maxDeaths = maxDeaths;
    }
    public int getMaxMedicalServices() {
        return maxMedicalServices;
    }
    public void setMaxMedicalServices(int maxMedicalServices) {
        this.maxMedicalServices = maxMedicalServices;
    }
    public List<MedicalService> getMedicalServices() {
        return medicalServices;
    }
    /*
    public List<Doctor> getDoctors() {
        return doctors;
    }
*/

    private CreatureSickness getCreatureSickness(Creature creature, List<CreatureSickness> creatureSicknesses) {
        for (CreatureSickness sickness : creatureSicknesses) {
            if (sickness.getCreature().equals(creature)) {
                return sickness;
            }
        }
        return null;
    }

    /**
     * Déroulement du jeu :
     *
     * Création du jeu :
     * Initialisation des services médicaux et des créatures.
     *
     * Ajout de nouvelles créatures :
     * Des créatures sont générées aléatoirement.
     * Chaque nouvelle créature se voit attribuer une maladie et un service médical.
     *
     * Gestion des maladies :
     * Les maladies des créatures sont gérées, leur niveau peut augmenter ou diminuer. Elles peuvent également se propager à
     * d'autres créatures du même service. Si une maladie atteint son niveau maximum, la créature meurt.
     *
     * Interaction avec le joueur :
     * Le joueur peut interagir avec les créatures, notamment en les guérissant Il peut incarner un docteur pour cela, il y a 4 docteurs dans l'hôpital.
     * Il a un certain nombre de points d'action qui lui permettent de réaliser ces actions (elles ne coutent pas le même prix)
     * et sont réinitialisés à leur valeur max au début de chaque nouveau tour. Il peut également réviser le budget des services
     * médicaux.
     *
     * Fin du jeu :
     * Le jeu se termine lorsqu'il un nombre de morts défini a été atteint. Son score final (le nombre de tours) sera renvoyé au joueur
     *
     **/

    public void waiting() {
        for (MedicalService<?> service : medicalServices) {
            service.waiting();
        }

    }


    // Afficher les services médicaux
    public void displayMedicalServices() {
        if (medicalServices.isEmpty()) {
            System.out.println("Il n'y a pas de services médicaux.");
        } else {
            for (MedicalService service : medicalServices) {
                System.out.println("Service médical : " + service.getName());
            }
        }
    }




    //Générer une créature aléatoire
    public CreatureSickness generateRandomCreature() {
        Random rand = new Random();

        String name = "Creature_" + rand.nextInt(1000);
        boolean gender = rand.nextBoolean();
        double weight = 50 + rand.nextDouble() * 50;
        double height = 1.5 + rand.nextDouble() * 0.5;
        int age = 1 + rand.nextInt(100);

        // Génération aléatoire d'une race parmi 8 possibles
        int raceChoice = rand.nextInt(8); // 8 races
        switch (raceChoice) {
            case 0:

                return new BeastmanSicknessContaminator(new Beastman(name, gender, weight, height, age));
            case 1:
                return new DwarfSickness(new Dwarf(name, gender, weight, height, age));
            case 2:
                return new ElfSickness(new Elf(name, gender, weight, height, age));
            case 3:
                return new LycanthropeSicknessContaminator(new Lycanthrope(name, gender, weight, height, age));
            case 4:
                return new OrcSicknessContaminator(new Orc(name, gender, weight, height, age));
            case 5:
                return new ReptilianSickness(new Reptilian(name, gender, weight, height, age));
            case 6:
                return new VampireSiknessContaminator(new Vampire(name, gender, weight, height, age));
            case 7:
                return new ZombieSickness(new Zombie(name, gender, weight, height, age));
            default:
                throw new IllegalStateException("Mauvaise race : " + raceChoice);
        }
    }


    public boolean isDoctorAvailable(Doctor doctor) {
        if (doctorsAvailability.containsKey(doctor))
            return doctorsAvailability.get(doctor);
        return false;
    }
    public boolean isOneDoctorAvailable() {
        for (Map.Entry<Doctor, Boolean> entry : doctorsAvailability.entrySet()) {
            if (entry.getValue()) {
                return true;
            }
        }
        return false;
    }
    public boolean healing(CreatureSickness creatureSickness) {
        if (!doctorsAvailability.isEmpty()){
            return true;
        }
        return false;
    }
    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctorsAvailability.keySet());
    }



    // Afficher les actions possibles du joueur
    public void displayHomeActions() {
        System.out.println("Actions possibles :");
        System.out.println("1. Consulter les information de l'hôpital");//affiche tous les services et leur capacité + tous les docteurs, leur emplacement et leurs points d'action.
        System.out.println("2. Selectionner un service médical");
        System.out.println("3. Selectionner un docteur");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        System.out.println("8. ");
        System.out.println("9. Fin du tour");
    }


    public void displayHospitalInfo() {
        System.out.println(/*afficher des données comme le nombre de patients par service*/);
        System.out.println("9. Retour au menu");
    }


    public void displayServicesSelection() {
        System.out.println("Actions possibles :");
        System.out.println("1. Service des Hommes Bêtes");
        System.out.println("2. Service des Nains");
        System.out.println("3. Service des Elfes");
        System.out.println("4. Service des Lycanthropes");
        System.out.println("5. Service des Orcs");
        System.out.println("6. Service des Orcs");
        System.out.println("7. Service des Vampires");
        System.out.println("8. Service des Zombies");
        System.out.println("9. Retour au menu");
    }


    public void displayServiceInfo(MedicalService service) {
        //System.out.println("Nom du service : "+service.getName()+"\nCapacité : "+service.getNbPresentCreature()+"/"+service.getMaxCreature());
        System.out.println("9. Retour au menu");
    }


    // Affichage des informations des docteurs
    public void displayDoctorsSelection() {
        System.out.println("Actions possibles :");

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + getDoctors().get(i).getName());
        }

        // Options 5 à 8 restent vides
        for (int i = 5; i <= 8; i++) {
            System.out.println(i + ". ");
        }

        System.out.println("9. Retour au menu");
    }


    public void displayDoctorAction(Doctor doctor) {
        // System.out.println("Le médecin se trouve dans le service : "+doctor.get);
        System.out.println("Actions possibles :");
        System.out.println("1. Déplacer le médecin");
        System.out.println("2. Soigner un patient");
        System.out.println("3. Réviser le budget du service");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        System.out.println("8. ");
        System.out.println("9. Retour au menu");
    }


    private static List<MedicalService> generateMedicalServicies(){
        List<MedicalService> medicalServices = new ArrayList<>();

        MedicalServiceElf medicalServiceElf = new MedicalServiceElf("Service medical Elf");
        MedicalServiceDwarf medicalServiceDwarf = new MedicalServiceDwarf("Service medical Dwarf");
        MedicalServiceOrcQuarantine medicalServiceOrc = new MedicalServiceOrcQuarantine("Service medical Orc");
        MedicalServiceQuarantineBeastman medicalServiceBeastman = new MedicalServiceQuarantineBeastman("Service medical Beastman");
        MedicalServiceZombieCryp medicalServiceZombie = new MedicalServiceZombieCryp("Service medical Zombie");
        MedicalServiceVampireQuarantine medicalServiceVampire = new MedicalServiceVampireQuarantine("Service medical Vampire");
        MedicalServiceLycanthropeQuarantine medicalServiceLycanthrope = new MedicalServiceLycanthropeQuarantine("Service medical Lycanthrope");
        MedicalServiceReptilian medicalServiceReptilian = new MedicalServiceReptilian("Service medical Reptilian");
        medicalServices.add(medicalServiceElf);
        medicalServices.add(medicalServiceDwarf);
        medicalServices.add(medicalServiceOrc);
        medicalServices.add(medicalServiceBeastman);
        medicalServices.add(medicalServiceZombie);
        medicalServices.add(medicalServiceVampire);
        medicalServices.add(medicalServiceLycanthrope);
        medicalServices.add(medicalServiceReptilian);
        //exemple pour test
        //medicalServiceDwarf.addPatient(new DwarfSickness(new Dwarf("Gloin", true, 80.0, 1.4, 140)));
        //medicalServiceDwarf.addPatient(new DwarfSickness(new Dwarf("Gloin2", true, 85.0, 1.4, 140)));
        return medicalServices;
    }

    public void addToMedicalServices(CreatureSickness creatureSickness) {
        switch (creatureSickness.getCreature().getRace().getRaceName()) {
            case "Elf":
                medicalServices.get(0).addPatient((ElfSickness)creatureSickness);
                break;
            case "Dwarf":
                medicalServices.get(1).addPatient((DwarfSickness)creatureSickness);
                break;
            case "Reptilian":
                medicalServices.get(2).addPatient((ReptilianSickness)creatureSickness);
                break;
            case "Zombie":
                medicalServices.get(3).addPatient((ZombieSickness)creatureSickness);
                break;
            case "Beastman":
                medicalServices.get(4).addPatient((BeastmanSicknessContaminator)creatureSickness);
                break;
            case "Lycanthrope":
                medicalServices.get(5).addPatient((LycanthropeSicknessContaminator)creatureSickness);
                break;
            case "Orc":
                medicalServices.get(6).addPatient((OrcSicknessContaminator)creatureSickness);
                break;
            case "Vampire":
                medicalServices.get(7).addPatient((VampireSiknessContaminator)creatureSickness);
                break;
            default:
                System.out.println("Race non reconnue");
                break;
        }
    }


 /*   // Boucle principale de simulation
    public void mainLoop(List<CreatureSickness> creatureSicknesses) {
        Random rand = new Random();
        int turn = 0;
        int totalDeaths = 0;

        while (totalDeaths < getMaxDeaths()) {
            ++turn;
            System.out.println("\n--- Tour " + turn + " ---");

            // 1. Contamination des créatures et évolution des maladies
            for (MedicalService service : medicalServices) {
                for (Creature creature : service.getPresentCreature()) {
                    CreatureSickness sickness = getCreatureSickness(creature, creatureSicknesses);
                    if (sickness == null) continue;

                    if (rand.nextInt(100) < 30) { // 30% chance contamination
                        Disease newDisease = generateRandomDisease();
                        sickness.addDiseaseCurrentLevel(newDisease);
                        System.out.println(creature.getName() + " a été contaminé par : " + newDisease.getName());
                    }

                    for (Disease disease : sickness.getDisease()) {
                        sickness.increaseLevel(disease);
                    }
                }
            }
*/

/*    // Génération aléatoire de maladies
    private Disease generateRandomDisease() {
        String name = "Maladie_" + new Random().nextInt(100);
        String shortName = "M" + new Random().nextInt(10);
        int maxLevel = 5 + new Random().nextInt(5); // Niveau max entre 5 et 10
        return new Disease(name, shortName, maxLevel);
    }
    */
}
