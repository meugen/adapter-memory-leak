package meugeninua.adaptermemoryleak.ui.fragments.months

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.app.inject
import meugeninua.adaptermemoryleak.ui.common.Binding
import meugeninua.adaptermemoryleak.ui.common.BindingAction
import meugeninua.adaptermemoryleak.ui.common.NavControllerAction
import meugeninua.adaptermemoryleak.ui.common.bindToLifecycle
import meugeninua.adaptermemoryleak.ui.fragments.months.binding.setupMonths
import javax.inject.Inject

class MonthsFragment: Fragment() {

    @Inject
    lateinit var viewModel: IMonthsViewModel
    private val binding = Binding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireContext().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_months, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.attachViews(viewLifecycleOwner, view)
        binding.setupMonths(viewModel)
        viewModel.bindToLifecycle(viewLifecycleOwner)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.liveEvent.observe(viewLifecycleOwner, Observer { onEvent(it) })
    }

    private fun onEvent(event: Any) {
        when (event) {
            is BindingAction -> event.onAction(binding)
            is NavControllerAction -> event.onAction(binding.navController)
        }
    }
}