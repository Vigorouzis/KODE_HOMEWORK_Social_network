package com.example.pc.kode_homework_social_network

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

class FeedActivity : AppCompatActivity() {
    private val langList = ArrayList<Feed>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
//        val toolbar = findViewById<View>(R.id.collapsing_toolbar) as Toolbar
//        setSupportActionBar(toolbar)
        addItem()
        val recyclerView: RecyclerView = findViewById(R.id.collapsing_toolbar_recycler_view)

        //vertical RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FeedAdapter(langList)


        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    private fun addItem() {


        val Java = Feed(
            "Java",
            "Джеймс Гослинг",

            R.drawable.photo
        )
        langList.add(Java)


    }
}




