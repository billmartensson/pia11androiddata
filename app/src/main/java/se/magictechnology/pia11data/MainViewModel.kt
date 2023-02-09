package se.magictechnology.pia11data

import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val theNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun loadstuff() {
        /*
        Timer().schedule(5000) {

        }
        */

        Handler(Looper.getMainLooper()).postDelayed({
            currentName.value = "Hej"
        }, 5000)


        theNumber.value = 10

        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // do something
                theNumber.value = theNumber.value!! - 1
            }
            override fun onFinish() {
                // do something
                currentName.value = "ITS DONE!"
            }
        }
        timer.start()


    }
}