import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Order {



    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){

        System.out.println("Hello World! Wanna place an order? (Y or N)");
        Scanner scanner = new Scanner(System.in);
        String placeOrder = scanner.nextLine();
        ArrayList<Object> order =  new ArrayList<Object>();

        if (placeOrder.equalsIgnoreCase("y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here ... is the .... wo-menu");
            System.out.println("*screams* CUPCAKES!!!!!!!!");
            int itemNumber = 1;
            for (int i = 0; i < cupcakeMenu.size(); i++) {

                System.out.println(itemNumber);
                cupcakeMenu.get(i).type();
                System.out.println("Price: " + cupcakeMenu.get(i).getPrice());
                itemNumber++;
                System.out.println();
            }

            for (int i = 0; i < drinkMenu.size(); i++) {

                System.out.println(itemNumber);
                drinkMenu.get(i).type();
                System.out.println("Price: " + drinkMenu.get(i).getPrice());
                itemNumber++;
                System.out.println();
            }

        } else {
            System.out.println("Oh....ok then. Bye");
        }

        boolean ordering = true;
        while(ordering) {
            System.out.println("What would you like to order? *sigh* Gimme the number");
            int orderChoice = scanner.nextInt();
            scanner.nextLine();
             if(orderChoice == 1) {
                 order.add(cupcakeMenu.get(0));
                 System.out.println("Item added to order");
             } else if (orderChoice == 2) {
                 order.add(cupcakeMenu.get(1));
                 System.out.println("Item added to order");
             }  else if (orderChoice == 3) {
                 order.add(cupcakeMenu.get(2));
                 System.out.println("Item added to order");
             }  else if (orderChoice == 4) {
                 order.add(drinkMenu.get(0));
                 System.out.println("Item added to order");
             }  else if (orderChoice == 5) {
                 order.add(drinkMenu.get(1));
                 System.out.println("Item added to order");
             }  else if (orderChoice == 6) {
                 order.add(drinkMenu.get(2));
                 System.out.println("Item added to order");
             } else {
                 System.out.println("THAT'S NOT ON THE MENU");
             }
            System.out.println("WOuld you like anything else (Y/N)?");
             placeOrder = scanner.nextLine();
            if (placeOrder.equalsIgnoreCase("N")) {
                ordering = false;
            }
        }


        //Day 4 File Manipulation
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subtotal = 0.00;
        for(int i = 2; i < order.size(); i++) {
            if (order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).getPrice());
                subtotal = subtotal + cupcakeMenu.get(0).getPrice();
            } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).getPrice());
                subtotal = subtotal + cupcakeMenu.get(1).getPrice();
            }else if (order.get(i).equals(cupcakeMenu.get(2))) {
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).getPrice());
                subtotal = subtotal + cupcakeMenu.get(2).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(0))) {
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).getPrice());
                subtotal = subtotal + drinkMenu.get(0).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(1))) {
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).getPrice());
                subtotal = subtotal + drinkMenu.get(1).getPrice();
            }else if (order.get(i).equals(drinkMenu.get(2))) {
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).getPrice());
                subtotal = subtotal + drinkMenu.get(2).getPrice();
            }

        }
        System.out.println("Total" + subtotal);
        new CreateFile();
        new WriteToFile(order);




    }
}
class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()) {
                System.out.println("File created: " + salesData.getName());
            }  else {
                System.out.println("File already exists");
            }
        } catch(IOException e) {
            System.out.println("No file? No file");
        }
    }
}
class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch(IOException e) {
            System.out.println("Error has occurred uwu");

        }
    }
}


