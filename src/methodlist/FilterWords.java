package methodList;

public class FilterWords {
  FileWords reader;
  Queue<ArrayList<String>> seg1;

  public FilterWords(String fileName) {
    reader = new FileWords(fileName);
    seg1 = new Queue<ArrayList<String>>();
  }

  public Queue<ArrayList<String>> removeLines() {
    Queue<ArrayList<String>> lines = reader.toLines();
    int count = 0, size = lines.getSize();
    ArrayList<String> oneLine;
    while(count < size) {
      oneLine = lines.remove();
      if(oneLine.size() > 0) //compareTo protected not done
        if(oneLine.get(1).compareTo("public") == 0 || oneLine.get(1).compareTo("private") == 0) 
          seg1.insert(oneLine);
      count += 1;
    } 
    return seg1;
  }
         
