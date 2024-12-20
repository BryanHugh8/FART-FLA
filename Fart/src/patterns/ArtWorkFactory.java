package patterns;

import models.Artwork;

public class ArtWorkFactory {
    public static Artwork createArtwork(String name, double price, String category) {
        return new Artwork(name, price, category);
    }
}
