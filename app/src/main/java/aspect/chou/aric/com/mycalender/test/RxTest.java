package aspect.chou.aric.com.mycalender.test;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * aspect.chou.aric.com.mycalender.test
 * Created by Aric on 下午2:29.
 */

public class RxTest {

    public static void main(String... arg){
       // create();

        //just();


       // from();

        //defer();

        map();

        flatmap();
    }

    private static void flatmap() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("第一次发射");
            }
        }).flatMap(new Function<String, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(String s) throws Exception {
                return Observable.just(s);
            }
        }).subscribe();
    }

    private static void map() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("第一次");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s+"改变";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onNext---"+d.toString());
            }

            @Override
            public void onNext(String value) {
                System.out.println("onNext---"+value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError---"+e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

    }

    private static void from() {

        Observable.fromArray(Arrays.asList(1,2,4,5)).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                System.out.println("onNext---"+integers.toString());
            }
        });

    }

    private static void just() {
        Observable.just(1,2,3,4).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("onNext---"+integer);
            }
        });
    }

    private static void create() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("First");
                e.onNext("Second");
                e.onNext("Third");
                e.onComplete();
                e.onNext("forth");
                e.onNext("fifth");

                /**
                 *
                 * onNext 时间可以发送无数多个
                 * onError 和 oncomplete 先后顺序： 首先正常情况下两者互斥；但如果先发OnError则onComplete不会被接收
                 * 但如果先发onComplete在发onError 则会错误
                 *
                 * 单独 error/complete 之后 observable继续发送，但是observer不会接收；
                 */


            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                System.out.println("onNext---"+value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError---"+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
