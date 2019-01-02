package com.example.css.kotlinerx.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.css.kotlinerx.data.ContactsItem
import com.example.css.rxkotlin.R
import kotlinx.android.synthetic.main.item_list.view.*


class ListAdapter(var context: Context) : RecyclerView.Adapter<ListAdapter.ContactHolder>() {
    var contactsItem: List<ContactsItem>? = null

    init {
        contactsItem = ArrayList()
    }

    fun setFolderList(item: ArrayList<ContactsItem>? = null) {
        if (item == null)
            return
        contactsItem = item
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ContactHolder {
        return ContactHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return contactsItem!!.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ContactHolder, position: Int) {
        holder.bindData(contactsItem!![position])
    }

    inner class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var view: View = view

        fun bindData(item: ContactsItem) {
            view.tv_name.text = item.name
           view.tv_number.text = item.phone!!.mobile
        }

    }

}


