package methodlist;

import java.util.ArrayList;

public class FilterWords {
  FileWords reader;
  Queue<ArrayList<String>> seg1;

  public FilterWords(String fileName) {
    reader = new FileWords(fileName);
  }

  //Print lines having containing "public" or "private" and "{"
  private void removeLines() throws Exception {
    Queue<ArrayList<String>> lines = reader.toLines();
    int count = 0, size = lines.getSize();
    ArrayList<String> oneLine;
    while(count < size) {
      oneLine = lines.remove();
      if(oneLine.size() > 0) //compareTo protected not done
        if(oneLine.get(0).compareTo("public") == 0 || oneLine.get(0).compareTo("private") == 0 && checkLine(oneLine)) {
          print(count + 1, oneLine);
        }
      count += 1;
    } 
  }

  //Checks if the given line contains "{"
  private boolean checkLine(ArrayList<String> line) {
    int lastEle = line.size() - 1; //Should check char == ";"
    if(line.get(lastEle).compareTo("{") != 0) 
      return false;
    return true;
  }
  
  //Prints line number in the file and line
  private void print(int count, ArrayList<String> line) {
    System.out.print(count + " ");
    for(String word : line) { 
      if(word.compareTo("{") != 0)
        System.out.print(word + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    FilterWords reqLines = new FilterWords(args[0]);
    reqLines.removeLines();
  }
}
         
