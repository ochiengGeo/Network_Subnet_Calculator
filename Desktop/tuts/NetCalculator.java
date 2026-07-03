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
}
 
