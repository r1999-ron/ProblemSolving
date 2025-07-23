package low_level_design.stackoverflow;

import java.util.List;

public interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();

}
