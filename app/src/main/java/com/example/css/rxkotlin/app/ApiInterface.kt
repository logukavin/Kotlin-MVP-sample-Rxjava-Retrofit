package com.example.orgware.kotlinapicall.app

import com.example.css.kotlinerx.data.ContactResponse
import retrofit2.http.GET
import rx.Observable


interface ApiInterface {

    @GET("contacts/")
    fun getSampleApi(): Observable<ContactResponse>


}