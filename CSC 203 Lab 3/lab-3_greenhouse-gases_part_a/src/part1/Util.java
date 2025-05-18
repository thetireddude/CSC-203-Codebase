package part1;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static int getYearWithHighestEmissions(Country country){
        Map<Integer, Emission> emissions = country.getEmissions();
        int year_highest = 0;
        for(Integer key: emissions.keySet()){
            Emission emission_object = emissions.get(key);
            if(year_highest == 0){
                year_highest = key;
            }
            else if(findTotalEmissions(emission_object) > findTotalEmissions(emissions.get(year_highest))){
                year_highest = key;
            }
        }
        return year_highest;
    }

    public static int getYearWithHighestEmissions(Sector sector){
        Map<Integer, Double> emissions = sector.getEmissions();
        int year_highest = 0;
        for(Integer key: emissions.keySet()){
            if(year_highest == 0){
                year_highest = key;
            }
            else if(emissions.get(key) > emissions.get(year_highest)){
                year_highest = key;
            }
        }
        return year_highest;
    }

    // method takes in an Emission object and returns total emissions of CO2, N2O, CH4 combined
    private static double findTotalEmissions(Emission emission){
        double CO2 = emission.getCO2();
        double N2O = emission.getN2O();
        double CH4 = emission.getN2O();

        return CO2 + N2O + CH4;
    }
}
