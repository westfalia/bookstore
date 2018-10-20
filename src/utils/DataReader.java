package utils;

import data.Book;
import data.Magazine;
import java.util.Scanner;

public class DataReader {
    private Scanner sc;

    public DataReader(){
        sc = new Scanner(System.in);
    }

    public void close(){
        sc.close();
    }

    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public Book readAndCreateBook(){
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Author: ");
        String author = sc.nextLine();
        System.out.println("Publisher: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Release date: ");
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Pages: ");
        int pages = sc.nextInt();
        sc.nextLine();

        return  new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Title:");
        String title = sc.nextLine();
        System.out.println("Publisher:");
        String publisher = sc.nextLine();
        System.out.println("Language:");
        String language = sc.nextLine();
        System.out.println("Release date:");
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Miesiąc: ");
        int month = sc.nextInt();
        sc.nextLine();
        System.out.println("Day:");
        int day = sc.nextInt();
        sc.nextLine();

        return new Magazine(title, publisher, language, releaseDate, month, day);
    }
}
