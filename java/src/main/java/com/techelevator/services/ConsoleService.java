package com.techelevator.services;

import java.util.List;
import java.util.Scanner;

import com.techelevator.model.Pokemon;
import org.springframework.security.core.parameters.P;

public class ConsoleService {

        private final Scanner scanner = new Scanner(System.in);

        public int promptForMenuSelection() {
            int menuSelection;
            System.out.print("Please choose an option: ");
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                menuSelection = -1;
            }
            return menuSelection;
        }

        public void printMainMenu(List<Pokemon> list) {
            System.out.println();
            System.out.println("----Pokemon Compatibility Checker----");
            if (list.size() == 0){
            System.out.println("1: Add first pokemon");}
            else {
                System.out.println("1: Add second pokemon");}
            System.out.println("0: Exit");
            System.out.println();
        }


        public String promptForPokeTitle() {
            System.out.println("--------------------------------------------");
            System.out.print("Enter a pokemon's name (lowercase): ");
            return scanner.nextLine();
        }

        public void printPoke(Pokemon pokemon) {
            System.out.println("--------------------------------------------");
            System.out.println("Pokemon Details");
            System.out.println("--------------------------------------------");
            if (pokemon == null) {
                System.out.println("No pokemon to see!");
            } else {
                System.out.println("Id: " + pokemon.getId());
                System.out.println("Name: " + pokemon.getName());
              //  System.out.println(pokemon.getGeneration());
                pokemon.printEggGroups();
            }
        }

    }


