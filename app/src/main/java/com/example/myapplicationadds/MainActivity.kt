package com.example.myapplicationadds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val AdUnitID = "ca-app-pub-1640470884247283/9130371672"

        // Relative layout インスタンス生成
        val layout = RelativeLayout(this)
        setContentView(layout)

        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        // AdMob インスタンス生成
        val adMobView = AdView(this)
        adMobView.setAdUnitId(AdUnitID)
        adMobView.setAdSize(AdSize.BANNER)
        // AdMobをレイアウトに追加
        layout.addView(adMobView)

        // AdMobのレイアウト属性を設定
        adMobView.setLayoutParams(params)

        // AdMobをロードして表示
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}

