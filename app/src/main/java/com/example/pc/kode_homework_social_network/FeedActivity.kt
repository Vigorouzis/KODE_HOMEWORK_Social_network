package com.example.pc.kode_homework_social_network

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.bottom_sheet.*


class FeedActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var feed = dataInit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        Glide.with(this).load(R.drawable.photo).apply(RequestOptions.centerCropTransform())
            .into(findViewById(R.id.collapsing_toolbar_image_view))

        val bottomSheet = findViewById<LinearLayout>(R.id.bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_lenta -> {
                    updateActivity(feed)
                    collapsing_toolbar_layout.title = "Лента"
                    Glide.with(this).load(R.drawable.photo).apply(RequestOptions.centerCropTransform())
                        .into(findViewById(R.id.collapsing_toolbar_image_view))

                    soderj.text = getText(R.string.Disc_uved)
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                }


                R.id.bottom_news -> {
                    val data: List<Feed> =
                        feed.filter { i -> i.type.findAnyOf(listOf("News")) != null }
                    updateActivity(data)
                    collapsing_toolbar_layout.title = "Новости"
                    Glide.with(this).load(R.drawable.photo2).apply(RequestOptions.centerCropTransform())
                        .into(findViewById(R.id.collapsing_toolbar_image_view))
                    soderj.text = getText(R.string.Disc_news)
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                }

                R.id.bottom_uved -> {
                    val data: List<Feed> =
                        feed.filter { i -> i.type.findAnyOf(listOf("Notification")) != null }
                    updateActivity(data)
                    collapsing_toolbar_layout.title = "Уведомления"
                    Glide.with(this).load(R.drawable.photo3).apply(RequestOptions.centerCropTransform())
                        .into(findViewById(R.id.collapsing_toolbar_image_view))

                    soderj.text = getText(R.string.Disc_uved)
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                }
            }
            true
        }

        updateActivity(feed)


    }

    //update cardViews to data array
    private fun updateActivity(data: List<Feed>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedAdapter(data)

        recyclerView = findViewById<RecyclerView>(R.id.collapsing_toolbar_recycler_view).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }
    }

    private fun dataInit(): List<Feed> =
        listOf(
            Feed(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.photo,
                "Notification"
            ),
            Feed(
                "Новость",
                "Здесь находится текст",
                R.drawable.photo,
                "News"
            ),
            Feed(
                "Новость",
                "Здесь находится текст",
                R.drawable.photo,
                "News"
            ),
            Feed(
                "Новость",
                "Здесь находится текст",
                R.drawable.photo,
                "News"
            ),
            Feed(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.photo,
                "Notification"
            ),
            Feed(
                "Уведомление",
                "Здесь находится текст",
                R.drawable.photo,
                "Notification"
            )

        )


}