package part3;

import java.util.List;
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

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year){
        Country highestCH4 = null;
        for(Country country : countries){
            Map<Integer, Emission> emissions = country.getEmissions();
            if(highestCH4 == null){
                highestCH4 = country;
            }
            else if(emissions.get(year).getCH4() > highestCH4.getEmissions().get(year).getCH4()){
                highestCH4 = country;
            }
        }
        return highestCH4;
    }
    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear){
        Country highestChange = null;
        double amountOfChange = 0;
        for(Country country : countries){
            Map<Integer, Emission> emissions = country.getEmissions();
            if(highestChange == null){
                highestChange = country;
                amountOfChange = Math.abs(findTotalEmissions(highestChange.getEmissions().get(startYear)) - findTotalEmissions(highestChange.getEmissions().get(endYear)));
            }
            else if(Math.abs(findTotalEmissions(emissions.get(startYear)) - findTotalEmissions(emissions.get(endYear)))
                    > Math.abs(findTotalEmissions(highestChange.getEmissions().get(startYear)) - findTotalEmissions(highestChange.getEmissions().get(endYear)))){
                highestChange = country;
                amountOfChange = Math.abs(findTotalEmissions(highestChange.getEmissions().get(startYear)) - findTotalEmissions(highestChange.getEmissions().get(endYear)));
            }
        }
        System.out.println("Country: " + highestChange.name + ", Change: " + amountOfChange);
        return highestChange;
    }


    // method takes in an Emission object and returns total emissions of CO2, N2O, CH4 combined
    private static double findTotalEmissions(Emission emission){
        double CO2 = emission.getCO2();
        double N2O = emission.getN2O();
        double CH4 = emission.getN2O();

        return CO2 + N2O + CH4;
    }

}
