package edu.temple.namelist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(private val names: List<String>, private val context: Context) : BaseAdapter() {

    // How many items are in the collection
    override fun getCount(): Int {
        return names.size
    }

    // Fetch an item from the collection
    override fun getItem(p0: Int): Any {
        return names[p0]
    }

    // Get the associated ID of an item in the collection
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // Return a view associated with an item in the collection
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        return if (p1 != null) {
            p1 as TextView
        } else {
            TextView(context).apply {
                textSize = 24f
                setPadding(10,10,10,10)
            }
        }.apply {
            text = getItem(p0).toString()
        }
    }
}