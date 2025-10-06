package ca.bcit.comp2522.lab4;

/**
 * @author Luis Saberon, Hailey Kim
 * @version 1
 */
public class Autobiography extends Biography implements Printable
{
    /**
     * Models an autobiography, a biography written by the subject
     * @param title is the title of the book
     * @param author is both the author and subject of the book
     * @param yearPublished is the year the book was published
     */
    public Autobiography(final String title,
                         final Author author,
                         final int yearPublished)
    {
        super(title, author, yearPublished, author);
    }

    @Override
    public void display()
    {
        System.out.println("Autobiography: " + getTitle() + " (" + getYearPublished() + ")");
        System.out.println("Author: " + getAuthor());
    }
}
