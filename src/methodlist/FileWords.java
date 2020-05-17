package methodlist;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileWords {
  private String file;
  private Queue<ArrayList<String>> words;
  private int numLines;

  public FileWords(String file) {
    this.file =  "/home/veera/Projects/MethodList/src/methodlist/" + file;
    words = new Queue<ArrayList<String>>();
    numLines = 0;
  }

  public void toWords() throws FileNotFoundException{
    Scanner input = new Scanner(new File(file));
    while(input.hasNextLine()) {
      ArrayList<String> stringList = new ArrayList<String>();
      String line = input.nextLine();
      Scanner readLine = new Scanner(line);
      numLines += 1;
      while(readLine.hasNext()) {
        String word = readLine.next();
        stringList.add(word);
      }
      words.insert(stringList);
    }
  }
  
  public void readFirstWords() throws Exception {
    int count = 0;
    int size = words.getSize();
    while(count < size) {
      ArrayList<String> line = words.remove();
      if(line.size() > 0)
        System.out.println("line[0]: " + line.get(0));
      count += 1;
    }
  }

  public static void main(String[] args) throws FileNotFoundException, Exception {
    FileWords reader = new FileWords(args[0]);
    reader.toWords();
    reader.readFirstWords();
  }
}

