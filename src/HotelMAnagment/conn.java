package HotelMAnagment;

import java.sql.*;

class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms?autoReconnect=true&useSSL=false","root","");
            s = c.createStatement();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
//jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false