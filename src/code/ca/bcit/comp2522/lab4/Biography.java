package ca.bcit.comp2522.lab4;

/**
 * @author Luis Saberon, Hailey Kim
 * @version 1
 */
public class Biography extends Book implements Printable
{
    private final Person subject;

    /**
     *Contains basic information about a biography, a specific kind of book
     * @param title is the tile of the book
     * @param author is the author of the book
     * @param yearPublished is the year the book was published
     * @param subject is the person for whom the book is about
     */
    public Biography(final String title,
                     final Author author,
                     final int yearPublished,
                     final Person subject)
    {
        super(title, yearPublished, author);

        this.subject = subject;
    }

    /**
     * Validates subject
     * @param subject is the subject to validate
     */
    private static void validateSubject(final Person subject)
    {
        if(subject == null)
        {
            throw new IllegalArgumentException("Subject cannot be null");
        }
    }

    /**
     * Gets the subject of the biography
     * @return Person subject
     */
    public Person getSubject()
    {
        return subject;
    }

    /**
     * Returns true if comparable object is a biography with the same
     * subject, false for all other cases.
     * @param o   the reference object with which to compare.
     * @return boolean equals
     */
    @Override
    public boolean equals(final Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(!(o instanceof Biography))
        {
            return false;
        }

        final Person thatSubject = ((Biography)o).getSubject();

        return this.subject.equals(thatSubject);
    }

    /**
     * Gets the hashcode for the biography, based off of the
     * subject hashcode
     * @return int hashCode
     */
    @Override
    public int hashCode()
    {
        return this.subject.hashCode();
    }

    @Override
    public void display()
    {
        System.out.println("Biography: " + getTitle() + " (" + getYearPublished() + ")");
        System.out.println("Author: " + getAuthor());
        System.out.println("Subject: " + subject);
    }
}