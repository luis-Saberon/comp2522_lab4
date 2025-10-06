package ca.bcit.comp2522.lab4;

/**
 * Represents a person with a name, date of birth, and optional date of death.
 *
 * @author Hailey Kim, Luis Saberon
 * @version 1.0
 */
public class Person implements Comparable<Person>, Printable, Reversible
{
    private final Name name;
    private final Date dateOfBirth;
    private final Date dateOfDeath;

    /**
     * Constructors.
     *
     * @param name        the person's name
     * @param dateOfBirth the person's date of birth
     * @param dateOfDeath the person's date of death (nullable)
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);

        this.name         = name;
        this.dateOfBirth  = dateOfBirth;
        this.dateOfDeath  = dateOfDeath;
    }

    /**
     * Validates that the given name is not null.
     *
     * @param name the person's name
     * @throws IllegalArgumentException if the name is null
     */
    private static void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    /**
     * Validates that the given date of birth is not null.
     *
     * @param dateOfBirth the person's date of birth
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
    }

    /**
     * Returns the person's name.
     *
     * @return the person's name
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Returns the person's date of birth.
     *
     * @return the person's date of birth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Returns the person's date of death.
     *
     * @return the person's date of death
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Compares this person to another person by birth year.
     *
     * @param that the object to be compared
     * @return a positive number if this person is older,
     *         a negative number if younger, or zero if born in the same year
     */
    @Override
    public int compareTo(final Person that)
    {
        return that.dateOfBirth.getYear() - this.dateOfBirth.getYear();
    }

    /**
     * Displays all information about this person, including name and dates.
     */
    public void display()
    {
        System.out.print("Person: ");
        name.display();

        System.out.print("Born: " + dateOfBirth.getFormattedDate());

        if (dateOfDeath != null)
        {
            System.out.print(", Died: " + dateOfDeath.getFormattedDate());
        }
    }

    /**
     * Prints the person's full name in reverse order.
     */
    @Override
    public void reverse()
    {
        String fullName = name.getFirst() + " " + name.getLast();

        System.out.println(new StringBuilder(fullName).reverse());
    }

    /**
     * Returns the person's name as a string.
     *
     * @return the full name as a string
     */
    @Override
    public String toString()
    {
        return name.toString();
    }
}