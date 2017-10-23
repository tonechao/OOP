
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tone
 */
public class ConfigManager {

    private static String data = "{\"configs\":["
            + "{\"ext\":\"cs\",\"location\":\"c:\Projects\",\"subDirectory\":\"true\",\"unit\":\"file\",\"remove\":\"false\",\"handler\":\"zip\",\"destination\":\"directory\",\"dir\":\"c:\MyArchieves\",\"connectionString\":\"\"},"
            + "{\"ext\":\"DOCX\",\"location\":\"c:\Documents\",\"subDirectory\":\"true\",\"unit\":\"file\",\"remove\":\"false\",\"handler\":\"encode\",\"destination\":\"db\",\"dir\":\"\",\"connectionString\":\"MyConnectionString\"},"
            + "{\"ext\":\"jpg\",\"location\":\"c:\Pictures\",\"subDirectory\":\"true\",\"unit\":\"file\",\"remove\":\"false\",\"handler\":\"\",\"destination\":\"directory\",\"dir\":\"c:\MyArchieves\",\"connectionString\":\"\"}]}";
    private List<Config> configs;
    private int count;

    public void processConfigs() {
        try {
            configs = new ArrayList<>();
            JSONObject j = new JSONObject(data);
            int number = j.getJSONArray("configs").length();
            for (int i = 0; i < number; i++) {
                Config c = new Config();
                c.setConnectionString((String) j.getJSONArray("configs").getJSONObject(i).get("connectionString"));
                c.setDestination((String) j.getJSONArray("configs").getJSONObject(i).get("destination"));
                c.setDir((String) j.getJSONArray("configs").getJSONObject(i).get("dir"));
                c.setExt((String) j.getJSONArray("configs").getJSONObject(i).get("ext"));
                c.setHandler((String) j.getJSONArray("configs").getJSONObject(i).get("handler"));
                c.setLocation((String) j.getJSONArray("configs").getJSONObject(i).get("location"));
                c.setRemove((String) j.getJSONArray("configs").getJSONObject(i).get("remove"));
                c.setSubDirectory((String) j.getJSONArray("configs").getJSONObject(i).get("subDirectory"));
                c.setUnit((String) j.getJSONArray("configs").getJSONObject(i).get("unit"));
                configs.add(c);
            }
        } catch (JSONException ex) {
            Logger.getLogger(ScheduleManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCount() {
        return count = configs.size();
    }

    public void getSchedule() {
        for (Config data : configs) {
            System.out.println("connectionString: " + data.getConnectionString());
            System.out.println("destination: " + data.getDestination());
            System.out.println("dir: " + data.getDir());
            System.out.println("ext: " + data.getExt());
            System.out.println("handler: " + data.getHandler());
            System.out.println("location: " + data.getLocation());
            System.out.println("remove: " + data.getRemove());
            System.out.println("subdirectory: " + data.getSubDirectory());
            System.out.println("unit: " + data.getUnit());
        }
    }

    public static void main(String[] args) {
        ConfigManager m = new ConfigManager();
        m.processConfigs();
        System.out.println(m.getCount());
        m.getSchedule();
    }

}
