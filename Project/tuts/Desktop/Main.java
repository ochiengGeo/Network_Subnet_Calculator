package tuts.Desktop;
import java.util.Scanner;



public class Main {
    public static void main (String [] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("\n1. Network Requirement.\n2. Host Requirements.");
        int mode;

        do {
        System.out.println("Choose the calculation Mode(1 or 2): ");
        mode = cin.nextInt();
        cin.nextLine();

        if (mode != 1 && mode != 2) {
            System.out.print("Invalid Choice, Try again!");
        }
        } while (mode != 1 && mode != 2);

        if (mode == 1) {
            System.out.println("Enter the number of hosts required : ");
            int hostsreq = cin.nextInt();
            cin.nextLine();

            NetCalculator calc = new NetCalculator();

            System.out.println();
            System.out.println("Analysis");
            System.out.println((256 / calc.getIncrement(calc.hostbits(hostsreq))) +" Subnets on the Network.");
            System.out.println("Your Network Would have "+calc.getIncrement(calc.hostbits(hostsreq)) + " per subnet.");
            System.out.println("CIDR: /" +calc.cidr(calc.hostbits(hostsreq)));
            System.out.println("Capacity in each Subnet : " + calc.getIncrement(calc.hostbits(hostsreq)));
        }
       
        cin.close();
    }
};
