package meugeninua.adaptermemoryleak.app.di.fragments.details

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import meugeninua.adaptermemoryleak.ui.fragments.details.IMonthDetailsViewModel
import meugeninua.adaptermemoryleak.ui.fragments.details.MonthDetailsFragment
import meugeninua.adaptermemoryleak.ui.fragments.details.MonthDetailsViewModel

@Module
interface MonthDetailsFragmentComponent {

    @ContributesAndroidInjector(modules = [MonthDetailsFragmentModule::class])
    fun bindFragment(): MonthDetailsFragment
}

@Module
class MonthDetailsFragmentModule {

    @Provides
    fun viewModel(fragment: MonthDetailsFragment): IMonthDetailsViewModel {
        val factory = MonthDetailsViewModelFactory(fragment, fragment.arguments)
        return ViewModelProvider(fragment, factory).get(MonthDetailsViewModel::class.java)
    }
}

class MonthDetailsViewModelFactory(registry: SavedStateRegistryOwner, arguments: Bundle?)
    : AbstractSavedStateViewModelFactory(registry, arguments ?: Bundle.EMPTY) {

    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return MonthDetailsViewModel(handle) as T
    }
}