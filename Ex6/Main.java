import java.util.*;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) {
    RSA rsa = new RSA();
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
      System.out.print("1. Generate Key\n2. Encrypt\n3. Decrypt\n4. Exit\nEnter your choice: ");
      choice = sc.nextInt();
      sc.nextLine();

      if(choice == 1) {
        rsa.generateKey();
      }

      else if(choice == 2) {
        System.out.print("Enter plain text: ");
        String plainText = sc.nextLine();

        System.out.println("Enter  encryption key");
        System.out.print("e: ");
        BigInteger e = sc.nextBigInteger();
        System.out.print("N: ");
        BigInteger N = sc.nextBigInteger();

        BigInteger encrypted = rsa.encryption(plainText, e, N);
        System.out.println("Encrypted text: " + encrypted);
      }

      else if(choice == 3) {
        System.out.print("Enter encrypted text: ");
        BigInteger encrypted = sc.nextBigInteger();
        System.out.println("Enter  decryption key");
        System.out.print("d: ");
        BigInteger d = sc.nextBigInteger();
        System.out.print("N: ");
        BigInteger N = sc.nextBigInteger();

        String decrypted = rsa.decryption(encrypted, d, N);
        System.out.println("Decrypted text: " + new String(decrypted));
      }
    } while(choice != 4);
  }
}
