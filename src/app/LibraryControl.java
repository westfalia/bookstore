package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {
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
        Option option;
        printOptions();
        while((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT){
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
                case EXIT:
                    ;
            }
            printOptions();
        }
        //zamykamy strumien wejscia
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Choose an option: ");
        for(Option o: Option.values()) {
            System.out.println(o);
        }
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