package com.example.countravens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var btn_incr: Button? = null
    private var btn_next: Button? = null
    private var tv_counter: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        if (savedInstanceState != null )
        {
            val counter:String = savedInstanceState.getString("counter","0")
            tv_counter?.text = counter
        }

    }

    private fun initViews()
    {
        btn_incr = findViewById<Button>(R.id.btn_incr)
        btn_next = findViewById<Button>(R.id.btn_next)
        tv_counter = findViewById<TextView>(R.id.tv_count)

        btn_next?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ResultsActivity::class.java)
            intent.putExtra("counter", tv_counter?.text.toString())
            startActivity(intent)
        })

        btn_incr?.setOnClickListener(View.OnClickListener {
            var c = tv_counter?.text.toString().toInt()
            c += 1
            tv_counter?.text = c.toString()
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!tv_counter?.text.toString().equals("0")){
            outState.putString("counter",tv_counter?.text.toString())

        }
    }


}