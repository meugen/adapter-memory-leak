package meugeninua.adaptermemoryleak.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import meugeninua.adaptermemoryleak.app.App
import meugeninua.adaptermemoryleak.app.di.fragments.details.MonthDetailsFragmentComponent
import meugeninua.adaptermemoryleak.app.di.fragments.months.MonthsFragmentComponent

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

@Module(includes = [
    AndroidSupportInjectionModule::class,
    UiModule::class
])
interface AppModule

@Module(includes = [
    MonthsFragmentComponent::class,
    MonthDetailsFragmentComponent::class
])
interface UiModule