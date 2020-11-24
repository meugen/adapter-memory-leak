package meugeninua.adaptermemoryleak.ui.common

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class LiveEvent<T>: MediatorLiveData<T>() {

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner, Observer {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(value: T) {
        pending.set(true)
        super.setValue(value)
    }
}

interface LiveEventConfigurer {
    fun onAttach(liveEvent: LiveEvent<Any>)
    fun onDetach(liveEvent: LiveEvent<Any>)

    companion object EMPTY: LiveEventConfigurer {
        override fun onAttach(liveEvent: LiveEvent<Any>) { }

        override fun onDetach(liveEvent: LiveEvent<Any>) { }
    }
}