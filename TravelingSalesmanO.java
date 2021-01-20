import java.util.*;
import java.io.*;
public class TravelingSalesmanO{
  public static void main(String[] args) {
    ArrayList<String> input = new ArrayList<String>();
    try{
      String file = "Tester.txt";///Add name for txtfile
      Scanner scan = new Scanner(new File(file));
      while (scan.hasNextLine()){
        input.add(scan.nextLine());
      }
      int answer = 0;
      ArrayList<String> cities = new ArrayList<String>();
      for (int i = 0; i < input.size(); i++){
        if (!cities.contains(input.get(i).substring(0,1))){
          cities.add(input.get(i).substring(0,1));
        }
      }
      System.out.println(cities.toString());
      
    }catch(FileNotFoundException e){
      System.out.println("File not Found");
    }
  }
  
  public static int factorial(int number){
    int answer = 1;
    for (int i = 1; i <= number; i++){
      answer = answer*i;
    }
    return answer;
  }
}