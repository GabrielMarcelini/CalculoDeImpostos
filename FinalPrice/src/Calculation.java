
public class Calculation {
	private IPI ipi;
    private ICMS icms;
    private ISS iss;

    public Calculation(IPI ipi, ICMS icms, ISS iss) {
        this.ipi = ipi;
        this.icms = icms;
        this.iss = iss;
    }

    public double calculateProductTaxes(Product product) {
        double ipiValue = ipi.calculate(product.getTotalCost());
        double icmsValue = icms.calculate(product.getValue());
        return ipiValue + icmsValue;
    }

    public double calculateServiceTaxes(Service service) {
        return iss.calculate(service.getValue());
    }
		
}
