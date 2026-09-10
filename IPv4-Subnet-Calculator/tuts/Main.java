package tuts;
import java.util.Scanner;



public class Main {
    public static void main (String [] args) {
        NetCalculator calc = new NetCalculator();
        Scanner cin = new Scanner(System.in);
        System.out.println("\n1. Network Requirement.\n2. Host Requirements.");
        int mode;

        do {
        System.out.print("Choose the calculation Mode(1 or 2): ");
        mode = cin.nextInt();
        cin.nextLine(); //I will/have to prevent non-integer error🔴

        if (mode != 1 && mode != 2) {
            System.out.print("Invalid Choice, Try again!");
        }
        } while (mode != 1 && mode != 2);

        if (mode == 2) {
            System.out.println("\n1. With IP\n2. Without IP");
            do {
               System.out.print("Choose the calculation Mode(1 or 2): ");
               mode = cin.nextInt();
               cin.nextLine(); //I will/have to prevent non-integer error🔴

              if (mode != 1 && mode != 2) {
              System.out.print("Invalid Choice, Try again!\n");
        }
        } while (mode != 1 && mode != 2);

        if (mode == 1) {
        int choice;
        int ipoctet2, ipoctet1;
        double last2octets;
        System.out.println("\n1. Class B(172.16.xx.xx) \n2. Class C(192.168.xx.xx) ");

        do {
        System.out.print("Choose the IP type (1 or 2): ");
        
        if (cin.hasNextInt()) {
            choice = cin.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid Choice!");
            }
            else {break;}
        }
        else { 
            cin.next(); 
            System.out.println("Invalid Choice!");
        }
    }
        while (true);

        if (choice == 2) {
            System.out.print("Enter the CIDR of your network: ");
            int cidr = cin.nextInt(); //fix the input buffer🔴
            
            System.out.println("\nComplete the ip address to match your Network Address :");
            System.out.print("192.168.");
            do {
                if (cin.hasNextDouble()) {
                    last2octets = cin.nextDouble();
                    ipoctet2 = (int) last2octets;
                    ipoctet1 = (int)(last2octets * 100) % 100;
                    if ((ipoctet2 > 255 || ipoctet1 > 255) || ipoctet2 < 0 || !calc.isValidNetwork(cidr, ipoctet2, ipoctet1)) {
                        System.out.println("Invalid Network Address!\n");
                        System.out.println("Complete the ip address to match your Network Address :");
                        System.out.print("192.168.");
                    }
                    else{
                        break;
                    }
                }
                else {
                    cin.next();
                    System.out.println("Invalid Network Address!\n");
                    System.out.println("Complete the ip address to match your Network Address :");
                    System.out.print("192.168.");
                }
            } 
            while(true);
            //👇After successful octet input for Class C
            System.out.print("Enter the number of hosts required for the Network " + "192.168." +ipoctet2+"." +ipoctet1+ " : ");
            int hostsreq = cin.nextInt();
            System.out.println();
            System.out.println("Analysis For Network - 192.168." +ipoctet2+ "." +ipoctet1 + " : \n");
            System.out.println("CIDR: /" +calc.cidr(calc.hostbits(hostsreq)));
            System.out.println("Total Usable IP addresses: " + (calc.getIncrement(calc.hostbits(hostsreq)) - 2));
            System.out.println("Subnet Mask : " +calc.getSubnetMask(calc.hostbits(hostsreq)));
            calc.displayNetworkRanges(cidr, ipoctet2, ipoctet1);
            System.out.println();        }

        else {

            System.out.println("Enter the CIDR of your network: ");
            int cidr = cin.nextInt();

            System.out.println("\nComplete the ip address to match your Network Address :");
            System.out.print("172.16.");
            do {
                if (cin.hasNextDouble()) {
                    last2octets = cin.nextDouble();
                    ipoctet2 = (int) last2octets;
                    ipoctet1 = (int)(last2octets * 100) % 100;
                    if ((ipoctet2 > 255 || ipoctet1 > 255) || ipoctet2 < 0 || !calc.isValidNetwork(cidr, ipoctet2, ipoctet1)) {
                        System.out.println("Invalid Network Address!\n");
                        System.out.println("Complete the ip address to match your Network Address :");
                        System.out.print("172.16.");
                    }
                    else{
                        break;
                    }
                }
                else {
                    cin.next();
                    System.out.println("Invalid Network Address!\n");
                    System.out.println("Complete the ip address to match your Network Address :");
                    System.out.print("172.16.");
                }
            } 
            while(true);
            //👇Successful octet input Class B
         //   System.out.println("Hooray! The ip address is : 172.16." + ipoctet2 + "." + ipoctet1 + "\n");
            System.out.print("Enter the number of hosts required for the Network " + "172.16." +ipoctet2+"." +ipoctet1+ " : ");
            int hostsreq = cin.nextInt();
            cin.nextLine();


            System.out.println();
            System.out.println("Analysis For Network - 172.16." +ipoctet2+ "." +ipoctet1 + " : \n");
            System.out.println("CIDR: /" +calc.cidr(calc.hostbits(hostsreq)));
            System.out.println("Total Usable IP addresses: " + (calc.getIncrement(calc.hostbits(hostsreq)) - 2));
            System.out.println("Subnet Mask : " +calc.getSubnetMask(calc.hostbits(hostsreq)));
            calc.displayNetworkRanges(cidr, ipoctet2, ipoctet1);
            System.out.println();
        }
        
        }
            else {
            System.out.print("Enter the number of hosts required : ");
            int hostsreq = cin.nextInt();
            cin.nextLine();


            System.out.println();
            System.out.println("Analysis For Network : \n");
           /*  if (hostsreq > 254) { //actually, we do not need this in host requirement.
                System.out.println((256 / calc.getIncrement(calc.hostbits(hostsreq))) +" Subnets on the Network."); //remove since the host requirements only needs and requires the given number of hosts
                System.out.println("Capacity in each Subnet : " + calc.getIncrement(calc.hostbits(hostsreq)));
            }
                */
            System.out.println("CIDR: /" +calc.cidr(calc.hostbits(hostsreq)));
            System.out.println("Total Usable IP addresses: " + (calc.getIncrement(calc.hostbits(hostsreq)) - 2));
            System.out.println("Subnet Mask : " +calc.getSubnetMask(calc.hostbits(hostsreq)));
            System.out.println();
        }
    }
        cin.close();
    }
};
