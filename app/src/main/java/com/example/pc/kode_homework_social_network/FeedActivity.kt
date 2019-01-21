package com.example.pc.kode_homework_social_network

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_feed.*
import java.util.ArrayList

class FeedActivity : AppCompatActivity() {
    private val langList = ArrayList<Feed>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        addItem()
        val recyclerView: RecyclerView = findViewById(R.id.collapsing_toolbar_recycler_view)

        //vertical RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FeedAdapter(langList)


        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_lenta -> {
                    updateActivity(langList)
                                    }
                R.id.bottom_news -> {
                    val data: List<Feed> =
                        langList.filter { i -> i.type.findAnyOf(listOf("Новость")) != null }
                    updateActivity(data)
                    collapsing_toolbar_layout.title="Новости"
                    collapsing_toolbar_image_view.setBackgroundResource(R.drawable.photo2)


                }
                R.id.bottom_uved -> {
                    val data: List<Feed> =
                        langList.filter { i -> i.type.findAnyOf(listOf("Уведомление")) != null }
                    updateActivity(data)
                    collapsing_toolbar_layout.title="Уведомления"
                    collapsing_toolbar_image_view.setBackgroundResource(R.drawable.photo3)

                }
            }



               return@setOnNavigationItemSelectedListener false
        }


    }


    private fun addItem() {


        val Java = Feed(
            "Java",
            "Джеймс Гослинг",
            R.drawable.photo,
            "Новость"
        )
        langList.add(Java)

        val Java1 = Feed(
            "Java",
            "Джеймс Гослинг",
            R.drawable.photo2,
            "Уведомление"
        )
        langList.add(Java1)



    }

    private fun updateActivity(data: List<Feed>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedAdapter(data)

        recyclerView = findViewById<RecyclerView>(R.id.collapsing_toolbar_recycler_view).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }
    }
}









