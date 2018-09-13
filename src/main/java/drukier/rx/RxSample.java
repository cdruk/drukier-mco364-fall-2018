package drukier.rx;

import com.google.common.util.concurrent.AbstractScheduledService;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxSample {

    public static void main(String [] args){

        Observable<Integer> observable = Observable.just(5, 4, 3, 3, 4, 4, 4, 3, 2, 1);

        Observable.from

        Disposable disposable = observable
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * 2)
                .distinct()
                .sorted()
                .toList()
                //.subscribeOn(Schedulers.computation())
                //.observeOn(Schedulers.single())
                .subscribe(System.out::println);


    }
}
