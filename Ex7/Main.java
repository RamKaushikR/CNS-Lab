import java.util.*;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases;
    String A = "", B = "";
    BigInteger pA = BigInteger.valueOf(0) , pB = BigInteger.valueOf(0);
    DiffieHellman DH = new DiffieHellman();

    do {
      System.out.print("1.Generate Key\n2.Enter Secret Keys\n3.Display Shared Secret Keys\n4.Exit\nEnter choice: ");
      cases = sc.nextInt();

      if(cases == 1) {
        DH.genPrimeAndPrimitiveRoot();
        System.out.println("P(prime number): " + DH.getP());
        System.out.println("G(primitive root modulo P): " + DH.getG());
      }
      else if(cases == 2) {
        System.out.print("Enter A's Secret Key: ");
        A = sc.next();
        pA = DH.getAliceMessage(new BigInteger(A.getBytes()));
        System.out.println("A's Public Key: " + pA);
        System.out.print("Enter B's Secret Key: ");
        B = sc.next();
        pB = DH.getBobMessage(new BigInteger(B.getBytes()));
        System.out.println("B's Public Key:" + pB);
      }
      else if(cases == 3) {
        BigInteger secretA = DH.aliceCalculationOfKey(pB,new BigInteger(A.getBytes()));
        BigInteger secretB = DH.bobCalculationOfKey(pA,new BigInteger(B.getBytes()));
        System.out.println("A's Shared Secret Key: " + secretA);
        System.out.println("B's Shared Secret Key:" + secretB);
      }
    } while(cases != 4);
  }
}
