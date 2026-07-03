import java.util.Scanner;

public class ip_inclusion {
    public static void main(String[] args) {
        int choice;
        int octet2, octet1;
        double last2octets;
        Scanner cin = new Scanner(System.in);
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
            System.out.println("Complete the ip address to match yours :");
            System.out.print("192.168.");
            do {
                if (cin.hasNextDouble()) {
                    last2octets = cin.nextDouble();
                    octet2 = (int) last2octets;
                    octet1 = (int)(last2octets * 100) % 100;
                    if ((octet2 > 255 || octet1 > 255) || octet2 < 0) {
                        System.out.println("Invalid Address!\n");
                        System.out.println("Complete the ip address to match yours :");
                        System.out.print("192.168.");
                    }
                    else{
                        break;
                    }
                }
                else {
                    cin.next();
                    System.out.println("Invalid Address!\n");
                    System.out.println("Complete the ip address to match yours :");
                    System.out.print("192.168.");
                }
            } 
            while(true);
            System.out.println("Hooray! The ip address is : 192.168." + octet2 + "." + octet1);
        }
        
        cin.close();
    }
}
