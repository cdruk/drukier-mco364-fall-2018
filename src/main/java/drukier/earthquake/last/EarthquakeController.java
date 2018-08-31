package drukier.earthquake.last;

import com.google.inject.Inject;
import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeFeed;
import drukier.earthquake.EarthquakeProperties;
import drukier.earthquake.net.EarthquakeView;
import drukier.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EarthquakeController {
    private drukier.earthquake.net.EarthquakeView view;
    private USGSEarthquakeService service;

    @Inject
    public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
        this.view = view;
        this.service = service;
    }

    public void refreshData() {
       requestResults();

    }

    private void requestResults() {
        requestEarthquakeFeed(service.getAllHour(), view.getHourMagTextField(), view.getHourLocTextField());
    }

    private void requestEarthquakeFeed(Call<EarthquakeFeed> call, JTextComponent MagTextField, JTextComponent LocTextField) {
        call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> mCall, Response<EarthquakeFeed> response) {
                EarthquakeFeed feed = response.body();

                showLargestEarthquakes(feed, MagTextField, LocTextField);
            }

            @Override
            public void onFailure(Call<EarthquakeFeed> mCall, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    void showLargestEarthquakes(EarthquakeFeed feed, JTextComponent magField, JTextComponent locField) {
        List<Earthquake> earthquakes = feed.getFeatures()
                .stream()
                .filter(earthquake -> earthquake.getProperties().getMag() >= 1)
                .sorted(Comparator.comparing(Earthquake::getMagnitude).reversed())
                .limit(5)
                .collect(Collectors.toList());

        EarthquakeProperties properties = earthquakes.get().getProperties();

        String magnitude = String.valueOf(properties.getMag());
        magField.setText(magnitude);

        String location = String.valueOf(properties.getPlace());
        locField.setText(location);
    }
}
