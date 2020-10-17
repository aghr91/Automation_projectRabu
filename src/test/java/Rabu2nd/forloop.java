package Rabu2nd;

public class forloop {

    public static void main(String[] args) {
        String[] ZipCode = new String[5];
        ZipCode[0] = "3454";
        ZipCode[1] = "12345";
        ZipCode[2] = "3421";
        ZipCode[3] = "3467";
        ZipCode[4] = "34556";
        for (int i = 0; i <= 4; i++) { //++ is the same as +1

            System.out.println("my last zip code is " + ZipCode[i]);
        }

    }//end of main method
}//end of java class