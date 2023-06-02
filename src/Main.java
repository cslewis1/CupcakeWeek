import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Cupcakes
        //Create cupcake Array list
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        //Standard Cupcake//
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");

        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        String priceText = input.nextLine();

        Double price = Double.parseDouble(priceText);

        cupcake.setPrice(price);

        //Red Velvet Cupcake
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");

        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        String redVelvetPriceText = input.nextLine();

        Double redVelvetPrice = Double.parseDouble(priceText);

        redVelvet.setPrice(redVelvetPrice);

        //Chocolate cupcake
       System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");

        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? " +
                "(Input a numerical number taken to 2 decimal places)");

        String chocolatePriceText = input.nextLine();

        double chocolatePrice = Double.parseDouble(priceText);

        chocolate.setPrice(chocolatePrice);

        //Add the cupcakes to the Array List
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        //Drinks//
        //Create Drinks Array list//
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();

        Drink water = new Drink();
        Drink soda = new Drink();
        Drink milk = new Drink();

        System.out.println("We are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing.");

        //Water//
        System.out.println("We are deciding on the price for our water. Here is the description:");

        water.type();
        System.out.println("How much would you like to charge for the drink? " +
                "(Input a numerical number taken to 2 decimal places)");

        String waterPriceText = input.nextLine();

        Double waterPrice = Double.parseDouble(priceText);

        water.setPrice(waterPrice);

        //Soda//
        System.out.println("We are deciding on the price for our soda. Here is the description:");

        soda.type();
        System.out.println("How much would you like to charge for the drink? " +
                "(Input a numerical number taken to 2 decimal places)");

        String sodaPriceText = input.nextLine();

        Double sodaPrice = Double.parseDouble(priceText);

        soda.setPrice(sodaPrice);

        //Milk//
        System.out.println("We are deciding on the price for our milk. Here is the description:");

        milk.type();
        System.out.println("How much would you like to charge for the drink? " +
                "(Input a numerical number taken to 2 decimal places)");

        String milkPriceText = input.nextLine();

        Double milkPrice = Double.parseDouble(priceText);

        milk.setPrice(milkPrice);

        //Add the objects to the array list
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);
    }
}
class Cupcake{
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting.");
    }
}

class RedVelvet extends Cupcake{
    @Override
    public void type() {
       System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake{
    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void type(){
        System.out.println("A generic bottle of water.");
    }
}

class Soda extends Drink{
    @Override
    public void type(){
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink{
    @Override
    public void type(){
        System.out.println("A generic bottle of milk.");
    }
}