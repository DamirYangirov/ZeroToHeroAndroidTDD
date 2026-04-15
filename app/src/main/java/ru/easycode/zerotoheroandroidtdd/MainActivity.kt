package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.internal.TextScale

class MainActivity : AppCompatActivity() {


    lateinit var linearLayout: LinearLayout
    lateinit var textView: TextView
    companion object{
        val KEY = "key"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.removeButton)
        textView = findViewById<TextView>(R.id.titleTextView)
        linearLayout = findViewById<LinearLayout>(R.id.rootLayout)

        button.setOnClickListener {
            linearLayout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, linearLayout.childCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getInt(KEY) <2){
            linearLayout.removeView(textView)
        }
    }
}