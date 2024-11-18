package com.fantasticHospital;

import java.util.Scanner;


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
            System.out.println("erreur");
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] choices = {"Choix 1", "Choix 2", "Choix 3"};
        int test = choiceTerminal(choices);
        System.out.println("le choix utilisateur est : " + test);

    }
}