import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SchedulingProblem problem = new SchedulingProblem();
        problem.readJsonTeachers("D:\\json_teacher.txt");
        problem.readJsonNiaz("d:\\niaz.txt");
        SchedulingSolution solution = new SchedulingSolution();
        solution.readJsonclass1("D:\\json_class1.txt");
        solution.getArrayClass();
        System.out.println( CheckRightClassprogram.checker(problem,solution));
    }
}