package services;

import models.Artwork;
import models.Transaction;
import models.User;
import models.Customer;
import models.Artist;
import patterns.Observer;
import patterns.CurrencyConverter;
import patterns.DollarAdapter;
import patterns.EuroAdapter;
import patterns.RupiahAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marketplace implements Observer {
    private List<Artwork> artworks = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);
    }

    public void addArtwork(User user, Artwork artwork) {
        if (user instanceof Artist) {
            artworks.add(artwork);
            notifyUsers(artwork);
            System.out.println("Artwork added successfully by " + user.getUsername());
        } else {
            System.out.println("Only artists can add artwork.");
        }
    }

    public void buyArtwork(User user, Artwork artwork) {
        if (user instanceof Customer) {
            if (artworks.contains(artwork)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Select currency for payment:");
                System.out.println("1. Rupiah (Rp)");
                System.out.println("2. Dollar ($)");
                System.out.println("3. Euro (€)");
                System.out.print("Choose an option: ");
                int currencyChoice = scanner.nextInt();
                scanner.nextLine();
                
                CurrencyConverter converter;
                switch (currencyChoice) {
                    case 2:
                        converter = new DollarAdapter();
                        break;
                    case 3:
                        converter = new EuroAdapter();
                        break;
                    case 1:
                    default:
                        converter = new RupiahAdapter();
                        break;
                }

                double convertedPrice = converter.convert(artwork.getPrice());
                String formattedPrice = converter.format(convertedPrice);

                artworks.remove(artwork);
                user.addBoughtItem(artwork);
                transactions.add(new Transaction(user, artwork));

                System.out.println(user.getUsername() + " bought " + artwork.getName() + " with price " + formattedPrice);
            } else {
                System.out.println("Artwork not available.");
            }
        } else {
            System.out.println("Only customers can buy artwork.");
        }
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public List<User> getUsers() { 
        return users;
    }

    @Override
    public void notifyUsers(Artwork artwork) {
        for (User user : users) {
            if (user instanceof Customer) {
                System.out.println("Notification to " + user.getUsername() + ": New artwork added - " + artwork.getName());
            }
        }
    }
}
