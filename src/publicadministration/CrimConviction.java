package publicadministration;

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

    public Date getDate() {
        return this.commitDate;
    }

    public String getOffense() {
        return this.offense;
    }

    public String getSentence() {
        return this.sentence;
    }

    public String toString() {

    } // converts to String
}
