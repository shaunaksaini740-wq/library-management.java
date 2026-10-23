package library;
public class IssueRecord 
{
    private int bookId;
    private int memberId;
    private int date;

    public IssueRecord(int bookId, int memberId, int date) 
    {
        this.bookId = bookId;
        this.memberId = memberId;
        this.date = date;
    }

    public int getBookId() 
    { 
        return bookId; 
    }
    public int getMemberId() 
    { 
        return memberId; 
    }
    public int getDate() 
    { 
        return date; 
    }
}
