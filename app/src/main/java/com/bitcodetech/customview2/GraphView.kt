package com.bitcodetech.customview2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import java.util.Random
import kotlin.math.absoluteValue

class GraphView(
    context: Context,
    attributeSet: AttributeSet?
) : androidx.appcompat.widget.AppCompatImageView(context, attributeSet){

    constructor(context: Context) : this(context, null)

    var values : Array<Int>? = null
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if(values == null) {
            return
        }

        val paint = Paint()
        paint.color = Color.RED

        val percToHeight = height / 100
        val barWidth = width / values!!.size

        val random = Random()

        for((position, value) in values!!.withIndex()) {

            paint.color = Color.rgb(
                random.nextInt().absoluteValue % 256,
                random.nextInt().absoluteValue % 256,
                random.nextInt().absoluteValue % 256
            )

            canvas.drawRect(
                position * barWidth.toFloat(), (height - (percToHeight * value).toFloat()),
                position*barWidth.toFloat() - 10 + barWidth, height.toFloat(),
                paint
            )
        }
    }

}