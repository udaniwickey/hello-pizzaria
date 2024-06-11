import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            homeViewScreen();
            String selectHomeViewOption = scanner.nextLine();

            switch (selectHomeViewOption) {
                case "1": {
                    menuViewScreen(scanner);
                }
                case "2": {
                    orderViewScreen(scanner);
                }
                case "x": {
                    exit=true;
                    System.out.println("Thank you for visiting Pizza Hut, See you next time");
                    break;
                }
                default: {
                    errorHomeViewScreen();
                }
            }
            scanner.close();
        }
    }

    private static void errorHomeViewScreen() {
        System.out.println("Please enter valid option from below");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]");
    }

    private static void orderViewScreen(Scanner scanner) {
    }

    private static void homeViewScreen() {
        System.out.println("Welcome to PizzaHut!");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]");
        System.out.println("Press [x] to exit the store");

    }

    private static void menuViewScreen(Scanner scanner) {
        boolean navigateToHomeViewScreen = false;

        while (!navigateToHomeViewScreen){
            menuItems();
            String menu_choice = scanner.nextLine();

            switch(menu_choice) {
                case "0": {
                    navigateToHomeViewScreen = true;
                }
                case "1": {
                    System.out.println("name: BBQ Chicken Pizza\n" +
                            "price: 1299.0\n" +
                    "description: BBQ Chicken brest, Mozzarella Cheese, Bell Pepper\n");
                    break;
                }
                case "2": {
                    System.out.println("name: Devil Chicken Pizza\n" +
                                    "price: 1499.0\n" +
                                    "description: Devil Chicken brest, Mozzarella Cheese, Bell Pepper\n");
                }
                case "3": {
                    System.out.println("name: Vegi Pizza\n" +
                            "price: 999.0\n" +
                            "description: Carrot & onions, Mozzarella Cheese, Bell Pepper\n");
                }
                case "4": {
                    System.out.println("name: Pork Pizza\n" +
                            "price: 1999.0\n" +
                            "description: BBQ Pork, Mozzarella Cheese, Bell Pepper\n");
                }
                default:
                    errorMenuViewScreen();
            }
        }
    }

    private static void errorMenuViewScreen() {
        System.out.println("Please enter a valid input");
        menuItems();
    }

    private static void menuItems(){
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
    }


}

