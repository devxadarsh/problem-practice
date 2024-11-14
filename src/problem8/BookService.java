package problem8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookService {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Dune", "Frank Herbert", "Science Fiction", true, 1965));
        books.add(new Book("Neuromancer", "William Gibson", "Science Fiction", false, 1984));
        books.add(new Book("Foundation", "Isaac Asimov", "Science Fiction", true, 1951));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", true, 1813));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", false, 1937));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", true, 1997));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true, 1925));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", true, 1960));
        books.add(new Book("Moby Dick", "Herman Melville", "Adventure", false, 1851));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", true, 1951));
        books.add(new Book("Brave New World", "Aldous Huxley", "Science Fiction", true, 1932));
        books.add(new Book("The Road", "Cormac McCarthy", "Post-Apocalyptic", false, 2006));
        books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy", true, 1954));
        books.add(new Book("Anna Karenina", "Leo Tolstoy", "Drama", true, 1877));
        books.add(new Book("The Shining", "Stephen King", "Horror", true, 1977));

        List<Book> filteredBooksByGenre = getAllBookByGenre(books, "Fiction");
        filteredBooksByGenre.forEach(System.out::println);
    }

    /*
    Get All Available Books by Genre
    Write a method that accepts a List<Book> and a genre as inputs and
    returns a List<String> containing the titles of all available books of the specified genre.
     */
    private static List<Book> getAllBookByGenre(List<Book> books, String genre) {
        List<Book> filteredByGenre = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .toList();
        return filteredByGenre;
    }
}
