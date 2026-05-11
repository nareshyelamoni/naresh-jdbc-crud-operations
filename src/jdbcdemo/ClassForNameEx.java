package jdbcdemo;

import java.sql.DriverManager;

class Demo{
    static {
        System.out.println("static block");
    }
    {
        System.out.println("instance block--->Non static block");
    }
}
public class ClassForNameEx {
    public static void main(String[] args) {
        try{
            //Class.forName("jdbcdemo.Demo");
            Class.forName("jdbcdemo.Demo").newInstance();
            //DriverManager.registerDriver(new jdbcdemo.Demo());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            //throw new RuntimeException(e);
            System.out.println("exception occur");
        }
    }
}
