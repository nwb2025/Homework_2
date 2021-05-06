package com.example.countravens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    private var tv_counter: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        initViews()
        val intent = intent

        if ( intent != null)
            tv_counter?.text = intent.getStringExtra("counter")
    }
    private fun initViews()
    {
        tv_counter = findViewById<TextView>(R.id.tv_count)
    }
}