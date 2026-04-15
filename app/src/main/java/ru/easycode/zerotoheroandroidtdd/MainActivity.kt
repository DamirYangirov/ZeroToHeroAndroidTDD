package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.internal.TextScale
import java.io.Serializable

class MainActivity : AppCompatActivity() {


    lateinit var linearLayout: LinearLayout
    lateinit var textView: TextView
    lateinit var state: State
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

        state = State.Initial
        button.setOnClickListener {
            state = State.Removed
            state.apply(textView, linearLayout)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as State
        state.apply(textView, linearLayout)
    }
}

interface  State: Serializable{
    fun apply (textView: TextView, linearLayout: LinearLayout)
    object Initial: State {
        override fun apply(
            textView: TextView,
            linearLayout: LinearLayout,
        ): Unit {
        }
    }

    object Removed: State {
        override fun apply(
            textView: TextView,
            linearLayout: LinearLayout,
        ) {
            linearLayout.removeView(textView)
        }
    }


}
