package drukier.earthquake.net;

import com.google.gson.Gson;

import drukier.earthquake.EarthquakeFeed;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

public class EarthquakeClient {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		EarthquakeFeed feed = gson.fromJson(reader, EarthquakeFeed.class);
		
		System.out.println(
				feed.getFeatures()
				.stream()
				.filter(e-> e.getProperties().getMag() >=5)
				.count());
	}
}
