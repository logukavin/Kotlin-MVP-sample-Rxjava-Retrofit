package com.example.orgware.kotlinapicall.base


interface ResponseHandler<in T> {

    fun onResponse(responseParser: T)

    fun onFailure(message: String)


}
