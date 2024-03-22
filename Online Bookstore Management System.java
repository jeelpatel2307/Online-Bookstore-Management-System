import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

class Bookstore {
    private ArrayList<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class OnlineBookstore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookstore bookstore = new Bookstore();

        // Adding sample books
        bookstore.addBook(new Book("Java Programming", "John Doe", 29.99, 10));
        bookstore.addBook(new Book("Python Basics", "Jane Smith", 24.99, 15));
        bookstore.addBook(new Book("Web Development", "Adam Johnson", 34.99, 8));

        int choice;
        do {
            System.out.println("\n1. Display Books\n2. Find Book\n3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- All Books ---");
                    bookstore.displayBooks();
                    break;
                case 2:
                    System.out.print("\nEnter the title of the book to find: ");
                    String title = scanner.nextLine();
                    Book foundBook = bookstore.findBook(title);
                    if (foundBook != null) {
                        System.out.println("\nBook found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("\nBook not found!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
