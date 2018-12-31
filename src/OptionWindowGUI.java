import javax.swing.*;
import java.awt.*;

public class OptionWindowGUI extends JFrame {
    private static InMemoryGamesHistory history = new InMemoryGamesHistory();
    private static StatCalculator calculator = new StatCalculator(history);
    private Font myFont = new Font("Sans-Serif", Font.PLAIN, 24);
    private JButton addStats, viewStats;
    private JLabel label;
    private JPanel panel;

    OptionWindowGUI() {
        setTitle("Choose Operation");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        addStats = new JButton("Add Stats");
        viewStats = new JButton("View Stats");
        addStats.addActionListener(e -> {
            var gui = new AddStatsGUI(calculator, history);
        });
        viewStats.addActionListener(e -> {
            if (history.getCurrentGame() == null) {
                JOptionPane.showMessageDialog(null, "No data yet. Try adding a game first.");
            } else {
                var gui = new ViewStatsGUI(calculator, history);
            }
        });
        addStats.setFont(myFont);
        viewStats.setFont(myFont);
        panel = new JPanel(new GridLayout(0, 2));
        label = new JLabel("What would you like to do?");
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
        label.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
        add(label, BorderLayout.CENTER);
        panel.add(addStats);
        panel.add(viewStats);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
