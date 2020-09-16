import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    while(true) {
      // scanner.nextLine();
      System.out.println("1. Caesar Cipher\n2. PlayFair Cipher\n3. Exit\nEnter your choice");

      int choice = scanner.nextInt();

      if(choice == 3) {
	scanner.nextLine();
	break;
      }

      if(choice == 1) {
        scanner.nextLine();
        CaesarCipher cc = new CaesarCipher();

        System.out.println("1. Encrypt\n2. Decrypt\nEnter your choice");
        int c = scanner.nextInt();
        scanner.nextLine();

        if(c == 1) {
          System.out.println("Enter the message");
          String msg = scanner.nextLine();
          msg = msg.toUpperCase();
          System.out.println("Enter the Encryption Key");
          int key = scanner.nextInt();
          cc.setKey(key);

          String out = cc.encrypt(msg);
          System.out.println("Encrypted Message is: " + out);
        }
        else {
          System.out.println("Enter the message");
          String msg = scanner.nextLine();
          msg = msg.toUpperCase();
          int key = 0;
          System.out.println("Enter decryption key if known else 0");
          key = scanner.nextInt();

          if(key == 0) {
            System.out.println("Possible messages are");
            for(int i=0; i < 26; i++) {
              String out = cc.decrypt(msg, key);
              System.out.println("k=" + i + " " + out);
            }
          }
          else {
            cc.setKey(key);
            String out = cc.decrypt(msg, key);
            System.out.println("Decrypted Message is: " + out);
          }
        }
      }

      if(choice == 2) {
        scanner.nextLine();
        PlayFairCipher pfc = new PlayFairCipher();

        System.out.println("1. Encrypt\n2. Decrypt\nEnter your choice");
        int c = scanner.nextInt();
        scanner.nextLine();

        if(c == 1) {
          System.out.println("Enter the message to encrypt");
          String msg = scanner.nextLine();
          msg = msg.toUpperCase();
          System.out.println("Enter encryption key");
          String key = scanner.nextLine();
          key = key.toUpperCase();

          pfc.setKey(key);
          pfc.printPlayFairMatrix();

          String out = pfc.encrypt(msg);
          System.out.println("The Encrypted Message is: " + out);
        }
        else {
          System.out.println("Enter the message to decrypt");
          String msg = scanner.nextLine();
          msg = msg.toUpperCase();
          System.out.println("Enter the Decryption Key");
          String key = scanner.nextLine();
          key = key.toUpperCase();
          pfc.setKey(key);

          String out = pfc.decrypt(msg);
          System.out.println("The Decrypted Message is: " + out);
        }
      }
    }
  }
}
