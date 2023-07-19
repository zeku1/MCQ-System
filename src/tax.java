import java.util.Scanner;

public class tax {

  public static void main(String[] args) {
    Scanner in = new Scanner (System.in);

    double pay = in.nextDouble();
    double monthlySalary = pay*2;
    double minSalary = 4249.99;
    double credit = 4000;
    double sssTax = 0;

    for(int i = 1; i < monthlySalary ; i++) {

      if(monthlySalary < minSalary) {
        sssTax = credit * 0.045;
      }else if (monthlySalary > (minSalary-499.99) && monthlySalary < minSalary) {
        sssTax = credit * 0.045;
      }

      if(i>=(4250-500)) {
        if(i%500 == 0) {
          minSalary += 500;
          credit += 500;
        }
      }
    }
    System.out.println(credit);
    System.out.println(minSalary);
    System.out.println(sssTax);
  }

}
