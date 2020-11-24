package meugeninua.adaptermemoryleak.app.di

import dagger.Component
import meugeninua.adaptermemoryleak.MainActivity

@Component
interface AppComponent {
    fun inject(activity: MainActivity)
}