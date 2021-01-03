package meugeninua.adaptermemoryleak.app

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import meugeninua.adaptermemoryleak.app.di.DaggerAppComponent
import javax.inject.Inject

class App: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent
            .factory().create(this)
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    companion object {

        @JvmStatic
        fun injector(context: Context) = (context.applicationContext as App).androidInjector()
    }
}

fun Context.inject(component: Any) {
    App.injector(this).inject(component)
}