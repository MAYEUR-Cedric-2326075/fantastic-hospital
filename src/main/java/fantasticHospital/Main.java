package fantasticHospital;

import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.MedicalService.MedicalService.Hospital;
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
                    MedicalService choiceService = hospital.getMedicalServices().get(answer-1);
                    //afficher le service choisi
                    System.out.println("nom : " + choiceService.getName());//nom du service choisi
                    //affiche tout les patient du service choisi
                    for (Object creature : choiceService.getPatients()) {
                        System.out.println(creature.toString());
                    }

                    //demande au joueur ce qu'il veux faire dans ce service
                    String[] choices2 = {"soigner une créature", "réviser le budget", ""};
                    int choice2 = choiceTerminal(choices);
                    switch (choice2) {
                        case 1:
                            //soigner une créature
                            System.out.println("Entrer la créature a soigner : ");

                            break;
                        case 2:
                            //réviser budget
                            break;
                        case 3:

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
        for (int i = 0; i < hospital.getMedicalServices().size(); i++) {
            System.out.println(i+1 + ") " + hospital.getMedicalServices().get(i).getName() + " | nb de patient = " + hospital.getMedicalServices().get(i).getNumberOfPatientNow());
        }
    }



    public static void mainLoop() {
        //début de partie
        Hospital hospital = new Hospital("hospital1", 8, 100, 100);

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
            //Contamination des créatures + évolution des maladies + nouvelle creature

        }

        // fin de partie
        displayFinalScore(turn);
    }
}