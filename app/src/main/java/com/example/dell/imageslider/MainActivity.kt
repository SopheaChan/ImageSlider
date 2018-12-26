package com.example.dell.imageslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: SlideShowAdapter
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var mTimer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mAdapter = SlideShowAdapter(this)
        view_pager.adapter = mAdapter
        circleIndicator.setViewPager(view_pager)

        mHandler = Handler()
        mRunnable = Runnable {
            var i = view_pager.currentItem

            if (i == mAdapter.images.size - 1) {

                i = 0
                view_pager.setCurrentItem(i, true)

            } else {

                i++
                view_pager.setCurrentItem(i, true)
            }
        }

        mTimer = Timer()
        mTimer.schedule(object : TimerTask() {
            override fun run() {

                mHandler.post(mRunnable)
            }
        }, 4000, 4000)
    }
}

