import java.util.Map;

public class Sector implements GreenhouseGasEmitter{
    private String name;
    private Map<Integer, Double> emissions;

    public Sector(String name, Map<Integer, Double> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Double> getEmissions() {
        return emissions;
    }

    public double getEmissionsInYear(int year) {
        return this.emissions.get(year);
    }
}
