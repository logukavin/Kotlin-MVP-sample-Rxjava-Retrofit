package com.example.css.kotlinerx.data

import android.databinding.BaseObservable
import android.databinding.Bindable

class ContactsItem : BaseObservable() {
    val address: String? = null
    val gender: String? = null
    val phone: Phone? = null
        @Bindable
        get() = field
    val name: String? = null
        @Bindable
        get() = field
    val id: String? = null
    val email: String? = null
}
