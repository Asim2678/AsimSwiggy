package RestAPI;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibReqRsData {
    String strName = "Niranjana";
    String strRole = "TL";

    public String getStrName(){
        return strName;
    }
    public void setStrName (String strName){
        this.strName = strName;

    }
    public String getStrRole(){
        return strRole;
    }
    public void setStrRole(String strRole){
        this.strRole= strRole;
    }
    public JSONObject DataJsonCreateUser(){
        JSONObject jsonUserData = new JSONObject(        );
        jsonUserData.put("name", strName);
        jsonUserData.put("job", strRole);
        return jsonUserData;
    }

    public String ReadfileToString(){
        String strpostData = "";
        String strPath = "C:\\Users\\mabassra.SCT\\Downloads\\postrequestdata.json";
        Path path = Paths.get(strPath);
        try {
            strpostData = new String(Files.readAllBytes(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return strpostData;
    }

}
