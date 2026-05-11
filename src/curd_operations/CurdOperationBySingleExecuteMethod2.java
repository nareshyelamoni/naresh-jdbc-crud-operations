package curd_operations;

import java.sql.*;

public class CurdOperationBySingleExecuteMethod2 {
    public static void main(String[] args) {
        Connection connect=null;
        Statement stmt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3307/jdbclearning";
            String user="root";
            String password="Naresh@123";
            connect= DriverManager.getConnection(url,user,password);
            stmt=connect.createStatement();
            String sql="SELECT * FROM studentInfo Where sage>18";
            boolean status=stmt.execute(sql);
            if(status){
                ResultSet rs=stmt.getResultSet();
                while (rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
                }
            }else{
                int rowsAffected=stmt.getUpdateCount();
                if(rowsAffected==0){
                    System.out.println("unable to insert the record");
                }else{
                    System.out.println("Data inserted successfully");
                }
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                stmt.close();
                connect.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}
