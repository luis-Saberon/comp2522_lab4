package ca.bcit.comp2522.lab4;

/**
 * @author Luis Saberon, Hailey Kim
 * @version 1
 */
public class Book implements Comparable<Book>, Reversible, Printable
{

    private final String title;
    private final Author author;
    private final int yearPublished;

    private final static int MAX_CHAR_FOR_TITLE = 100;
    private final static int MIN_YEAR_PUBLISHED = 1;
    private final static int CURRENT_YEAR = 2025;

    /**
     * REMEMBER TO CHANGE AUTHOR FROM STRING TO AUTHOR OBJECT WHEN IT'S READY
     * Contains basic information about a book
     *
     * @param title         is the title of the book
     * @param yearPublished is the year the book was published
     * @param author        is the author of the book.
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {

        validateTitle(title);
        validateYearPublished(yearPublished);
        validateAuthor(author);

        this.title         = title;
        this.yearPublished = yearPublished;
        this.author        = author;
    }

    /**
     * Validates that the title isn't blank or null, and is less
     * than the max characters allowed
     * @param title String title
     */
    private static void validateTitle(final String title)
    {
        if(title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }

        if(title.length() > MAX_CHAR_FOR_TITLE)
        {
            throw new IllegalArgumentException("Title exceeds maximum length: " +  MAX_CHAR_FOR_TITLE);
        }
    }

    /**
     * Validates that the year published is between the
     * min year published and the current year.
     * @param yearPublished int yearPublished
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if(yearPublished < MIN_YEAR_PUBLISHED)
        {
            throw new IllegalArgumentException("Year published cannot be before year " + MIN_YEAR_PUBLISHED);
        }

        if(yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year published cannot be after current year " + CURRENT_YEAR);
        }
    }

    private static void validateAuthor(final Author author)
    {
        if (author == null)
        {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }

    /**
     * Gets the year the book was published
     * @return int yearPublished
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Gets the title
     * @return String title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the author
     * @return Author author
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Gets the age of the book
     * @return int age
     */
    public int getAge()
    {
        return CURRENT_YEAR - yearPublished;
    }
    /**
     * Compares books, books that are older are "bigger"
     * @param that is the book we are comparing it to.
     * @return this books age - that books age
     */
    @Override
    public int compareTo(final Book that)
    {
        return this.getAge() - that.getAge();
    }

    /**
     * Prints out a reversed title.
     */
    @Override
    public void reverse()
    {
        StringBuilder builder;
        builder = new StringBuilder();

        builder.append(this.title);
        System.out.println(builder.reverse());
    }

    @Override
    public void display()
    {
        System.out.println("Book: " + title + ", (" + yearPublished + "), Author: " + author);
    }
}
