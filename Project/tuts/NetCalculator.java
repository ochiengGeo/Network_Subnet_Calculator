package Project.tuts;

public class NetCalculator {
    public static void main(String[] args) {
        
    }

    public int hostbits(int hostsreq) {
        return (int) Math.ceil((Math.log(hostsreq + 2) / Math.log(2)));
    }

    public int getIncrement(int hostbits) {
        return (int)(Math.pow(2, hostbits));
    }

    public int cidr(int hostbits) {
        return 32 - hostbits;
    }

    public String getSubnetMask(int cidr) {
        int maskVal = (cidr == 0) ? 0 : (0xFFFFFFFF << (32 - cidr));
        int octet1 = (maskVal >> 24) & 0xFF;
        int octet2 = (maskVal >> 16) & 0xFF;
        int octet3 = (maskVal >> 8) & 0xFF;
        int octet4 = maskVal & 0xFF;
        
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    public boolean isValidNetwork(int cidr, int octet2, int octet1) {
        int hostBits = 32 - cidr;

        if (cidr >= 16 && cidr <= 24) {
            if (octet1 != 0) return false;
            if (hostBits > 8) hostBits = 8; 
            int blockSize = 1 << hostBits;
            return (octet2 % blockSize) == 0;
            
        } else if (cidr > 24 && cidr <= 32) {
            int blockSize = 1 << hostBits;
            return (octet1 % blockSize) == 0;
        }
        
        return false;
    }

    public void displayNetworkRanges(int cidr, int octet2, int octet1) {
        int hostBits = 32 - cidr;
        
        if (cidr == 31 || cidr == 32) {
            System.out.println("CIDR /" + cidr + " does not support standard usable host ranges.");
            return;
        }

        int blockSize = 1 << hostBits;
        String firstUsable = "";
        String lastUsable = "";
        String broadcast = "";

        if (cidr >= 16 && cidr <= 24) {
            int broadcastOctet3 = octet2 + blockSize - 1;
            firstUsable = "192.168." + octet2 + ".1";
            lastUsable = "192.168." + broadcastOctet3 + ".254";
            broadcast = "192.168." + broadcastOctet3 + ".255";

        } else if (cidr > 24 && cidr <= 32) {
            int broadcastOctet4 = octet1 + blockSize - 1;
            firstUsable = "192.168." + octet2 + "." + (octet1 + 1);
            lastUsable = "192.168." + octet2 + "." + (broadcastOctet4 - 1);
            broadcast = "192.168." + octet2 + "." + broadcastOctet4;
        }

        System.out.println("Network ID:   192.168." + octet2 + "." + octet1);
        System.out.println("First Usable: " + firstUsable);
        System.out.println("Last Usable:  " + lastUsable);
        System.out.println("Broadcast:    " + broadcast);
        System.out.println("--------------------------------");
    }
}
