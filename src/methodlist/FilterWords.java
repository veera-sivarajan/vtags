package methodlist;

import java.util.ArrayList;

public class FilterWords {
  FileWords reader;
  Queue<ArrayList<String>> seg1;

  public FilterWords(String fileName) {
    reader = new FileWords(fileName);
    seg1 = new Queue<ArrayList<String>>();
  }

  private Queue<ArrayList<String>> removeLines() throws Exception {
    Queue<ArrayList<String>> lines = reader.toLines();
    int count = 0, size = lines.getSize();
    ArrayList<String> oneLine;
    while(count < size) {
      oneLine = lines.remove();
      if(oneLine.size() > 0) //compareTo protected not done
        if(oneLine.get(0).compareTo("public") == 0 || oneLine.get(0).compareTo("private") == 0) 
          seg1.insert(oneLine);
      count += 1;
    } 
    return seg1;
  }

  private boolean checkLine(ArrayList<String> line) {
    int lastEle = line.size() - 1;
    if(line.get(lastEle).compareTo("{") != 0) 
      return false;
    return true;
  }
  
  private void print(ArrayList<String> line) {
    for(String word : line) { 
      if(word.compareTo("{") != 0)
        System.out.print(word + " ");
    }
    System.out.println();
  }

  public void getTags() throws Exception {
    Queue<ArrayList<String>> seg1 = removeLines();
    int size = seg1.getSize(), count = 0;
    ArrayList<String> line;
    boolean noOpenBracket;
    while(count < size) {
      line = seg1.remove();
      noOpenBracket = checkLine(line);
      if(noOpenBracket) {
        print(line);
      }
      count += 1;
    }
  }

  public static void main(String[] args) throws Exception {
    FilterWords reqLines = new FilterWords("FilterWords.java");
    reqLines.getTags();
  }
}
         
