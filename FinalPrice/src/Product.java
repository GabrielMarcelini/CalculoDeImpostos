
public class Product extends Item {
	private double shipping;
    private double insurance;

    public Product(double value, double shipping, double insurance) {
        super(value);
        this.shipping = shipping;
        this.insurance = insurance;
    }

    public double getShipping() {
        return shipping;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getTotalCost() {
        return value + shipping + insurance;
    }

    @Override
    public double calculateTaxes(Calculation calculation) {
        return calculation.calculateProductTaxes(this);
    }

	
}
