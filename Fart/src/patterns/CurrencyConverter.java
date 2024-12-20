package patterns;

public interface CurrencyConverter {
    double convert(double basePrice);
    String format(double convertedPrice); 
}
