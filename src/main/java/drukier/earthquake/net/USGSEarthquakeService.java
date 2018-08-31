package drukier.earthquake.net;

import drukier.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface USGSEarthquakeService {

	@GET("/earthquakes/feed/v1.0/summary/all_month.geojson")
	Call<EarthquakeFeed> getAllMonth();
	
	@GET("/earthquakes/feed/v1.0/summary/all_week.geojson")
	Call<EarthquakeFeed> getAllWeek();
	
	@GET("/earthquakes/feed/v1.0/summary/all_day.geojson")
	Call<EarthquakeFeed> getAllDay();
	
	@GET("/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Call<EarthquakeFeed> getAllHour();

}
