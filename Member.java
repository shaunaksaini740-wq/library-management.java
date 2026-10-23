package library;
public class Member {
    private int id;
    private String name;
    private String course;
    private String phone;

    public Member(int id, String name, String course, String phone) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.phone = phone;
    }

    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getCourse() { 
        return course; 
    }
    public String getPhone() { 
        return phone; 
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + course + " | " + phone;
    }
}
