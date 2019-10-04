/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risenquicktool;

/**
 *
 * @author tguyer
 */
public class QuickToolConfig {
    private static QuickToolConfig instance = null;
    
    public String accessCode;
    public boolean isValidAccessCode;
    
    private QuickToolConfig() {
        this.isValidAccessCode = false;
        this.accessCode = "";
    }
    
    public static QuickToolConfig getInstance() {
        if (instance == null) {
            instance = new QuickToolConfig();
        }
        return instance;
    }
    
    public void setIsValidAccessCode(boolean isValid) {
        getInstance().isValidAccessCode = isValid;
    }
    public boolean getIsValidAccessCode() {
        return getInstance().isValidAccessCode;
    }
    
    public String getConnectionUrl() {
        HashTool ht = new HashTool();
        QuickToolFileReader qtfr = new QuickToolFileReader(Constants.SECRETS_FILE);
        return ht.unhash(
                (String) qtfr.getFileInfo().get("connectionUrl"));
    }
    
    public String getUserName() {
        HashTool ht = new HashTool();
        QuickToolFileReader qtfr = new QuickToolFileReader(Constants.SECRETS_FILE);
        return ht.unhash(
                (String) qtfr.getFileInfo().get("userName"));
    }

    public String getPasswordHaHAha() {
        HashTool ht = new HashTool();
        QuickToolFileReader qtfr = new QuickToolFileReader(Constants.SECRETS_FILE);
        return ht.unhash(
                (String) qtfr.getFileInfo().get("lolhaa"));
    }
}
