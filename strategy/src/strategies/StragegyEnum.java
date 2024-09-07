package strategies;

public enum StragegyEnum {
    PAYPAL("1"),
    CREDITCARD("2");

    private String option;

    StragegyEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}