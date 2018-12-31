import java.security.InvalidParameterException;

public class GamePlayed {
    private int plateAppearances, singles, doubles, triples, homers,
            runsScored, RBIs, walks, strikeouts, timesHitByPitch, sacrifices;

    public GamePlayed(int plateAppearances, int singles, int doubles, int triples, int homers,
                      int runsScored, int RBIs, int walks, int strikeouts, int timesHitByPitch, int sacrifices) {
        if (singles + doubles + triples + homers + walks + strikeouts + timesHitByPitch + sacrifices > plateAppearances) {
            throw new InvalidParameterException("Outcomes of plate appearances can't be greater than the number of plate appearances. ");
        } else if (runsScored > plateAppearances + 1) { // can enter game as pinch runner, but only once
            throw new InvalidParameterException("Can only score one run per plate appearance. ");
        } else if (RBIs > plateAppearances * 4) {
            throw new InvalidParameterException("Can't do better than a grand slam each time. ");
        } // could be more technical impossibilities of data entry, but we'll have to trust the user for now

        this.plateAppearances = plateAppearances;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.homers = homers;
        this.runsScored = runsScored;
        this.RBIs = RBIs;
        this.walks = walks;
        this.strikeouts = strikeouts;
        this.timesHitByPitch = timesHitByPitch;
        this.sacrifices = sacrifices;
    }

    public int getPlateAppearances() {
        return plateAppearances;
    }

    public int getHits() {
        return singles + doubles + triples + homers;
    }

    public int getSingles() {
        return singles;
    }

    public int getDoubles() {
        return doubles;
    }

    public int getTriples() {
        return triples;
    }

    public int getHomers() {
        return homers;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getRBIs() {
        return RBIs;
    }

    public int getSacrifices() {
        return sacrifices;
    }

    public int getWalks() {
        return walks;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public int getTimesHitByPitch() {
        return timesHitByPitch;
    }

    public int getTimesOnBase() {
        return getHits() + walks + timesHitByPitch;
    }

    // method name is reminder that plate appearances is the regular stat
    public int getAtBatsNotPA() {
        return plateAppearances - walks - timesHitByPitch - sacrifices;
    }

    public int getTotalBases() {
        return singles + doubles * 2 + triples * 3 + homers * 4;
    }
}
