
package io.github.miladheydari.tapsell.utils.base

import android.widget.Toast


interface IView<T> {

    fun onError(error: String?) {
        Toast.makeText(getBaseActivity(), error, Toast.LENGTH_LONG).show()
    }

    fun getBaseActivity(): BaseActivity

}
