package org.pondar.listviewotheruikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import org.pondar.listviewotheruikotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //normally you should not hardcode this, but keep in the strings.xml as a string array.
    private val countries = mutableListOf("Albania", "Algeria", "Armenia", "Andora", "Angola", "Argentina", "Australia", "Bahrain",
            "Bangladesh", "Barbados", "Brazil", "China", "Denmark", "Egypt", "France", "Ghana", "Hong Kong", "India", "Italy",
            "United Kingdom", "United States", "United Arab Emirates")


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, countries)

        //below is a way of initializing the adapter with something defined in the strings.xml
       /* adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,
                resources.getStringArray(R.array.countries2)
        )*/

        binding.mylist.choiceMode = ListView.CHOICE_MODE_SINGLE

        //Button clicked
        binding.button.setOnClickListener {
            val selected = binding.mylist.checkedItemPosition
            Log.d("selection", "selected: $selected")
            if (selected != ListView.INVALID_POSITION)
                Toast.makeText(applicationContext,
                        "My selection: " + countries[selected], Toast.LENGTH_SHORT).show()
        }

        binding.mylist.adapter = adapter
        binding.mylist.setOnItemClickListener { parent, v, position, id ->
            Log.d("listview", "itemclicked")
            val country = countries[position]
            Toast.makeText(applicationContext, "you clicked : $country", Toast.LENGTH_SHORT).show()
        }

        countries.add("United Nations")

    }
}
