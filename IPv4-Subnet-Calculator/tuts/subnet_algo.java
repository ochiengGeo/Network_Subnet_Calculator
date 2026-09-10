import java.util.Scanner;

public class trial_subnetmask {
    public static void main (String[] args) {
        int octet4 = 255, octet3 = 255, octet2 = 255, octet1 = 255;
        System.out.print("Enter the Number of hostbits: ");
        Scanner cin = new Scanner(System.in);
        int hostbits = cin.nextInt();
        cin.nextLine();

        //4th octet
        if (hostbits <= 8) {
        for (int j = 1; j <= hostbits; j++) {
            octet1 -= Math.pow(2, j - 1);
        }
}
        
        //3rd Octet
        else if (hostbits > 8 && hostbits <= 16) {
            int temp = hostbits - 8;
        for (int j = 1; j <= temp; j++) {
            octet2 -= Math.pow(2, j - 1);
        }
        octet1 = 0;
        }

        //2nd Octet
        else if (hostbits > 16 && hostbits <= 24) {
            int temp = hostbits - 16;
        for (int j = 1; j <= temp; j++) {
            octet3 -= Math.pow(2, j - 1);
        }
        octet1 = 0;
        octet2 = 0;
        }

        else {
            //1st octet
            int temp = hostbits - 24;
            for (int j = 1; j <= temp; j++) {
            octet4 -= (int)Math.pow(2, j -1);

        }
        octet3 = 0;
        octet2 = 0;
        octet1 = 0;
    }
        System.out.println("Subnet Mask: " + octet4+ "." +octet3+ "." +octet2+ "." +octet1);

        cin.close();

    }


}
