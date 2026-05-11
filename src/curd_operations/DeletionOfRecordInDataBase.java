package curd_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletionOfRecordInDataBase {
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
            String sql="DELETE FROM studentInfo WHERE id=5";
            int rowAffect=stmt.executeUpdate(sql);
            if (rowAffect == 0) {
                System.out.println("unable to delete the record");
            }else{
                System.out.println("Data deleted successfully");
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
