package com.example.myapplicationadds

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.concurrent.timer
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.example.myapplicationadds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var binding: ActivityMainBinding
        lateinit var mAdView : AdView
        val AdUnitID = "ca-app-pub-3940256099942544/6300978111"
        val roulette:roulette = findViewById(R.id.roulette)

        // Relative layout インスタンス生成
        MobileAds.initialize(this){}


        mAdView = findViewById(R.id.adView)
        // AdMobをロードして表示
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        }

    }
