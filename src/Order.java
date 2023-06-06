import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order (ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        ArrayList<Object> order = new ArrayList<Object>();

        if(placeOrder.equalsIgnoreCase("Y")){
            LocalDate.now();
            LocalTime.now();

            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES");

            int itemNumber = 0;

            for(Cupcake cupcake : cupcakeMenu ){
                itemNumber++;
                System.out.println(itemNumber);
                cupcake.type();
                System.out.println("Price: $" + cupcake.getPrice());
            }

            System.out.println();
            System.out.println("DRINKS");

            for(Drink drink : drinkMenu){
                itemNumber++;
                System.out.println(itemNumber);
                drink.type();
                System.out.println("Price: $" + drink.getPrice());
            }

            System.out.println();
            Boolean ordering = true;

            while(ordering == true){
                System.out.println("What would you like to order? Please use the number associated with each item to order.");

                int orderChoice = input.nextInt();

                input.nextLine();

                switch(orderChoice){
                    case 1:
                        order.add(cupcakeMenu.get(0));
                        break;
                    case 2:
                        order.add(cupcakeMenu.get(1));
                        break;
                    case 3:
                        order.add(cupcakeMenu.get(2));
                        break;
                    case 4:
                        order.add(drinkMenu.get(0));
                        break;
                    case 5:
                        order.add(drinkMenu.get(1));
                        break;
                    case 6:
                        order.add(drinkMenu.get(2));
                        break;
                    default: System.out.println("Sorry, we don’t seem to have that on the menu.");
                }

                System.out.println("Would you like to continue ordering? (Y/N)");

                placeOrder = input.nextLine();

                if (!placeOrder.equalsIgnoreCase("Y")){
                    ordering = false;
                }
            }

            //Generate a receipt of items ordered.
            System.out.println(order.get(0));
            System.out.println(order.get(1));

            double subTotal = 0.0;

            for (int i = 2; i < order.size(); i++)
            {
                // Check if order at i is equal to cupcakeMenu at 0
                if (order.get(i).equals(cupcakeMenu.get(0)))
                {
                    // Print the type of cupcake at cupcakeMenu index 0
                    cupcakeMenu.get(0).type();

                    // Print the price of cupcake at cupcakeMenu index 0
                    System.out.println(cupcakeMenu.get(0).getPrice());

                    //Set subtotal equal to subtotal plus cupcakeMenu getPrice at 0
                    subTotal = subTotal + cupcakeMenu.get(0).getPrice();
                }
                // Check if order at i is equal to cupcakeMenu at 1
                else if (order.get(i).equals(cupcakeMenu.get(1)))
                {
                    // Print the type of cupcake at cupcakeMenu index 0
                    cupcakeMenu.get(1).type();

                    // Print the price of cupcake at cupcakeMenu index 0
                    System.out.println(cupcakeMenu.get(1).getPrice());

                    //Set subtotal equal to subtotal plus cupcakeMenu getPrice at 0
                    subTotal = subTotal + cupcakeMenu.get(1).getPrice();
                }
                //check if order at i is equal to cupcakeMenu at 2
                else if (order.get(i).equals(cupcakeMenu.get(2)))
                {
                    // Print the type of cupcake at cupcakeMenu index 0
                    cupcakeMenu.get(2).type();

                    // Print the price of cupcake at cupcakeMenu index 0
                    System.out.println(cupcakeMenu.get(2).getPrice());

                    //Set subtotal equal to subtotal plus cupcakeMenu getPrice at 0
                    subTotal = subTotal + cupcakeMenu.get(2).getPrice();
                }
                // Check if order at i is equal to drinkMenu at 0
                else if (order.get(i).equals(drinkMenu.get(0)))
                {
                    // Print the type of drink at drinkMenu index 0
                    drinkMenu.get(0).type();

                    // Print the price of drink at drinkMenu index 0
                    System.out.println(drinkMenu.get(0).getPrice());

                    //Set subtotal equal to subtotal plus drinkMenu getPrice at 0
                    subTotal = subTotal + drinkMenu.get(0).getPrice();
                }
                // Check if order at i is equal to drinkMenu at 1
                else if (order.get(i).equals(drinkMenu.get(1)))
                {
                    // Print the type of drink at drinkMenu index 1
                    drinkMenu.get(1).type();

                    // Print the price of drink at drinkMenu index 0
                    System.out.println(drinkMenu.get(1).getPrice());

                    //Set subtotal equal to subtotal plus drinkMenu getPrice at 0
                    subTotal = subTotal + drinkMenu.get(1).getPrice();
                }
                // Check if order at i is equal to drinkMenu at 2
                else if (order.get(i).equals(drinkMenu.get(2)))
                {
                    // Print the type of drink at drinkMenu index 2
                    drinkMenu.get(2).type();

                    // Print the price of drink at drinkMenu index 2
                    System.out.println(drinkMenu.get(2).getPrice());

                    //Set subtotal equal to subtotal plus drinkMenu getPrice at 2
                    subTotal = subTotal + drinkMenu.get(2).getPrice();
                }
            }
            // Print subtotal
            System.out.println("$" + subTotal + "\n");
            new CreateFile();
            new WriteToFile(order);
        } else {
            System.out.println("Have a nice day then.");
        }
    }

    class CreateFile{
        public CreateFile(){
            try{
                File salesData = new File("salesData.txt");

                if(salesData.createNewFile()){
                    System.out.println("File created: " + salesData.getName());
                } else {
                    System.out.println("File already exist");
                }
            } catch (IOException e){
                System.out.println("An error occurred");
            }
        }
    }

    class WriteToFile{
        public WriteToFile(ArrayList<Object> order){
            try{
                FileWriter fw = new FileWriter("salesData.txt", true);
                PrintWriter salesWriter = new PrintWriter(fw);

                for( int i = 0; i < order.size(); i++){
                    salesWriter.println(order.get(i));
                }
                salesWriter.close();
                System.out.println("Successfully wrote to the file");

            } catch (IOException e){
                System.out.println("An error occurred.");

            }

        }
    }
}
