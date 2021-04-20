package com.example.coroutines

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        val KEY_CURRENT_VALUE = "CURRENT_VALUE"
        val KEY_MAX_VALUE = "MAX_VALUE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentCount = findViewById<EditText>(R.id.current_count).text
        val maxValue = findViewById<EditText>(R.id.max_count).text
        val next = findViewById<Button>(R.id.next)

        next.setOnClickListener {
            if (maxValue.toString().toInt() < currentCount.toString().toInt()) {
                Toast.makeText(
                    getApplicationContext(),
                    "The max value must be greater than or equal to current value!!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, AddRemoveActivity::class.java)
                intent.putExtra(KEY_CURRENT_VALUE, currentCount.toString())
                intent.putExtra(KEY_MAX_VALUE, maxValue.toString())
                startActivity(intent)
            }
        }
    }
}