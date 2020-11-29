package meugeninua.adaptermemoryleak.ui.fragments.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import meugeninua.adaptermemoryleak.ui.common.LiveEvent
import meugeninua.adaptermemoryleak.ui.common.LiveEventConfigurer
import meugeninua.adaptermemoryleak.ui.common.OnStartStopListener
import meugeninua.adaptermemoryleak.ui.fragments.details.actions.ShowMonthAction

interface IMonthDetailsViewModel: OnStartStopListener {
    val liveEvent: LiveEvent<Any>
}

class MonthDetailsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel(), IMonthDetailsViewModel {

    override val liveEvent = LiveEvent<Any>()
    private val configurer: LiveEventConfigurer

    init {
        var configurer: LiveEventConfigurer = LiveEventConfigurer.EMPTY
        configurer = ShowMonthAction.withLiveData(configurer, savedStateHandle.getLiveData(ARG_MONTH))
        this.configurer = configurer
    }

    override fun onStart() {
        configurer.onAttach(liveEvent)
    }

    override fun onStop() {
        configurer.onDetach(liveEvent)
    }

    companion object {
        const val ARG_MONTH = "month"
    }
}