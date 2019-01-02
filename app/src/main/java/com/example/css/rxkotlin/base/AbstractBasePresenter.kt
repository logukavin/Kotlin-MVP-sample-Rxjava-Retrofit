package com.example.orgware.kotlinapicall.base

import com.example.orgware.kotlinapicall.app.AppRepo


open class AbstractBasePresenter<in V : BaseView> : BasePresenter<V>, ResponseHandler<Any> {


    private var view: V? = null
    protected var appRepo: AppRepo? = null

    override fun setView(view: V) {
        this.view = view

    }

    override fun destroyView() {
        view = null

    }

    override fun destroy() {

    }

    override fun onResponse(responesApi: Any) {

    }

    override fun onFailure(message: String) {

    }


}
