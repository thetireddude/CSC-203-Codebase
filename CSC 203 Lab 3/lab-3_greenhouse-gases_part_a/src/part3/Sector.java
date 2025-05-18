package part3;

import java.util.List;
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

    public static Sector sectorWithHighestAverageEmissions(List<Sector> sectors, int startYear, int endYear){
        Sector highestAvgSector = null;
        double sectorAvg = 0;
        for(Sector sector: sectors){
            double sum = 0;
            Map<Integer, Double> emissions = sector.getEmissions();
            for(int key: emissions.keySet()){
                if(startYear <= key && key <= endYear){
                    sum += emissions.get(key);
                }
            }
            double avg = sum / (endYear - startYear);

            if(highestAvgSector == null){
                highestAvgSector = sector;
                sectorAvg = avg;
            }
            else if(avg > sectorAvg){
                highestAvgSector = sector;
                sectorAvg = avg;
            }
        }
        System.out.println("Sector: " + highestAvgSector.name + ", Average: " + sectorAvg);
        return highestAvgSector;
    }
}
