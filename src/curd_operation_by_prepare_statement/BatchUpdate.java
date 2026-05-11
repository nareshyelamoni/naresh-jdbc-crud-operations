package curd_operation_by_prepare_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Arrays;

public class BatchUpdate {
    public static void main(String[] args) {
        Connection connect=null;
        PreparedStatement pstmt=null;
        try{
            connect=JdbcUtil.getConnection();
            String sql="UPDATE studentInfo SET scity=? WHERE id=?";
            pstmt=connect.prepareStatement(sql);
            Scanner scan=new Scanner(System.in);
            System.out.println("update information: ");
            System.out.println("enter your id");
            Integer id=scan.nextInt();
            System.out.println("enter your city");
            String city=scan.next();
            pstmt.setString(1,city);
            pstmt.setInt(2,id);
            pstmt.addBatch();
            System.out.println("enter your id");
            Integer sid=scan.nextInt();
            System.out.println("enter your city");
            String sscity=scan.next();
            pstmt.setString(1,sscity);
            pstmt.setInt(2,sid);
            pstmt.addBatch();

            int[] arr=pstmt.executeBatch();
            System.out.println(Arrays.toString(arr));

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
