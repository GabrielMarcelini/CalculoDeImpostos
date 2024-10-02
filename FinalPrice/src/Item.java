
abstract class Item {
    protected double value;

    public Item(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public abstract double calculateTaxes(Calculation calculation);
}
