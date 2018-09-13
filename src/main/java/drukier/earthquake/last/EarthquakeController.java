package drukier.earthquake.last;

import com.google.inject.Inject;
import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeFeed;
import drukier.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EarthquakeController {
    private EarthquakeView view;
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
        requestEarthquakeFeed(service.getAllDay());

    }

    private void requestEarthquakeFeed(Call<EarthquakeFeed> call) {
        call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> mCall, Response<EarthquakeFeed> response) {
                EarthquakeFeed feed = response.body();

                showLargestEarthquakes(feed);

            }

            @Override
            public void onFailure(Call<EarthquakeFeed> mCall, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    void showLargestEarthquakes(EarthquakeFeed feed) {
        List<Earthquake> earthquakes = feed.getFeatures()
                .stream()
                .filter(earthquake -> earthquake.getProperties().getMag() >= 1)
                .sorted(Comparator.comparing(Earthquake::getMagnitude).reversed())
                .limit(5)
                .collect(Collectors.toList());

        view.setEarthquakes(earthquakes);
    }


}