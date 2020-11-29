package meugeninua.adaptermemoryleak.ui.fragments.details.actions

import android.widget.TextView
import androidx.lifecycle.LiveData
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.ui.common.Binding
import meugeninua.adaptermemoryleak.ui.common.BindingAction
import meugeninua.adaptermemoryleak.ui.common.DefaultLiveEventConfigurer
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
        ): LiveEventConfigurer = DefaultLiveEventConfigurer(baseConfigurer, monthsData) { ShowMonthAction(it) }
    }
}