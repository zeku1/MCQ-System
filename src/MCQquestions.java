public class MCQquestions {
    private int number;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;

    public MCQquestions(int number){ this.number = number; }

    public void setQuestion(String question){ this.question = question; }

    public void setA(String a) { this.a = a; }

    public void setB(String b) { this.b = b; }

    public void setC(String c) { this.c = c; }

    public void setD(String d) { this.d = d; }

    public void setAnswer(String answer) { this.answer = answer; }

    public int getNumber() { return number; }

    public String getQuestion(){ return this.question; }

    public String getA(){ return this.a; }

    public String getB(){ return this.b; }

    public String getC(){ return this.c; }

    public String getD(){ return this.d; }

    public String getAnswer() { return answer; }

    public String toString(){
        return String.format("%d) %s, %s, %s, %s, %s, %s", getNumber(),getQuestion(),getA(),getB(),getC(),getD(),getAnswer() );
    }
}
