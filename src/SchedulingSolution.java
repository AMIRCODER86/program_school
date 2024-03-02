import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SchedulingSolution {
    public JSONObject json_class1;
    public String class1[][] = new String[5][3];
    private HashMap<String, Integer> assigned_hours = new HashMap<String, Integer>();
   private SchedulingProblem problem = new SchedulingProblem();
    public SchedulingSolution(){
        for (int item_json_niaz = 0; item_json_niaz < 12; item_json_niaz++){
            assigned_hours.put(problem.json_niaz.getJSONObject(String.valueOf(item_json_niaz)).getString("0"), 0);
        }
    }
    public void readJsonclass1(String address_file) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(address_file));
        String json_class1_read = "";
        String readjson;
        while ((readjson = input.readLine()) != null) {
            json_class1_read = json_class1_read + readjson;
        }
         this.json_class1 = new JSONObject(json_class1_read);
    }
    public void getArrayClass(){
        for (int class_day_number = 0 ; class_day_number < 5 ; class_day_number++) {
            for (int bell_number_class = 0 ; bell_number_class < 3 ; bell_number_class++) {
                class1[class_day_number][bell_number_class] = json_class1.getJSONObject(String.valueOf(class_day_number)).getString(String.valueOf(bell_number_class));
            }
        }
    }
    public void printProblem(String address_file) throws FileNotFoundException {
        PrintWriter print=new PrintWriter(address_file);
        for (int class_day_number = 0 ; class_day_number < 5 ; class_day_number++ ){
            for (int bell_number_class = 0 ; bell_number_class < 3 ; bell_number_class++){
                print.println();
            }
        }
    }
    public int[] getNextHour(){
        int next_hour[] = new int[2];
        for(int class_day_number = 0 ; class_day_number < 5 ; class_day_number++){
            for (int bell_number_class = 0 ; bell_number_class < 3 ; bell_number_class++){
                if (class1[class_day_number][bell_number_class].equals("null")) {
                    System.out.println(class_day_number+"_"+bell_number_class);
                    break;
                }
            }
        }
        return next_hour;
    }
    public int getAssignedHours(String lesson){
        return 0;
    }
    public boolean assignHour(int day, int hour, String lesson){
        class1[day][hour]=lesson;
        assigned_hours.replace(lesson, assigned_hours.get(lesson)+1);
        return true;
    }
    public ArrayList<String> getListLeson(int day, int hour) {
        ArrayList <String> list_lesson = new ArrayList<String>();
        for (int counter_teacher = 0; counter_teacher < 12; counter_teacher++){
            for (int counter_lesson = 0; counter_lesson < 12; counter_lesson++) {
                if (problem.teacher_avaialability[counter_teacher][day][hour].equals(problem.json_niaz.getJSONObject(String.valueOf(counter_lesson)).getString("0"))){
                    if (assigned_hours.get(problem.json_niaz.getJSONObject(String.valueOf(counter_lesson)).getString("0")) < Integer.valueOf(problem.json_niaz.getJSONObject(String.valueOf(counter_lesson)).getString("naiz"))){
                        list_lesson.add(problem.json_niaz.getJSONObject(String.valueOf(counter_lesson)).getString("0"));
                    }
                }
            }
        }
        return list_lesson;
    }
}