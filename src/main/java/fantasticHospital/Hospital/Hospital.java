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
import fantasticHospital.Tools.Randomizer;



import java.util.*;

public class Hospital implements Randomizer {

    private String name;
    private int maxPatients;
    private int maxDeaths;
    private HashMap<Doctor, Boolean> doctorsAvailability;
    private int maxActionPoints;
    private int currentActionPoints;
    private List<Creature> deadCreatures = new ArrayList<>();
    private List<CreatureSickness> creatureSicknesses;
    private MedicalServiceElf medicalServiceElf = new MedicalServiceElf("Service medical Elf");
    private MedicalServiceDwarf medicalServiceDwarf = new MedicalServiceDwarf("Service medical Dwarf");
    private MedicalServiceOrcQuarantine medicalServiceOrc = new MedicalServiceOrcQuarantine("Service medical Orc");
    private MedicalServiceQuarantineBeastman medicalServiceBeastman = new MedicalServiceQuarantineBeastman("Service medical Beastman");
    private MedicalServiceZombieCryp medicalServiceZombie = new MedicalServiceZombieCryp("Service medical Zombie");
    private MedicalServiceVampireQuarantine medicalServiceVampire = new MedicalServiceVampireQuarantine("Service medical Vampire");
    private MedicalServiceZombieCryp cryptSZombie = new MedicalServiceZombieCryp("Crypt  Zombie");
    private MedicalServiceVampireQuarantine cryptVampire = new MedicalServiceVampireQuarantine("Crypt Vampire");

    private MedicalServiceLycanthropeQuarantine medicalServiceLycanthrope = new MedicalServiceLycanthropeQuarantine("Service medical Lycanthrope");
    private MedicalServiceReptilian medicalServiceReptilian = new MedicalServiceReptilian("Service medical Reptilian");
    public Hospital(String name, int maxPatients, int maxDeaths) {
        this.name = name;
        this.maxPatients = maxPatients;
        this.maxDeaths = maxDeaths;
        this.doctorsAvailability = new HashMap<Doctor, Boolean>();
        this.generateAndAddRandomDoctors(generateRandomNumber(1,3));
    }

    public MedicalServiceReptilian getMedicalServiceReptilian() {
        return medicalServiceReptilian;
    }

    public void setMedicalServiceReptilian(MedicalServiceReptilian medicalServiceReptilian) {
        this.medicalServiceReptilian = medicalServiceReptilian;
    }

    public MedicalServiceLycanthropeQuarantine getMedicalServiceLycanthrope() {
        return medicalServiceLycanthrope;
    }

    public void setMedicalServiceLycanthrope(MedicalServiceLycanthropeQuarantine medicalServiceLycanthrope) {
        this.medicalServiceLycanthrope = medicalServiceLycanthrope;
    }

    public MedicalServiceVampireQuarantine getMedicalServiceVampire() {
        return medicalServiceVampire;
    }

    public void setMedicalServiceVampire(MedicalServiceVampireQuarantine medicalServiceVampire) {
        this.medicalServiceVampire = medicalServiceVampire;
    }

    public MedicalServiceZombieCryp getMedicalServiceZombie() {
        return medicalServiceZombie;
    }

    public void setMedicalServiceZombie(MedicalServiceZombieCryp medicalServiceZombie) {
        this.medicalServiceZombie = medicalServiceZombie;
    }

    public MedicalServiceQuarantineBeastman getMedicalServiceBeastman() {
        return medicalServiceBeastman;
    }

    public void setMedicalServiceBeastman(MedicalServiceQuarantineBeastman medicalServiceBeastman) {
        this.medicalServiceBeastman = medicalServiceBeastman;
    }

    public MedicalServiceOrcQuarantine getMedicalServiceOrc() {
        return medicalServiceOrc;
    }

    public void setMedicalServiceOrc(MedicalServiceOrcQuarantine medicalServiceOrc) {
        this.medicalServiceOrc = medicalServiceOrc;
    }

    public MedicalServiceDwarf getMedicalServiceDwarf() {
        return medicalServiceDwarf;
    }

    public void setMedicalServiceDwarf(MedicalServiceDwarf medicalServiceDwarf) {
        this.medicalServiceDwarf = medicalServiceDwarf;
    }

    public MedicalServiceElf getMedicalServiceElf() {
        return medicalServiceElf;
    }

    public void setMedicalServiceElf(MedicalServiceElf medicalServiceElf) {
        this.medicalServiceElf = medicalServiceElf;
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
        // Appeler la méthode `waiting` pour chaque service médical.
        medicalServiceElf.waiting();
        medicalServiceDwarf.waiting();
        medicalServiceReptilian.waiting();
        medicalServiceZombie.waiting();
        medicalServiceBeastman.waiting();
        medicalServiceLycanthrope.waiting();
        medicalServiceOrc.waiting();
        medicalServiceVampire.waiting();

    }
    public void generateAndAddRandomDoctors(int maxDoctors) {
        Random random = new Random();
        int numDoctors = random.nextInt(maxDoctors) + 1;

        for (int i = 0; i < numDoctors; i++) {
            String doctorName = generateRandomName(generateRandomNumber(3,10)); // Utilisation de Randomizer pour générer un nom
            Doctor newDoctor = new Doctor(doctorName, generateRandomBoolean(), generateRandomNumber(20,60)); // Exemple : âge entre 30 et 40 ans
            addDoctor(newDoctor);
            //System.out.println("Docteur ajouté : " + newDoctor.getName());
        }

        //System.out.println(numDoctors + " docteurs ont été ajoutés à l'hôpital.");
    }




    public boolean cured(CreatureSickness creatureSickness) {
        if(isOneDoctorAvailable()){
            getFirstAvailableDoctor().heal(creatureSickness);
        }
        return false;
    }

    private Doctor getFirstAvailableDoctor() {
        for (Map.Entry<Doctor, Boolean> entry : doctorsAvailability.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
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

    public void addToMedicalServices(CreatureSickness creatureSickness) {
        switch (creatureSickness.getCreature().getRace().getRaceName()) {
            case "Elf":
                medicalServiceElf.addPatient((ElfSickness)creatureSickness);
                break;
            case "Dwarf":
                medicalServiceDwarf.addPatient((DwarfSickness)creatureSickness);
                break;
            case "Reptilian":
                medicalServiceReptilian.addPatient((ReptilianSickness)creatureSickness);
                break;
            case "Zombie":
                medicalServiceZombie.addPatient((ZombieSickness)creatureSickness);
                break;
            case "Beastman":
                medicalServiceBeastman.addPatient((BeastmanSicknessContaminator)creatureSickness);
                break;
            case "Lycanthrope":
                medicalServiceLycanthrope.addPatient((LycanthropeSicknessContaminator)creatureSickness);
                break;
            case "Orc":
                medicalServiceOrc.addPatient((OrcSicknessContaminator)creatureSickness);
                break;
            case "Vampire":
                medicalServiceVampire.addPatient((VampireSiknessContaminator)creatureSickness);
                break;
            default:
                System.out.println("Race non reconnue");
                break;
        }
    }
    /*
    static List<C>  moveDead(MedicalService medicalService){
        return  medicalService.removeAndReturnDeceasedPatients();
    }
*/
    boolean moveDeadZombieToVampire() {
        HashSet<ZombieSickness> dead = medicalServiceZombie.removeDeads();
        if(!dead.isEmpty())
            cryptSZombie.addPatient(dead);
        return false;
    }
    boolean moveDeadZombieToZombie() {
        HashSet<ZombieSickness> dead = medicalServiceZombie.removeDeads();
        if(!dead.isEmpty())
            cryptSZombie.addPatient(dead);
        return false;
    }

}
