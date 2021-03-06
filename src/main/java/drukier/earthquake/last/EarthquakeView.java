package drukier.earthquake.last;

import com.google.inject.Guice;
import com.google.inject.Injector;
import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeProperties;
import drukier.earthquake.net.EarthquakeModule;

import javax.inject.Singleton;
import javax.swing.*;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.FileNotFoundException;
import java.util.List;

@Singleton
public class EarthquakeView extends JFrame  {

    private static Timer timer;
    private JLabel showEarthquakeInfo[] = new JLabel[5];

    public EarthquakeView() {
        setTitle("Largest Earthquake");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < showEarthquakeInfo.length; i++){
            showEarthquakeInfo[i] = new JLabel();
            panel.add(showEarthquakeInfo[i]);
        }

        add(panel);

    }

    public void setEarthquakes(List<Earthquake> earthquakes) {

        for (int i = 0; i < showEarthquakeInfo.length && i < earthquakes.size(); i++) {
            EarthquakeProperties properties = earthquakes.get(i).getProperties();

            String earthquakeValue = properties.getMag() + " " + properties.getPlace();

            showEarthquakeInfo[i].setText(earthquakeValue);
        }

    }


    public static void main(String[] args) throws FileNotFoundException {

        Injector injector = Guice.createInjector(new EarthquakeModule());

        drukier.earthquake.last.EarthquakeView view = injector.getInstance(drukier.earthquake.last.EarthquakeView.class);

        drukier.earthquake.last.EarthquakeController controller = injector.getInstance(drukier.earthquake.last.EarthquakeController.class);

        controller.refreshData();

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                controller.stop();
            }
        });

        view.setVisible(true);
    }

}
