package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {


    companion object{
        const val  KEY = "key_state"
    }
    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var linearLayout: LinearLayout
    lateinit var state: State
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        state = State.Initial

        button = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        linearLayout  = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            state = State.Remove
            state.apply(textView, linearLayout, button)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state =  savedInstanceState.getSerializable(KEY) as State
        state.apply(textView, linearLayout, button)
    }
}



interface State: Serializable{
    fun apply(textView: TextView, linearLayout: LinearLayout, button: Button)

    object Initial: State {
        override fun apply(
            textView: TextView,
            linearLayout: LinearLayout,
            button: Button,
        ) {

        }
    }

    object Remove: State{
        override fun apply(
            textView: TextView,
            linearLayout: LinearLayout,
            button: Button,
        ) {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }
}
