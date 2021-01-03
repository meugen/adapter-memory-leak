package meugeninua.adaptermemoryleak.ui.fragments.months

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import meugeninua.adaptermemoryleak.R

class MonthsAdapter(context: Context): RecyclerView.Adapter<MonthsAdapter.MonthHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var items = emptyList<String>()
    private var listener: ((String) -> Unit)? = null

    fun submitMonths(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setListener(listener: (String) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        val view = inflater.inflate(R.layout.item_month, parent, false)
        return MonthHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MonthHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MonthHolder(view: View): RecyclerView.ViewHolder(view) {

        private val monthView = view.findViewById<TextView>(R.id.month)
        private var month: String? = null

        init {
            monthView.setOnClickListener {
                month?.let { item -> listener?.invoke(item) }
            }
        }

        fun bind(month: String) {
            this.month = month
            monthView.text = month
        }
    }
}