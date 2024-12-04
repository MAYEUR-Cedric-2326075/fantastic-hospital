package fantasticHospital;

import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.Hospital;
import fantasticHospital.Hospital.MedicalService.MedicalService;

import java.util.Scanner;


import static fantasticHospital.Disease.TypeOfPatient.CreatureSickness.randomDisease;


public class Main {

    static String ANSI_RESET = "\u001B[0m";
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int choiceTerminal(String[] choices) {
        //affiche tout les choix du tableau passer en paramètre
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i+1 + ") " + choices[i]);
        }
        //lit la valeur entrée dans le terminal
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        //vérifie si la valeur entrée par l'utilisateur est un des choix proposer
        if(answer < 1 || answer > choices.length) {
            //si le choix n'est pas valide alors faire ici
            //System.out.println("erreur");
        }
        return answer;
    }

    public static void main(String[] args) {

        mainLoop();

    }

    public static void mainLoop() {
        //début de partie
        Hospital hospital = new Hospital("hospital1", 100, 100);// création d'un hopital
        //générer 1 créature malade en début de partie
        CreatureSickness creature1 = hospital.generateRandomCreature();
        creature1.addDiseaseCurrentLevel(randomDisease());
        hospital.addToMedicalServices(creature1);

        //variables de jeux
        int turn = 0;
        int totalDeaths = 0;
        int currentActionPoints = 50;

        // la partie est en cours
        while (totalDeaths < 10) {
            ++turn;
            //création de 1 créature malade
            CreatureSickness creatureX = hospital.generateRandomCreature();
            creatureX.addDiseaseCurrentLevel(randomDisease());
            hospital.addToMedicalServices(creatureX);

            //début d'un tour
            clearScreen();
            System.out.println("\u001B[32m\n--- Tour " + turn + " ---" + ANSI_RESET);
            //afficher nb de point action
            System.out.println("nb de point : " + currentActionPoints);
            //Affiche le menu pour jouer en proposant les action du joueur
            actionMenu(hospital);

            //Fin du tour
            //Contamination des créatures + évolution des maladies
            hospital.waiting();
        }
        // fin de partie
        System.out.println("Fin de partie, vous avez survécu " + turn + "tour.");
    }

    public static void actionMenu(Hospital hospital) {
        boolean currentRound= true;
        while (currentRound){
            System.out.println("\u001B[35m\n** Menu d'hopital **" + ANSI_RESET);
            String[] choices = {"Afficher les services medicaux", "Choisir un service medical", "Déplacer mort à la crypte", "Fin du tour"};
            int choice = choiceTerminal(choices);
            switch (choice) {
                case 1:
                    //afficher tout les services medicaux
                    showMedicalServices(hospital);
                    break;
                case 2:
                    //affiche en detail 1 service medical
                    System.out.println("Entrer le service medical choisi : ");
                    Scanner scanner = new Scanner(System.in); //le joueur choisi le service
                    int answer = scanner.nextInt();

                    MedicalService choiceService = null;
                    switch (answer) {
                        case 1:
                            choiceService = hospital.getMedicalServiceElf();
                            break;
                        case 2:
                            choiceService = hospital.getMedicalServiceDwarf();
                            break;
                        case 3:
                            choiceService = hospital.getMedicalServiceOrc();
                            break;
                        case 4:
                            choiceService = hospital.getMedicalServiceBeastman();
                            break;
                        case 5:
                            choiceService = hospital.getMedicalServiceZombie();
                            break;
                        case 6:
                            choiceService = hospital.getMedicalServiceVampire();
                            break;
                        case 7:
                            choiceService = hospital.getMedicalServiceLycanthrope();
                            break;
                        case 8:
                            choiceService = hospital.getMedicalServiceReptilian();
                            break;
                        default:
                            System.out.println("Service medical non existant");
                            break;
                    }
                    //afficher le service choisi
                    System.out.println("Nom du service : " + choiceService.getName());//nom du service choisi
                    System.out.println("Budget du service : " + choiceService.getBudgetCategory());
                    //affiche tout les patient du service choisi
                    for (Object creature : choiceService.getPatients()) {
                        System.out.println(creature.toString());
                    }

                    //demande au joueur ce qu'il veux faire dans ce service
                    System.out.println("\u001B[34m\n** Menu d'action joueur **" + ANSI_RESET);
                    String[] choices2 = {"soigner une créature", "réviser le budget", "Ne rien faire"};
                    int choice2 = choiceTerminal(choices2);
                    switch (choice2) {
                        case 1:
                            //soigner une créature
                            System.out.println("Entrer la créature a soigner : ");
                            for (int i=0; i<choiceService.getPatients().size();i++) {
                                System.out.println(i + ")" + choiceService.getPatients().get(i));
                            }
                            int creatureToHeal = scanner.nextInt();
                            //tente de soigner la créature
                            if (choiceService.isEmpty()){
                                break;
                            }
                            if (hospital.cured((CreatureSickness) choiceService.getPatients().get(creatureToHeal))) { //bool on a résussi a soigner la créature
                                System.out.println("La créature à été soigner");
                            }else {
                                System.out.println("La créature n'a pas pu être soigner");
                            }
                            break;
                        case 2:
                            //réviser budget
                            System.out.println("Entrer le nouveau budget en chiffre : ");
                            answer = scanner.nextInt();
                            choiceService.setBudget(answer);
                            break;
                        case 3:
                            //ne rien faire
                            break;
                        default:
                            System.out.println("Ce choix n'est pas valide !, choisir autre chose\n");
                            break;
                    }
                    break;
                case 3:
                    String[] choices3 = {"Déplacer les zombie mort a la crypte", "Déplacer les vampires à la crypte", "Ne rien faire"};
                    int choice3 = choiceTerminal(choices3);
                    switch (choice3) {
                        case 1:
                            //deplacer zombies
                            if (hospital.moveDeadZombieToCrypt()){
                                System.out.println("Tout les zombies ont été déplacer dans la crypte");
                            }else {
                                System.out.println("Aucun zombie à déplacer dans la crypte");
                            }
                            break;
                        case 2:
                            //deplacer vampires
                            if (hospital.moveDeadVampireToCrypt()){
                                System.out.println("Tout les vampires ont été déplacer dans la crypte");
                            }else {
                                System.out.println("Aucun vampire à déplacer dans la crypte");
                            }
                            break;
                        case 3:
                            //ne rien faire
                            break;
                    }
                    break;
                case 4:
                    currentRound=false;
                    break;
                default:
                    System.out.println("Ce choix n'est pas valide !, choisir autre chose\n");
                    break;
            }
        }
    }

    public static void showMedicalServices(Hospital hospital) {
        //affiche les services medical
            System.out.println("1) " + hospital.getMedicalServiceElf().getName() + " | nb de patient = " + hospital.getMedicalServiceElf().getNumberOfPatientNow());
            System.out.println("2) " + hospital.getMedicalServiceDwarf().getName() + " | nb de patient = " + hospital.getMedicalServiceDwarf().getNumberOfPatientNow());
            System.out.println("3) " + hospital.getMedicalServiceOrc().getName() + " | nb de patient = " + hospital.getMedicalServiceOrc().getNumberOfPatientNow());
            System.out.println("4) " + hospital.getMedicalServiceBeastman().getName() + " | nb de patient = " + hospital.getMedicalServiceBeastman().getNumberOfPatientNow());
            System.out.println("5) " + hospital.getMedicalServiceZombie().getName() + " | nb de patient = " + hospital.getMedicalServiceZombie().getNumberOfPatientNow());
            System.out.println("6) " + hospital.getMedicalServiceVampire().getName() + " | nb de patient = " + hospital.getMedicalServiceVampire().getNumberOfPatientNow());
            System.out.println("7) " + hospital.getMedicalServiceLycanthrope().getName() + " | nb de patient = " + hospital.getMedicalServiceLycanthrope().getNumberOfPatientNow());
            System.out.println("8) " + hospital.getMedicalServiceReptilian().getName() + " | nb de patient = " + hospital.getMedicalServiceReptilian().getNumberOfPatientNow());
    }
}