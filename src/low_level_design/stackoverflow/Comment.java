package low_level_design.stackoverflow;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private final String id;
    private final String content;
    private final User author;
    private final Date creationDate;

    public Comment(String content, User author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
    }
    public String getId() { return id; }
    public User getAuthor() { return author; }
    public String getContent() { return content; }
}
