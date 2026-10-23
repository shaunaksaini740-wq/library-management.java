package library;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<IssueRecord> issueRecords = new ArrayList<>();

    // ---------- BOOK OPERATIONS ----------
    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book Added Successfully!");
    }

    public void removeBook(int id) {
        Book found = findBookById(id);
        if (found != null) {
            books.remove(found);
            System.out.println("Book Removed Successfully!");
        } else {
            System.out.println("Book Not Found!");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        for (Book b : books) {
            if (String.valueOf(b.getId()).equals(keyword) ||
                b.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    // ---------- MEMBER OPERATIONS ----------
    public void registerMember(Member m) {
        members.add(m);
        System.out.println("Member Registered Successfully!");
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("\n--- All Members ---");
        for (Member m : members) {
            System.out.println(m);
        }
    }

    private Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    // ---------- ISSUE / RETURN OPERATIONS ----------
    public void issueBook(int memberId, int bookId, int date) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null) {
            System.out.println("Member Not Found!");
            return;
        }
        if (book == null) {
            System.out.println("Book Not Found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book Already Issued!");
            return;
        }

        book.setAvailable(false);
        issueRecords.add(new IssueRecord(bookId, memberId, date));
        System.out.println("Book Issued Successfully!");
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book Not Found!");
            return;
        }
        if (book.isAvailable()) {
            System.out.println("This book was not issued.");
            return;
        }

        book.setAvailable(true);
        issueRecords.removeIf(r -> r.getBookId() == bookId);
        System.out.println("Book Returned Successfully!");
    }
}
