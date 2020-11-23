package meugeninua.adaptermemoryleak.fragments.months

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MonthsViewModel @ViewModelInject constructor(
    private val liveData: LiveData<String>
): ViewModel() {

    val monthsData = MutableLiveData<List<String>>(
        listOf("January", "February", "March", "May",
            "June", "July", "August", "September",
            "October", "November", "December")
    )
}