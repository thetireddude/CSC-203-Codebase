package part1;

public class Emission {

    private double CO2level;
    private double N2Olevel;
    private double CH4level;

    public Emission(double CO2, double N2O, double CH4){
        this.CO2level = CO2;
        this.N2Olevel = N2O;
        this.CH4level = CH4;
    }

    public double getCO2() {
        return CO2level;
    }

    public double getN2O() {
        return N2Olevel;
    }

    public double getCH4() {
        return CH4level;
    }

}
