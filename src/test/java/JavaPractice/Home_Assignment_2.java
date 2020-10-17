package JavaPractice;
/*using array, loop & conditional with the following array values
cities = Brooklyn, Queens, Manhattan, Staten;
using array inside a for or while loo, print me when city is Brooklyn or city is Manhattan;
    use examples of both loops */
public class Home_Assignment_2 {
    public static void main(String[] args) {
        String[] cities = new String[4];
        cities[0] = "Manhattan";
        cities[1] = "Queens";
         cities[2] = "Staten";
         cities[3] = "Brooklyn";
         for(int   i = 0;i< cities.length; i++) {

             if (cities[i] == "Brooklyn") {
                 System.out.println("my city name is " + cities[i]);

             }
             if (cities[i]== "Manhattan"){
                 System.out.println("my city name is " + cities[i]);
             }
         }//end loop
    }//end of main method
}//end of java class