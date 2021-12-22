/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddEBook;

/**
 *
 * @author nsivaakumaar
 */
import java.io.*;
import java.sql.*;

public class AddBook {
    public static boolean getdetails(AddBookBean ob) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","oracle");
            String query = "select \"book\",\"fname\",\"lname\" from ebook where \"isbn\"=?";            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,ob.getisbn_number());
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                return false;     
            }            
            con.close();
            System.out.println("success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insert(AddBookBean ob) {
        if(!getdetails(ob)){
            return false;
        }
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","oracle");
            PreparedStatement ps = con.prepareStatement("insert into ebook values(?,?,?,?,?)");
            ob.getfile_path().trim();
            System.out.println(ob.getfile_path());
            File f = new File(ob.getfile_path());
            FileInputStream input = new FileInputStream(ob.getfile_path());
            ps.setString(1,ob.getisbn_number());
            ps.setString(2,ob.getbook_name());
            ps.setString(3,ob.getauthor_first_name());
            ps.setString(4,ob.getauthor_last_name());
            ps.setBinaryStream(5, input);
            System.out.println("Reading input file: " + f.getAbsolutePath());
            System.out.println("\nStoring resume in database: " + f);
            int i = ps.executeUpdate();
            System.out.println(i + " records affected");
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


