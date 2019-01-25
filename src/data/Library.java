package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Library implements Serializable {

    private static final long serialVersionUID = 7769688676975803589L;

    public static final int INITIAL_CAPACITY = 1;
    private Publication[] publications;
    private int publicationsNumber;

    public Publication[] getPublications() {
        return publications;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public Library() {
        publications = new Publication[INITIAL_CAPACITY];
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void removePublication(Publication pub) {
        if (pub == null)
            return;

        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < publications.length && found == NOT_FOUND) {
            if (pub.equals(publications[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if (found != NOT_FOUND) {
            System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
            publicationsNumber--;
        }
    }

    private void addPublication(Publication pub) throws ArrayIndexOutOfBoundsException {
        if (publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationsNumber] = pub;
        publicationsNumber++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < publicationsNumber; i++) {
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }

    public static class AlphabeticalComparator implements Comparator<Publication> {

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }

            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public class DateComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if(o1 == null) {
                return 1;
            }
            if(o2 == null) {
                return -1;
            }

            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();
            return -i1.compareTo(i2);
        }
    }
}