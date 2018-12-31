import java.util.ArrayList;

public class Player {
    String name;
    int gamesPlayed, PA, AB, H, _1B, _2B, _3B, HR, R, RBI, BB, IBB, SO, HBP;
    float avg, obp, slg, ops;
    public Player(String name) {
        this.name = name;
    }

    ArrayList<String> statsByGame = new ArrayList<>();

    public void addGamePlayed(int plateAppearances, int singles, int doubles, int triples, int homers, int runs,
                              int rbis, int walks, int intWalks, int strikeouts, int hitByPitch, int stolenBases, int timesCaughtStealing){

    }
}
