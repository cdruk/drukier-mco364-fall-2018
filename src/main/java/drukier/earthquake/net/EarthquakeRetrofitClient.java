package drukier.earthquake.net;

import java.util.Comparator;
import java.util.Optional;

import drukier.earthquake.Earthquake;
import drukier.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient {

	private String hMag;
	private String hPlace;
	private String dMag;
	private String dPlace;
	private String wMag;
	private String wPlace;
	private String mMag;
	private String mPlace;
	
	public EarthquakeRetrofitClient() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create()).build();

		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);

		Call<EarthquakeFeed> mCall = service.getAllMonth();

		mCall.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> mCall, Response<EarthquakeFeed> response) {
				EarthquakeFeed mFeed = response.body();

				Optional<Earthquake> largestMonth = mFeed.getFeatures().stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));

				setmMag((String.valueOf(largestMonth.get().getProperties().getMag())));
				setmPlace((String.valueOf(largestMonth.get().getProperties().getPlace())));
				

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> mCall, Throwable t) {
				t.printStackTrace();
			}

		});
		
		Call<EarthquakeFeed> wCall = service.getAllWeek();

		wCall.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> wCall, Response<EarthquakeFeed> response) {
				EarthquakeFeed mFeed = response.body();

				Optional<Earthquake> largestMonth = mFeed.getFeatures().stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));

				setmMag((String.valueOf(largestMonth.get().getProperties().getMag())));
				setmPlace((String.valueOf(largestMonth.get().getProperties().getPlace())));
				

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> wCall, Throwable t) {
				t.printStackTrace();
			}

		});
		
		Call<EarthquakeFeed> dCall = service.getAllMonth();

		dCall.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> dCall, Response<EarthquakeFeed> response) {
				EarthquakeFeed mFeed = response.body();

				Optional<Earthquake> largestMonth = mFeed.getFeatures().stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));

				setmMag((String.valueOf(largestMonth.get().getProperties().getMag())));
				setmPlace((String.valueOf(largestMonth.get().getProperties().getPlace())));
				

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> dCall, Throwable t) {
				t.printStackTrace();
			}

		});
		
		Call<EarthquakeFeed> hCall = service.getAllWeek();

		hCall.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> hCall, Response<EarthquakeFeed> response) {
				EarthquakeFeed mFeed = response.body();

				Optional<Earthquake> largestMonth = mFeed.getFeatures().stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));

				setmMag((String.valueOf(largestMonth.get().getProperties().getMag())));
				setmPlace((String.valueOf(largestMonth.get().getProperties().getPlace())));
				

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> hCall, Throwable t) {
				t.printStackTrace();
			}

		});
	}
	

	public String gethMag() {
		return hMag;
	}


	public void sethMag(String hMag) {
		this.hMag = hMag;
	}


	public String gethPlace() {
		return hPlace;
	}


	public void sethPlace(String hPlace) {
		this.hPlace = hPlace;
	}


	public String getdMag() {
		return dMag;
	}


	public void setdMag(String dMag) {
		this.dMag = dMag;
	}


	public String getdPlace() {
		return dPlace;
	}


	public void setdPlace(String dPlace) {
		this.dPlace = dPlace;
	}


	public String getwMag() {
		return wMag;
	}


	public void setwMag(String wMag) {
		this.wMag = wMag;
	}


	public String getwPlace() {
		return wPlace;
	}


	public void setwPlace(String wPlace) {
		this.wPlace = wPlace;
	}


	public String getmMag() {
		return mMag;
	}

	public void setmMag(String mMag) {
		this.mMag = mMag;
	}

	public String getmPlace() {
		return mPlace;
	}

	public void setmPlace(String mPlace) {
		this.mPlace = mPlace;
	}


}
