package drukier.earthquake.last;

import com.google.inject.Guice;
import com.google.inject.Injector;
import drukier.earthquake.net.EarthquakeController;
import drukier.earthquake.net.EarthquakeModule;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class EarthquakeView extends JFrame {

    private JTextField firstMag;
    private JTextField firstLoc;
    private JTextField secondMag;
    private JTextField secondLoc;
    private JTextField thirdMag;
    private JTextField thirdLoc;
    private JTextField fourthMag;
    private JTextField fourthLoc;
    private JTextField fifthMag;
    private JTextField fifthLoc;

    public EarthquakeView() {
        setTitle("Largest Earthquake");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        firstMag = new JTextField();
        firstLoc = new JTextField();
        secondMag = new JTextField();
        secondLoc = new JTextField();
        thirdMag = new JTextField();
        thirdLoc = new JTextField();
        fourthMag = new JTextField();
        fourthLoc = new JTextField();
        fifthMag = new JTextField();
        fifthLoc = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JLabel("Largest Earthquake"), BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2));
        mainPanel.add(firstMag);
        mainPanel.add(firstLoc);
        mainPanel.add(secondMag);
        mainPanel.add(secondLoc);
        mainPanel.add(thirdMag);
        mainPanel.add(thirdLoc);
        mainPanel.add(fourthMag);
        mainPanel.add(fourthLoc);
        mainPanel.add(fifthMag);
        mainPanel.add(fifthLoc);
        panel.add(mainPanel, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Injector injector = Guice.createInjector(new EarthquakeModule());

        drukier.earthquake.last.EarthquakeView view = injector.getInstance(drukier.earthquake.last.EarthquakeView.class);

        drukier.earthquake.last.EarthquakeController controller = injector.getInstance(drukier.earthquake.last.EarthquakeController.class);

        controller.refreshData();

        view.setVisible(true);
    }
}
