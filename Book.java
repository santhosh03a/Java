import java.sql.*;
import java.util.Scanner;

public class Book {
    Scanner sc=new Scanner(System.in);
    String addr = "jdbc:mysql://localhost:3306/book_store";
    String username = "root";
    String password = "root";
    Connection conn = null;
    Statement stm;
    public void insert() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            System.out.println("enter book ID");
            int book_id=sc.nextInt();
            System.out.println("enter book name");
            String book_name=sc.next();
            System.out.println("enter book prize");
            float prize=sc.nextFloat();
            System.out.println("enter the no of copies");
            int no_of_copies=sc.nextInt();
            System.out.println("enter author name");
            String author=sc.next();
            System.out.println("enter year of publish");
            int year_of_publish=sc.nextInt();

            String sql = "insert into book values(?,?,?,?,?,?)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, book_id);
            psm.setString(2, book_name);
            psm.setFloat(3, prize);
            psm.setInt(4, no_of_copies);
            psm.setString(5, author);
            psm.setInt(6, year_of_publish);
            psm.execute();
            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            System.out.println("enter the book name to delete");
            String book_name = sc.next();
            String sql = "delete from book where book_name=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, book_name);
            psm.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }

    }
    public void display(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            String sql = "select * from book";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("book ID=" + rs.getInt(1) + " name=" + rs.getString(2) + " Prize=" + rs.getFloat(3) + " number of copies=" + rs.getInt(4) + " author=" + rs.getString(5) + " Year of Publish=" + rs.getInt(6));
            }

            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }

    public void update(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(addr, username, password);
            stm = conn.createStatement();
            System.out.println("enter the book name to update");
            String book_name = sc.next();
            System.out.println("enter the new book name");
            String updated_name=sc.next();
            String sql = "update book set book_name=? where book_name=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, book_name);
            psm.setString(2,updated_name);
            psm.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
}
