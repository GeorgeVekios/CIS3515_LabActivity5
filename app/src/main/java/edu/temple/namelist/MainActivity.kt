package edu.temple.namelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.size

class MainActivity : AppCompatActivity() {

    lateinit var names: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        names = mutableListOf("Kevin Shaply", "Stacey Lou", "Gerard Clear", "Michael Studdard", "Michelle Studdard")

        val spinner = findViewById<Spinner>(R.id.spinner)
        val nameTextView = findViewById<TextView>(R.id.textView)

        with (spinner) {
            adapter = CustomAdapter(names, this@MainActivity)
            onItemSelectedListener = object: OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    p0?.run {
                        nameTextView.text = getItemAtPosition(p2).toString()
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }

        findViewById<View>(R.id.deleteButton).setOnClickListener {
            if(names.size > 0) {
                (names as MutableList).removeAt(spinner.selectedItemPosition)
                (spinner.adapter as BaseAdapter).notifyDataSetChanged()
                if(names.size > 0){
                        val newSelection =
                            if (spinner.selectedItemPosition >= names.size) names.size - 1 else spinner.selectedItemPosition

                    spinner.setSelection(newSelection)
                    nameTextView.text = spinner.selectedItem.toString()
                } else {
                    nameTextView.text = "There are no names left to delete"
                }
            }
            else {
                nameTextView.text = "There are no names left to delete"
            }
        }

    }
}