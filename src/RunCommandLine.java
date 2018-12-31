import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

public class RunCommandLine {
    private static int plateAppearances, singles, doubles, triples, homers,
            runsScored, RBIs, walks, strikeouts, timesHitByPitch, sacrifices;
    private static InMemoryGamesHistory history = new InMemoryGamesHistory();
    private static StatCalculator calculator = new StatCalculator(history);

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.println("add game or view stats?");
            answer = kb.nextLine();
            if (answer.equalsIgnoreCase("add game")) {
                addGame(kb);
            } else if (answer.equalsIgnoreCase("view stats")) {
                showStats(kb);
            } else if (answer.equalsIgnoreCase("exit")) {
                return;
            }
        }
    }

    private static void showStats(Scanner kb) {
        //TODO get way to see all stats
        if (history.getCurrentGame() == null) {
            System.out.println("No stats available.");
            return;
        }
        System.out.println("What stat do you want to see? (\"all\" to see all stats)");
        switch (kb.nextLine().toLowerCase(Locale.ENGLISH)) {
            case ("singles"):
                System.out.println(history.getTotalSingles());
                break;
            case ("doubles"):
                System.out.println(history.getTotalDoubles());
                break;
            case ("triples"):
                System.out.println(history.getTotalTriples());
                break;
            case ("homers"):
                System.out.println(history.getTotalHomers());
                break;
            case ("runs"):
                System.out.println(history.getTotalRunsScored());
                break;
            case ("rbis"):
                System.out.println(history.getTotalRBIs());
                break;
            case ("walks"):
                System.out.println(history.getTotalWalks());
                break;
            case ("strikeouts"):
                System.out.println(history.getTotalStrikeouts());
                break;
            case ("hbp"):
                System.out.println(history.getTotalHBPs());
                break;
            case ("sacs"):
                System.out.println(history.getTotalSacs());
                break;
            case ("avg"):
                System.out.println(history.getOverallBattingAverage());
                break;
            case ("obp"):
                System.out.println(history.getOverallOnBasePercentage());
                break;
            case ("slg"):
                System.out.println(history.getOverallSluggingPercentage());
                break;
            case ("ops"):
                System.out.println(history.getOverallOnBasePlusSlugging());
                break;
            case("all"):
                System.out.println("Singles: "+history.getTotalSingles());
                System.out.println("Doubles: "+history.getTotalDoubles());
                System.out.println("Triples: "+history.getTotalTriples());
                System.out.println("Homers: "+history.getTotalHomers());
                System.out.println("Runs: "+history.getTotalRunsScored());
                System.out.println("RBIs: "+history.getTotalRBIs());
                System.out.println("Walks: "+history.getTotalWalks());
                System.out.println("Strikeouts: "+history.getTotalStrikeouts());
                System.out.println("HBPs: "+history.getTotalHBPs());
                System.out.println("Sacs: "+history.getTotalSacs());
                System.out.println("Batting Average: "+history.getOverallBattingAverage());
                System.out.println("On Base Percentage: "+history.getOverallOnBasePercentage());
                System.out.println("Slugging Percentage: "+history.getOverallSluggingPercentage());
                System.out.println("On Base plus Slugging: "+history.getOverallOnBasePlusSlugging());
                break;
            default:
                System.out.println("Stat not found. Please try again. ");
        }
    }

    private static void addGame(Scanner kb) {
        // NOTE: test for validity only done at end
        //TODO: test for text input
        System.out.println("How many times did you come to bat?");
        plateAppearances = kb.nextInt();
        System.out.println("How many singles?");
        singles = kb.nextInt();
        System.out.println("How many doubles?");
        doubles = kb.nextInt();
        System.out.println("Triples?");
        triples = kb.nextInt();
        System.out.println("Homers?");
        homers = kb.nextInt();
        System.out.println("Did you get any walks?");
        walks = kb.nextInt();
        System.out.println("Any strikeouts?");
        strikeouts = kb.nextInt();
        System.out.println("Hit by the pitch?");
        timesHitByPitch = kb.nextInt();
        System.out.println("How many bunts and sac flies?");
        sacrifices = kb.nextInt();
        System.out.println("How many runs did you score?");
        runsScored = kb.nextInt();
        System.out.println("How many RBIs?");
        RBIs = kb.nextInt();
        try {
            calculator.addGame(plateAppearances, singles, doubles, triples, homers, runsScored, RBIs,
                    walks, strikeouts, timesHitByPitch, sacrifices);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage() + "Please try again.");
        }
    }
}
