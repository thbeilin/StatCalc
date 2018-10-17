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

    public static float OPSCalc(int hits, int totalBases, int atBats) {
        return AVGCalc(hits, atBats) + SLGCalc(totalBases, atBats);
    }
}
