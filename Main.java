
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Operations op=new Operations();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Book Store \n2.User\n3.cart \n4.exit");
            System.out.println("enter the choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: op.bookOperation();
                    break;
                case 2:op.userOperation();
                    break;
                case 3:op.cartOperation();
                    break;
                case 4:System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }
}
