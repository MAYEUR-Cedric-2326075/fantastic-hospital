package fantasticHospital;

import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.Hospital;
import fantasticHospital.Hospital.MedicalService.MedicalService;

import java.util.Random;
import java.util.Scanner;

import static fantasticHospital.Disease.TypeOfPatient.CreatureSickness.randomDisease;


public class Main {

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
        //String[] choices = {"Choix 1", "Choix 2", "Choix 3"};
        //int test = choiceTerminal(choices);
        //System.out.println("le choix utilisateur est : " + test);

        mainLoop();

    }

    public static void actionMenu(Hospital hospital) {
        boolean currentRound= true;
        String[] choices = {"Afficher les services medicaux", "Choisir un service medical", "Fin du tour"};
        while (currentRound){
            int choice = choiceTerminal(choices);
            switch (choice) {
                case 1:
                    //afficher tout les services medicaux
                    showMedicalServices(hospital);
                    System.out.println();
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
                    }
                    //afficher le service choisi
                    System.out.println("nom : " + choiceService.getName());//nom du service choisi
                    //affiche tout les patient du service choisi
                    for (Object creature : choiceService.getPatients()) {
                        System.out.println(creature.toString());
                    }

                    //demande au joueur ce qu'il veux faire dans ce service
                    String[] choices2 = {"soigner une créature", "réviser le budget", "Ne rien faire"};
                    int choice2 = choiceTerminal(choices);
                    switch (choice2) {
                        case 1:
                            //soigner une créature
                            System.out.println("Entrer la créature a soigner : ");
                            System.out.println("Entrer la créature a soigner : ");
                            System.out.println("Entrer la créature a soigner : ");

                            break;
                        case 2:
                            //réviser budget
                            System.out.println("Entrer le nouveau budget : ");
                            choiceService.setBudget("");
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
                    currentRound=false;
                    break;
                default:
                    System.out.println("Ce choix n'est pas valide !, choisir autre chose\n");
                    break;
            }
        }
    }

    public static void displayFinalScore(int score){
        System.out.println("Fin de partie, vous avez survécu " + score + "tour.");
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



    public static void mainLoop() {
        //début de partie
        Hospital hospital = new Hospital("hospital1", 100, 100);

        //générer 2 créature malade
        CreatureSickness creature1 = hospital.generateRandomCreature();
        creature1.addDiseaseCurrentLevel(randomDisease());
        hospital.addToMedicalServices(creature1);

        Random rand = new Random();
        int turn = 0;
        int totalDeaths = 0;
        int currentActionPoints = 50;

        // la partie est en cours
        while (totalDeaths < 10) {
            ++turn;
            //création de 2 créature avec 1 ou 2 maladie
            CreatureSickness creatureX = hospital.generateRandomCreature();
            creatureX.addDiseaseCurrentLevel(randomDisease());
            hospital.addToMedicalServices(creatureX);

            System.out.println("\n--- Tour " + turn + " ---");

            //afficher menue action
            System.out.println("nb de point : " + currentActionPoints);
            //Affiche le menu pour jouer en proposant les action du joueur
            actionMenu(hospital);

            //Fin du tour
            hospital.waiting();
            //Contamination des créatures + évolution des maladies + nouvelle creature

        }

        // fin de partie
        displayFinalScore(turn);
    }
}