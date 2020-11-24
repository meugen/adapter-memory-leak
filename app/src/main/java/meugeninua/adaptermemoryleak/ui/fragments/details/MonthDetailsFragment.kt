package meugeninua.adaptermemoryleak.ui.fragments.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.app.App
import meugeninua.adaptermemoryleak.ui.common.Binding

class MonthDetailsFragment: Fragment() {

    private val args: MonthDetailsFragmentArgs by navArgs()
    private val binding = Binding()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.injector(context).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_month_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.attachViews(viewLifecycleOwner, view)
        val month: TextView = binding.get(R.id.month)
        month.text = args.month
    }
}