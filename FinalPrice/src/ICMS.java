
public class ICMS {
	private String originState;
    private String destinationState;

    public ICMS(String originState, String destinationState) {
        this.originState = originState;
        this.destinationState = destinationState;
    }

    public double calculate(double productValue) {
        double rate = 0;

        if (originState.equals("SP") && destinationState.equals("RJ")) {
            rate = 0.12;
        } else if (originState.equals("SP") && destinationState.equals("DF")) {
            rate = 0.07;
        } else {
            System.out.println("Rate between the states not defined.");
        }

        return productValue * rate;
    }
}
