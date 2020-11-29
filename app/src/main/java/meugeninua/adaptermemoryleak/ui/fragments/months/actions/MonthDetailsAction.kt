package meugeninua.adaptermemoryleak.ui.fragments.months.actions

import android.os.Bundle
import androidx.navigation.NavController
import meugeninua.adaptermemoryleak.R
import meugeninua.adaptermemoryleak.ui.common.NavControllerAction
import meugeninua.adaptermemoryleak.ui.fragments.details.MonthDetailsViewModel

class MonthDetailsAction(
    private val month: String
): NavControllerAction {

    override fun onAction(navController: NavController) {
        val args = Bundle()
        args.putString(MonthDetailsViewModel.ARG_MONTH, month)
        navController.navigate(R.id.navToDetails, args)
    }
}