import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        System.out.println("Welcome to PizzaHut!");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]");
        System.out.println("Press [x] to exit the store");
        String HomeViewScreen = scanner.nextLine();

        switch (HomeViewScreen) {
            case "1" -> {
                menuViewScreen(scanner);
            }
            case "x" -> exit=true;
            default -> System.out.println("Please enter valid option from bellow\n" +
                    "To View our menu, press [1]\n" +
                    "To place an Order, press [2]");
        }
        scanner.close();
    }

    private static void menuViewScreen(Scanner scanner) {
        boolean previousMenuOption = false;

        String MenuViewScreen = scanner.nextLine();

        System.out.println("PizzaHut Menu");
        System.out.println("""
                        #1 BBQ Chicken Pizza - 1299.00 LKR
                        #2 Devil Chicken Pizza - 1499.00 LKR
                        #3 Vegi Pizza - 999.00 LKR
                        #4 Pork Pizza - 1999.00 LKR""");
        System.out.println("""
                        Press item number to view description
                        OR
                        Press [0] to go back""");

        switch (MenuViewScreen) {
            case "0" -> {
                previousMenuOption = true;
            }
            case "1" -> {
                System.out.println("Name        : BBQ Chicken Pizza\n" +
                        "Description : BBQ Chicken brest, Mozzarella Cheese, Bell Pepper\n" +
                        "Price       : 1299.00 LKR");
            }
        }


    }
}

