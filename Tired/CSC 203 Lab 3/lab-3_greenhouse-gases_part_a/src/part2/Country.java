package part2;

import java.util.Map;
public class Country {
    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions){
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }
    public Map<Integer, Emission> getEmissions(){
        return emissions;
    }

    public int getYearWithHighestEmissions(){
        Map<Integer, Emission> emissions = this.emissions;
        int year_highest = 0;
        for(Integer key: emissions.keySet()){
            if(year_highest == 0){
                year_highest = key;
            }
            else if(findTotalEmissions(emissions.get(key)) > findTotalEmissions(emissions.get(year_highest))){
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
