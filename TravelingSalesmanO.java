import java.util.*;
import java.io.*;
public class TravelingSalesmanO{
  public static void main(String[] args) {
    ArrayList input = new ArrayList();
    try{
      String file = "Tester.txt";///Add name for txtfile
      Scanner scan = new Scanner(new File(file));
      while (scan.hasNextLine()){
        input.add(scan.nextLine());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not Found");
    }
  }
  
}