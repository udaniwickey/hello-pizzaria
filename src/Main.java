import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ItemData> currentDataItems= new ArrayList<>();
    static ArrayList<ItemData> finalBillItems= new ArrayList<>();

    public static void main(String[] args) {

        ItemData chickenPizza = new ItemData();
        chickenPizza.setName("BBQ Chicken Pizza");
        chickenPizza.setPrice(1299.00F);

        ItemData devilChickenPizza = new ItemData();
        devilChickenPizza.setName("Devil Chicken Pizza");
        devilChickenPizza.setPrice(1499.00F);

        ItemData vegiPizza = new ItemData();
        vegiPizza.setName("Vegi Pizza");
        vegiPizza.setPrice(999.00F);

        ItemData porkPizza = new ItemData();
        porkPizza.setName("Pork Pizza");
        porkPizza.setPrice(1999.00F);

        currentDataItems.add(chickenPizza);
        currentDataItems.add(devilChickenPizza);
        currentDataItems.add(vegiPizza);
        currentDataItems.add(porkPizza);

        homeViewScreen();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String menu_choice = scanner.nextLine();

            switch (menu_choice) {
                case "0": homeViewScreen();
                    break;
                case "1":
                    int result = menuViewScreen(scanner);

                    if(result == 0){
                        homeViewScreen();
                        break;
                    } else if (result == 1) {
                        scanner.nextLine();
                        menuViewScreen(scanner);
                        break;
                    }
                case "x": programExit();
                    System.exit(0);
                case "2":
                    placeOrder();
                    break;
                default: invalidInput();
            }
        }
    }

    private static void invalidInput() {
        System.out.println("Please enter valid option from bellow\n" +
                "To View our menu, press [1]\n" +
                "To place an Order, press [2]\n");
    }

    private static void placeOrder() {
        justViewOrder();
    }

    private static void selectTheItems(ItemData itemData) {
        ArrayList<ItemData> pizzas = new ArrayList<ItemData>();
    }

    private static void homeViewScreen() {
        System.out.println("Welcome to PizzaHut!");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]");
        System.out.println("Press [x] to exit the store");
    }

    private static int menuViewScreen(Scanner scanner) {
            menuItems();
            String menu_choice = scanner.nextLine();

            switch(menu_choice) {
                case "0": {
                    return 0;
                }
                case "1": {
                    System.out.println("name: BBQ Chicken Pizza\n" +
                            "price: 1299.0\n" +
                    "description: BBQ Chicken brest, Mozzarella Cheese, Bell Pepper\nPress any to go back");
                    return 1;
                }
                case "2": {
                    System.out.println("name: Devil Chicken Pizza\n" +
                                    "price: 1499.0\n" +
                                    "description: Devil Chicken brest, Mozzarella Cheese, Bell Pepper\nPress any to go back");
                    return 1;
                }
                case "3": {
                    System.out.println("name: Vegi Pizza\n" +
                            "price: 999.0\n" +
                            "description: Carrot & onions, Mozzarella Cheese, Bell Pepper\nPress any to go back");
                    return 1;
                }
                case "4": {
                    System.out.println("name: Pork Pizza\n" +
                            "price: 1999.0\n" +
                            "description: BBQ Pork, Mozzarella Cheese, Bell Pepper\nPress any to go back");
                    return 1;
                }
            }
            return 1;
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

    private static void justViewOrder(){
        System.out.println("\nYou can buy 3 items.\n" +
                "Please select first item you want to buy.\n" +
                "\n" +
                "#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR\n" +
                "\n" +
                "Press item number to select first item\n" +
                "OR\n" +
                "Press [0] to go back to Main menu");
    }

    private static void programExit() {
        System.out.println("Thank you for visiting Pizza Hut, See you next time");
    }


}

