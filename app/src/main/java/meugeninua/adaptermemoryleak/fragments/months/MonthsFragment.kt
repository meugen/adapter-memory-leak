package meugeninua.adaptermemoryleak.fragments.months

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_months.*
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.fragments.months.MonthsFragmentDirections.Companion.navToDetails

class MonthsFragment: Fragment() {

    private val viewModel: MonthsViewModel by viewModels()
    private var adapter: MonthsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_months, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = MonthsAdapter(context)
        adapter?.setListener {
            findNavController().navigate(navToDetails(it))
        }
        recycler.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.monthsData.observe(viewLifecycleOwner, Observer {
            adapter?.submitMonths(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // TODO To fix memory leak uncomment next line
//        recycler.adapter = null
    }
}