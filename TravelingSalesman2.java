import java.util.*;
import java.io.*;
public class TravelingSalesman2{
  public static void main(String[] args){
    // System.out.println(!isNumber(null));
    // System.out.println(!isNumber("forty"));
    // System.out.println(isNumber("0"));
    // System.out.println(isNumber("14"));
    // ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
    // try{
    //   lines = scan("/Users/ryanli/Desktop/APCS/Tree/Cities.txt");
    // }
    // catch(FileNotFoundException e) {
    //   System.out.println("File not found");
		//   System.exit(1);
    // }
    // for(int i = 0; i < lines.size(); i++){
    //   System.out.println(lines.get(i).toString());
    // }
    try{
      System.out.println(distance("Faerun", "Tristram", scan("/Users/ryanli/Desktop/APCS/Tree/Cities.txt")));
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
		  System.exit(1);
    }
  }

  public static ArrayList<ArrayList<String>> scan(String fileName) throws FileNotFoundException{//add each city name and the distance to an arraylist, with the distance in position 0
    Scanner in = new Scanner(new File(fileName));
    ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
    int trips = 0;
    while(in.hasNextLine()){
      Scanner line = new Scanner(in.nextLine());
      int wordCounter = 0;
      ArrayList<String> info = new ArrayList<String>();
      while(line.hasNext()){
        String word = line.next();
        wordCounter++;
        if(!word.equals("to") && !word.equals("=")){
          if(isNumber(word)){
            info.add(0, word);
          }
          else{
            info.add(word);
          }
        }
      }
      trips++;
      lines.add(info);
    }
    return lines;
  }

  public static boolean isNumber(String word){//check if word is number
    if(word == null){
      return false;
    }
    try{
      int num = Integer.parseInt(word);
    }
    catch(NumberFormatException e){
      return false;
    }
    return true;
  }

  public static int distance(String start, String end, ArrayList<ArrayList<String>> arrays){
    if(start.equals(end)){
      return 0;
    }
    for(int i = 0; i < arrays.size(); i++){
      if(arrays.get(i).contains(start) && arrays.get(i).contains(end)){
        return Integer.parseInt(arrays.get(i).get(0));
      }
    }
    return 1000000;
  }//find distance between two points

  public static int bestPath(){//actual thingy

  }
}
