package org.example;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        boolean exit = false;
        while(!exit){
            System.out.print("Choose option: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Pizza Type: ");
                    String pizzaType = s.next();
                    System.out.print("Quantity: ");
                    int quantity = s.nextInt();
                    System.out.println();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    printOrders(pizzas,quantities);
                    System.out.print("Order number to update: ");
                    int indx = s.nextInt()-1;
                    System.out.print("New quantity: ");
                    int newquant = s.nextInt();
                    updateOrder(quantities, indx, newquant);
                    break;
                case 3:
                    printOrders(pizzas,quantities);
                    System.out.print("Order number to remove: ");
                    int removeIndex = s.nextInt() - 1;
                    removeOrder(pizzas, quantities, removeIndex);
                    break;
                case 4:
                    printOrders(pizzas,quantities);
                    break;
                case 5:
                    System.out.println("--- Thank You! ---");
                    exit = true;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        Scanner s = new Scanner(System.in);

        while(quantity <= 0){
            System.out.println("Quantity must be positive");
            System.out.print("Quantity: ");
            quantity = s.nextInt();
        }
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).equalsIgnoreCase(pizzaType)) {
                quantities.set(i, quantities.get(i) + quantity);
                System.out.printf("Added %d more to existing order: %s",quantity, pizzaType);
                System.out.println();
                System.out.println();
                return;
            }
        }
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if (index < 0 || index >= quantities.size()) {
            System.out.println("Invalid order number");
            System.out.println();
        } else if (newQuantity <= 0) {
            System.out.println("Quantity must be positive");
            System.out.println();
        } else {
            quantities.set(index, newQuantity);
            System.out.printf("Order updated to quantity: %d%n%n",newQuantity);
        }
    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Invalid order number");
            System.out.println();
        } else {
            String removedPizza = pizzas.remove(index);
            int removedQuantity = quantities.remove(index);
            System.out.printf("Removed order: %s x%d",removedPizza, removedQuantity);
            System.out.println();
            System.out.println();
        }
    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if (pizzas.isEmpty()) {
            System.out.println("No orders yet.");
        }else{
            System.out.println("--- Current Orders ---");
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.printf("%d) %s x %d%n", i + 1, pizzas.get(i), quantities.get(i));
            }
            System.out.println();
        }
    }
}