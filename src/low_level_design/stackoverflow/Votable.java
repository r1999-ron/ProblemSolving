package low_level_design.stackoverflow;

public interface Votable {
    void vote(User voter, VoteType voteType);
    int getVoteCount();
}
