import java.io.*;
import java.util.*;

/*
 *
 *
 *
 *
 */

public class main {

    public static void main(String[] args) {

        //**********************************************//
        //**************Getting users name**************//
        //**********************************************//
        Scanner s = new Scanner(System.in);

        Student student = new Student();

        System.out.print("Enter your Name: ");
        student.setName(s.nextLine());

        System.out.println("\nWelcome to MCQ test " + student.getName() + "!\n");

        //**********************************************//
        //*************Choosing MCQ set*****************//
        //**********************************************//

        System.out.println("Choose your Multiple Choice Question Set. The Options are :");

        File f = new File("src/MCQ");// folder of the mcq sets
        File files[] = f.listFiles();

        for(File file : files){
            System.out.println(file.getName().replace(".csv",""));
        }

        System.out.print("Your choice: ");
        String choice = "";
        String testPath = "";

        boolean go = false;

        //*********Getting and comparing users MCQ choice**********//

        while (!go) {

            choice = s.nextLine();
            testPath = findPathOfChoice(files,choice);

            if(testPath == null){
                go = false;
            }else {
                go = true;
            }

        }

        //******************************************************//
        //*******************READING CSV FILE******************//

        //putting file content to 2d array
        Question ques = new Question(MCQto2dArray(testPath));



        //****************************************************//
        //*Taking and comparing the answer input of the user*//
        //****************************************************//

        System.out.println("\nMCQ for " + choice.toUpperCase() + " Start!\n");

        boolean next = true;
        while(next){

            ques.printQuestion();
            ques.printOptions();

            System.out.print("Your Answer is ");
            String answer = s.next().toUpperCase();

            if(ques.checkAnswer(answer)){
                System.out.println("You are Right! The Answer is "
                        + ques.getRightAnswer() + "\n");
                student.addScore();
            }else {
                System.out.println("Wrong Answer. The Correct Answer is "
                        + ques.getRightAnswer() + "\n");
            }

            ques.nextQuestion();
            next = ques.hasNextQuestion();
        }

        //*******************************************//
        //************Calculating Result*************//

        student.setItems(ques.getLenght());

        System.out.println("\n" + student.getName() + ", you answered " + student.getScore() +
                " Questions Right," + student.mistakes() +
                " Questions Wrong for a Total of " + student.getItems() + " Questions.\n" +
                "You scored " + student.grades() +"%");

    }


    public static String findPathOfChoice(File[] files, String choice) {

        String path = "";

        for (File file : files) {
            String f1 = file.getName().replace(".csv","");
            if (choice.equalsIgnoreCase(f1)) {
                path = file.getAbsolutePath();
                break;
            }
        }

        if(path.equals("")){
            System.out.println("It is not in the choices!\n" +
                    "Choose again. Your choice: ");
            return null;
        }else {
            return path;
        }

    }


    public static String[][] MCQto2dArray(String path){

        List<String> recordList = new ArrayList<>();
        String currentLine;

        FileReader fr = null;
        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            while( (currentLine = br.readLine()) != null){
                recordList.add(currentLine);
            }

            int recordCount = recordList.size();

            String arrayToReturn[][] = new String [recordCount][6];
            String[] data;

            for(int i = 0; i < recordCount; i++){
                data = recordList.get(i).split(",");
                for(int j = 0; j < data.length; j++){
                    arrayToReturn[i][j]=data[j];
                }
            }

            return arrayToReturn;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
