package library;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Search Book");
            System.out.println("5. Register Member");
            System.out.println("6. View Members");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = readInt(sc);
                    System.out.print("Enter Book Name: ");
                    String bname = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    library.addBook(new Book(bid, bname, author, category));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeBook(readInt(sc));
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter search keyword (ID/Name/Author): ");
                    library.searchBook(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Member ID: ");
                    int mid = readInt(sc);
                    System.out.print("Enter Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    library.registerMember(new Member(mid, mname, course, phone));
                    break;

                case 6:
                    library.displayMembers();
                    break;

                case 7:
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = readInt(sc);
                    System.out.print("Enter Book ID: ");
                    int issueBookId = readInt(sc);
                    System.out.print("Enter Issue Date (YYYYMMDD): ");
                    int issueDate = readInt(sc);
                    library.issueBook(issueMemberId, issueBookId, issueDate);
                    break;

                case 8:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(readInt(sc));
                    break;

                case 9:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 9);

        sc.close();
    }

    // Helper method to safely read integers and consume the newline
    private static int readInt(Scanner sc) {
        int value = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        return value;
    }
}
