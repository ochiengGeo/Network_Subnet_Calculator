package tuts;
public class NetCalculator {
    public static void main(String[] args) {
        
    }
       public int hostbits (int hostsreq) {
        
        return (int) Math.ceil((Math.log(hostsreq + 2)/Math.log(2)));
    }

   public int getIncrement (int hostbits) {
        return (int)(Math.pow(2, hostbits));
     }
    public int cidr (int hostbits) {
        return 32 - hostbits;
    }
    public String getSubnetMask (int hostbits) {
        int octet1 = 255, octet2 = 255, octet3 = 255, octet4 = 255;
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
       return octet4+ "." +octet3+ "." +octet2+ "." +octet1;
    }

    public boolean isValidNetwork(int cidr, int octet2, int octet1) { // inspired by AI
        // Step 1: Identify which octet is the "changing" boundary octet
        if (cidr >= 16 && cidr <= 24) {
            // The 3rd octet changes. The 4th octet MUST be 0.
            if (octet1 != 0) return false;
            
            int hostBits = 8 - (cidr % 8);
            if (hostBits == 8) hostBits = 0; // Handle edge case /16
            int blockSize = 1 << hostBits;
            
            return (octet2 % blockSize) == 0;
            
        } else if (cidr > 24 && cidr <= 32) {
            // The 4th octet changes. The 3rd octet can be anything (0-255).
            int hostBits = 8 - (cidr % 8);
            if (hostBits == 8) hostBits = 0; // Handle edge case /24
            int blockSize = 1 << hostBits;
            
            return (octet1 % blockSize) == 0;
        }
        
        return false; // cidr out of the xx.xx range
    }

    public void displayNetworkRanges(int cidr, int octet2, int octet1) {
        // Step 1: Calculate Host Bits and Block Size
        int hostBits = 8 - (cidr % 8);
        if (hostBits == 8) hostBits = 0; // Handles exact boundaries like /16 and /24
        int blockSize = 1 << hostBits;

        // Variables to hold our final outputs
        String firstUsable = "";
        String lastUsable = "";
        String broadcast = "";

        // Step 2 & 3: Determine boundaries based on the cidr scope
        if (cidr >= 16 && cidr <= 24) {
            // Case B: 3rd octet changes. 4th octet is currently 0.
            int broadcastOctet3 = octet2 + blockSize - 1;

            // Handle edge case for /31 and /32 which do not have standard host ranges
            if (cidr == 31 || cidr == 32) {
                System.out.println("cidr /" + cidr + " does not support standard usable host ranges.");
                return;
            }

            firstUsable = "192.168." + octet2 + ".1";
            lastUsable = "192.168." + broadcastOctet3 + ".254";
            broadcast = "192.168." + broadcastOctet3 + ".255";

        } else if (cidr > 24 && cidr <= 32) {
            // Case A: 4th octet changes. 3rd octet is fixed as entered.
            int broadcastOctet4 = octet1 + blockSize - 1;

            // Handle edge case for point-to-point links /31 or single hosts /32
            if (cidr == 31 || cidr == 32) {
                System.out.println("cidr /" + cidr + " does not support standard usable host ranges.");
                return;
            }

            firstUsable = "192.168." + octet2 + "." + (octet1 + 1);
            lastUsable = "192.168." + octet2 + "." + (broadcastOctet4 - 1);
            broadcast = "192.168." + octet2 + "." + broadcastOctet4;
        }

        // Step 4: Display the calculated results
        System.out.println("Network ID:   192.168." + octet2 + "." + octet1);
        System.out.println("First Usable: " + firstUsable);
        System.out.println("Last Usable:  " + lastUsable);
        System.out.println("Broadcast:    " + broadcast);
        System.out.println("--------------------------------");
    }
}
 
