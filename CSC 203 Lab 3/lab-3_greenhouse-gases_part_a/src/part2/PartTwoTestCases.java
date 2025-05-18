 // To uncomment this file, select the entire file (Cmd/Ctrl+A) and then Cmd/Ctrl+/
 package part2;

 import org.junit.jupiter.api.Test;
 import part1.Util;

 import java.lang.reflect.Method;
 import java.lang.reflect.Modifier;
 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.stream.Collectors;

 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertTrue;

 /**
  * NOTE THAT THIS FILE WILL NOT COMPILE UNTIL YOU HAVE COPIED OVER YOUR
  * EMISSION, COUNTRY, AND SECTOR CLASSES TO THE part2 DIRECTORY
  */
 public class PartTwoTestCases {

     /**
      * Tests the implementation of the Emission class.
      *
      * TO-DO: Examine this test case to know what you should name your public methods.
      *
      * @throws NoSuchMethodException
      */
     @Test
     public void testEmissionImplSpecifics() throws NoSuchMethodException {
         final List<String> expectedMethodNames = Arrays.asList("getCO2", "getN2O", "getCH4");

         final List<Class> expectedMethodReturns = Arrays.asList(double.class, double.class, double.class);

         final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

         verifyImplSpecifics(Emission.class, expectedMethodNames, expectedMethodReturns,
                 expectedMethodParameters);
     }

     /**
      * Tests the part2 implementation of the Country class.
      *
      * @throws NoSuchMethodException
      */
     @Test
     public void testCountryImplSpecifics() throws NoSuchMethodException {
         final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

         final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

         final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

         verifyImplSpecifics(Country.class, expectedMethodNames, expectedMethodReturns,
                 expectedMethodParameters);
     }

     /**
      * Tests the part2 implementation of the Sector class.
      *
      * @throws NoSuchMethodException
      */
     @Test
     public void testSectorImplSpecifics() throws NoSuchMethodException {
         final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

         final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

         final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

         verifyImplSpecifics(Sector.class, expectedMethodNames, expectedMethodReturns,
                 expectedMethodParameters);
     }

     @Test
     public void SectorTestYearWithHighestEmissions1() {
         // Create the testable Sector object
         Map<Integer, Double> emissions = new HashMap<Integer, Double>();
         emissions.put(1970, 2278.8);
         emissions.put(1971, 2356.43);
         emissions.put(1972, 2243.3);
         part2.Sector sector = new part2.Sector("Transport", emissions);

         // Check that the method works as expected
         assertEquals(1971, sector.getYearWithHighestEmissions());
     }
     @Test
     public void SectorTestYearWithHighestEmissions2() {
         // Create the testable Sector object
         Map<Integer, Double> emissions = new HashMap<Integer, Double>();
         emissions.put(1985, 4322.8);
         emissions.put(1966, 1293.092);
         emissions.put(1978, 3921.3002);
         part2.Sector sector = new part2.Sector("Transport", emissions);

         // Check that the method works as expected
         assertEquals(1985, sector.getYearWithHighestEmissions());
     }

     @Test
     public void CountryTestYearWithHighestEmissions1() {
         // Create the testable Sector object
         Map<Integer, part2.Emission> emissions = new HashMap<Integer, part2.Emission>();
         emissions.put(1989, new part2.Emission(1032.5, 1784.1, 1420.2));
         emissions.put(1990, new part2.Emission(1570.317, 2034.125, 632.36));
         emissions.put(1990, new part2.Emission(1215.7, 1879.2, 1140.4));
         part2.Country country = new part2.Country("Transport", emissions);

         // Check that the method works as expected
         assertEquals(1990, country.getYearWithHighestEmissions());
     }
     @Test
     public void CountryTestYearWithHighestEmissions2() {
         // Create the testable Sector object
         Map<Integer, part2.Emission> emissions = new HashMap<Integer, part2.Emission>();
         emissions.put(1989, new part2.Emission(3235.005, 292.98, 2021.0));
         emissions.put(1990, new part2.Emission(453.954, 2912.65, 921.9));
         emissions.put(1990, new part2.Emission(2323.04, 233.3, 769.04));
         part2.Country country = new part2.Country("Transport", emissions);

         // Check that the method works as expected
         assertEquals(1989, country.getYearWithHighestEmissions());
     }

     private static void verifyImplSpecifics(final Class<?> clazz, final List<String> expectedMethodNames,
                                             final List<Class> expectedMethodReturns, final List<Class[]> expectedMethodParameters)
             throws NoSuchMethodException {
         assertEquals(0, clazz.getFields().length, "Unexpected number of public fields");

         final List<Method> publicMethods = Arrays.stream(clazz.getDeclaredMethods())
                 .filter(m -> Modifier.isPublic(m.getModifiers())).collect(Collectors.toList());

         assertEquals(expectedMethodNames.size(), publicMethods.size(),
                 "Unexpected number of public methods");

         assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
                 "Invalid test configuration");
         assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
                 "Invalid test configuration");

         for (int i = 0; i < expectedMethodNames.size(); i++) {
             Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i), expectedMethodParameters.get(i));
             assertEquals(expectedMethodReturns.get(i), method.getReturnType());
         }
     }

 }
