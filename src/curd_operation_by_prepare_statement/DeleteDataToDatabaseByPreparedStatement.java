package curd_operation_by_prepare_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDataToDatabaseByPreparedStatement {
    public static void main(String[] args) {
        Connection connect=null;
        PreparedStatement pstmt=null;
        try{
            connect=JdbcUtil.getConnection();
            String sql="DELETE FROM studentInfo WHERE id=?";
            pstmt=connect.prepareStatement(sql);
            System.out.println("please enter delete profile details");
            Scanner scan=new Scanner(System.in);
            System.out.println("enter delete profile  id");
            Integer id=scan.nextInt();
            pstmt.setInt(1,id);
            int rowsAffected=pstmt.executeUpdate();
            if(rowsAffected==0){
                System.out.println("unable to insert data");
            }else{
                System.out.println("Data deleted successfully");
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
