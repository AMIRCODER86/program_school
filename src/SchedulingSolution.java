import org.json.JSONObject;

import java.io.*;

public class SchedulingSolution {
    public JSONObject json_class1;
    public String class1[][] = new String[5][3];
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
    public void getNextHour(){
        for(int class_day_number = 0 ; class_day_number < 5 ; class_day_number++){
            for (int bell_number_class = 0 ; bell_number_class < 3 ; bell_number_class++){
                if (class1[class_day_number][bell_number_class].equals("null")) {
                    System.out.println(class_day_number+"_"+bell_number_class);
                    break;
                }
            }
        }
    }
}