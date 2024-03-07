import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        SchedulingProblem problem = new SchedulingProblem();
        problem.readJsonTeachers(Main.class.getResource("teacher.json").getPath());
        problem.readJsonNiaz("D:\\niaz.txt");
        SchedulingSolution solution = new SchedulingSolution();
        solution.readJsonclass1("D:\\json_class2.txt");
        solution.getArrayClass();
        System.out.println( CheckRightClassprogram.checker(problem,solution));
        int day_and_hour[] = new int[2];
        for (int x = 0; x < 15; x++){
        ArrayList <String> list_lesson = new ArrayList<String>();
        day_and_hour = solution.getNextHour();
        list_lesson = solution.getListLeson(day_and_hour[0], day_and_hour[1]);
            //System.out.println(solution.getListLeson(day_and_hour[0], day_and_hour[1]));
            try {
                solution.assignHour(day_and_hour[0], day_and_hour[1], list_lesson.get(0));

            }
            catch (Exception e){
                solution.assignHour(day_and_hour[0], day_and_hour[1], "hichi");
            }
        }
        System.out.println(Arrays.deepToString(solution.class1));
    }
}