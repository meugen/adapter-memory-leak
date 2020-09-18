package meugeninua.adaptermemoryleak.fragments.months

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MonthsViewModel: ViewModel() {

    val monthsData = MutableLiveData<List<String>>(
        listOf("January", "February", "March", "May",
            "June", "July", "August", "September",
            "October", "November", "December")
    )
}