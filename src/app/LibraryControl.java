package app;

import data.Book;
import data.Library;
import utils.DataReader;

public class LibraryControl {
    //zmienne do kontrolowania programu
    public final int exit = 0;
    public final int addBook = 1;
    public final int printBooks = 2;

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
        while((option = dataReader.getInt()) != exit){
            switch (option){
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
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
        System.out.println("0 - exit");
        System.out.println("1 - add book");
        System.out.println("2 - show available books");
    }

    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks(){
        library.printBooks();
    }
}