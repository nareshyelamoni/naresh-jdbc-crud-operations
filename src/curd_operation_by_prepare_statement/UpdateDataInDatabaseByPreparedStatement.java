package curd_operation_by_prepare_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDataInDatabaseByPreparedStatement {
    public static void main(String[] args) {
        Connection connect=null;
        PreparedStatement pstmt=null;
        try{
            connect=JdbcUtil.getConnection();
            String sql="UPDATE studentInfo SET scity=? WHERE id=?";
            pstmt=connect.prepareStatement(sql);
            Scanner scan=new Scanner(System.in);
            System.out.println("enter your id");
            Integer id=scan.nextInt();
            System.out.println("enter your city");
            String city=scan.next();
            pstmt.setString(1,city);
            pstmt.setInt(2,id);
            int rowsAffected=pstmt.executeUpdate();
            if(rowsAffected==0){
                System.out.println("unable to update data");
            }else{
                System.out.println("Data updated successfully");
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
