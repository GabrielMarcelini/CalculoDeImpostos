
public class Service extends Item {
	public Service(double value) {
        super(value);
    }

    @Override
    public double calculateTaxes(Calculation calculation) {
        return calculation.calculateServiceTaxes(this);
    }
}
