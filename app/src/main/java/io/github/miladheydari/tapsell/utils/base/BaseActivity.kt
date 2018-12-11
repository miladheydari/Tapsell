package io.github.miladheydari.tapsell.utils.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {




    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val intent = Intent("PERMISSION_RECEIVER")
        intent.putExtra("requestCode", requestCode)
        intent.putExtra("permissions", permissions)
        intent.putExtra("grantResults", grantResults)
        sendBroadcast(intent)
    }

}
