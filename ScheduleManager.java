
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
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
public class ScheduleManager {

    private static String data = "{\"schedules\":[{\"ext\":\"cs\",\"time\":\"12:00\",\"interval\":\"Everyday\"},{\"ext\":\"docx\",\"time\":\"20:00\",\"interval\":\"Everyday\"},{\"ext\":\"jpg\",\"time\":\"7:00\",\"interval\":\"Monday\"}]}";
    private List<Schedule> schedules;
    private int count;

    public void processSchedules() {
        try {
            schedules = new ArrayList<>();
            JSONObject j = new JSONObject(data);
            int number = j.getJSONArray("schedules").length();
            for (int i = 0; i < number; i++) {
                Schedule s = new Schedule();
                s.setExt((String) j.getJSONArray("schedules").getJSONObject(i).get("ext"));
                s.setTime((String) j.getJSONArray("schedules").getJSONObject(i).get("time"));
                s.setInterval((String) j.getJSONArray("schedules").getJSONObject(i).get("interval"));
                schedules.add(s);
            }
        } catch (JSONException ex) {
            Logger.getLogger(ScheduleManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCount() {
        return count = schedules.size();
    }

    public void getSchedule() {
        for (Schedule data : schedules) {
            System.out.println("ext: " + data.getExt());
            System.out.println("interval: " + data.getInterval());
            System.out.println("time: " + data.getTime());
        }
    }

    public static void main(String[] args) {
        ScheduleManager m = new ScheduleManager();
        m.processSchedules();
        System.out.println(m.getCount());
        m.getSchedule();
    }

}
