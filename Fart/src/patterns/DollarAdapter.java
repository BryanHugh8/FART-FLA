package patterns;

public class DollarAdapter implements CurrencyConverter {
    private static final double EXCHANGE_RATE = 16000;

    @Override
    public double convert(double basePrice) {
        return basePrice / EXCHANGE_RATE;
    }

    @Override
    public String format(double convertedPrice) {
        return "$" + String.format("%.2f", convertedPrice);
    }
}
