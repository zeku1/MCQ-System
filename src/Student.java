public class Student {

    private String name;
    private int score = 0;
    private int items;

    public Student(){}

    public void setName(String name){ this.name = name; }

    public String getName(){ return this.name; }

    public void addScore() { this.score++; }

    public int getScore(){ return this.score; }

    public void setItems(int items){ this.items = items; }

    public int getItems(){ return this.items; }

    public int mistakes(){
        return getItems() - getScore();
    }

    public int grades(){
        double grade = ((double) getScore()/getItems())*100;
        return (int)grade;
    }


}
