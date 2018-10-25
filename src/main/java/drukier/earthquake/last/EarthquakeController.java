package drukier.earthquake.last;

import com.google.inject.Inject;
import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeFeed;
import drukier.earthquake.net.USGSEarthquakeService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class EarthquakeController {
    private EarthquakeView view;
    private USGSEarthquakeService service;
    private Disposable disposable;

    @Inject
    public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
        this.view = view;
        this.service = service;
    }

    public void refreshData() {
        requestResults();

    }

    private void requestResults() {
        disposable =
                Observable.interval(0, 30, TimeUnit.SECONDS)
                .flatMap(aLong -> service.getAllDay())
                .map(EarthquakeFeed::getFeatures)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this::showLargestEarthquakes,
                        throwable -> System.out.println("Error getting data."));

    }


    private void showLargestEarthquakes(List<Earthquake> list) {
        List<Earthquake> earthquakes = list

                .stream()
                .filter(earthquake -> earthquake.getProperties().getMag() >= 1)
                .sorted(Comparator.comparing(Earthquake::getMagnitude).reversed())
                .limit(5)
                .collect(Collectors.toList());

        view.setEarthquakes(earthquakes);
    }

    public void stop(){
        disposable.dispose();
    }

}