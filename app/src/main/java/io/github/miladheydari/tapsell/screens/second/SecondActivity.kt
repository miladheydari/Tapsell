package io.github.miladheydari.tapsell.screens.second

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import dagger.android.AndroidInjection
import io.github.miladheydari.tapsell.R
import io.github.miladheydari.tapsell.utils.ViewModelFactory
import io.github.miladheydari.tapsell.utils.base.BaseActivity
import io.github.miladheydari.tapsell.utils.toast
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : BaseActivity(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var noteViewModel: NoteViewModel

    override fun onClick(p0: View?) {
        if (p0?.id == btn_apply.id) {

            if (et_note.text.toString().isNotEmpty()) {
                btn_apply.progress = 50
                noteViewModel.store(et_note.text.toString())
            } else {
                toast("لطفا اطلاعات را کامل وارد کنید.")
            }
        }
    }

    private fun onStore() {

        btn_apply.progress = 0
        finish()


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        noteViewModel = ViewModelProviders.of(this, viewModelFactory).get(NoteViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_apply.isIndeterminateProgressMode = true
        btn_apply.setOnClickListener(this)
        observableViewModel()
    }


    private fun observableViewModel() {

        noteViewModel.success.observe(this, Observer {

            if (it == true) {
                onStore()
            }
        })
        noteViewModel.loading.observe(this, Observer {
            if (it == true)
                btn_apply.progress = 50
        })

        noteViewModel.error.observe(this, Observer {
            if (it?.first == true)
                onError()
        })

    }

    private fun onError() {
        btn_apply.progress = 0
    }

}
