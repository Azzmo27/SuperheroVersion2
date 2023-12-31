package org.example;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Database database = new Database();
    Controller controller = new Controller(database);
    Scanner scanner = new Scanner(System.in);

    public void StartProgram() {
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println("Menu ");
            System.out.println("1. Create superhero");
            System.out.println("2. Show superhero");
            System.out.println("3. Show a list of all the superheroes");
            System.out.println("4. Search after a superhero");
            System.out.println("5. Show all superheroes sorted");
            System.out.println("6. Edit superhero");
            System.out.println("7. Delete superhero");
            System.out.println("8. Exit the program");
            try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            String superheroName = null;
            switch (choice) {

                case 1 -> {
                    System.out.println("Write the government name: ");
                    String realName = scanner.nextLine();
                    System.out.println("Write your superhero name: ");
                    superheroName= scanner.nextLine();
                    System.out.println("Write your superpower: ");
                    String superpower = scanner.nextLine();
                    System.out.println("Write the year of creation: ");
                    int yearCreated = scanner.nextInt();
                    scanner.nextLine();
                    boolean isHuman;
                    do {
                        System.out.print("Is the superhero a human? (true/false): ");
                        if (scanner.hasNextBoolean()) {
                            isHuman = scanner.nextBoolean();
                            break;
                        } else {
                            System.out.println("You must either write true or false.");
                            scanner.nextLine();
                        }
                    } while (true);
                    System.out.println("How strong is your superhero? ");
                    int strength = scanner.nextInt();
                    scanner.nextLine();
                    controller.addSuperhero(realName,superheroName, superpower, yearCreated, isHuman, strength);
                    System.out.println("The superhero is added to the database.");
                    System.out.println();
                }
                case 2 -> controller.viewAsuperhero();
                case 3 -> controller.showSuperheroes();
                case 4 -> controller.searchSuperhero();
                case 5 -> {
                    System.out.println("Menu: please choose one of the options: ");
                    System.out.println("1.Sorted by government name");
                    System.out.println("2.Sorted by superhero name");
                    System.out.println("3.Sorted by superpowers");
                    System.out.println("4.Sorted by year created");
                    System.out.println("5.Sorted if superhero is human or not");
                    System.out.println("6.Sorted by strength");
                    controller.SortedOptions();
                }
                case 6 -> controller.editSuperhero();
                case 7 -> {
                    System.out.println("Write the name of the superhero that you would like to delete");
                    controller.showSuperhero();
                    String superName = scanner.nextLine();
                    controller.removeSuperhero(superName);
                }
                case 8 -> {
                    System.out.println("Goodbye!");
                    exitProgram = true;
                }
                default -> System.out.println("Invalid answer, please try again...");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Type in a valid answer.");
            scanner.nextLine();
        } catch (DateTimeParseException e) {
            System.out.println("Error: wrong date format. Use only YYYY.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("An error has been made: " + e.getMessage());
            scanner.nextLine();
        }


    }
}
}






