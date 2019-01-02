package com.example.css.kotlinerx.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.css.kotlinerx.data.ContactResponse
import com.example.css.kotlinerx.data.ContactsItem
import com.example.css.rxkotlin.R
import com.example.orgware.kotlinapicall.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivitys : BaseActivity(), MainView {
    private var mainPresenter=MainPresenter()
    private var listAdapter: ListAdapter? = null
    var contactsItem: List<ContactsItem>? = null


    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_main);
        mainPresenter.setView(this)
        mainPresenter.contact()


        rv_list.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(this)
        rv_list.adapter = listAdapter
    }

    override fun onSuccess(contactsItem: ContactResponse) {
        listAdapter!!.setFolderList(contactsItem.contacts as ArrayList<ContactsItem>?)

    }

    override fun onFailure(throwable: Throwable?) {
        Toast.makeText(this@MainActivitys, ""+throwable, Toast.LENGTH_SHORT).show()

    }

    override fun hideLoading() {

    }

    override fun showRetry() {

    }

    override fun hideRetry() {

    }

    override fun showError(message: String) {

    }

    override fun context(): Context {
        return this

    }

    override fun showLoading() {

    }
}