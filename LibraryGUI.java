package library;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {

    private Library library;

    public LibraryGUI() {

        // Connect GUI with your existing Library class
        library = new Library();

        // Window settings
        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Title
        JLabel title = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(title, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 15, 15));

        JButton addBookButton = new JButton("Add Book");
        JButton removeBookButton = new JButton("Remove Book");
        JButton viewBooksButton = new JButton("View Books");
        JButton searchBookButton = new JButton("Search Book");

        JButton addMemberButton = new JButton("Register Member");
        JButton viewMembersButton = new JButton("View Members");

        JButton issueBookButton = new JButton("Issue Book");
        JButton returnBookButton = new JButton("Return Book");

        buttonPanel.add(addBookButton);
        buttonPanel.add(removeBookButton);
        buttonPanel.add(viewBooksButton);
        buttonPanel.add(searchBookButton);
        buttonPanel.add(addMemberButton);
        buttonPanel.add(viewMembersButton);
        buttonPanel.add(issueBookButton);
        buttonPanel.add(returnBookButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Exit button
        JButton exitButton = new JButton("EXIT");
        mainPanel.add(exitButton, BorderLayout.SOUTH);

        // Button actions
        addBookButton.addActionListener(e -> addBook());
        removeBookButton.addActionListener(e -> removeBook());
        viewBooksButton.addActionListener(e -> viewBooks());
        searchBookButton.addActionListener(e -> searchBook());

        addMemberButton.addActionListener(e -> registerMember());
        viewMembersButton.addActionListener(e -> viewMembers());

        issueBookButton.addActionListener(e -> issueBook());
        returnBookButton.addActionListener(e -> returnBook());

        exitButton.addActionListener(e -> System.exit(0));

        // Add panel to window
        add(mainPanel);
    }

    // ---------------- ADD BOOK ----------------

    private void addBook() {

        try {
            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(this, "Enter Book ID:")
            );

            String name = JOptionPane.showInputDialog(
                    this, "Enter Book Name:"
            );

            String author = JOptionPane.showInputDialog(
                    this, "Enter Author Name:"
            );

            String category = JOptionPane.showInputDialog(
                    this, "Enter Category:"
            );

            Book book = new Book(id, name, author, category);

            library.addBook(book);

            JOptionPane.showMessageDialog(
                    this,
                    "Book Added Successfully!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input!"
            );
        }
    }

    // ---------------- REMOVE BOOK ----------------

    private void removeBook() {

        try {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Book ID to remove:"
                    )
            );

            library.removeBook(id);

            JOptionPane.showMessageDialog(
                    this,
                    "Remove operation completed."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Book ID!"
            );
        }
    }

    // ---------------- VIEW BOOKS ----------------

    private void viewBooks() {

        library.displayBooks();
    }

    // ---------------- SEARCH BOOK ----------------

    private void searchBook() {

        String keyword = JOptionPane.showInputDialog(
                this,
                "Enter Book ID, Name or Author:"
        );

        if (keyword != null && !keyword.trim().isEmpty()) {
            library.searchBook(keyword);
        }
    }

    // ---------------- REGISTER MEMBER ----------------

    private void registerMember() {

        try {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Member ID:"
                    )
            );

            String name = JOptionPane.showInputDialog(
                    this,
                    "Enter Member Name:"
            );

            String course = JOptionPane.showInputDialog(
                    this,
                    "Enter Course:"
            );

            String phone = JOptionPane.showInputDialog(
                    this,
                    "Enter Phone Number:"
            );

            Member member = new Member(
                    id,
                    name,
                    course,
                    phone
            );

            library.registerMember(member);

            JOptionPane.showMessageDialog(
                    this,
                    "Member Registered Successfully!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input!"
            );
        }
    }

    // ---------------- VIEW MEMBERS ----------------

    private void viewMembers() {

        library.displayMembers();
    }

    // ---------------- ISSUE BOOK ----------------

    private void issueBook() {

        try {

            int memberId = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Member ID:"
                    )
            );

            int bookId = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Book ID:"
                    )
            );

            int issueDate = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Issue Date (YYYYMMDD):"
                    )
            );

            library.issueBook(
                    memberId,
                    bookId,
                    issueDate
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Issue operation completed."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input!"
            );
        }
    }

    // ---------------- RETURN BOOK ----------------

    private void returnBook() {

        try {

            int bookId = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Book ID to return:"
                    )
            );

            library.returnBook(bookId);

            JOptionPane.showMessageDialog(
                    this,
                    "Return operation completed."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Book ID!"
            );
        }
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LibraryGUI gui = new LibraryGUI();

            gui.setVisible(true);
        });
    }
}
