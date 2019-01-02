package com.example.orgware.kotlinapicall.app

import com.example.css.kotlinerx.data.ContactResponse
import com.example.orgware.kotlinapicall.utils.RxJavaUtils
import rx.Observable


class AppRepo(appApi: ApiInterface) {

    private var appApi: ApiInterface


    init {
        this.appApi = appApi!!
    }

    fun getContact(): Observable<ContactResponse> {
        return appApi.getSampleApi().compose(RxJavaUtils.applyErrorTransformer())
                .map {it}
    }




}