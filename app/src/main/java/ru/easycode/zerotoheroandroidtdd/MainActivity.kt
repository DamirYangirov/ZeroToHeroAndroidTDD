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
    lateinit var mathOperation: MathOperation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)

        mathOperation = MathOperation.Initial

        button.setOnClickListener {
            mathOperation = MathOperation.Increment
            mathOperation.increment(textView)
        }
    }
}

interface MathOperation: Serializable{
    companion object{
        const val number = 2
    }
    fun increment(textView: TextView)
    object Initial: MathOperation {
        override fun increment(textView: TextView) {

        }

    }
    object Increment: MathOperation {
        override fun increment(textView: TextView) {

            val count = textView.text.toString().toInt()
            textView.text =(count+number).toString()
        }
    }

}