package data;
import data.Book;

public class Library {
    public final int maxBooks = 1000;
    private Book[] books;
    private int booksNumber;

    public Library() {
        books = new Book[maxBooks];
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public Book[] getBooks() {
        return books;
    }


    public int getBooksNumber() {
        return booksNumber;
    }

    public void addBook(Book book){
        if(booksNumber < maxBooks){
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("maximum value of books!");
        }
    }

    public void printBooks(){
        if(booksNumber == 0){
            System.out.println("The library is empty.");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }

}