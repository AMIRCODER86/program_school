import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static SchedulingSolution chinesh(SchedulingSolution solution) throws IOException {
        int[] day_and_hour = solution.getNextHour();
        if (day_and_hour[0] == -1 ){
            solution.compeleted = true;
            return solution;
        }
        ArrayList <String> list_lesson = solution.getListLeson(day_and_hour[0], day_and_hour[1]);
        if(list_lesson.isEmpty()){
            return solution;
        }
        for (String lesson : list_lesson){
            solution.assignHour(day_and_hour[0], day_and_hour[1], lesson);
            SchedulingSolution solution_new = solution.copy();
            SchedulingSolution solution1 = chinesh(solution_new);
           if (solution1.compeleted){
               return solution1;
           }
        }
        return solution;
    }
    public static void main(String[] args) throws IOException {
        SchedulingProblem problem = new SchedulingProblem();
        problem.readJsonTeachers("D:\\json_teacher.txt");
        problem.readJsonNiaz("D:\\niaz.txt");
        SchedulingSolution solution = new SchedulingSolution();
        solution.readJsonclass1("D:\\json_class2.txt");
        solution.getArrayClass();
        System.out.println( CheckRightClassprogram.checker(problem,solution));
        solution = chinesh(solution);
        solution.print();


















//        for (int x = 0; x < 15; x++){

//            //System.out.println(solution.getListLeson(day_and_hour[0], day_and_hour[1]));
//            try {
//                solution.assignHour(day_and_hour[0], day_and_hour[1], list_lesson.get(0));
//
//            }
//            catch (Exception e){
//                solution.assignHour(day_and_hour[0], day_and_hour[1], "hichi");
//            }
//        }
//        System.out.println(Arrays.deepToString(solution.class1));
//        File f=new File(Main.class.getResource("niaz.json").getPath());
//        JSONObject j=new JSONObject(f);
//        for (int i=0;i<12;i++){
//            System.out.println(j.getJSONObject(String.valueOf(i)).getString("0"));
//        }
    }
}