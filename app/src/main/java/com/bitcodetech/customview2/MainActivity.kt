package com.bitcodetech.customview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    private lateinit var graphViewMarks : GraphView
    private lateinit var btnRefresh : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        graphViewMarks.values = arrayOf(60, 90, 50, 80, 40, 70)

        btnRefresh.setOnClickListener {
            val random = Random()
            val values = Array<Int>(
                random.nextInt().absoluteValue % 11 + 1,
                {index -> random.nextInt().absoluteValue % 101}
            )
            graphViewMarks.values = values
        }
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        btnRefresh = findViewById(R.id.btnRefresh)
        graphViewMarks = findViewById(R.id.graphViewMarks)
    }
}