package drukier.earthquake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class EarthquakeReader {
	
	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();

		BufferedReader in = new BufferedReader(new FileReader(new File("src/drukier/earthquake/all_month.geojson")));

		EarthquakeFeed feed = gson.fromJson(in, EarthquakeFeed.class);

		System.out.println(feed.getFeatures().stream().filter(e -> e.getProperties().getMag() >= 5).count());
	}
}
