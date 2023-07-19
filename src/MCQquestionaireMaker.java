import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MCQquestionaireMaker {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter MCQ name: ");
        String mcqName =  "src/MCQ/" + s.nextLine() + ".csv";

        File csvFile = new File(mcqName);
        PrintWriter out = new PrintWriter(csvFile);

        System.out.print("How many items do you want? ");
        int items = s.nextInt();
        s.nextLine();

        ArrayList<MCQquestions> ques = new ArrayList<>();

        for(int i =0; i < items; i++){
            MCQquestions q = new MCQquestions(i +1);
            System.out.print("Question " + (i+1) + ": ");
            q.setQuestion(s.nextLine());
            System.out.println("choice a: ");
            q.setA(s.nextLine());
            System.out.println("choice b: ");
            q.setB(s.nextLine());
            System.out.println("choice c: ");
            q.setC(s.nextLine());
            System.out.println("choice d: ");
            q.setD(s.nextLine());
            System.out.println("Answer: ");
            q.setAnswer(s.nextLine());
            s.nextLine();

            ques.add(q);
        }

        for(MCQquestions mcqQues : ques){
            out.println(mcqQues.toString());
        }

        out.close();
        System.out.println("MCQ questionaire is successfully created!");


    }
}

