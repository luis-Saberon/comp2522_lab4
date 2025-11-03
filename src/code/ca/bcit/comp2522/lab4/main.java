package ca.bcit.comp2522.lab4;

public class main
{


    private static final Date   a1Birth = new Date(1903, 6, 35);
    private static final Date   a1Death = new Date(1950, 1, 21);
    private static final String genre1  = "Sci-fi";
    private static final Name   n1      = new Name("George", "Orwell");
    private static final Author author1 = new Author(n1, a1Birth, a1Death, genre1);

    private static final Date   a2Birth = new Date(1926, 4, 28);
    private static final Date   a2Death = new Date(2016, 2, 19);
    private static final String genre2  = "Fiction";
    private static final Name   n2      = new Name("Harper", "Lee");
    private static final Author author2 = new Author(n2, a2Birth, a2Death, genre2);

    private static final Date   a3Birth = new Date(1775, 12, 16);
    private static final Date   a3Death = new Date(1817, 7, 18);
    private static final String genre3  = "Fiction";
    private static final Name   name3   = new Name("Jane", "Austen");
    private static final Author author3 = new Author(name3, a3Birth, a3Death, genre3);

    private static final Date   a4Birth = new Date(1896, 9, 24);
    private static final Date   a4Death = new Date(1940, 12, 21);
    private static final String genre4  = "Fiction";
    private static final Name   name4   = new Name("F. Scott", "Fitzgerald");
    private static final Author author4 = new Author(name4, a4Birth, a4Death, genre4);

    private static final Date   a5Birth = new Date(1819, 8, 1);
    private static final Date   a5Death = new Date(1891, 9, 28);
    private static final String genre5  = "Fiction";
    private static final Name   name5   = new Name("Herman", "Melville");
    private static final Author author5 = new Author(name5, a5Birth, a5Death, genre5);


    //BIOGRAPHIES

    private static final String bioGenre = "Biography";

    private static final Date   ab1Birth  = new Date(1935, 10, 30);
    private static final Name   abName1   = new Name("Robert", "Caro");
    private static final Author abAuthor1 = new Author(abName1, ab1Birth, null, bioGenre);
    private static final Name   sName1    = new Name("Robert", "Moses");
    private static final Date   s1Birth   = new Date(1888, 12, 18);
    private static final Date   s1Death   = new Date(1981, 7, 21);
    private static final Person s1        = new Person(sName1, s1Birth, s1Death);

    private static final Date   ab2Birth  = new Date(1952, 5, 20);
    private static final Name   ab2Name   = new Name("Walter", "Isaacson");
    private static final Author abAuthor2 = new Author(ab2Name, ab2Birth, null, bioGenre);
    private static final Name   sName2    = new Name("Steve", "Jobs");
    private static final Date   s2Birth   = new Date(1955, 2, 24);
    private static final Date   s2Death   = new Date(2011, 10, 5);
    private static final Person s2        = new Person(sName2, s2Birth, s2Death);

    private static final Date   ab3Birth  = new Date(1936, 10, 25);
    private static final Date   ab3Death  = new Date(2015, 2, 3);
    private static final Name   ab3Name   = new Name("Martin", "Gillbert");
    private static final Author abAuthor3 = new Author(ab3Name, ab3Birth, ab3Death, bioGenre);
    private static final Name   sName3    = new Name("Winston", "Churchill");
    private static final Date   sBirth3   = new Date(1874, 11, 30);
    private static final Date   sDeath3   = new Date(1965, 1, 24);
    private static final Person s3        = new Person(sName3, sBirth3, sDeath3);

    private static final Date   ab4Birth  = new Date(1949, 3, 3);
    private static final Name   ab4Name   = new Name("Ron", "Chernow");
    private static final Author abAuthor4 = new Author(ab4Name, ab4Birth, null, bioGenre);
    private static final Name   sName4    = new Name("Alexander", "Hamilton");
    private static final Date   sBirth4   = new Date(1755, 1, 11);
    private static final Date   sDeath4   = new Date(1804, 8, 12);
    private static final Person s4        = new Person(sName4, sBirth4, sDeath4);

    private static final Name   s5Name  = new Name("Albert", "Einstein");
    private static final Date   s5Birth = new Date(1879, 3, 14);
    private static final Date   s5Death = new Date(1955, 4, 18);
    private static final Person s5      = new Person(s5Name, s5Birth, s5Death);


    //Autobiographies

    private static final String autoGenre = "Autobiography";

    private static final Name   aaName1   = new Name("Anne", "Frank");
    private static final Date   aaBirth1  = new Date(1929, 6, 23);
    private static final Date   aaDeath1  = new Date(1945, 2, 12);
    private static final Author aaAuthor1 = new Author(aaName1, aaBirth1, aaDeath1, autoGenre);

    private static final Name   aaName2   = new Name("Nelson", "Mandela");
    private static final Date   aaBirth2  = new Date(1918, 7, 18);
    private static final Date   aaDeath2  = new Date(2013, 11, 5);
    private static final Author aaAuthor2 = new Author(aaName2, aaBirth2, aaDeath2, autoGenre);

    private static final Name   aaName3   = new Name("Mahatma", "Gandhi");
    private static final Date   aaBirth3  = new Date(1869, 10, 2);
    private static final Date   aaDeath3  = new Date(1948, 1, 30);
    private static final Author aaAuthor3 = new Author(aaName3, aaBirth3, aaDeath3, autoGenre);

    private static final Name   aaName4   = new Name("Maya", "Angelou");
    private static final Date   aaBirth4  = new Date(1928, 4, 4);
    private static final Date   aaDeath4  = new Date(2014, 5, 28);
    private static final Author aaAuthor4 = new Author(aaName4, aaBirth4, aaDeath4, autoGenre);

    private static final Name   aaName5   = new Name("Malcolm", "X");
    private static final Date   aaBirth5  = new Date(1925, 5, 19);
    private static final Date   aaDeath5  = new Date(1965, 2, 21);
    private static final Author aaAuthor5 = new Author(aaName5, aaBirth5, aaDeath5, autoGenre);

    public static void main()
    {

        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        final Book bBook1;
        final Book bBook2;
        final Book bBook3;
        final Book bBook4;
        final Book bBook5;

        final Book aBook1;
        final Book aBook2;
        final Book aBook3;
        final Book aBook4;
        final Book aBook5;


        book1 = new Book("1984", 1949, author1);
        book2 = new Book("To Kill A Mockingbird", 1960, author2);
        book3 = new Book("Pride and Prejudice", 1813, author3);
        book4 = new Book("The Great Gatsby", 1925, author4);
        book5 = new Book("Moby Dick", 1851, author5);


        bBook1 = new Biography("The Power Broker", abAuthor1, 1974, s1);
        bBook2 = new Biography("Steve Jobs", abAuthor2, 2011, s2);
        bBook3 = new Biography("Churchill: A Life", abAuthor3, 1991, s3);
        bBook4 = new Biography("Alexander Hamilton", abAuthor4, 2004, s4);
        bBook5 = new Biography("Einstein: His Life and Universe", abAuthor2, 2007, s5);

        aBook1 = new Autobiography("The Diary of a Young Girl", aaAuthor1, 1947);
        aBook2 = new Autobiography("Long Walk to Freedom", aaAuthor2, 1994);
        aBook3 = new Autobiography("The Story of My Experiments with Truth", aaAuthor3, 1927);
        aBook4 = new Autobiography("I Know Why the Caged Bird Sings", aaAuthor4, 1969);
        aBook5 = new Autobiography("Autobiography of Malcom X", aaAuthor5, 1965);

        System.out.println(book1.compareTo(book2));
        System.out.println(book1.compareTo(book1));
        System.out.println(book1.compareTo(book3));

        System.out.println(aaAuthor3.compareTo(author4));
        System.out.println(abAuthor2.compareTo(aaAuthor2));

        System.out.println(bBook1.equals(bBook2));
        System.out.println(bBook2.equals(bBook1));

        aBook1.reverse();
        book2.reverse();

        bBook3.display();
        aaAuthor1.display();
        aaAuthor2.display();


    }
}
