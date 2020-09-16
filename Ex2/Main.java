import java.util.*;

class Main {
  public static void main(String[] args) {
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("1. HillCipher\n2. VigenereCipher\n3. Exit\nEnter your choice: ");
      choice = sc.nextInt();

      if(choice == 1) new HillCipher();
      else if(choice == 2) new VigenereCipher();
      else break;
    } while(choice != 3);
    sc.close();
  }
}
