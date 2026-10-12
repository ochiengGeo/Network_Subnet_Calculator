package Project.tuts;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        NetCalculator calc = new NetCalculator();
        Scanner cin = new Scanner(System.in);
        System.out.println("\n1. Network Requirement.\n2. Host Requirements.");
        int mode;

        do {
            System.out.print("Choose the calculation Mode (1 or 2): ");
            mode = cin.nextInt();
            cin.nextLine(); 

            if (mode != 1 && mode != 2) {
                System.out.print("Invalid Choice, Try again!");
            }
        } while (mode != 1 && mode != 2);

        if (mode == 2) {
            System.out.println("\n1. With IP\n2. Without IP");
            do {
                System.out.print("Choose the calculation Mode (1 or 2): ");
                mode = cin.nextInt();
                cin.nextLine(); 

                if (mode != 1 && mode != 2) {
                    System.out.print("Invalid Choice, Try again!\n");
                }
            } while (mode != 1 && mode != 2);

            if (mode == 1) {
                int choice;
                int ipoctet2 = 0, ipoctet1 = 0;
                double last2octets;
                System.out.println("\n1. Class B (172.16.xx.xx) \n2. Class C (192.168.xx.xx) ");

                do {
                    System.out.print("Choose the IP type (1 or 2): ");
                    if (cin.hasNextInt()) {
                        choice = cin.nextInt();
                        if (choice != 1 && choice != 2) {
                            System.out.println("Invalid Choice!");
                        } else {
                            break;
                        }
                    } else { 
                        cin.next(); 
                        System.out.println("Invalid Choice!");
                    }
                } while (true);

                if (choice == 2) {
                    System.out.print("Enter the CIDR of your network: ");
                    int cidr = cin.nextInt(); 
                    
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
                            } else {
                                break;
                            }
                        } else {
                            cin.next();
                            System.out.println("Invalid Network Address!\n");
                            System.out.println("Complete the ip address to match your Network Address :");
                            System.out.print("192.168.");
                        }
                    } while(true);

                    System.out.print("Enter the number of hosts required for the Network 192.168." + ipoctet2 + "." + ipoctet1 + " : ");
                    int hostsreq = cin.nextInt();
                    int hBits = calc.hostbits(hostsreq);
                    int calculatedCidr = calc.cidr(hBits);

                    System.out.println();
                    System.out.println("Analysis For Network - 192.168." + ipoctet2 + "." + ipoctet1 + " : \n");
                    System.out.println("CIDR: /" + calculatedCidr);
                    System.out.println("Total Usable IP addresses: " + (calc.getIncrement(hBits) - 2));
                    System.out.println("Subnet Mask : " + calc.getSubnetMask(calculatedCidr));
                    calc.displayNetworkRanges(calculatedCidr, ipoctet2, ipoctet1);
                    System.out.println();         
                } else {
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
                            } else {
                                break;
                            }
                        } else {
                            cin.next();
                            System.out.println("Invalid Network Address!\n");
                            System.out.println("Complete the ip address to match your Network Address :");
                            System.out.print("172.16.");
                        }
                    } while(true);

                    System.out.print("Enter the number of hosts required for the Network 172.16." + ipoctet2 + "." + ipoctet1 + " : ");
                    int hostsreq = cin.nextInt();
                    cin.nextLine();

                    int hBits = calc.hostbits(hostsreq);
                    int calculatedCidr = calc.cidr(hBits);

                    System.out.println();
                    System.out.println("Analysis For Network - 172.16." + ipoctet2 + "." + ipoctet1 + " : \n");
                    System.out.println("CIDR: /" + calculatedCidr); 
                    System.out.println("Total Usable IP addresses: " + (calc.getIncrement(hBits) - 2));
                    System.out.println("Subnet Mask : " + calc.getSubnetMask(calculatedCidr));
                    calc.displayNetworkRanges(calculatedCidr, ipoctet2, ipoctet1);
                    System.out.println();
                }
            } else {
                System.out.print("Enter the number of hosts required : ");
                int hostsreq = cin.nextInt();
                cin.nextLine();

                int hBits = calc.hostbits(hostsreq);
                int calculatedCidr = calc.cidr(hBits);

                System.out.println();
                System.out.println("Analysis For Network : \n");
                System.out.println("CIDR: /" + calculatedCidr);
                System.out.println("Total Usable IP addresses: " + (calc.getIncrement(hBits) - 2));
                System.out.println("Subnet Mask : " + calc.getSubnetMask(calculatedCidr));
                System.out.println();
            }
        } else if (mode == 1) {
            System.out.println("Enter the number of subnets required: ");
            int subnetsReq = cin.nextInt();
            cin.nextLine();

            int subnetBits = (int) Math.ceil(Math.log(subnetsReq) / Math.log(2));
            int totalSubnets = (int) Math.pow(2, subnetBits);
            
            int baseCIDR = 24; 
            int newCIDR = baseCIDR + subnetBits;
            
            int remainingHostBits = 32 - newCIDR;
            int totalIPsPerSubnet = (int) Math.pow(2, remainingHostBits);
            int usableHostsPerSubnet = totalIPsPerSubnet > 2 ? totalIPsPerSubnet - 2 : 0;

            System.out.println();
            System.out.println("--- Network Requirement Analysis ---\n");
            System.out.println("Subnets Requested: " + subnetsReq);
            System.out.println("Bits Borrowed: " + subnetBits);
            System.out.println("Total Subnets Created: " + totalSubnets);
            System.out.println("New CIDR Notation: /" + newCIDR);
            System.out.println("Subnet Mask : " + calc.getSubnetMask(newCIDR));
            System.out.println("Total IPs per Subnet: " + totalIPsPerSubnet);
            System.out.println("Usable Hosts per Subnet: " + usableHostsPerSubnet);
            System.out.println();
        }
        
        cin.close();
    }
}
