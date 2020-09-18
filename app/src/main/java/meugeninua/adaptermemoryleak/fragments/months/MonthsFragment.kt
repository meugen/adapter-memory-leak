package meugeninua.adaptermemoryleak.fragments.months

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.ui.tooling.preview.Preview
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.databinding.LayoutComposeBinding

class MonthsFragment: Fragment() {

    private val viewModel: MonthsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_compose, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LayoutComposeBinding.bind(view).composeView.setContent {
            content(viewModel.monthsData)
        }
    }

    private fun onClickMonth(month: String) {
        findNavController().navigate(MonthsFragmentDirections.navToDetails(month))
    }

    @Composable
    fun content(monthsData: LiveData<List<String>>) {
        val state = monthsData.observeAsState()
        LazyColumnFor(
            items = state.value ?: emptyList()
        ) {
            monthItem(month = it)
        }
    }

    @Composable
    fun LazyItemScope.monthItem(month: String) {
        Column {
            Box(
                modifier = Modifier.fillParentMaxWidth()
                    .height(50.dp)
                    .clickable { onClickMonth(month) },
                gravity = ContentGravity.CenterStart
            ) {
                Text(
                    text = month,
                    modifier = Modifier.fillParentMaxWidth()
                        .padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.body1
                )
            }
            Divider()
        }
    }

    @Preview
    @Composable
    fun preview() {
        content(monthsData = MutableLiveData(listOf("Month 1", "Month 2")))
    }
}