package com.example.com.example.myapplicationadds

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.concurrent.timer

class roulette(context: Context?,attrs:AttributeSet?,var color: Int): View(context) {

    private var paint: Paint = Paint()
    var deg:Float = 0F
    var n = 6
    var degm:Float = 0F
    var state = 0
    var txt:String = "START"
    val colLis = listOf(
        Color.argb(200,200,125,125),
        Color.argb(200,125,125,200),
        Color.argb(200,125,200,125),
        Color.argb(200,120,200,200),
        Color.argb(200,200,200,120),
        Color.argb(200,200,120,200))

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        if(state == 0) {
            state = 1
            degm = 179F
            txt = "STOP"
        }else if(state == 1){
            state = 2
            txt = "WAIT"
        }
        return super.onTouchEvent(event)

    }

    override fun onDraw(canvas: Canvas?) {
        val wid = width.toFloat()
        val height = height.toFloat()
        super.onDraw(canvas)
        canvas?.drawColor(color)
        paint.setColor(colLis[2])
        val re = RectF(wid/2-300F,height/2-300F,wid/2+300F,height/2+300F)
        for(i in 0..n-1){
            paint.setColor(colLis[i%n])
            var rad:Float = 360/n.toFloat()
            canvas?.drawArc(re,(rad*i+deg)%360,rad,true,paint)
            paint.setColor(Color.WHITE)
        }
        canvas?.drawCircle(wid/2,height/2,200F,paint)
        paint.setColor(Color.BLACK)
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = 100F
        canvas?.drawText(txt,wid/2,height/2,paint)
        deg += degm
        if(state == 2)degm -= 2F
        if(degm <= 0F){
            degm = 0F
            state = 0
            txt = "START"
        }
        invalidate()
    }
}
