package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDeDatos {
    public static void baseDeDatos() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argpro", "root", "332211");
            Statement stmt = con.createStatement();

            ResultSet rs=stmt.executeQuery("SELECT * FROM pronostico");
            while(rs.next()) System.out.println(rs.getString(1)+ " "+ rs.getString(2) + " "+ rs.getString(3)+ " "+ rs.getString(4));




            stmt.close();

        } catch(Exception e) {System.out.println(e.getMessage());}
    }
}
