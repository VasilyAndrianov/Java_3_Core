package Home_work_2;

import java.sql.*;

public class Main {
    private static Connection conn;
    private static Statement st;


    public static void main(String[] args){

        connect();
        newTable("users");
//        newUser("john", 355674535);
//        newUser("john2", 35446535);
//        newUser("john3", 358909-4535);
//        newUser("john4", 354457535);
//        userInfo(3);
//        delUser(1);
//        dellTabel("users");
        disconnect();
    }

    public static void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:main.db");
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try{
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void newTable(String str){
        try {
            st.executeUpdate("CREATE TABLE " + str + " (" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " name TEXT, " +
                    " number INTEGER)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void newUser(String name, int number) {
        try {
            st.executeUpdate("INSERT INTO users (name, number) VALUES ('" + name + "', " + number + ");");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void userInfo(int id) {
           try {
               ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id =" + id);
               System.out.println(rs.getString("name") + " - " + rs.getString("number"));
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }

    }

    public static void delUser(int id){
       try {
           st.executeUpdate("DELETE FROM users WHERE id =" + id);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }

    public static void dellTabel(String tabel){
       try {
           st.executeUpdate("DROP TABLE " + tabel);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }



}
