package com.example.css.kotlinerx.data

import android.databinding.BaseObservable
import android.databinding.Bindable

class Phone : BaseObservable() {
    val mobile: String? = null
        @Bindable
        get() = field
    val office: String? = null
    val home: String? = null
}
