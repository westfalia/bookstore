package app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Library v0.92";
        System.out.println(appName);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop(null);
    }
}
