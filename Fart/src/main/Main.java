package main;

import models.User;
import models.Artwork;
import models.Customer;
import models.Artist;
import services.Marketplace;
import patterns.ArtWorkFactory;
import patterns.CustomerFactory;
import patterns.ArtistFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Marketplace marketplace = new Marketplace();
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (currentUser == null) {
        	System.out.println("");
        	System.out.println("          _____                    _____                    _____                _____          ");
            System.out.println("         /\\    \\                  /\\    \\                  /\\    \\              /\\    \\         ");
            System.out.println("        /::\\    \\                /::\\    \\                /::\\    \\            /::\\    \\        ");
            System.out.println("       /::::\\    \\              /::::\\    \\              /::::\\    \\           \\:::\\    \\       ");
            System.out.println("      /::::::\\    \\            /::::::\\    \\            /::::::\\    \\           \\:::\\    \\      ");
            System.out.println("     /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\           \\:::\\    \\     ");
            System.out.println("    /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\           \\:::\\    \\    ");
            System.out.println("   /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\          /::::\\    \\   ");
            System.out.println("  /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\        /::::::\\    \\  ");
            System.out.println(" /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\____\\      /:::/\\:::\\    \\ ");
            System.out.println("/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::|    |    /:::/  \\:::\\____\\");
            System.out.println("\\::/    \\:::\\   \\::/    /\\::/    \\:::\\  /:::/    /\\::/   |::::\\  /:::|____|   /:::/    \\::/    /");
            System.out.println(" \\/____/ \\:::\\   \\/____/  \\/____/ \\:::\\/:::/    /  \\/____|:::::\\/:::/    /   /:::/    / \\/____/ ");
            System.out.println("          \\:::\\    \\               \\::::::/    /         |:::::::::/    /   /:::/    /          ");
            System.out.println("           \\:::\\____\\               \\::::/    /          |::|\\::::/    /   /:::/    /           ");
            System.out.println("            \\::/    /               /:::/    /           |::| \\::/____/    \\::/    /            ");
            System.out.println("             \\/____/               /:::/    /            |::|  ~|           \\/____/             ");
            System.out.println("                                  /:::/    /             |::|   |                               ");
            System.out.println("                                 /:::/    /              \\::|   |                               ");
            System.out.println("                                 \\::/    /                \\:|   |                               ");
            System.out.println("                                  \\/____/                  \\|___|                               ");
            System.out.println("\n=== Welcome to the FART Marketplace ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    System.out.println("Are you a Customer or an Artist?");
                    System.out.print("Enter 'customer' or 'artist': ");
                    String userType = scanner.nextLine();

                    User newUser;
                    if (userType.equalsIgnoreCase("customer")) {
                        newUser = CustomerFactory.createCustomer(regUsername, regPassword);
                    } else if (userType.equalsIgnoreCase("artist")) {
                        newUser = ArtistFactory.createArtist(regUsername, regPassword);
                    } else {
                        System.out.println("Invalid user type. Registration failed.");
                        continue;
                    }

                    marketplace.registerUser(newUser);
                    System.out.println("Registration successful! Please login.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 2: 
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    for (User user : marketplace.getUsers()) {
                        if (user.getUsername().equals(loginUsername) && user.getPassword().equals(loginPassword)) {
                            currentUser = user;
                            System.out.println("Login successful! Welcome, " + currentUser.getUsername());
                            break;
                        }
                    }

                    if (currentUser == null) {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }

        while (true) {
        	System.out.println("");
        	System.out.println("          _____                    _____                    _____                _____          ");
            System.out.println("         /\\    \\                  /\\    \\                  /\\    \\              /\\    \\         ");
            System.out.println("        /::\\    \\                /::\\    \\                /::\\    \\            /::\\    \\        ");
            System.out.println("       /::::\\    \\              /::::\\    \\              /::::\\    \\           \\:::\\    \\       ");
            System.out.println("      /::::::\\    \\            /::::::\\    \\            /::::::\\    \\           \\:::\\    \\      ");
            System.out.println("     /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\           \\:::\\    \\     ");
            System.out.println("    /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\           \\:::\\    \\    ");
            System.out.println("   /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\          /::::\\    \\   ");
            System.out.println("  /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\        /::::::\\    \\  ");
            System.out.println(" /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\____\\      /:::/\\:::\\    \\ ");
            System.out.println("/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::|    |    /:::/  \\:::\\____\\");
            System.out.println("\\::/    \\:::\\   \\::/    /\\::/    \\:::\\  /:::/    /\\::/   |::::\\  /:::|____|   /:::/    \\::/    /");
            System.out.println(" \\/____/ \\:::\\   \\/____/  \\/____/ \\:::\\/:::/    /  \\/____|:::::\\/:::/    /   /:::/    / \\/____/ ");
            System.out.println("          \\:::\\    \\               \\::::::/    /         |:::::::::/    /   /:::/    /          ");
            System.out.println("           \\:::\\____\\               \\::::/    /          |::|\\::::/    /   /:::/    /           ");
            System.out.println("            \\::/    /               /:::/    /           |::| \\::/____/    \\::/    /            ");
            System.out.println("             \\/____/               /:::/    /            |::|  ~|           \\/____/             ");
            System.out.println("                                  /:::/    /             |::|   |                               ");
            System.out.println("                                 /:::/    /              \\::|   |                               ");
            System.out.println("                                 \\::/    /                \\:|   |                               ");
            System.out.println("                                  \\/____/                  \\|___|                               ");
            System.out.println("\n=== Marketplace Menu ===");
            System.out.println("1. View All Artworks");
            System.out.println("2. Buy Artwork");
            System.out.println("3. View Bought Items");
            System.out.println("4. Add Artwork");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	System.out.println("\n=== Available Artworks ===");
                	if (marketplace.getArtworks().isEmpty()) {
                	    System.out.println("No artworks available.");
                	} else {
                	    int counter = 1;
                	    for (Artwork artwork : marketplace.getArtworks()) {
                	        System.out.println(counter++ + ". " + artwork);
                	    }
                	}
                	System.out.println("Press Enter to continue...");
                	scanner.nextLine();

                    break;

                case 2:
                	if (currentUser instanceof Customer) {
                		
                		if(marketplace.getArtworks().isEmpty()) {
                			System.out.println("No artwork available to buy");
                		}
                		else {
                			System.out.println("\n=== Available Artworks ===");
                            for (int i = 0; i < marketplace.getArtworks().size(); i++) {
                                Artwork artwork = marketplace.getArtworks().get(i);
                                System.out.println((i + 1) + ". " + artwork.getName() + " - Rp. " + artwork.getPrice());
                            }
                            System.out.print("Enter the number of the artwork to buy: ");
                            int artworkChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (artworkChoice > 0 && artworkChoice <= marketplace.getArtworks().size()) {
                                Artwork selectedArtwork = marketplace.getArtworks().get(artworkChoice - 1);
                                marketplace.buyArtwork(currentUser, selectedArtwork);
                            } else {
                                System.out.println("Invalid choice.");
                            }
                		}
                    } 
                	else {
                        System.out.println("Only customers can buy artworks.");
                    }
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 3:
                    if (currentUser instanceof Customer) {
                        System.out.println("\n=== Your Bought Items ===");
                        if (((Customer) currentUser).getBoughtItems().isEmpty()) {
                            System.out.println("No items purchased yet.");
                        } else {
                            for (Artwork boughtItem : ((Customer) currentUser).getBoughtItems()) {
                                System.out.println(boughtItem);
                            }
                        }
                    } else {
                        System.out.println("Artists do not have bought items.");
                    }
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 4:
                    if (currentUser instanceof Artist) {
                        System.out.print("Enter the name of the artwork: ");
                        String artworkName = scanner.nextLine();
                        System.out.print("Enter the price of the artwork: ");
                        double artworkPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter the category of the artwork: ");
                        String artworkCategory = scanner.nextLine();

                        Artwork newArtwork = ArtWorkFactory.createArtwork(artworkName, artworkPrice, artworkCategory);
                        marketplace.addArtwork(currentUser, newArtwork);
                    } else {
                        System.out.println("Only artists can add artworks.");
                    }
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;

                case 5: 
                	System.out.println("Logging out...");
                    currentUser = null;
                    System.out.println("You have been logged out. Please login again to access the menu.");
                    
                    while (currentUser == null) {
                    	System.out.println("");
                    	System.out.println("          _____                    _____                    _____                _____          ");
                        System.out.println("         /\\    \\                  /\\    \\                  /\\    \\              /\\    \\         ");
                        System.out.println("        /::\\    \\                /::\\    \\                /::\\    \\            /::\\    \\        ");
                        System.out.println("       /::::\\    \\              /::::\\    \\              /::::\\    \\           \\:::\\    \\       ");
                        System.out.println("      /::::::\\    \\            /::::::\\    \\            /::::::\\    \\           \\:::\\    \\      ");
                        System.out.println("     /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\           \\:::\\    \\     ");
                        System.out.println("    /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\           \\:::\\    \\    ");
                        System.out.println("   /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\          /::::\\    \\   ");
                        System.out.println("  /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\        /::::::\\    \\  ");
                        System.out.println(" /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\____\\      /:::/\\:::\\    \\ ");
                        System.out.println("/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::|    |    /:::/  \\:::\\____\\");
                        System.out.println("\\::/    \\:::\\   \\::/    /\\::/    \\:::\\  /:::/    /\\::/   |::::\\  /:::|____|   /:::/    \\::/    /");
                        System.out.println(" \\/____/ \\:::\\   \\/____/  \\/____/ \\:::\\/:::/    /  \\/____|:::::\\/:::/    /   /:::/    / \\/____/ ");
                        System.out.println("          \\:::\\    \\               \\::::::/    /         |:::::::::/    /   /:::/    /          ");
                        System.out.println("           \\:::\\____\\               \\::::/    /          |::|\\::::/    /   /:::/    /           ");
                        System.out.println("            \\::/    /               /:::/    /           |::| \\::/____/    \\::/    /            ");
                        System.out.println("             \\/____/               /:::/    /            |::|  ~|           \\/____/             ");
                        System.out.println("                                  /:::/    /             |::|   |                               ");
                        System.out.println("                                 /:::/    /              \\::|   |                               ");
                        System.out.println("                                 \\::/    /                \\:|   |                               ");
                        System.out.println("                                  \\/____/                  \\|___|                               ");
                        System.out.println("\n=== Login or Register ===");
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Exit");
                        System.out.print("Choose an option: ");
                        int loginChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (loginChoice) {
                            case 1: 
                                System.out.print("Enter username: ");
                                String newUsername = scanner.nextLine();
                                System.out.print("Enter password: ");
                                String newPassword = scanner.nextLine();
                                System.out.println("Are you a Customer or an Artist?");
                                System.out.print("Enter 'customer' or 'artist': ");
                                String userType = scanner.nextLine();

                                User newRegister;
                                if (userType.equalsIgnoreCase("customer")) {
                                    newRegister = CustomerFactory.createCustomer(newUsername, newPassword);
                                } else if (userType.equalsIgnoreCase("artist")) {
                                    newRegister = ArtistFactory.createArtist(newUsername, newPassword);
                                } else {
                                    System.out.println("Invalid user type. Registration failed.");
                                    continue;
                                }

                                marketplace.registerUser(newRegister);
                                System.out.println("Registration successful! Please login.");
                                System.out.println("Press Enter to continue....");
                                scanner.nextLine();
                                break;

                            case 2:
                                System.out.print("Enter username: ");
                                String loginUsername = scanner.nextLine();
                                System.out.print("Enter password: ");
                                String loginPassword = scanner.nextLine();
                                for (User user : marketplace.getUsers()) {
                                    if (user.getUsername().equals(loginUsername) && user.getPassword().equals(loginPassword)) {
                                        currentUser = user;
                                        System.out.println("Login successful! Welcome, " + currentUser.getUsername());
                                        break;
                                    }
                                }
                                if (currentUser == null) {
                                    System.out.println("Invalid username or password. Please try again.");
                                }
                                System.out.println("Press Enter to continue....");
                                scanner.nextLine();
                                break;
                            case 3:
                            	System.out.println("Exiting the program. Thank you!");
                                scanner.close();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice. Please select from 1 to 3.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 5.");
            }
        }
    }
}
