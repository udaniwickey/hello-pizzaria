import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String[] name = {"BBQ Chicken Pizza", "Devil Chicken Pizza", "Vegi Pizza", "Pork Pizza"};
    static float[] price = {1299.00f, 1499.00f, 999.00f, 1999.00f};
    static String[] description = {"BBQ Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Devil Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Carrot & onions, Mozzarella Cheese, Bell Pepper",
            "BBQ Pork, Mozzarella Cheese, Bell Pepper"};


    public static void main(String[] args) {
        homeView();
        Scanner scan = new Scanner(System.in);

        while(true){
            String chooseTheMenuInput = scan.nextLine();
            switch(chooseTheMenuInput){
                case "1": mainMenuView();
                break;
                case "2": makeOrderScreen();
                break;
                case "x":
                    System.exit(exitTheProgram());
                default: invalidInput();
            }
        }
    }

    private static void homeView() {
        System.out.println("Welcome to PizzaHut!\n" +
                "To View our menu, press [1]\n" +
                "To place an Order, press [2]\n" +
                "Press [x] to exit the store");
    }
    private static int exitTheProgram() {
        System.out.println("Thank you for visiting Pizza Hut, See you next time");
        return 0;
    }
    private static void invalidInput() {
        System.out.println("Please enter valid option from bellow\n" + "To View our menu, press [1]\n" + "To place an Order, press [2]");
    }

    private static void mainMenuView() {
        boolean insideMenu = true;
        justViewMenu();
        Scanner scan = new Scanner(System.in);

        while(insideMenu){
            String chooseThePizzaMenuInput = scan.nextLine();
            switch(chooseThePizzaMenuInput) {
                case "1":
                    printSubMenuItemData1();
                    break;
                case "2":
                    printSubMenuItemData2();
                    break;
                case "3":
                    printSubMenuItemData3();
                    break;
                case "4":
                    printSubMenuItemData4();
                    break;
                case "0":
                    homeView();
                    return;
                default:
                    backToPizzaMenu();
                    break;
            }
            scan.nextLine();
            justViewMenu();
        }
    }

    private static void justViewMenu() {
        System.out.println("PizzaHut Menu\n" +
                "\n" +
                "#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR\n" +
                "\n" +
                "Press item number to view description\n" +
                "OR\n" +
                "Press [0] to go back");
    }

    private static void backToPizzaMenu() {
        System.out.println("Please enter a valid input\n" +
                "PizzaHut Menu\n" +
                "\n" +
                "#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR\n" +
                "\n" +
                "Press item number to view description\n" +
                "OR\n" +
                "Press [0] to go back");
    }

    private static void printSubMenuItemData1() {

        DecimalFormat df = new DecimalFormat("#.00");
        String priceFormatted = String.valueOf(Float.valueOf(df.format(price[0])));

        System.out.println("Name        :" + " " + name[0]);
        System.out.println("Description :" + " " + description[0]);
        System.out.println("Price       :"+ " " + priceFormatted + " LKR");
        System.out.println("\nPress any to go back");

    }

    private static void printSubMenuItemData2() {
        System.out.println("Name        :" + " " + name[1]);
        System.out.println("Description :" + " " + description[1]);
        System.out.println("Price       :"+ " " + price[1] + " LKR");
        System.out.println("\nPress any to go back");
    }

    private static void printSubMenuItemData3() {
        System.out.println("Name        :" + " " + name[2]);
        System.out.println("Description :" + " " + description[2] + " LKR");
        System.out.println("Price       :"+ " " + price[2]);
        System.out.println("\nPress any to go back");
    }


    private static void printSubMenuItemData4() {
        System.out.println("Name        :" + " " + name[3]);
        System.out.println("Description :" + " " + description[3]);
        System.out.println("Price       :"+ " " + price[3] + " LKR");
        System.out.println("\nPress any to go back");
    }

    private static void makeOrderScreen() {
        int pizzaOrderCount = 0;
        boolean insideOrderMenu = true;

        ArrayList orderedPizzaNames = new ArrayList<String>();
        ArrayList finalPrice = new ArrayList<Float>();

        Scanner scanner = new Scanner(System.in);
        starterItemsSelectScreen();

        while(insideOrderMenu || pizzaOrderCount < 3){

            if(pizzaOrderCount == 1){
                System.out.println("Please select second item you want to buy.\n");
                printMenuList();
                System.out.println("Press item number to select as second item\n" + "OR\n" +
                        "Press [E] to complete\n" + "OR\n" + "Press [0] to go back to Main menu");
            } else if (pizzaOrderCount == 2) {
                insideOrderMenu = false;
                System.out.println("Please select final item you want to buy.\n");
                printMenuList();
                System.out.println("Press item number to select as third item\n" + "OR\n" +
                        "Press [E] to complete\n" + "OR\n" + "Press [0] to go back to Main menu");
            }
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                case "2":
                case "3":
                case "4":
                    int choice = Integer.parseInt(userInput);
                    orderedPizzaNames.add(name[choice-1]);
                    finalPrice.add(price[choice-1]);
                    pizzaOrderCount++;
                    break;
                case "E":
                    printReceipt(orderedPizzaNames, finalPrice);
                    return;
                case "0":
                    homeView();
                    return;
            }
        }
        printReceipt(orderedPizzaNames, finalPrice);
    }
    private static void printMenuList() {
        System.out.println("#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR" + "\n");
    }

    private static void starterItemsSelectScreen() {
        System.out.println("\nYou can buy 3 items.\n" + "Please select first item you want to buy.\n");
        printMenuList();
        System.out.println("Press item number to select first item\n" + "OR\n" + "Press [0] to go back to Main menu");
    }

    private static void printReceipt(ArrayList orderedPizzaNames, ArrayList finalPrice) {
        float total = 0;
        System.out.println("You have ordered #" + orderedPizzaNames.size() + " number of items\n" +
                "            Pizza Hut\n" + "-------------------------------------");
        for(int i = 0; i < finalPrice.size(); i++){
            total = total + Float.parseFloat(finalPrice.get(i).toString());
            System.out.println("#" + (i+1) + " " + orderedPizzaNames.get(i) + " - " + finalPrice.get(i) + " LKR");
        }

        System.out.println("\n        Total : " + total + " LKR" + "\n-------------------------------------");
        System.out.println("      Thank You For Ordering\n" +
                "-------------------------------------");
        System.exit(exitTheProgram());
    }

}