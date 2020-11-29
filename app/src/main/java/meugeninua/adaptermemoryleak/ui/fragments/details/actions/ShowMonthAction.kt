package meugeninua.adaptermemoryleak.ui.fragments.details.actions

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.ui.common.Binding
import meugeninua.adaptermemoryleak.ui.common.BindingAction
import meugeninua.adaptermemoryleak.ui.common.LiveEvent
import meugeninua.adaptermemoryleak.ui.common.LiveEventConfigurer

class ShowMonthAction(
    private val month: String
): BindingAction {

    override fun onAction(binding: Binding) {
        val monthView = binding.get<TextView>(R.id.month)
        monthView.text = month
    }

    companion object {

        @JvmStatic
        fun withLiveData(
            baseConfigurer: LiveEventConfigurer,
            monthsData: LiveData<String>
        ): LiveEventConfigurer = ShowMonthLiveEventConfigurer(baseConfigurer, monthsData)
    }
}

class ShowMonthLiveEventConfigurer(
    private val baseConfigurer: LiveEventConfigurer,
    private val monthData: LiveData<String>
): LiveEventConfigurer {

    override fun onAttach(liveEvent: LiveEvent<Any>) {
        baseConfigurer.onAttach(liveEvent)
        liveEvent.addSource(monthData, Observer {
            liveEvent.setValue(ShowMonthAction(it))
        })
    }

    override fun onDetach(liveEvent: LiveEvent<Any>) {
        baseConfigurer.onDetach(liveEvent)
        liveEvent.removeSource(monthData)
    }
}