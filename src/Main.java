import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String[] name = {"BBQ Chicken Pizza", "Devil Chicken Pizza", "Vegi Pizza", "Pork Pizza"};
    static float[] price = {1299.0F, 1499.0F, 999.0F, 1999.0F};
    static String[] description = {"BBQ Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Devil Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Carrot & onions, Mozzarella Cheese, Bell Pepper",
            "BBQ Pork, Mozzarella Cheese, Bell Pepper"};


    public static void main(String[] args) {
        boolean programRunning = true;
        Scanner scan = new Scanner(System.in);

        while(programRunning){
            WelcomeToPizzaMsgPrint();
            String chooseTheMenuInput = scan.nextLine();
            switch(chooseTheMenuInput){
                case "1": printMenu();
                case "2": orderMenu();
                case "x":
                    int i = 11;
                    System.exit(i);
                default: incorrectInput();
            }
        }
    }
    private static void WelcomeToPizzaMsgPrint() {
        System.out.println("Welcome to PizzaHut!\n" +
                "To View our menu, press [1]\n" +
                "To place an Order, press [2]\n" +
                "Press [x] to exit the store");
    }
    private static void incorrectInput() {
        System.out.println("Please enter valid option from below\n");
    }

    private static void orderMenu() {
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
                System.out.println("Press item number to select second item\n" + "OR" +
                        "Press [E] to complete\n" + "\n" + "Press [0] to go back to Main menu");
            } else if (pizzaOrderCount == 2) {
                insideOrderMenu = false;
                System.out.println("Please select final item you want to buy.\n");
                printMenuList();
                System.out.println("Press item number to select final item\n" + "OR" +
                        "Press [E] to complete\n" + "\n" + "Press [0] to go back to Main menu");
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
            }
        }
        printReceipt(orderedPizzaNames, finalPrice);
    }


    private static void starterItemsSelectScreen() {
        System.out.println("\nYou can buy 3 items.\n" + "Please select first item you want to buy.\n");
        printMenuList();
        System.out.println("Press item number to select first item\n" + "OR" + "\n" + "Press [0] to go back to Main menu");
    }

    private static void printReceipt(ArrayList orderedPizzaNames, ArrayList finalPrice) {
        float total = 0;
        System.out.println("You have ordered #" + orderedPizzaNames.size() + " number of items\n" +
                "            Pizza Hut\n");
        for(int i = 0; i < finalPrice.size(); i++){
            total = total + Float.parseFloat(finalPrice.get(i).toString());
            System.out.println("#" + i + " " + orderedPizzaNames.get(i) + " -" + finalPrice.get(i) + "LKR");
        }

        System.out.println("Total :" + "" + total);
        System.out.println("Thank You For Ordering\n" +
                "-------------------------------------\n" +
                "Thank you for visiting Pizza Hut, See you next time");
    }

    private static void printMenu() {
        boolean insideMenu = true;
        Scanner scan = new Scanner(System.in);

        while(insideMenu){
            justViewTheMenuList();
            String chooseThePizzaMenuInput = scan.nextLine();
            switch(chooseThePizzaMenuInput){
                case "1": printSubMenuItem1();
                    break;
                case "2": printSubMenuItem2();
                    break;
                case "3": printSubMenuItem3();
                    break;
                case "4": printSubMenuItem4();
                    break;
                case "0": exitFromMenu();
                    break;
                default: incorrectInput();
            }
        }
    }

    private static void justViewTheMenuList() {
        printMenuList();
        System.out.println("Press item number to view description\n" +
                "OR\n" +
                "Press [0] to go back");
    }

    private static void exitFromMenu() {

    }
    private static void printMenuList() {
        System.out.println("PizzaHut Menu\n" +
                "#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR");
    }
    private static void printSubMenuItem1() {
        boolean insideSubMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(insideSubMenu){
            printSubMenuItemData1();
            String chooseThePizzaMenuInput = scanner.nextLine();
            break;
        }
    }

    private static void printSubMenuItemData1() {
        System.out.println("Name        :" + " " + name[0]);
        System.out.println("Description :" + " " + description[0]);
        System.out.println("Price       :"+ " " + price[0] + " LKR");
        System.out.println("\nPress any to go back");
    }

    private static void printSubMenuItem2() {
        boolean insideSubMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(insideSubMenu){
            printSubMenuItemData2();
            String chooseThePizzaMenuInput = scanner.nextLine();
            break;
        }
    }

    private static void printSubMenuItemData2() {
        System.out.println("Name        :" + " " + name[1]);
        System.out.println("Description :" + " " + description[1]);
        System.out.println("Price       :"+ " " + price[1] + " LKR");
        System.out.println("\nPress any to go back");
    }

    private static void printSubMenuItem3() {
        boolean insideSubMenu = true;
        Scanner scan = new Scanner(System.in);

        while (insideSubMenu){
            printSubMenuItemData3();
            String chooseThePizzaMenuInput = scan.nextLine();
            break;
        }
    }
    private static void printSubMenuItemData3() {
        System.out.println("Name        :" + " " + name[2]);
        System.out.println("Description :" + " " + description[2]);
        System.out.println("Price       :"+ " " + price[2] + " LKR");
        System.out.println("\nPress any to go back");
    }

    private static void printSubMenuItem4() {
        boolean insideSubMenu = true;
        Scanner scan = new Scanner(System.in);

        while (insideSubMenu){
            printSubMenuItemData4();
            String chooseThePizzaMenuInput = scan.nextLine();
            break;
        }
    }

    private static void printSubMenuItemData4() {
        System.out.println("Name        :" + " " + name[3]);
        System.out.println("Description :" + " " + description[3]);
        System.out.println("Price       :"+ " " + price[3] + " LKR");
        System.out.println("\nPress any to go back");
    }


}