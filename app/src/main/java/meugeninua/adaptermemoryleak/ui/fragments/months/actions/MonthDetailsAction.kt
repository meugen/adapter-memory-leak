package meugeninua.adaptermemoryleak.ui.fragments.months.actions

import androidx.navigation.NavController
import meugeninua.adaptermemoryleak.ui.common.NavControllerAction
import meugeninua.adaptermemoryleak.ui.fragments.months.MonthsFragmentDirections.Companion.navToDetails

class MonthDetailsAction(
    private val month: String
): NavControllerAction {

    override fun onAction(navController: NavController) {
        navController.navigate(navToDetails(month))
    }
}