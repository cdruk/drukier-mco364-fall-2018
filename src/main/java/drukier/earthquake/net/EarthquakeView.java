package drukier.earthquake.net;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class EarthquakeView extends JFrame {

	private JTextField hMag;
	private JTextField hPlace;
	private JTextField dMag;
	private JTextField dPlace;
	private JTextField wMag;
	private JTextField wPlace;
	private JTextField mMag;
	private JTextField mPlace;
	
	public EarthquakeView() {
		setTitle("Largest Earthquake");
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		hMag = new JTextField();
		hPlace = new JTextField();
		dMag = new JTextField();
		dPlace = new JTextField();
		wMag = new JTextField();
		wPlace = new JTextField();
		mMag = new JTextField();
		mPlace = new JTextField();

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		panel.add(new JLabel("Largest Earthquake"), BorderLayout.NORTH);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 3));
		mainPanel.add(new JLabel("Last Hour", SwingConstants.CENTER));
		mainPanel.add(hMag);
		mainPanel.add(hPlace);
		mainPanel.add(new JLabel("Last Day", SwingConstants.CENTER));
		mainPanel.add(dMag);
		mainPanel.add(dPlace);
		mainPanel.add(new JLabel("Last Week", SwingConstants.CENTER));
		mainPanel.add(wMag);
		mainPanel.add(wPlace);
		mainPanel.add(new JLabel("Last Month", SwingConstants.CENTER));
		mainPanel.add(mMag);
		mainPanel.add(mPlace);
		panel.add(mainPanel, BorderLayout.CENTER);

		add(panel);
	}

	public JTextComponent getHourMagTextField() {
		return hMag;
	}

	public JTextComponent getHourLocTextField() {
		return hPlace;
	}

	public JTextComponent getDayMagTextField() {
		return dMag;
	}

	public JTextComponent getDayLocTextField() {
		return dPlace;
	}

	public JTextComponent getWeekMagTextField() {
		return wMag;
	}

	public JTextComponent getWeekLocTextField() {
		return wPlace;
	}

	public JTextComponent getMonthMagTextField() {
		return mMag;
	}

	public JTextComponent getMonthLocTextField() {
		return mPlace;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Injector injector = Guice.createInjector(new EarthquakeModule());
		
		EarthquakeView view = injector.getInstance(EarthquakeView.class);
		
		EarthquakeController controller = injector.getInstance(EarthquakeController.class);
		
		controller.refreshData();
		
		view.setVisible(true);
	}

}