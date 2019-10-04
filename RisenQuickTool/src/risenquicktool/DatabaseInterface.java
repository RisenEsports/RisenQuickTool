/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risenquicktool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tguyer
 */
public class DatabaseInterface {
    Connection conn = null;
    
    public DatabaseInterface() {
        QuickToolConfig qtc = QuickToolConfig.getInstance();
        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://" + qtc.getConnectionUrl() +
                            "user=" + qtc.getUserName() + "&password=" +
                            qtc.getPasswordHaHAha() + "");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkAccessCode(String accessCode) {
        boolean isValid = false;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM api_access_codes WHERE code='" + accessCode + "'");
            if (rs.getString("code").equals(accessCode)) {
                isValid = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return isValid;
    }
}
