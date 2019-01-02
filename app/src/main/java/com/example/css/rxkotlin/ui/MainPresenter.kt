package com.example.css.kotlinerx.ui

import com.example.css.kotlinerx.data.ContactResponse
import com.example.orgware.kotlinapicall.app.AppController
import com.example.orgware.kotlinapicall.base.AbstractBasePresenter
import com.example.orgware.kotlinapicall.utils.RxJavaUtils
import rx.functions.Action1

class MainPresenter:AbstractBasePresenter<MainView>() {

    var mainView: MainView? = null


    override fun setView(view: MainView) {
        mainView = view
        appRepo = AppController.getInstanse()!!.getappRepo()
    }

    fun contact() {
        appRepo!!.getContact()
                .compose(RxJavaUtils.applyObserverSchedulers())
                .subscribe(Action1<Any>{ contactResponse ->
                    contactResponse
                    if (contactResponse!=null)
                        mainView!!.onSuccess(contactResponse as ContactResponse)
                    mainView!!.hideLoading()
                }, Action1<Throwable> { throwable ->
                    throwable
                    mainView!!.onFailure(throwable)
                    mainView!!.hideLoading()
                })

    }


}