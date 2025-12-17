package StreamsAPI;

public class Student {
    String name;
    int score;
    String subject;
    String city;

    public Student(String name, int score, String subject, String city) {
        this.name = name;
        this.score = score;
        this.subject = subject;
        this.city = city;
    }
    // Getters...
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getSubject() { return subject; }
    public String getCity() { return city; }
    @Override public String toString() { return name; }
}
