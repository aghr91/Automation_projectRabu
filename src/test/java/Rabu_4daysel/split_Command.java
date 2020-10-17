package Rabu_4daysel;

public class split_Command {


    public static void main(String[] args) {
//dec;are and define a string variable
      String message = "my name is Rabu" ;
      //Print only Rabu
        String[] result = message.split(" ");
        System.out.println("my result is " + result[1] + " and " + result[3] );

    }//end main method
}//end java class
