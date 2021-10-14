import java.sql.*;
import java.util.Scanner;

public class user {
        Scanner sc=new Scanner(System.in);
        String addr = "jdbc:mysql://localhost:3306/book_store";
        String username = "root";
        String password = "root";
        Connection conn = null;
        Statement stm;
        public void addUser() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(addr, username, password);
                stm = conn.createStatement();
                System.out.println("enter user ID");
                int user_id=sc.nextInt();
                System.out.println("enter user name");
                String user_name=sc.next();
                System.out.println("enter password");
                String password=sc.next();
                System.out.println("enter the place");
                String place=sc.next();

                String sql = "insert into user values(?,?,?,?)";
                PreparedStatement psm = conn.prepareStatement(sql);
                psm.setInt(1, user_id);
                psm.setString(2, user_name);
                psm.setString(3, password);
                psm.setString(4, place);
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

        public void deleteUser(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(addr, username, password);
                stm = conn.createStatement();
                System.out.println("enter the user id to delete");
                String book_name = sc.next();
                String sql = "delete from user where user_id=?";
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
                String sql = "select * from user";
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("user ID=" + rs.getInt(1) + " name=" + rs.getString(2) + " password=" + rs.getString(3) + " place=" + rs.getString(4));
                }

                conn.close();
            } catch (ClassNotFoundException e) {

            } catch (SQLException e) {

            }
        }

        public void updateUser(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(addr, username, password);
                stm = conn.createStatement();
                System.out.println("enter the user name to update");
                String user_name = sc.next();
                System.out.println("enter the new user name");
                String updated_name=sc.next();
                String sql = "update user set username=? where username=?";
                PreparedStatement psm = conn.prepareStatement(sql);
                psm.setString(1, user_name);
                psm.setString(2,updated_name);
                psm.executeUpdate();

                conn.close();
            } catch (ClassNotFoundException e) {

            } catch (SQLException e) {

            }
        }
    }
