
public class ISS {
	private double rate;

    public ISS(double rate) {
        this.rate = rate;
    }

    public double calculate(double serviceValue) {
        return serviceValue * (rate / 100);
    }

}
