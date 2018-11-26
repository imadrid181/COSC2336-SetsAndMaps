import java.io.*;
import java.util.*;
public class KeyWordReader {
  public static void main(String[] args) throws IOException {
    File testerFile = new File("Tester.java");
    BufferedReader testerReader = new BufferedReader(new FileReader(testerFile));
    
    File keyWordFile = new File("keyWords.txt");
    BufferedReader keyWordReader = new BufferedReader(new FileReader(keyWordFile));
    
    Map<String,String> keyWords = new TreeMap<String,String>();
    ArrayList<String> listOfKeyWords = new ArrayList<String>(50);
    String line;
    
    while((line = keyWordReader.readLine()) != null) {
      String[] keyWordTokens = line.split("\\,");
      for(int i = 0; i < keyWordTokens.length; i++) {
        listOfKeyWords.add(keyWordTokens[i]);
      }
    }
    keyWordReader.close();
    
    int lineNumber = 1;
    String[] testerTokens;
    while((line = testerReader.readLine()) != null) {
      if(line.contains("{"))
    	  line = line.replace("{"," ");
      if(line.contains("("))
    	  line = line.replace("("," ");
      testerTokens = line.split(" "); 
      for(int i = 0; i < testerTokens.length; i++) {
        String key = testerTokens[i].trim();
        if(listOfKeyWords.contains(key)) {
          if(keyWords.containsKey(key))
            keyWords.put(key, "[ "+keyWords.get(key)+", "+Integer.toString(lineNumber)+" ]");
          else
            keyWords.put(key, Integer.toString(lineNumber));          
        }
      }
      lineNumber++;
    }
    testerReader.close();
    
    for(Map.Entry<String,String> entry : keyWords.entrySet()) {
      String key  = entry.getKey();
      String value = entry.getValue();
      System.out.println(key + " => " + value);
    }
  }
}