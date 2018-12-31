import javax.swing.*;
import java.awt.*;

public class ViewStatsGUI extends JFrame {
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private JPanel panel;
    private JLabel label;
    private JTextField[] textFields;
    private JButton all, avg, slg, obp, ops;
    private Font myFont = new Font("Sans-Serif", Font.PLAIN, 24);
    private static int plateAppearances, singles, doubles, triples, homers,
            runsScored, RBIs, walks, strikeouts, timesHitByPitch, sacrifices;
    private InMemoryGamesHistory history;
    private StatCalculator calculator;

    ViewStatsGUI(StatCalculator calculator, InMemoryGamesHistory history) {
        this.calculator = calculator;
        this.history = history;

        setTitle("View Stats");
        setSize(700, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        label = new JLabel("Which stats do you want to see?");
        label.setFont(myFont);
        all = new JButton("All");
        all.setFont(myFont);
        all.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Singles: "+history.getTotalSingles()+
                    "\nDoubles: "+history.getTotalDoubles()+
                    "\nTriples: "+history.getTotalTriples()+
                    "\nHomers: "+history.getTotalHomers()+
                    "\nRuns: "+history.getTotalRunsScored()+
                    "\nRBIs: "+history.getTotalRBIs()+
                    "\nWalks: "+history.getTotalWalks()+
                    "\nStrikeouts: "+history.getTotalStrikeouts()+
                    "\nHBPs: "+history.getTotalHBPs()+
                    "\nSacs: "+history.getTotalSacs()+
                    "\nBatting Average: "+history.getOverallBattingAverage()+
                    "\nOn Base Percentage: "+history.getOverallOnBasePercentage()+
                    "\nSlugging Percentage: "+history.getOverallSluggingPercentage()+
                    "\nOn Base plus Slugging: "+history.getOverallOnBasePlusSlugging(),
                    "Total stats", JOptionPane.PLAIN_MESSAGE);
        });
        avg = new JButton("Batting AVG");
        avg.setFont(myFont);
        slg = new JButton("Slugging %");
        slg.setFont(myFont);
        obp = new JButton("On Base %");
        obp.setFont(myFont);
        ops = new JButton("On Base + Slugging");
        ops.setFont(myFont);
        panel = new JPanel(new GridLayout(0,2));
        add(label);
        panel.add(all);
        panel.add(avg);
        panel.add(slg);
        panel.add(obp);
        panel.add(ops);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);

    }
}
