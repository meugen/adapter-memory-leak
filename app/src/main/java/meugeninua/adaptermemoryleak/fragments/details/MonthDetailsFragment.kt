package meugeninua.adaptermemoryleak.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.databinding.LayoutComposeBinding

class MonthDetailsFragment: Fragment() {

    private val args by navArgs<MonthDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_compose, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LayoutComposeBinding.bind(view).composeView.setContent {
            content(args.month)
        }
    }

    @Composable
    fun content(month: String) {
        ConstraintLayout {
            val text = createRef()

            Text(
                text = month,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.constrainAs(text) {
                    centerTo(parent)
                }
            )
        }
    }
}