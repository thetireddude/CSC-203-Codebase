 // To uncomment this file, select all the text (Cmd/Ctrl+A) and then "Cmd/Ctrl+/"
 package part3;

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.*;

 /**
  * NOTE THAT THIS CLASS WILL NOT COMPILE UNTIL YOU HAVE COMPLETED PART 2 OF THIS LAB
  */
 public class Main {

     public static void main(String[] args) throws FileNotFoundException {
         List<Country> countries = getCountries();
         List<Sector> sectors = getSectors();

         System.out.println("Which country had the highest methane gas emissions in 2000? ");
         System.out.println(Country.countryWithHighestCH4InYear(countries, 2000).getName());

         System.out.println("\nWhich country had the highest increase in greenhouse gas emissions between 1988 (the year the Intergovernmental Panel on Climate Change was formed) and 2012? ");
         Country.countryWithHighestChangeInEmissions(countries, 1988, 2012);

         System.out.println("\nWhich sector had the highest average greenhouse gas emissions between the years of 1988 and 2012? ");
         Sector.sectorWithHighestAverageEmissions(sectors, 1988, 2012);
     }

 	/**
      * Reads country emissions data from the countries.csv file. Do not modify this
      * method. Note that this method won't compile until you have implemented the
      * Country class.
      *
      * @return A List of Country objects.
      * @throws FileNotFoundException If the countries.csv file does not exist
      */
     private static List<Country> getCountries() throws FileNotFoundException {
         File dataFile = new File("C:\\Calpoly\\Assignments\\CSC_203\\CSC 203 Lab 3\\lab-3_greenhouse-gases_part_a\\countries.csv");
         Map<String, Map<Integer, Emission>> emissions = new HashMap<>();

         Scanner scan = new Scanner(dataFile);
         scan.nextLine(); // Skip the header line
         while (scan.hasNextLine()) {
             String[] data = scan.nextLine().split(",");

             // Each line contains Country, Year, CO2, N20, CH4 --- in that order
             String name = data[0];
             int year = Integer.parseInt(data[1]);
             double co2emissions = Double.parseDouble(data[2]);
             double n2oemissions = Double.parseDouble(data[3]);
             double ch4emissions = Double.parseDouble(data[4]);

             Emission emission = new Emission(co2emissions, n2oemissions, ch4emissions);

             if (!emissions.containsKey(name)) {
                 emissions.put(name, new HashMap<>());
             }
             emissions.get(name).put(year, emission);
         }
         scan.close();

         // Process emissions into a List of Countries
         List<Country> result = new LinkedList<>();
         for (Map.Entry<String, Map<Integer, Emission>> entry : emissions.entrySet()) {
             Country country = new Country(entry.getKey(), entry.getValue());
             result.add(country);
         }

         return result;
     }

     /**
      * Reads sector emissions data from the sectors.csv file. Do not modify this
      * method. Note that this method won't compile until you have implemented the
      * Country class.
      *
      * @return A List of Sector objects
      * @throws FileNotFoundException If the sectors.csv file does not exist
      */
     private static List<Sector> getSectors() throws FileNotFoundException {
         File dataFile = new File("C:\\Calpoly\\Assignments\\CSC_203\\CSC 203 Lab 3\\lab-3_greenhouse-gases_part_a\\sectors.csv");
         Map<String, Map<Integer, Double>> tempMap = new HashMap<>();
         Scanner scan = new Scanner(dataFile);
         scan.nextLine(); // Skip the header line
         while (scan.hasNextLine()) {
             String[] data = scan.nextLine().split(",");

             // Each line contains Sector, Year, Emissions --- in that order
             String name = data[0].split("\\.")[2]; // Sector names are "Emissions.Sector.X" — we only want "X"
             int year = Integer.parseInt(data[1]);
             double greenhouseGasEmissions = Double.parseDouble(data[2]);

             if (!tempMap.containsKey(name)) {
                 tempMap.put(name, new HashMap<>());
             }
             tempMap.get(name).put(year, greenhouseGasEmissions);
         }
         scan.close();

         // Process tempMap into a List of Countries
         List<Sector> result = new LinkedList<>();
         for (Map.Entry<String, Map<Integer, Double>> entry : tempMap.entrySet()) {
             Sector sector = new Sector(entry.getKey(), entry.getValue());
             result.add(sector);
         }

         return result;
     }


 }
