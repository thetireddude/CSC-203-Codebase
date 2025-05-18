package part1;

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
}
