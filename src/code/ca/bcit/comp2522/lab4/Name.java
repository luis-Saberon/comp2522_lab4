package ca.bcit.comp2522.lab4;

/**
 * Represents a person's name with a first and last component.
 *
 * @author Hailey Kim, Luis Saberon
 * @version 1.0
 */
public class Name implements Printable
{
    private static final int MAX_LENGTH = 50;

    private final String first;
    private final String last;

    /**
     * Constructors.
     *
     * @param first the first name
     * @param last  the last name
     */
    public Name(final String first,
                final String last)
    {
        validate(first, "First name");
        validate(last, "Last name");

        this.first = first;
        this.last  = last;
    }

    /**
     * Validates a name-like string to ensure it is not null, not blank,
     * and does not exceed the maximum allowed length.
     *
     * @param name                      the name
     * @param field                     a descriptive label for the name
     * @throws IllegalArgumentException if the name is invalid
     */
    private static void validate(final String name,
                                 final String field)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(field + " cannot be null or blank");
        }

        if (name.length() > MAX_LENGTH)
        {
            throw new IllegalArgumentException(field + " exceeds max length of " + MAX_LENGTH);
        }
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Displays the full name.
     */
    @Override
    public void display()
    {
        System.out.println(first + " " + last);
    }

    /**
     * Returns a string representation of the name.
     *
     * @return the full name as a string
     */
    @Override
    public String toString()
    {
        return first + " " + last;
    }
}
