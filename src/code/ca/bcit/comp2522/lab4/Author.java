package ca.bcit.comp2522.lab4;

/**
 * Represents an author with a name, lifespan, and literary genre.
 *
 * @author Hailey Kim, Luis Saberon
 * @version 1.0
 */
public class Author extends Person implements Printable
{
    private static final int MAX_GENRE_LENGTH = 30;

    private final String genre;

    /**
     * Constructors.
     *
     * @param name        the author's name
     * @param dateOfBirth the author's date of birth
     * @param dateOfDeath the author's date of death (nullable)
     * @param genre       the literary genre the author is known for
     */
    public Author(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre)
    {
        super(name, dateOfBirth, dateOfDeath);

        validateGenre(genre);

        this.genre = genre;
    }

    /**
     * Validates that the given genre string is not null, blank,
     * and does not exceed the maximum allowed length.
     *
     * @param genre the genre to validate
     * @throws IllegalArgumentException if the genre is invalid
     */
    private static void validateGenre(final String genre)
    {
        if (genre == null || genre.isBlank())
        {
            throw new IllegalArgumentException("Genre cannot be null or blank");
        }

        if (genre.length() > MAX_GENRE_LENGTH)
        {
            throw new IllegalArgumentException("Genre cannot exceed " + MAX_GENRE_LENGTH + " characters");
        }
    }

    /**
     * Returns the author's literary genre.
     *
     * @return the genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Displays the author's information, including name and genre.
     */
    @Override
    public void display()
    {
        System.out.print("Author: ");
        getName().display();

        System.out.println("Genre: " + genre);
    }

    /**
     * Returns a string representation of the author, including name and genre.
     *
     * @return the author's name and genre as a string
     */
    @Override
    public String toString()
    {
        return getName().toString() + " (" + genre + ")";
    }
}
