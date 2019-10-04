/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risenquicktool;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author tguyer
 */
public class QuickToolFileReader {
    private String fileName = "";
    
    public QuickToolFileReader(String fileName) {
        this.fileName = fileName;
    }
    
    public JSONObject getFileInfo() {
        JSONParser parser = new JSONParser();
        JSONObject fileInfo = null;
        try {
            Object obj = parser.parse(new FileReader(
                this.getFileName()));
            fileInfo = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fileInfo;
    }
    
    private String getFileName() {
        return this.fileName;
    }
}
