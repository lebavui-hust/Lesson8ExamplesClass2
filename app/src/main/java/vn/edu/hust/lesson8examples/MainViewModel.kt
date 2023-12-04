package vn.edu.hust.lesson8examples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel: ViewModel() {
    var count = MutableLiveData(0)

    fun increaseCount() {
        count.postValue(count.value!! + 1)
    }

    val text = MutableLiveData<String>("")
    val textReverse: LiveData<String> = text.map {
        it.reversed()
    }

    val textA = MutableLiveData("")
    val textB = MutableLiveData("")
    val aOrb = MutableLiveData(true)

    val switchText: LiveData<String> = aOrb.switchMap {
        if (it) textA else textB
    }

}