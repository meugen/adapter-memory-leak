package meugeninua.adaptermemoryleak.ui.common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

interface OnStartStopListener {

    fun onStart()
    fun onStop()
}

fun OnStartStopListener.bindToLifecycle(owner: LifecycleOwner) {
    owner.lifecycle.addObserver(object: LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_START -> onStart()
                Lifecycle.Event.ON_STOP -> onStop()
                else -> { }
            }
        }
    })
}