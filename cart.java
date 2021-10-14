import java.sql.*;
import java.util.Scanner;

public class cart {
    Scanner sc = new Scanner(System.in);
    String addr = "jdbc:mysql://localhost:3306/book_store";
    String username = "root";
    String password = "root";
    Connection conn = null;
    Statement stm;
    int flag=0;

    public void addBookToCart(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            System.out.println("enter book name");
            String book_name = sc.next();
            System.out.println("enter no of copies");
            int noc = sc.nextInt();
            String sql1 = "insert into cart values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, book_name);
            ps.setInt(2, id);
            ps.setInt(3, noc);
            ps.execute();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void deleteBookFromCart() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            System.out.println("enter the book name to delete");
            String book_name = sc.next();
            String sql = "delete from cart where book_name=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, book_name);
            psm.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }

    public void displayBookFromCart() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            String sql = "select * from cart";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("book name=" + rs.getString(1) + " user Id=" + rs.getInt(2) + " No of copies=" + rs.getInt(3));
            }

            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }

    public void checkUserInList() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);

            System.out.println("enter username");
            String uname = sc.next();
            String sql = "select * from user";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(2).equals(uname)) {
                    int id = rs.getInt(1);
                    flag=1;
                    addBookToCart(id);
                }
            }
            if(flag==0){
                System.out.println("user does not exist");
            }

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
}
