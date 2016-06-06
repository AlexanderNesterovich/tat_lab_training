package beans;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/30/2016.
 */
public class Letter {

    private String subject;
    private String body;
    private User to;

    public User getFrom() {
        return from;
    }

    private User from;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Letter(User from, User to, String subject, String body) {
        this.subject = subject;
        this.from = from;
        this.body = body;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", to=" + to +
                ", from=" + from +
                '}';
    }
}
