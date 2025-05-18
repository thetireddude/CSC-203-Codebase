import java.util.Map;

public class Country implements GreenhouseGasEmitter{
    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        return emissions;
    }

    public double getEmissionsInYear(int year) {
        Emission emissionsInYear =  this.emissions.get(year);
        return emissionsInYear.getCH4() + emissionsInYear.getCO2() + emissionsInYear.getN2O();
    }
}
