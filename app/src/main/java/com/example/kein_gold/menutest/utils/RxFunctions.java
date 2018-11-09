package com.example.kein_gold.menutest.utils;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxFunctions {
    public static <T> SingleTransformer<T, T> applySingleSchedulers() {
        return singleObservable -> singleObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
