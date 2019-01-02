package com.example.css.kotlinerx.ui

import com.example.css.kotlinerx.data.ContactResponse
import com.example.orgware.kotlinapicall.base.LoadDataView

interface MainView:LoadDataView {
    fun onSuccess(contactsItem: ContactResponse)
    fun onFailure(throwable: Throwable?)


}