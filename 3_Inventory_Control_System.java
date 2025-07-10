package core_java_projects;

import java.util.ArrayList;
import java.util.Scanner;

// Product class to hold item data
class Product {
    private int productId;
    private String productName;
    private int quantity;

    // Setters
    public void setProductId(int id) {
        this.productId = id;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    // Methods
    public void addStock(int qty) {
        this.quantity += qty;
    }

    public void removeStock(int qty) {
        if (qty <= quantity) {
            this.quantity -= qty;
        } else {
            System.out.println(" Not enough stock to remove.");
        }
    }

    public int getProductId() {
        return productId;
    }

    public void display() {
        System.out.println("Product ID: " + productId + " | Name: " + productName + " | Quantity: " + quantity);
    }
}

// Main class
public class Inventory_Control_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();
        int choice;

        // Warehouse-style greeting
        System.out.println(" Inventory Control Activated");
        System.out.println("..........................................");
        System.out.println("Hello Supervisor! Let’s manage your stock ");
        System.out.println("..........................................");

        // Menu loop
        do {
            System.out.println("\n Select an operation:");
            System.out.println("1. Add New Product");
            System.out.println("2. Add Stock");
            System.out.println("3. Remove Stock");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit System");
            System.out.print("Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add product
                    Product p = new Product();
                    System.out.print("Enter Product ID: ");
                    p.setProductId(sc.nextInt());
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    p.setProductName(sc.nextLine());
                    System.out.print("Enter Initial Quantity: ");
                    p.setQuantity(sc.nextInt());

                    inventory.add(p);
                    System.out.println(" Product successfully added to inventory.");
                    break;

                case 2:
                    // Add stock
                    System.out.print("Enter Product ID to add stock: ");
                    int idAdd = sc.nextInt();
                    boolean foundAdd = false;

                    for (Product prod : inventory) {
                        if (prod.getProductId() == idAdd) {
                            System.out.print("Enter quantity to add: ");
                            int qty = sc.nextInt();
                            prod.addStock(qty);
                            System.out.println(" Stock updated.");
                            foundAdd = true;
                            break;
                        }
                    }

                    if (!foundAdd) {
                        System.out.println(" Product ID not found.");
                    }
                    break;

                case 3:
                    // Remove stock
                    System.out.print("Enter Product ID to remove stock: ");
                    int idRemove = sc.nextInt();
                    boolean foundRemove = false;

                    for (Product prod : inventory) {
                        if (prod.getProductId() == idRemove) {
                            System.out.print("Enter quantity to remove: ");
                            int qty = sc.nextInt();
                            prod.removeStock(qty);
                            System.out.println(" Stock removed.");
                            foundRemove = true;
                            break;
                        }
                    }

                    if (!foundRemove) {
                        System.out.println(" Product ID not found.");
                    }
                    break;

                case 4:
                    // View inventory
                    if (inventory.isEmpty()) {
                        System.out.println(" Inventory is currently empty.");
                    } else {
                        System.out.println(" Current Inventory List:");
                        for (Product prod : inventory) {
                            prod.display();
                        }
                    }
                    break;

                case 5:
                    // Exit message
                    System.out.println("\n Inventory Control Logged Out");
                    System.out.println(" Thanks for managing the warehouse efficiently!");
                    break;

                default:
                    System.out.println(" Invalid input. Try a valid option.");
            }

        } while (choice != 5);
    }
}
