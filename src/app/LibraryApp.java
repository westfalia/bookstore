package app;

public class LibraryApp {
    public static final String APP_NAME = "Library v0.9";
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
        //todo: dziedziczenie
        //Analogicznie jak w przypadku książki zdefiniowaliśmy także odpowiedni konstruktor. Metoda printInfo() pozwoli nam w zgrabnej formie wyświetlić informację o danej publikacji.
        //
        //Ponieważ chcemy tworzyć już nie tylko książki, ale także magazyny, czy gazety, to w klasie DataReader musimy stworzyć dodatkową metodę, która pozwoli nam utworzyć obiekt typu Magazine.
    }
}
