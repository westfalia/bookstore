package app;

import java.util.NoSuchElementException;

public enum Option {
    EXIT(0, "exit program"),
    ADD_BOOK(1, "add book"),
    ADD_MAGAZINE(2, "add magazine"),
    PRINT_BOOKS(3, "show available books"),
    PRINT_MAGAZINES(4, "show available magazines");

    private int value;
    private String description;

    public int getValue() {
        return value;
    }

//    public void setValue(int value) {
//        this.value = value;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    Option(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
     public static Option createFromInt(int option) throws NoSuchElementException {
        Option result = null;
        try {
            result = Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException("No item of this ID.");
        }
        return result;
     }
}
