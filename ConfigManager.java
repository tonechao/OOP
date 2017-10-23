
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
            + "{\"ext\":\"cs\",\"location\":\"c:\Projects\",\"subDirectory\":true,\"unit\":\"file\",\"remove\":false,\"handler\":\"zip\",\"destination\":\"directory\",\"dir\":\"c:\MyArchieves\",\"connectionString\":\"\"},"
            + "{\"ext\":\"DOCX\",\"location\":\"c:\Documents\",\"subDirectory\":true,\"unit\":\"file\",\"remove\":false,\"handler\":\"encode\",\"destination\":\"db\",\"dir\":\"\",\"connectionString\":\"MyConnectionString\"},"
            + "{\"ext\":\"jpg\",\"location\":\"c:\Pictures\",\"subDirectory\":true,\"unit\":\"file\",\"remove\":false,\"handler\":\"\",\"destination\":\"directory\",\"dir\":\"c:\MyArchieves\",\"connectionString\":\"\"}]}";
    private List<Config> configs;
    private int count;

    public void processConfigs() {
        try {
            configs = new ArrayList<>();
            JSONObject j = new JSONObject(data);
            int number = j.getJSONArray("configs").length();
            for (int i = 0; i < number; i++) {
                Config c = new Config();
                c.setConnectionString(j.getJSONArray("configs").getJSONObject(i).getString("connectionString"));
                c.setDestination(j.getJSONArray("configs").getJSONObject(i).getString("destination"));
                c.setDir(j.getJSONArray("configs").getJSONObject(i).getString("dir"));
                c.setExt(j.getJSONArray("configs").getJSONObject(i).getString("ext"));
                c.setHandler(j.getJSONArray("configs").getJSONObject(i).getString("handler"));
                c.setLocation(j.getJSONArray("configs").getJSONObject(i).getString("location"));
                c.setRemove(j.getJSONArray("configs").getJSONObject(i).getBoolean("remove"));
                c.setSubDirectory(j.getJSONArray("configs").getJSONObject(i).getBoolean("subDirectory"));
                c.setUnit(j.getJSONArray("configs").getJSONObject(i).getString("unit"));
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
