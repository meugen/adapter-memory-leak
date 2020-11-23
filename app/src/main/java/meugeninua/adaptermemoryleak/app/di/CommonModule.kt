package meugeninua.adaptermemoryleak.app.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class CommonModule {

    @Provides
    fun liveData(): LiveData<String> = MutableLiveData()
}