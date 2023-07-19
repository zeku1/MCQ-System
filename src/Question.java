import java.sql.Array;
import java.util.ArrayList;

public class Question {


    private String[][] QuestionAnswer;
    private int index = 0;

    public Question(String[][] s){
        this.QuestionAnswer = s;
    }


    public void printQuestion(){
        System.out.println(QuestionAnswer[index][0]);
    }

    public void printOptions(){
        System.out.println("A. "+ QuestionAnswer[this.index][1] +
                "\nB. "+ QuestionAnswer[this.index][2] +
                "\nC. "+ QuestionAnswer[this.index][3] +
                "\nD. "+ QuestionAnswer[this.index][4]);
    }

    public int getLenght() {
        return this.QuestionAnswer.length;
    }

    public boolean hasNextQuestion() {
        if(this.index < getLenght()){
            return true;
        }else {
            return false;
        }
    }

    public void nextQuestion(){
        this.index++;
    }

    public boolean checkAnswer(String answer) {

        if(answer.startsWith(String.valueOf(QuestionAnswer[this.index][5].charAt(1)))){
            return true;
        }else{
            return false;
        }
    }

    public String getRightAnswer() {
        return QuestionAnswer[this.index][5];
    }
}

