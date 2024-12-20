package patterns;

import models.Artist;

public class ArtistFactory {
    public static Artist createArtist(String username, String password) {
        return new Artist(username, password);
    }
}
