package se.magictechnology.pia11data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    //val model : MainViewModel by viewModels()
    val model by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameObserver = Observer<String> { newName ->
            findViewById<TextView>(R.id.mainTextview).text = newName
        }

        model.currentName.observe(this, nameObserver)

        val numberObserver = Observer<Int> {
            findViewById<TextView>(R.id.mainTextview).text = it.toString()
        }

        model.theNumber.observe(this, numberObserver)

        model.loadstuff()

        findViewById<Button>(R.id.mainButton).setOnClickListener {
            model.currentName.value = "Bartil"
        }


    }


}