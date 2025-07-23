package low_level_design.stackoverflow;

public class Vote {
    private final User voter;
    private final VoteType voteType;

    public Vote(User voter, VoteType voteType) {
        this.voter = voter;
        this.voteType = voteType;
    }
    public User getVoter() { return voter; }
    public VoteType getVoteType() { return voteType; }

    public VoteType getType() {
        return voteType;
    }
}
