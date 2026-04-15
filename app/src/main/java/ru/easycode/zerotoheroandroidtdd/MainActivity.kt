package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.compose.runtime.savedinstancestate.savedInstanceState

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_INSTANCE_STATE = "KeyInstanceState"
    }

    private lateinit var tv: TextView
    private lateinit var btn: Button
    private var textWhoAmI: String = "I am an Android Developer!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.changeButton)



        btn.setOnClickListener {
            tv.text = textWhoAmI
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_INSTANCE_STATE, tv.text.toString())
    }

    override fun onSaveInstanceState(
        outState: Bundle,
        outPersistentState: PersistableBundle,
    ) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tv.text = savedInstanceState.getString(KEY_INSTANCE_STATE)
    }
}