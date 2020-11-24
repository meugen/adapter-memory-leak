package meugeninua.adaptermemoryleak.ui.common

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.collection.SparseArrayCompat
import androidx.collection.set
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavController
import androidx.navigation.Navigation

class Binding: LifecycleObserver {

    val context: Context
        get() = requireNotNull(rootView).context
    val navController: NavController
        get() = Navigation.findNavController(requireNotNull(rootView))

    private var rootView: View? = null
    private var childrenViews: SparseArrayCompat<View>? = null

    fun attachViews(owner: LifecycleOwner, view: View) {
        rootView = view
        childrenViews = SparseArrayCompat()

        owner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun detachViews(owner: LifecycleOwner) {
        rootView = null
        childrenViews?.clear()
        childrenViews = null

        owner.lifecycle.removeObserver(this)
    }

    private fun find(@IdRes id: Int): View? {
        val _rootView = this.rootView ?: return null
        val _childrenViews = this.childrenViews ?: return null

        var view = _childrenViews[id]
        if (view == null) {
            view = _rootView.findViewById(id)
            if (view != null) {
                _childrenViews[id] = view
            }
        }
        return view
    }

    fun has(@IdRes id: Int) = find(id) != null

    fun <V: View> get(@IdRes id: Int): V = find(id) as V
}