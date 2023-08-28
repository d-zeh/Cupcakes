import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing");
        Scanner scanner = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake?");
        String priceText = scanner.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        cupcakeMenu.add(cupcake);

        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake?");
        String priceText1 = scanner.nextLine();
        double price1 = Double.parseDouble(priceText1);
        redVelvet.setPrice(price1);
        cupcakeMenu.add(redVelvet);

        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake?");
        String priceText2 = scanner.nextLine();
        double price2 = Double.parseDouble(priceText2);
        chocolate.setPrice(price2);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();


        System.out.println("Don't know what water is? This is it:");
        water.type();
        System.out.println("How much would you like to charge for the water?");
        String inputWater = scanner.nextLine();
        double priceWater = Double.parseDouble(inputWater);
        water.setPrice(priceWater);
        drinkMenu.add(water);

        System.out.println("Don't know what milky is? This is it:");
        milk.type();
        System.out.println("How much would you like to charge for the milkie?");
        String inputMilk = scanner.nextLine();
        double priceMilk = Double.parseDouble(inputMilk);
        milk.setPrice(priceMilk);
        drinkMenu.add(milk);

        System.out.println("Don't know what soooo-duhh is? This is it:");
        soda.type();
        System.out.println("How much would you like to charge for the pop?");
        String inputSoda = scanner.nextLine();
        double priceSoda = Double.parseDouble(inputSoda);
        soda.setPrice(priceSoda);
        drinkMenu.add(soda);

        new Order(cupcakeMenu, drinkMenu);


    }
}
    class Cupcake {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type() {
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }
    }


class RedVelvet extends Cupcake {
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting");
    }
}
class Chocolate extends Cupcake {
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

class Drink {
    public double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void type() {
        System.out.println("a basic drank, made for dranking");
    }
}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("a bOttLE oF sODa");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("pure white, delicious milk. fresh from the chicken");
    }
}