package tuts;
public class NetCalculator {
    public static void main(String[] args) {
        
    }
       public int hostbits (int hostsreq) {
        
        return (int)(Math.log(hostsreq)/Math.log(2));
    }

   public int getIncrement (int hostbits) {
        return (int)(Math.pow(2, hostbits));
     }
    public int cidr (int hostbits) {
        return 32 - hostbits;
    }
}
 

