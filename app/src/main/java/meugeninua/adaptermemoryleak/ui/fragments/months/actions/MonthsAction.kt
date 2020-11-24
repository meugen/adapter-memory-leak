package meugeninua.adaptermemoryleak.ui.fragments.months.actions

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.ui.common.Binding
import meugeninua.adaptermemoryleak.ui.common.BindingAction
import meugeninua.adaptermemoryleak.ui.common.LiveEvent
import meugeninua.adaptermemoryleak.ui.common.LiveEventConfigurer
import meugeninua.adaptermemoryleak.ui.fragments.months.MonthsAdapter

class MonthsAction(
    private val months: List<String>
): BindingAction {

    override fun onAction(binding: Binding) {
        val recycler: RecyclerView = binding.get(R.id.recycler)
        val adapter = recycler.adapter as? MonthsAdapter
        adapter?.submitMonths(months)
    }

    companion object {

        @JvmStatic
        fun withLiveData(
            base: LiveEventConfigurer,
            liveData: LiveData<List<String>>
        ): LiveEventConfigurer = MonthsLiveEventConfigurer(base, liveData)
    }
}

class MonthsLiveEventConfigurer(
    private val baseConfigurer: LiveEventConfigurer,
    private val liveData: LiveData<List<String>>
): LiveEventConfigurer {

    override fun onAttach(liveEvent: LiveEvent<Any>) {
        baseConfigurer.onAttach(liveEvent)
        liveEvent.addSource(liveData, Observer {
            liveEvent.setValue(MonthsAction(it))
        })
    }

    override fun onDetach(liveEvent: LiveEvent<Any>) {
        baseConfigurer.onDetach(liveEvent)
        liveEvent.removeSource(liveData)
    }
}
