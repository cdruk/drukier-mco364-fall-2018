package drukier.earthquake.net;

import java.util.Comparator;
import java.util.Optional;

import javax.swing.text.JTextComponent;

import com.google.inject.Inject;

import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeFeed;
import drukier.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeController {

	private EarthquakeView view;
	private USGSEarthquakeService service;

	@Inject
	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}

	public void refreshData() {
		requestHour();
		requestDay();
		requestWeek();
		requestMonth();

	}

	private void requestEarthquakeFeed(Call<EarthquakeFeed> call, JTextComponent magField, JTextComponent locField) {

		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> mCall, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();

				showLargestEarthquake(feed, magField, locField);
			}

			@Override
			public void onFailure(Call<EarthquakeFeed> mCall, Throwable t) {
				t.printStackTrace();
			}

		});
	}

	void requestHour()
	{
		requestEarthquakeFeed(service.getAllHour(), view.getHourMagTextField(), view.getHourLocTextField());
	}
	
	void requestDay()
	{
		requestEarthquakeFeed(service.getAllDay(), view.getDayMagTextField(), view.getDayLocTextField());
	}
	
	void requestWeek()
	{
		requestEarthquakeFeed(service.getAllWeek(), view.getWeekMagTextField(), view.getWeekLocTextField());
	}
	
	void requestMonth()
	{
		requestEarthquakeFeed(service.getAllMonth(), view.getMonthMagTextField(), view.getMonthLocTextField());
	}

	void showLargestEarthquake(EarthquakeFeed feed, JTextComponent magField, JTextComponent locField) {
		Optional<Earthquake> largest = feed.getFeatures().stream()
				.max(Comparator.comparing(e -> e.getProperties().getMag()));

		EarthquakeProperties properties = largest.get().getProperties();

		String magnitude = String.valueOf(properties.getMag());
		magField.setText(magnitude);
		
		String location = String.valueOf(properties.getPlace());
		locField.setText(location);
	}
}
