package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY = "Visible"

    }

    lateinit var button: Button
    lateinit var textView: TextView
    var isVisibile = true


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.hideButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            textView.visibility = View.INVISIBLE
            isVisibile = false
            Log.e("TAG", "setOnClickListener: $isVisibile ", )
        }
        Log.e("onCreate", "onCreate: $isVisibile ", )

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, isVisibile)
        Log.e("onSaveInstanceState", isVisibile.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            isVisibile = savedInstanceState.getBoolean(KEY)
        if(!isVisibile){
            textView.visibility = View.INVISIBLE
        }
        Log.e("onRestoreInstanceState", isVisibile.toString())

    }
}