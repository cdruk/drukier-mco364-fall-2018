package drukier.earthquake.net;

import drukier.earthquake.EarthquakeFeed;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface USGSEarthquakeService {

	@GET("/earthquakes/feed/v1.0/summary/all_month.geojson")
	Observable<EarthquakeFeed> getAllMonth();
	
	@GET("/earthquakes/feed/v1.0/summary/all_week.geojson")
	Observable<EarthquakeFeed> getAllWeek();
	
	@GET("/earthquakes/feed/v1.0/summary/all_day.geojson")
	Observable<EarthquakeFeed> getAllDay();
	
	@GET("/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Observable<EarthquakeFeed> getAllHour();

}
