package org.pondar.listviewotheruikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //normally you should not hardcode this, but keep in the strings.xml as a string array.
    private val countries = mutableListOf("Albania", "Algeria", "Armenia", "Andora", "Angola", "Argentina", "Australia", "Bahrain",
            "Bangladesh", "Barbados", "Brazil", "China", "Denmark", "Egypt", "France", "Ghana", "Hong Kong", "India", "Italy",
            "United Kingdom", "United States", "United Arab Emirates")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, countries)

        //below is a way of initializing the adapter with something defined in the strings.xml
       /* adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,
                    resources.getStringArray(R.array.countries2)
                )*/

        mylist.choiceMode = ListView.CHOICE_MODE_SINGLE

        //Button clicked
        button.setOnClickListener{
            val selected = mylist.checkedItemPosition
            Log.d("selection", "selected: $selected")
            if (selected != ListView.INVALID_POSITION)
                Toast.makeText(applicationContext,
                        "My selection: " + countries[selected], Toast.LENGTH_SHORT).show()
        }

        mylist.adapter = adapter
        mylist.setOnItemClickListener { parent, view, position, id ->
            Log.d("listview", "itemclicked")
            val country = countries[position]
            Toast.makeText(applicationContext, "you clicked : $country", Toast.LENGTH_SHORT).show()
        }

        countries.add("United Nations")



    }
}
