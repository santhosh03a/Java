import java.sql.*;
import java.util.Scanner;

class Operations{
    Book b=new Book();
    user u=new user();
    cart c=new cart();
    Scanner sc=new Scanner(System.in);
    public void bookOperation() {
        while(true){
            System.out.println("1.Insert\n2.delete\n3.display\n4.update\n5.Exit");
            int op=sc.nextInt();
            switch (op){
                case 1:b.insert();
                    break;
                case 2:b.delete();
                    break;
                case 3:b.display();
                    break;
                case 4:b.update();
                    break;
                case 5:System.exit(0);
                default:
                    System.out.println("enter a valid option");
                    break;
            }
        }
    }
    public void userOperation() {
        while(true){
            System.out.println("1.Insert\n2.delete\n3.display\n4.update\n5.Exit");
            int op=sc.nextInt();
            switch (op){
                case 1:u.addUser();
                    break;
                case 2:u.deleteUser();
                    break;
                case 3:u.display();
                    break;
                case 4:u.updateUser();
                    break;
                case 5:System.exit(0);
                default:
                    System.out.println("enter a valid option");
                    break;
            }
        }
    }
    public void cartOperation() {
        while(true){
            System.out.println("1.add book to cart\n2.delete a book from cart\n3.display\n4.Exit");
            int op=sc.nextInt();
            switch (op){
                case 1:c.checkUserInList();
                    break;
                case 2:c.deleteBookFromCart();
                    break;
                case 3:c.displayBookFromCart();
                    break;
                case 4:System.exit(0);
                default:
                    System.out.println("enter a valid option");
                    break;
            }
        }
    }
}


