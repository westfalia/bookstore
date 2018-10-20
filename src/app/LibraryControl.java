package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {
    //zmienne do kontrolowania programu
    public static final int EXIT = 0;
    public static final int ADD_BOOK = 1;
    public static final int ADD_MAGAZINE = 2;
    public static final int PRINT_BOOKS = 3;
    public static final int PRINT_MAGAZINES = 4;

    //zmienna do komunikacji z uzytkownikiem
    private DataReader dataReader;

    //"bibliteka" przechowujaca dane
    private Library library;

    public LibraryControl(){
        dataReader = new DataReader();
        library = new Library();
    }

    //Główna pętla programu, która pozwala na wybór opcji i interakcje

    public void controlLoop(){
        int option;
        printOptions();
        while((option = dataReader.getInt()) != EXIT){
            switch (option){
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                case PRINT_BOOKS:
                    printBooks();
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                default:
                    System.out.println("There is no option, enter again.");
            }
            printOptions();
        }
        //zamykamy strumien wejscia
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Choose an option: ");
        System.out.println(EXIT + " - exit");
        System.out.println(ADD_BOOK + " - add book");
        System.out.println(ADD_MAGAZINE + " - add magazine");
        System.out.println(PRINT_BOOKS + " - show available books");
        System.out.println(PRINT_MAGAZINES + " - show available magazines");
    }

    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks(){
        library.printBooks();
    }

    private void addMagazine(){
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        library.printMagazines();
    }
}