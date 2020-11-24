package meugeninua.adaptermemoryleak.ui.fragments.months.binding

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.ui.common.Binding
import meugeninua.adaptermemoryleak.ui.fragments.months.MonthsAdapter

interface MonthsBindingsListener {
    fun onMonthClick(month: String)
}

fun Binding.setupMonths(listener: MonthsBindingsListener) {
    val recycler: RecyclerView = get(R.id.recycler)
    recycler.layoutManager = LinearLayoutManager(context)
    recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    val adapter = MonthsAdapter(context)
    adapter.setListener { listener.onMonthClick(it) }
    recycler.adapter = adapter
}