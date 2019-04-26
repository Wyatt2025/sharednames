/**
 * SharedNames.java
 *
 * This program reads through a list of names and finds
 * the names that are common to both boys and girls.
 *
 * @author
 * @version
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class SharedNames {
   static HashSet<String> names = new HashSet<String>();
   static ArrayList<String> commonNames = new ArrayList<String>();

   public static void main(String... args) {

       readFile("girlnames.txt"); // read girls names file
       readFile("boynames.txt"); // read boys names file
       printCommanNames(); // print common names in both files

   }

   // Method to read names from file specified
   private static void readFile(String fileName) {

       try {
           FileInputStream fileStream = new FileInputStream(fileName); // file input stream object to read file
           DataInputStream dataInputStream = new DataInputStream(fileStream);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
           String line;
           while ((line = bufferedReader.readLine()) != null) { // loop through file to read names
               String[] name = line.split(" "); // split by space to read name and count in array
               if (!names.add(name[0])) // if name is already present in hashset then add to commonNames arraylist
                   commonNames.add(name[0]);
           }
           dataInputStream.close(); // close input stream
       } catch (Exception e) {
           System.err.println("Error: " + e.getMessage()); // print error
       }
   }

   // Method to print common Names
   private static void printCommanNames() {

       System.out.println("Common Names are :");
       for (int i = 0; i < commonNames.size(); i++) { // loop through arraylist to print names

           System.out.println(commonNames.get(i));
       }

   }

}