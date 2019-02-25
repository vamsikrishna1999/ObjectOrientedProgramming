package Oop;
import java.util.*;
//BillingApplication
interface Bill{
    double PER_UNIT = 5.0;
    double CalculateBill(int nou);
    void displayBill(double amount);
}
abstract class DisplayBill implements Bill{

    public void displayBill(double amount) {
        System.out.println("BIll amount:"+amount);
    }
}
class ElectricBill extends DisplayBill {

    public double CalculateBill(int nou){
       return nou*PER_UNIT;
    }
}
class WaterBill extends DisplayBill {
    public double CalculateBill(int nou){
        return (nou+1)*PER_UNIT;
    }
}
public class OopsApplication {
    public static void takeBill(Bill bref,int nou){
        if(bref instanceof ElectricBill){
            double amount = bref.CalculateBill(nou);
            bref.displayBill(amount);
        }
        else if(bref instanceof WaterBill){
            double amount = bref.CalculateBill(nou);
            bref.displayBill(amount);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to BillApplication");
        System.out.println("Selecetd one of the options");
        System.out.println("1: Electric Bill");
        System.out.println("2: water Bill");
        int choice = sc.nextInt();
        int nou;
        Bill bref = new ElectricBill();
        switch (choice){
            case 1:
                System.out.println("welcome to Ebill payment");
                System.out.println("Enter number of units");
                nou = sc.nextInt();
                takeBill(bref,nou);
                break;
            case 2:
                System.out.println("Welcome to Wbill payment");
                System.out.println("Enter number of units");
                nou = sc.nextInt();
                bref = new WaterBill();
                takeBill(bref,nou);
                break;
                default:
                    System.out.println("Invalid Option");

        }
    }
}
