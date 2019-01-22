package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Library;

public class FileManager {
    public static final String FILE_NAME = "Library.o";
     public void writeLibraryToFile(Library lib) {
         try (
                 FileOutputStream fos = new FileOutputStream(FILE_NAME);
                 ObjectOutputStream oos = new ObjectOutputStream(fos);
                 ) {
             oos.writeObject(lib);
         } catch (FileNotFoundException e) {
             System.err.println("File doesnt exist" + FILE_NAME);
         } catch (IOException e) {
             System.err.println("Error while writing data to file." + FILE_NAME);
         }
     }

     public Library readLibraryFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
         Library library = null;

         try(
                 FileInputStream fis = new FileInputStream(FILE_NAME);
                 ObjectInputStream ois = new ObjectInputStream(fis);
                 ) {
             library = (Library)ois.readObject();
         } catch (FileNotFoundException e) {
             System.err.println("File doesn't exist" + FILE_NAME);
             throw e;
         } catch (IOException e) {
             System.err.println("Error while writing data to file" + FILE_NAME);
             throw e;
         } catch (ClassNotFoundException e) {
             System.err.println("Incorrect file format");
             throw e;
         }

         return library;
     }
}
