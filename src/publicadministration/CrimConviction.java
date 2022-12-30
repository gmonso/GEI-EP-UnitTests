package publicadministration;

import exceptions.NullArgumentException;

import java.util.Date;

public class CrimConviction { // Represents a criminal conviction registered
    private final Date commitDate;
    private final String offense;
    private final String sentence;

    //Initialize attributes
    public CrimConviction(Date commit, String off, String sentc) {
        this.commitDate = commit;
        this.offense = off;
        this.sentence = sentc;
    }

    public Date getDate() throws NullArgumentException {
        if (this.commitDate == null) throw new NullArgumentException("CommitDate is null");
        return this.commitDate;
    }

    public String getOffense() throws NullArgumentException {
        if (this.offense == null) throw new NullArgumentException("Offense is null");
        return this.offense;
    }

    public String getSentence() throws NullArgumentException {
        if (this.sentence == null) throw new NullArgumentException("Sentence is null");
        return this.sentence;
    }

    @Override
    public String toString() {
        return "CrimConviction{" +
                "commitDate=" + commitDate +
                ", offense='" + offense + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
