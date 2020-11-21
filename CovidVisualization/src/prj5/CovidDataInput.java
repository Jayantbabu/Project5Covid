package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CovidDataInput 
{
    private DLList<State> state;
    private DLList<Race> race;


/**
 * @return 
 * constructor 
 * 
 * @param
 * 
 * @throws
 * 
 * 
 */
 public void FileReader(String fileone) throws FileNotFoundException 
 {
     readCSVFile(fileone);
     outputTextFile("CovidOutput_1.txt");
 }
 

 /**
  * Reading the csv file
  * 
  * @param
  * 
  * @throws
  * 
  */
  private void readCSVFile(String fileName)
  {
      state = new DLList<State>();
      
      Scanner file = null;
      try {
          file = new Scanner(new File(fileName));
      }
      catch (FileNotFoundException e)
      {
          e.printStackTrace();
      }
      
      String[] title = file.nextLine().split(", *");
      for (int i = 1; i < 6; i++)
      {
          title[i] = title[i].substring(6);
      }
      while (file.hasNextLine())
      {
          race = new DLList<Race>();
          String[] filestates = file.nextLine().split(", *");
          for (int i = 1; i < 6; i++)
          {
              String cases = filestates[i];
              String deaths = filestates[i + 5];
              if (cases.equals("N/A"))
              {
                  cases = "0";
              }
              if (deaths.equals("N/A"))
              {
                  deaths = "0";
              }
              race.add(new Race(title[i], Integer.valueOf(cases), Integer
                  .valueOf(deaths)));
          }
          state.add(new State(filestates[0], race));
      }
       file.close();
  }
  
  /**
   * Output text into file
   * 
   * @param
   * 
   * @throws
   */
   private void outputTextFile(String fileName) throws FileNotFoundException
   {
       PrintWriter writer = new PrintWriter(new File(fileName));
       CovidCalculator covid = new CovidCalculator(state);
       covid.sortAlphabatically();
       
       writer.write("List is sorted in Alphabatical order\n");
       writer.write("====================================\n");
       for (int i = 0; i < covid.getState().size(); i++)
       {
           writer.write(covid.getState().get(i).toString());
           writer.write("=================================");
       }
       writer.write("\n\nList is sorted by CFR Ratio\n");
       writer.write("=============================\n");
       covid.sortRatio();
       
       for (int i = 0; i < covid.getState().size(); i++)
       {
           writer.write(covid.getState().get(i).toString());
           writer.write("=================================");
           
       }
       writer.close();
   }
  
}
