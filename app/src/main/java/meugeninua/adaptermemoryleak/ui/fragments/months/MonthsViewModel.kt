package meugeninua.adaptermemoryleak.ui.fragments.months

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import meugeninua.adaptermemoryleak.ui.common.LiveEvent
import meugeninua.adaptermemoryleak.ui.common.LiveEventConfigurer
import meugeninua.adaptermemoryleak.ui.common.OnStartStopListener
import meugeninua.adaptermemoryleak.ui.fragments.months.actions.MonthDetailsAction
import meugeninua.adaptermemoryleak.ui.fragments.months.actions.MonthsAction

interface IMonthsViewModel: OnStartStopListener {
    val liveEvent: LiveData<Any>

    fun onMonthClick(month: String)
}

class MonthsViewModel: ViewModel(), IMonthsViewModel {

    override val liveEvent = LiveEvent<Any>()
    private val monthsData = MutableLiveData(listOf(
        "January", "February", "March", "May",
        "June", "July", "August", "September",
        "October", "November", "December"))
    private val configurer: LiveEventConfigurer

    init {
        var configurer: LiveEventConfigurer = LiveEventConfigurer.EMPTY
        configurer = MonthsAction.withLiveData(configurer, monthsData)
        this.configurer = configurer
    }

    override fun onMonthClick(month: String) {
        liveEvent.setValue(MonthDetailsAction(month))
    }

    override fun onStart() {
        configurer.onAttach(liveEvent)
    }

    override fun onStop() {
        configurer.onDetach(liveEvent)
    }
}