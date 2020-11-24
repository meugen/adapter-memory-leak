package meugeninua.adaptermemoryleak.app.di.fragments.details

import dagger.Module
import dagger.android.ContributesAndroidInjector
import meugeninua.adaptermemoryleak.ui.fragments.details.MonthDetailsFragment

@Module
interface MonthDetailsFragmentComponent {

    @ContributesAndroidInjector
    fun bindFragment(): MonthDetailsFragment
}