import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String[] name = {"BBQ Chicken Pizza", "Devil Chicken Pizza", "Vegi Pizza", "Pork Pizza"};
    static float[] price = {1299.00F, 1499.00F, 999.00F, 1999.00F};
    static String[] description = {"BBQ Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Devil Chicken brest, Mozzarella Cheese, Bell Pepper",
            "Carrot & onions, Mozzarella Cheese, Bell Pepper",
            "BBQ Pork, Mozzarella Cheese, Bell Pepper"};


    public static void main(String[] args) {
        boolean programRunning = true;
        welcomeToPizzaMsgPrint();
        Scanner scan = new Scanner(System.in);

        while(programRunning){
            String chooseTheMenuInput = scan.nextLine();

            switch(chooseTheMenuInput){
                case "1": printMenu();
                break;
                case "2": orderMenu();
                break;
                case "x":
                    System.exit(exitTheProgram());
                default: incorrectInput();
            }
        }
    }

    private static void welcomeToPizzaMsgPrint() {
        System.out.println("Welcome to PizzaHut!\n" +
                "To View our menu, press [1]\n" +
                "To place an Order, press [2]\n" +
                "Press [x] to exit the store");
    }
    private static int exitTheProgram() {
        System.out.println("Thank you for visiting Pizza Hut, See you next time");
        return 0;
    }
    private static void incorrectInput() {
        System.out.println("Please enter valid option from bellow\n" + "To View our menu, press [1]\n" + "To place an Order, press [2]");
    }

    private static void printMenu() {
        boolean insideMenu = true;
        justViewMenu();
        Scanner scan = new Scanner(System.in);

        while(insideMenu){
            String chooseThePizzaMenuInput = scan.nextLine();
            switch(chooseThePizzaMenuInput){
                case "1": printSubMenuItemData1();
                    break;
                case "2": printSubMenuItem2();
                    break;
                case "3": printSubMenuItem3();
                    break;
                case "4": printSubMenuItem4();
                    break;
                case "0": insideMenu=false;
                    break;
                default: backToPizzaMenu();
                    break;
            }
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

    private static void printSubMenuItem1() {
        boolean insideSubMenu = true;

        while(insideSubMenu){
            printSubMenuItemData1();
            return;
        }
    }

    private static void printSubMenuItemData1() {
        DecimalFormat df = new DecimalFormat("#.00");
        String priceFormatted = String.valueOf(Float.valueOf(df.format(price[0])));

        System.out.println("Name        :" + " " + name[0]);
        System.out.println("Description :" + " " + description[0]);
        System.out.println("Price       :"+ " " + priceFormatted + " LKR");
        System.out.println("\nPress any to go back");
    }
    private static void printSubMenuItem2() {
        boolean insideSubMenu = true;

        while(insideSubMenu){
            printSubMenuItemData2();
            break;
        }
    }

    private static void printSubMenuItemData2() {
        System.out.println("Name        :" + " " + name[1]);
        System.out.println("Description :" + " " + description[1]);
        System.out.println("Price       :"+ " " + price[1] + "%.2fLKR");
        System.out.println("\nPress any to go back");
    }

    private static void printSubMenuItem3() {
        boolean insideSubMenu = true;

        while (insideSubMenu){
            printSubMenuItemData3();
            break;
        }
    }
    private static void printSubMenuItemData3() {
        System.out.println("Name        :" + " " + name[2]);
        System.out.println("Description :" + " " + description[2]);
        System.out.println("Price       :"+ " " + price[2] + "%.2f" + "LKR");
        System.out.println("\nPress any to go back");
    }


    private static void printSubMenuItem4() {
        boolean insideSubMenu = true;

        while (insideSubMenu){
            printSubMenuItemData4();
            break;
        }
    }

    private static void printSubMenuItemData4() {
        System.out.println("Name        :" + " " + name[3]);
        System.out.println("Description :" + " " + description[3]);
        System.out.println("Price       :"+ " " + price[3] + " LKR");
        System.out.println("\nPress any to go back");
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

        System.out.println("Total :" + total);
        System.out.println("Thank You For Ordering\n" +
                "-------------------------------------\n" +
                "Thank you for visiting Pizza Hut, See you next time");
    }



    private static void exitFromMenu() {

    }
    private static void printMenuList() {
        System.out.println("PizzaHut Menu\n\n" +
                "#1 BBQ Chicken Pizza - 1299.00 LKR\n" +
                "#2 Devil Chicken Pizza - 1499.00 LKR\n" +
                "#3 Vegi Pizza - 999.00 LKR\n" +
                "#4 Pork Pizza - 1999.00 LKR");
    }

}