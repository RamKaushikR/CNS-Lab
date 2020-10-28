import java.util.*;

class Main {
  public static void main(String[] args) throws Exception  {
    int choice;
    Scanner sc = new Scanner(System.in);
    DSS dss = new DSS();
    do {
      System.out.print("1. Create Digital Signature\n2. Verify Digital Signature\n3. Exit\nEnter your choice: ");
      choice = sc.nextInt();
      sc.nextLine();

      if(choice == 1) {
        System.out.print("Enter plain text: ");
        String plainText = sc.nextLine();
        String signature = dss.createDigitalSignature(plainText);
        System.out.println("Digital Signature: " + signature);
      }
      else if(choice == 2) {
        System.out.print("Enter verification text: ");
        String verificationText = sc.nextLine();
        boolean verified = dss.verifyDigitalSignature(verificationText);

        if(verified)
          System.out.println("Digital Signature verified");
        else
          System.out.println("Digital Signature not verified");
      }
    } while(choice != 3);
  }
}