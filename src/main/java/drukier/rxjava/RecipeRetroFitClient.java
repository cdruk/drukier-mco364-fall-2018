package drukier.rxjava;

import com.google.inject.AbstractModule;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeRetroFitClient extends AbstractModule {

    @Override
            protected void configure() {
        super.configure();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.yummly.com/v1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RecipeService service = retrofit.create(RecipeService.class);

        bind(RecipeService.class).toInstance(service);
    }
}
