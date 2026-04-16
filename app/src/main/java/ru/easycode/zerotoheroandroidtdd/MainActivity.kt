package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val count =  Count.Base(2)
        button = findViewById(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)



        button.setOnClickListener {
            val digit = textView.text.toString()
            val string =  count.increment(digit)

            textView.text = string
        }


    }
}
