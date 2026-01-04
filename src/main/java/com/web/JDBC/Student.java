package com.web.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Student
{
    public void createDatabase()
    {
        try {
            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";

            Connection con = DriverManager.getConnection(url, username, password);


            Statement st = con.createStatement();

            String query = "create database WebhavInfo";


            st.execute(query);

            System.out.println("Database created successfully ");
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable()
    {
        try {
//            String db = "WebhavInfo";
            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";;

            Connection con = DriverManager.getConnection(url, username, password);


            Statement st = con.createStatement();

            String query = "create table student(sid int(3),sname varchar(100),semail varchar(200) )";


            st.execute(query);

            System.out.println("Table created successfully ");
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    C R U D
    public void createData()
    {
        try {
            String db="WebhavInfo";
            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";

            Connection con = DriverManager.getConnection(url+db, username, password);

            String query = "INSERT into student (sid, sname, semail) VALUES (?,?,?)";

            PreparedStatement pstm = con.prepareStatement(query);
//            pstm.setInt(1,10);
//            pstm.setString(2,"vaibhav");
//            pstm.setString(3,"vaibhav@gmail.com");

            pstm.setInt(1,12);
            pstm.setString(2,"Boom");
            pstm.setString(3,"Boom@gmail.com");
            pstm.execute();

//            pstm.executeUpdate();
//

            System.out.println("Data inserted successfully ");
            pstm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData()
    {
        try {

            String db = "WebhavInfo";

            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";;

            Connection con = DriverManager.getConnection(url+db, username, password);

            String query = "Select * from student";

            Statement st = con.createStatement();

           ResultSet rs =  st.executeQuery(query);

//           process result
           while(rs.next()){
               System.out.println("id = " + rs.getInt(1)+", "+ " name = "+" " + rs.getString(2)+", "+" email =  " + rs.getString(3));
           }

            System.out.println("readed successfully.... ");
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData()
    {
        try {
            String db = "WebhavInfo";
            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";;

            Connection con = DriverManager.getConnection(url+db, username, password);

            String query = "UPDATE student set sid = ? where sname =?";

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,19);
            pstm.setString(2,"navin");
           //jha bache ka naam boom ho vha sid 13 set krdo
            pstm.execute();

            System.out.println("Data updated successfully ");
            pstm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        try {
            ;
            String db = "WebhavInfo";

            String url = "jdbc:mysql://localhost:0000/";
            String username = "Enter your root name";
            String password = "Enter db password";
            Connection con = DriverManager.getConnection(url+db, username, password);

            String query = "DELETE from student WHERE sid = ?";

            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,19);
            pstm.execute();

            System.out.println("User deleted successfully ");
            pstm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
