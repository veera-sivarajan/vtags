package methodlist;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileWords {
  private String file;
  private Queue<ArrayList<String>> words;

  public FileWords(String file) {
    this.file =  "/home/veera/Projects/MethodList/src/methodlist/" + file;
    words = new Queue<ArrayList<String>>();
  }
  
  //Store every word in a line in an ArrayList and insert the list into a queue 
  public Queue<ArrayList<String>> toLines() throws FileNotFoundException{
    Scanner input = new Scanner(new File(file));
    while(input.hasNextLine()) {
      ArrayList<String> stringList = new ArrayList<String>();
      String line = input.nextLine();
      Scanner readLine = new Scanner(line);
      while(readLine.hasNext()) {
        String word = readLine.next();
        stringList.add(word);
      }
      words.insert(stringList);
      readLine.close();
    }
    input.close();
    return words;
  }
}

