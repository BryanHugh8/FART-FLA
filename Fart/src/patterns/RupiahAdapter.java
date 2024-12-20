package patterns;

public class RupiahAdapter implements CurrencyConverter {

    @Override
    public double convert(double basePrice) {
        return basePrice;
    }

    @Override
    public String format(double convertedPrice) {
        return "Rp. " + String.format("%.0f", convertedPrice);
    }
}
