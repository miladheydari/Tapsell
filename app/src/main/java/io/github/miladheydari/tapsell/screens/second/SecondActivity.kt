package io.github.miladheydari.tapsell.screens.second

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dagger.android.AndroidInjection
import io.github.miladheydari.tapsell.R
import io.github.miladheydari.tapsell.utils.base.BaseActivity
import io.github.miladheydari.tapsell.utils.toast
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : BaseActivity(), SecondContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: SecondContract.Presenter

    override fun onClick(p0: View?) {
        if (p0?.id == btn_apply.id) {

            if (et_note.text.toString().isNotEmpty()) {
                btn_apply.progress = 50
                presenter.store(et_note.text.toString())
            } else {
                toast("لطفا اطلاعات را کامل وارد کنید.")
            }
        }
    }

    override fun onStore() {

        btn_apply.progress = 0
        finish()


    }

    override fun getBaseActivity(): BaseActivity {
        return this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        presenter.attachView(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_apply.isIndeterminateProgressMode = true
        btn_apply.setOnClickListener(this)
    }

    override fun onError(error: String?) {
        btn_apply.progress = 0
        super.onError(error)
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }
}
