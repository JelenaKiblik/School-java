import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CookieClicker extends JFrame {
    // non graphical variables
    private int cookies = 0;
    private int clicker = 1;
    private static final int TIME  = 25;
    private static final int PERIOD2  = 2000;
    private static final int PERIOD3  = 1000;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    // graphical variables
    private int numberOfColumns = 5;
    private Container container;
    private JLabel cookieLabel;
    private JButton increaseCookiesButton;
    private JLabel clickerLabel;
    private JButton increaseClickerButton;

    // buildings
    private Building cursor;
    private boolean cursorUnlocked;

    public CookieClicker() {
        int clickerPrice = 50;
        container = getContentPane();
        container.setLayout(new GridLayout(5, 1));

        cursor = new Building("Cursor", 0, 1, 10);
        cursorUnlocked = false;

        // produce cookies by hand
        cookieLabel = new JLabel("Cookies: " + cookies);
        increaseCookiesButton = new JButton("Clicker");
        increaseCookiesButton.addActionListener(e -> cookies += clicker);

        // improve clicking production rate
        clickerLabel = new JLabel("Clicker Level: " + clicker);
        increaseClickerButton = new JButton("Improve Clicker (Costs: " + clickerPrice + ")");
        increaseClickerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increaseClicker();
            }

            private void increaseClicker() {
                int clickerPrice = 50;
                if (cookies >= clickerPrice) {
                    clicker++;
                    cookies -= clickerPrice;
                    clickerPrice *= 1;
                    JOptionPane.showMessageDialog(null, "You have improved your clicker!");
                } else {
                    JOptionPane.showMessageDialog(null, "You have not enough money!");
                }
            }
        });

        java.util.Timer actualizeProgress = new java.util.Timer();
        actualizeProgress.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                cookieLabel.setText("Cookies: " + cookies);
                clickerLabel.setText("Clicker Level: " + clicker);
                increaseClickerButton.setText("Improve Clicker (Costs: " + clickerPrice + ")");
            }
        }, 0, TIME);

        java.util.Timer getMoreBuildings = new java.util.Timer();
        getMoreBuildings.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (!cursorUnlocked && clicker >= 2) {
                    cursor.unlock();
                    cursorUnlocked = true;
                }
            }
        }, 0, PERIOD2);

        java.util.Timer produceWithBuildings = new java.util.Timer();
        produceWithBuildings.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                cookies += cursor.getProductionRate();
            }
        }, 0, PERIOD3);

        container.add(cookieLabel);
        container.add(increaseCookiesButton);
        container.add(new JLabel("")); // blank label
        container.add(clickerLabel);
        container.add(increaseClickerButton);
    }

    public class Building {
        // non graphical variables
        private String name;
        private int level;
        private int productionRate;
        private int costs;

        // graphical variables
        JLabel label;
        JButton button;

        public Building(String name, int level, int productionRate, int costs) {
            // non graphical variables
            this.name = name;
            this.level = level;
            this.productionRate = productionRate;
            this.costs = costs;

            // graphical variables
            label = new JLabel();
            button = new JButton();
            button.addActionListener(e -> improve());
        }

        public int getLevel() {
            return level;
        }

        public void unlock() {
            numberOfColumns += 3;
            container.setLayout(new GridLayout(numberOfColumns, 1));
            container.add(new JLabel(""));
            container.add(label);
            container.add(button);
            actualize();
        }

        public void improve() {
            if (cookies >= costs) {
                level++;
                cookies -= costs;
                costs *= 1;
                JOptionPane.showMessageDialog(null, "You have improved the " + name + "!");
            } else {
                JOptionPane.showMessageDialog(null, "You have not enough money!");
            }
            actualize();
        }

        public int getProductionRate() {
            return productionRate * level;
        }

        public void actualize() {
            label.setText(name + " Rate: " + getProductionRate());
            button.setText("Improve (costs: " + costs + ")");
        }
    }

    public static void main(String[] args) {
        CookieClicker cookieClicker = new CookieClicker();
        cookieClicker.setTitle("Cookie Clicker");
        cookieClicker.setSize(WIDTH, HEIGHT);
        cookieClicker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cookieClicker.setVisible(true);
    }
}
