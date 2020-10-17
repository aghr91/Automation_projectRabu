package Rabu2nd;

public class WhileLoop {


    public static void main(String[] args) { String[] ZipCode = new String[5];
        ZipCode[0] = "3454";
        ZipCode[1] = "12345";
        ZipCode[2] = "3421";
        ZipCode[3] = "3467";
        ZipCode[4] = "34556";

        int i = 0;
        //define the while loop with your end point execution
        while (i < ZipCode.length) {
            System.out.println("my zipcode is" +ZipCode [i]);
            //increment goes here
            i = i + 1;//same as i++
        }//end loop

    }///end main method
}//end java
