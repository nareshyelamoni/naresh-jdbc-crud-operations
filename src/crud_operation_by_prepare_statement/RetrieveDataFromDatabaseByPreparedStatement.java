package crud_operation_by_prepare_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrieveDataFromDatabaseByPreparedStatement {
    public static void main(String[] args) {
        Connection connect=null;
        PreparedStatement pstmt=null;
        try{
            connect=JdbcUtil.getConnection();
            String sql="SELECT * FROM studentInfo WHERE id=?";
            pstmt=connect.prepareStatement(sql);
            Scanner scan=new Scanner(System.in);
            System.out.println("enter profile  id");
            Integer id=scan.nextInt();
            pstmt.setInt(1,id);
            System.out.println("profile details");
            ResultSet rs =pstmt.executeQuery();
            while(rs.next()){
                System.out.println("ID: "+rs.getInt(1));
                System.out.println("Name: "+rs.getString(2));
                System.out.println("Age: "+rs.getInt(3));
                System.out.println("City: "+rs.getString(4));
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
