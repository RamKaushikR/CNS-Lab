import java.util.*;

class Main {
  public static void railFence() {
    RailFenceCipher rf = new RailFenceCipher();
    Scanner sc = new Scanner(System.in);
    int depth = 0;
    int choice;
    do {
      System.out.print("1. Encrypt\n2. Decrypt\n3. Exit\nEnter the choice ");
      choice = sc.nextInt();

      if(choice == 1) {
        System.out.print("Enter message to encrypt: ");
        String plainText = sc.next();
        System.out.print("Enter the depth: ");
        depth = sc.nextInt();
        sc.nextLine();
        String cipherText = rf.encryption(plainText, depth);
        System.out.println("Encrypted text is: " + cipherText);
      }
      else if(choice == 2) {
        System.out.print("Enter message to decrypt: ");
        String plainText = sc.next();
        System.out.print("Enter the depth: ");
        depth = sc.nextInt();
        String decryptedText = rf.decryption(plainText, depth);
        System.out.println("Decrypted text is: " + decryptedText);
      }
      else
        return;     
    } while(choice!=3);
    sc.close();
  }

  public static void transposition() {
    int encryptKey[] = new int[10];
    int decipherKey[] = new int[10];
    int n, choice;
    TranspositionCipher tc = new TranspositionCipher();
    String k, message;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("1. Encrypt\n2. Decrypt\n3. Exit\nEnter your choice: ");
      choice = sc.nextInt();
      if(choice == 1) {
        sc.nextLine();
        System.out.print("Enter message to encrypt: ");
        message = sc.nextLine();
        System.out.print("Enter the key size: ");
        n = sc.nextInt();
        System.out.print("Enter the key: ");

        for(int i = 0;i < n;i++)
          encryptKey[i] = sc.nextInt();

        tc.setKey(encryptKey, n);
        System.out.println("The encrypted message is: " + tc.encryption(message));
      }
      else if(choice == 2) {
        sc.nextLine();
        System.out.print("Enter message to decrypt: ");
        message = sc.nextLine();
        System.out.print("Enter the key size: ");
        n = sc.nextInt();
        System.out.print("Enter the key: ");

        for(int i=0; i<n; i++)
          encryptKey[i] = sc.nextInt();

        tc.setKey(encryptKey, n);
        System.out.println("The decrypted message is: " + tc.decryption(message));
      }
      else
        return;
    } while(choice != 3);
  }

  public static void main(String[] args) {
    int choice;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("1. RailFence Cipher\n2. Transposition Cipher\n3. Exit\nEnter the choice ");
      choice = sc.nextInt();
      if(choice == 1) railFence();
      else if(choice == 2) transposition();
      else break;
    } while(choice != 3);
    sc.close();
  }
}
