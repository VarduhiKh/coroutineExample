package com.example.coroutines

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddRemoveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_remove)

        val add = findViewById<Button>(R.id.add)
        val remove = findViewById<Button>(R.id.remove)
        val reset = findViewById<Button>(R.id.reset)

        val count = findViewById<TextView>(R.id.count)
        val intent = intent
        count.setText(intent.getStringExtra(MainActivity.KEY_CURRENT_VALUE))
        val maxCount = intent.getStringExtra(MainActivity.KEY_MAX_VALUE)

        fun resetData() {
            reset.visibility = View.VISIBLE
            reset.setOnClickListener {
                count.setText(intent.getStringExtra(MainActivity.KEY_CURRENT_VALUE))
            }
        }

        GlobalScope.launch(Dispatchers.Default) {
            add.setOnClickListener {
                if (count.text.toString().toInt() == maxCount?.toInt()) {
                    resetData()
                } else
                    count.setText((count.text.toString().toInt() + 1).toString())
            }

            remove.setOnClickListener {
                if (count.text.toString().toInt() == 0) {
                    resetData()
                } else
                    count.setText((count.text.toString().toInt() - 1).toString())
            }
        }
    }
}

