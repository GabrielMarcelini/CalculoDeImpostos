import java.util.Scanner;

public class FinalPriceCalculator {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is this a product or service? (p/s): ");
        char itemType = scanner.next().charAt(0);

        System.out.print("Enter the value: ");
        double value = scanner.nextDouble();

        Item item = null;

        if (itemType == 'p') {
           
            System.out.print("Enter the shipping cost: ");
            double shipping = scanner.nextDouble();

            System.out.print("Enter the insurance cost: ");
            double insurance = scanner.nextDouble();

            item = new Product(value, shipping, insurance);
        } else if (itemType == 's') {
            
            item = new Service(value);
        } else {
            System.out.println("Invalid input!");
            return;
        }

        IPI ipi = new IPI();
        System.out.print("Enter the origin state (abbreviation): ");
        String origin = scanner.next().toUpperCase();

        System.out.print("Enter the destination state (abbreviation): ");
        String destination = scanner.next().toUpperCase();
        ICMS icms = new ICMS(origin, destination);

        System.out.print("Enter the ISS rate (in %): ");
        double issRate = scanner.nextDouble();
        ISS iss = new ISS(issRate);

        Calculation calculation = new Calculation(ipi, icms, iss);

        double totalTaxes = item.calculateTaxes(calculation);

        System.out.print("Enter the profit margin (in %): ");
        double profitMargin = scanner.nextDouble();

        double totalCost = item instanceof Product ? ((Product) item).getTotalCost() : item.getValue();
        double profit = (totalCost + totalTaxes) * (profitMargin / 100);
        double finalPrice = totalCost + totalTaxes + profit;

        System.out.printf("The final price of the product/service is: $ %.2f%n", finalPrice);
    }
}
