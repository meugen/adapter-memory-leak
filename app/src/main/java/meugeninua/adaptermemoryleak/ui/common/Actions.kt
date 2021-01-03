package meugeninua.adaptermemoryleak.ui.common

import androidx.navigation.NavController

interface BindingAction {
    fun onAction(binding: Binding)
}

interface NavControllerAction {
    fun onAction(navController: NavController)
}