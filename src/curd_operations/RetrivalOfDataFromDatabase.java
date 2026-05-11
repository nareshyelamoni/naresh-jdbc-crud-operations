package curd_operations;

import java.sql.*;

public class RetrivalOfDataFromDatabase {
    public static void main(String[] args) {
        Connection connect=null;
        Statement stmt=null;
        try{
            //loading and registering driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //establish the connection
            String url="jdbc:mysql://localhost:3307/jdbclearning";
            String user="root";
            String password="Naresh@123";
            connect= DriverManager.getConnection(url,user,password);
            //creating statement Object
            stmt=connect.createStatement();
            //execute the query
            String sql="SELECT * FROM studentInfo";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("sname")+" "+rs.getInt("sage")+" "+rs.getString("scity"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e1){
            e1.printStackTrace();
        }catch (Exception e2){
            e2.printStackTrace();
        }
        finally {
            try{
                stmt.close();
                connect.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
