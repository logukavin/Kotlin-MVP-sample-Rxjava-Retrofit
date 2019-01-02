package com.example.orgware.kotlinapicall.utils


import rx.Completable
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.exceptions.OnErrorNotImplementedException
import rx.schedulers.Schedulers


object RxJavaUtils {
    fun <T> applyObserverSchedulers(): Observable.Transformer<T, T> {
        return Observable.Transformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }

    fun applyCompletableSchedulers(): Completable.Transformer {
        return Completable.Transformer { completable -> completable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }


    fun <T> applyErrorTransformer(): Observable.Transformer<T, T> {
        return Observable.Transformer { observable -> observable.onErrorResumeNext { throwable -> Observable.error(throwable) } }
    }

    fun <T> applyOnErrorCrasher(): Observable.Transformer<T, T> {
        return Observable.Transformer { observable ->
            observable.doOnError { throwable ->
                val checkpoint = Throwable()
                val stackTrace = checkpoint.stackTrace
                val element = stackTrace[1] // First element after `crashOnError()`
                val msg = String.format("onError() crash from subscribe() in %s.%s(%s:%s)",
                        element.className,
                        element.methodName,
                        element.fileName,
                        element.lineNumber)

                throw OnErrorNotImplementedException(msg, throwable)
            }
        }
    }
}
