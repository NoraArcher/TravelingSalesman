public class TravelingSalesman {

//file name is TravelingInput.txt
  private static ArrayList<String> scanning(String fileName) throws FileNotFoundException {
    Scanner in = new Scanner(new File(fileName));
    ArrayList<String> lines = new ArrayList<String>();
    while (in.hasNextLine()) {
      lines.add(in.nextLine());
    }
    return lines;
  } //scanning end

  public static int TravelingSalesman() {
    //int is min route length, starts positive infinty double value, if its less than the min replace it
    
  }


}
