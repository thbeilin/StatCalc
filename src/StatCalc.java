public class StatCalc {
    public static float AVGCalc(int hits, int atBats) {
        if (hits > atBats)
            throw new Error("Cannot have more hits than at bats.");
        return (float) hits / atBats;
    }

    public static float SLGCalc(int totalBases, int atBats) {
        if (totalBases >atBats*4)
            throw new Error("Cannot have more total bases than four per at bat.");
        return (float) totalBases / atBats;
    }

    public static float OBPCalc(int timesOnBase, int plateAppearances){
        return (float) timesOnBase/plateAppearances;
    }

    public static float OPSCalc(int timesOnBase, int totalBases, int atBats, int plateAppearances) {
        return OBPCalc(timesOnBase, plateAppearances) + SLGCalc(totalBases, atBats);
    }
}
