package meugeninua.adaptermemoryleak.app.di.fragments.months

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import meugeninua.adaptermemoryleak.ui.fragments.months.IMonthsViewModel
import meugeninua.adaptermemoryleak.ui.fragments.months.MonthsFragment
import meugeninua.adaptermemoryleak.ui.fragments.months.MonthsViewModel

@Module
interface MonthsFragmentComponent {

    @ContributesAndroidInjector(modules = [MonthsFragmentModule::class])
    fun bindFragment(): MonthsFragment
}

@Module
class MonthsFragmentModule {

    @Provides
    fun viewModel(fragment: MonthsFragment): IMonthsViewModel {
        return ViewModelProvider(fragment).get(MonthsViewModel::class.java)
    }
}