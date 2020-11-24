package meugeninua.adaptermemoryleak.app.di.fragments.months

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
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
abstract class MonthsFragmentModule {

    @Binds
    abstract fun bindsViewModel(viewModel: MonthsViewModel): IMonthsViewModel

    companion object {

        @Provides
        fun viewModel(fragment: MonthsFragment): MonthsViewModel {
            return ViewModelProvider(fragment).get(MonthsViewModel::class.java)
        }
    }
}