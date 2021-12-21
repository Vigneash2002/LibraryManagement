/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendBook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nsivaakumaar
 */
public class SendBook {
    public static boolean retrive(SendBookBean ob) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","oracle");
            String query="select \"file\" from ebook where \"isbn\"=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,ob.getisbn_number());
            ResultSet rst = pstmt.executeQuery();
            File f = new File(ob.getbook_name()+".pdf");
	    FileOutputStream output = new FileOutputStream(f);
            if (rst.next()) {
                InputStream input = rst.getBinaryStream("file");
                System.out.println("Reading resume from database...");

                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                System.out.println("\nSaved to file: " + f.getAbsolutePath());

                System.out.println("\nCompleted successfully!");
                ob.setfile_path(f.getAbsolutePath());
                SendMail.sendbook(ob);
            }
            con.close();
            System.out.println("success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
