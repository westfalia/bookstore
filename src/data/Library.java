package data;

import data.Book;

public class Library {
    public static final int MAX_BOOKS = 1000;
    public static final int MAX_MAGAZINES = 1000;
    private Book[] books;
    private Magazine[] magazines;
    private int booksNumber;
    private int magazinesNumber;

    //    public int getMaxBooks() {
//        return maxBooks;
//    }

    public int getBooksNumber() {

        return booksNumber;
    }


    public Book[] getBooks() {
        return books;
    }

    public int getMagazinesNumber() {
        return magazinesNumber;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public Library() {

        books = new Book[MAX_BOOKS];
        magazines = new Magazine[MAX_MAGAZINES];
    }

    public void addBook(Book book) {
        if (booksNumber < MAX_BOOKS) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("maximum value of books!");
        }
    }

    public void addMagazine(Magazine magazine) {
        if (magazinesNumber < MAX_MAGAZINES) {
            magazines[magazinesNumber] = magazine;
            magazinesNumber++;
        } else {
            System.out.printf("maximum value of magazines!");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("The library is empty.");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }

    public void printMagazines() {
        if(magazinesNumber == 0) {
            System.out.println("The library is empty.");
        }
        for (int i = 0; i < magazinesNumber; i++) {
            magazines[i].printInfo();
        }
    }

}