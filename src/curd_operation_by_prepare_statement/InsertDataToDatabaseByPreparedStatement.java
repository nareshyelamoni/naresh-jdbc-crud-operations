package curd_operation_by_prepare_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataToDatabaseByPreparedStatement {
    public static void main(String[] args) {
        Connection connect=null;
        PreparedStatement pstmt=null;
        try{
            connect=JdbcUtil.getConnection();
            String sql="INSERT INTO studentInfo(id,sname,sage,scity)VALUES(?,?,?,?)";
            pstmt=connect.prepareStatement(sql);
            System.out.println("please enter your details");
            Scanner scan=new Scanner(System.in);
            System.out.println("enter your id");
            Integer id=scan.nextInt();
            System.out.println("enter your name");
            String name=scan.next();
            System.out.println("enter your age");
            Integer age=scan.nextInt();
            System.out.println("enter your city");
            String city=scan.next();
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setInt(3,age);
            pstmt.setString(4,city);
            int rowsAffected=pstmt.executeUpdate();
            if(rowsAffected==0){
                System.out.println("unable to insert data");
            }else{
                System.out.println("Data inserted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        finally {
            try{
                JdbcUtil.closeConnection(connect,pstmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
