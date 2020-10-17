package Actionitem;

public class Assignment1 {

    public static void main(String[] args) {
        int grade = 50;

        if (grade >= 90 && grade <= 100) {
            System.out.println("the grade is A");
        } else if (grade >= 80 && grade <= 89) {
        System.out.println("the grade is B");
    }
        else if (grade >= 70 && grade <= 79) {
            System.out.println("the grade is C");
        }
        else if (grade>= 60 && grade<= 69){
            System.out.println("the grade is D");
        }
        else if (grade < 60){
            System.out.println("the grade is F");
        }
    }//end of main method
}//end of Java class
