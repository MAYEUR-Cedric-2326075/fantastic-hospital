package fantasticHospital.Hospital.MedicalService;

import fantasticHospital.Creature.Creature;
import fantasticHospital.Creature.Races.*;
import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import com.fantasticHospital.Doctor;
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
    private List<Doctor> doctors;
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
        this.doctors = new ArrayList<>();
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
    public List<Doctor> getDoctors() {
        return doctors;
    }


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


/*
    // Affichage des créatures et de leurs maladies
    public void displayCreatures(List<CreatureSickness> creatureSicknesses) {
        int totalCreatures = 0;

        if (medicalServices.isEmpty()) {
            System.out.println("Il n'y a pas de services médicaux.");
            return;
        }

        for (MedicalService service : medicalServices) {
            System.out.println("Service médical : " + service.getName());

            if (service.isEmpty()) {
                System.out.println("  Il n'y a pas de créatures.");
            } else {
                for (Creature creature : service.getPatients().toArray()) {
                    ++totalCreatures;
                    System.out.println("  " + creature.getName() + " (" + creature.getRace() + ")");

                    CreatureSickness sickness = getCreatureSickness(creature, creatureSicknesses);
                    if (sickness == null || sickness.getDisease().isEmpty()) {
                        System.out.println("    Pas de maladie.");
                    } else {
                        for (Disease disease : sickness.getDisease()) {
                            int level = sickness.getCurrentLevel(disease);
                            System.out.println("    Maladie : " + disease.getName() + " (" + disease.getShortName() + ")"
                                    + " - Phase : " + level + " / " + disease.getMaxLevel());
                        }
                    }
                }
            }
        }

        System.out.println("Nombre total de créatures dans l'hôpital : " + totalCreatures);
        if (totalCreatures > maxPatients) {
            System.out.println("L'hôpital a atteint sa capacité maximale de créatures.");
        } else {
            System.out.println("L'hôpital peut encore accueillir " + (maxPatients - totalCreatures) + " créatures.");
        }
    }*/


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

/*
    // Modification du moral des créatures
    public void updateMorality(MedicalService service) {

        for (Creature creature : service.getPatients().toArray()) {

            if (!creature.isAlive()) {

                // Si la créature est morte et c'est un Elf ou un Vampire, abaisser le moral des autres créatures
                if (creature.getRace().getRaceName().equals("Elf") || creature.getRace().getRaceName().equals("Vampire")) {

                    // Abaisser le moral de toutes les créatures vivantes dans le service
                    for (Creature otherCreature : service.getPresentCreature()) {

                        if (otherCreature.isAlive()) {

                            if (otherCreature.getRace().getRaceName().equals("Elf")) {
                                Elf otherElf = (Elf) otherCreature;
                                Set<Creature> creatureSet = new HashSet<>(service.getPresentCreature());
                                otherElf.demoralize(creatureSet);

                            } else if (otherCreature.getRace().getRaceName().equals("Vampire")) {
                                Vampire otherVampire = (Vampire) otherCreature;
                                Set<Creature> creatureSet = new HashSet<>(service.getPresentCreature());
                                otherVampire.demoralize(creatureSet);
                            }
                        }
                    }
                }
                deadCreatures.add(creature);
            }
            else {
                //perte de patience des vip
                if (creature.getRace().isVip()) {

                    VipRace vipRace = (VipRace) creature.getRace();
                    int rateOfReduction = vipRace.getRateOfReduction();
                    creature.setMoralityRate(creature.getMoralityRate() - rateOfReduction);

                } else{
                    PoorRace poorRace = (PoorRace) creature.getRace();
                    int rateOfReduction;

                    // Si la créature est avec d'autres membres de sa race
                    boolean isWithOtherPoor = false;
                    for (Creature otherCreature : service.getPresentCreature()) {
                        if (otherCreature != creature && otherCreature.getRace().getRaceName().equals(creature.getRace().getRaceName())) {
                            isWithOtherPoor = true;
                            break;
                        }
                    }

                    // Choisir le taux de réduction en fonction de la présence d'autres membres de la race
                    if (isWithOtherPoor) {
                        rateOfReduction = poorRace.getRateOfReductionWithPeaple();
                    } else {
                        rateOfReduction = poorRace.getRateOfReductionWithoutPeaple();
                    }

                    creature.setMoralityRate(creature.getMoralityRate() - rateOfReduction);
                }

            }
        }
        service.getPresentCreature().removeAll(deadCreatures);
    }*/

    //Générer une créature aléatoire
    private Creature generateRandomCreature() {
        Random rand = new Random();

        String name = "Creature_" + rand.nextInt(100);
        boolean gender = rand.nextBoolean();
        double weight = 50 + rand.nextDouble() * 50;
        double height = 1.5 + rand.nextDouble() * 0.5;
        int age = 1 + rand.nextInt(100);

        // Génération aléatoire d'une race parmi 8 possibles
        int raceChoice = rand.nextInt(8); // 8 races
        switch (raceChoice) {
            case 0:
                return new Beastman(name, gender, weight, height, age);
            case 1:
                return new Dwarf(name, gender, weight, height, age);
            case 2:
                return new Elf(name, gender, weight, height, age);
            case 3:
                return new Lycanthrope(name, gender, weight, height, age);
            case 4:
                return new Orc(name, gender, weight, height, age);
            case 5:
                return new Reptilian(name, gender, weight, height, age);
            case 6:
                return new Vampire(name, gender, weight, height, age);
            case 7:
                return new Zombie(name, gender, weight, height, age);
            default:
                throw new IllegalStateException("Mauvaise race : " + raceChoice);
        }
    }

/*
    // Ajout de nouvelles créatures
    public void addNewCreature() {
        Random rand = new Random(); // Déclarez l'objet Random
        int newCreatures = rand.nextInt(3); // Génère entre 0 et 2 nouvelles créatures
        for (int i = 0; i < newCreatures; ++i) {
            // Génère une nouvelle créature
            Creature newCreature = generateRandomCreature();

            // Sélectionne un service médical aléatoire s'il y en a
            if (!medicalServices.isEmpty()) {
                MedicalService randomService = medicalServices.get(rand.nextInt(medicalServices.size()));
                randomService.getPresentCreature().add(newCreature); // Ajoute la créature au service
            }

            switch (newCreature.getRace().getRaceName()) {
                case "Elf":
                    creatureSicknesses.add(new CreatureSickness((Elf) newCreature));
                    break;
                case "Dwarf":
                    creatureSicknesses.add(new CreatureSickness((Dwarf) newCreature));
                    break;
                case "Reptilian":
                    creatureSicknesses.add(new CreatureSickness((Reptilian) newCreature));
                    break;
                case "Zombie":
                    creatureSicknesses.add(new CreatureSickness((Zombie) newCreature));
                    break;
                case "Beastman":
                    creatureSicknesses.add(new CreatureSicknessContaminator((Beastman) newCreature));
                    break;
                case "Lycanthrope":
                    creatureSicknesses.add(new CreatureSicknessContaminator((Lycanthrope) newCreature));
                    break;
                case "Orc":
                    creatureSicknesses.add(new CreatureSicknessContaminator((Orc) newCreature));
                    break;
                case "Vampire":
                    creatureSicknesses.add(new CreatureSicknessContaminator((Vampire) newCreature));
                    break;
                default:
                    System.out.println("Race non reconnue : " + newCreature.getRace());
                    break;
            }
        }
    }


    // Ajouter une créature à un service médical
    public void addCreatureToService(Creature creature, MedicalService service) {
        if (!medicalServices.contains(service)) {
            System.out.println("Service médical non trouvé.");
            return;
        }
        service.getPresentCreature().add(creature);
    }


    // Retirer une créature d'un service médical
    public void removeCreatureFromService(Creature creature, MedicalService service) {
        if (service.getPresentCreature().contains(creature)) {
            service.getPresentCreature().remove(creature);
        } else {
            System.out.println("La créature n'est pas présente dans ce service médical.");
        }
    }


    public void manageDiseaseProgression(CreatureSickness sickness) {
        Disease disease = sickness.getDisease().get(0); // On suppose qu'il n'y a qu'une maladie par créature pour simplifier.
        int currentLevel = sickness.getCurrentLevel(disease);
        if (currentLevel < disease.getMaxLevel()) {
            sickness.incrementDiseaseLevel(disease);
        } else {
            // La créature meurt
            deadCreatures.add(sickness.getCreature());
            System.out.println(sickness.getCreature().getName() + " est morte de la maladie.");
        }
    }


    // Ajouter une maladie à une créature
    public void addDiseaseToCreature(Creature creature, Disease disease) {
        CreatureSickness sickness = getCreatureSickness(creature, creatureSicknesses);
        if (sickness == null) {
            sickness = new CreatureSickness(creature);
            creatureSicknesses.add(sickness);
        }
        sickness.addDisease(disease);
    }


    // Propager une maladie à d'autres créatures dans un service
    public void propagateDiseaseToOtherCreatures(MedicalService service, Disease disease) {
        for (CreatureSickness sickness : creatureSicknesses) {
            if (service.getPresentCreature().contains(sickness.getCreature()) && !sickness.getDisease().contains(disease)) {
                sickness.addDisease(disease);
            }
        }
    }


    // Guérir une créature
    public void healCreature(Creature creature) {
        CreatureSickness sickness = getCreatureSickness(creature, creatureSicknesses);
        if (sickness != null) {
            sickness.removeDisease(sickness.getDisease().get(0)); // Supposons qu'une seule maladie par créature pour simplifier
            System.out.println(creature.getName() + " a été guérie.");
        }
    }*/


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
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
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


    // Exécuter une action choisie par le joueur
    public void executePlayerAction(String actionChoice) {
        // Implémentation de l'exécution des actions en fonction de l'entrée de l'utilisateur.
        // Par exemple : Ajouter une créature, ajouter une créature à un service, etc.
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
        return medicalServices;
    }


/*    public void playerAction() {
        for (MedicalService service : medicalServices) {
            currentActionPoints = maxActionPoints;


            while(currentActionPoints != 0) {
                Scanner choice = new Scanner(System.in);
                System.out.println("définition du jeu par exemple appuyez sur 1 pour x ou 2 pour y");
                String finalChoice = choice.nextLine();
                switch (finalChoice) {
                    case "1":
                        //a;
                        break;
                    case "2":
                        //a;
                        break;
                    case "3":
                        //a;
                        break;
                    case "4":
                        //a;
                        break;
                    case "5":
                        //a
                        break;
                }
            }
            for (Doctor doctor : service.getDoctors()) {
                doctor.passTurn();
                //---à finir, actions que le joueur peut faire
            }
        }
    }
*/

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
