package com.example.searchviewontoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {

    lateinit var mListView:ListView
    lateinit var mArrayAdapter:ArrayAdapter<String>
    val mArrayList = arrayOf("Arun","Anshar","Shrawan","Akash","Rahil","Chanchal","Arman","Nehal",
        "Sudish","Guddu","Sonalal","Abhishek","Dipak","Sonu","Suroj","Amit","Shankar","Vikarm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = findViewById(R.id.listView)
        mArrayAdapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,mArrayList)
        mListView.adapter = mArrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_menu_search,menu)
        val menuItem = menu!!.findItem(R.id.search_menu)
        var viewSearch = MenuItemCompat.getActionView(menuItem) as SearchView
        viewSearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewSearch.clearFocus()
                val query = ""
                if (mArrayList.contains(query))
                {
                    mArrayAdapter.filter.filter(query)
                }
                else
                {
                    Toast.makeText(applicationContext,"Match Not Found",Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newQuery: String?): Boolean {
                mArrayAdapter.filter.filter(newQuery)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}