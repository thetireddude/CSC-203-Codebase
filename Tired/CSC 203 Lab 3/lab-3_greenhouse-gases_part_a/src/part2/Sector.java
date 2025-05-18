package part2;

import java.util.Map;

public class Sector {
    private String name;
    private Map<Integer, Double> Emissions;

    public Sector(String name, Map<Integer, Double> Emissions){
        this.name = name;
        this.Emissions = Emissions;
    }

    public String getName() {
        return name;
    }
    public Map<Integer, Double> getEmissions() {
        return Emissions;
    }

    public int getYearWithHighestEmissions(){
        Map<Integer, Double> emissions = this.Emissions;
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
}
