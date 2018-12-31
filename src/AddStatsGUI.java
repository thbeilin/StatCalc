import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;


public class AddStatsGUI extends JFrame {
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private JPanel panel;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton enter;
    private static int plateAppearances, singles, doubles, triples, homers,
            runsScored, RBIs, walks, strikeouts, timesHitByPitch, sacrifices;
    private InMemoryGamesHistory history;
    private StatCalculator calculator;

    AddStatsGUI(StatCalculator calculator, InMemoryGamesHistory history) {
        this.calculator = calculator;
        this.history = history;
        setTitle("Enter Game Data");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        buildpanel();
        add(panel);
        enter = new JButton("Enter");
        enter.addActionListener(e -> {
            try {
                plateAppearances = Integer.parseInt(textFields[0].getText());
                singles = Integer.parseInt(textFields[1].getText());
                doubles = Integer.parseInt(textFields[2].getText());
                triples = Integer.parseInt(textFields[3].getText());
                homers = Integer.parseInt(textFields[4].getText());
                runsScored = Integer.parseInt(textFields[5].getText());
                RBIs = Integer.parseInt(textFields[6].getText());
                walks = Integer.parseInt(textFields[7].getText());
                strikeouts = Integer.parseInt(textFields[8].getText());
                timesHitByPitch = Integer.parseInt(textFields[9].getText());
                sacrifices = Integer.parseInt(textFields[10].getText());
                calculator.addGame(plateAppearances, singles, doubles, triples, homers, runsScored, RBIs,
                        walks, strikeouts, timesHitByPitch, sacrifices);
                for (int i = 0; i < textFields.length; i++) {
                    textFields[i].setText("");
                }
                JOptionPane.showMessageDialog(null, "Stats Successfully Added!");
            } catch (InvalidParameterException ipe) {
                JOptionPane.showMessageDialog(null, ipe.getMessage() + "Please try again.");
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Please try again.");
            }
        });
        add(enter, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void buildpanel() {
        labels = new JLabel[]{new JLabel("Plate Appearances"), new JLabel("Singles"), new JLabel("Doubles"),
                new JLabel("Triples"), new JLabel("Homers"), new JLabel("Runs"), new JLabel("RBIs"),
                new JLabel("Walks"), new JLabel("Strikeouts"), new JLabel("HBP"), new JLabel("Sacrifices")};
        textFields = new JTextField[11];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField(2);
        }

        panel = new JPanel(new GridLayout(0, 2));
        for (int i = 0; i < labels.length; i++) {
            panel.add(labels[i]);
            panel.add(textFields[i]);
        }
        panel.setBorder(BorderFactory.createEmptyBorder(0,4,0,0));
    }
}
