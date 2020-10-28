import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        SHA sha = new SHA();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
          System.out.print("1. Hashing\n2. Exit\nEnter your choice: ");
          choice = sc.nextInt();
          sc.nextLine();
          if(choice == 1) {
            System.out.print("Enter the plain text: ");
            String word = sc.nextLine();

            String binary = sha.convertToBinary(word);
            sha.messLength = binary.length();
            String hashValue = sha.hashString(word, binary);
            System.out.println("Secure hashed value: " + hashValue);
          }
        } while(choice != 2);
    }
}