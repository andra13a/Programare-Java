import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class Main
 {
     public static void main(String[] args)
     {
         Random rand = new Random();
         int countLetters = 'z' - 'a' + 1;
         int wordLength = 4;
         int wordsPerLine = 10;
         int lines = 5;

         try(FileWriter writer = new FileWriter("outrand.txt"))
         {
             for(int i = 0; i < lines; i++)
             {
                 String[] words = new String[wordsPerLine];
                 for (int j = 0; j < wordsPerLine; j++)
                 {
                     StringBuilder word = new StringBuilder();
                     for (int k = 0; k< wordLength; k++)
                     {
                         char c = (char) ('a' + rand.nextInt(countLetters));
                         word.append(c);
                     }
                     words[j]=word.toString();
                 }
                 Arrays.sort(words);
                 writer.write(String.join(" ", words) + "\n");
             }
             System.out.println("Fisierul outrand.txt a fost generat");
         }
         catch(IOException e)
         {
             System.out.println("Eroare");
         }
     }
 }