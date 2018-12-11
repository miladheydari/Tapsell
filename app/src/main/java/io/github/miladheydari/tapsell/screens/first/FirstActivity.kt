package io.github.miladheydari.tapsell.screens.first


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import io.github.miladheydari.tapsell.R
import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.screens.second.SecondActivity
import io.github.miladheydari.tapsell.utils.base.BaseActivity
import io.github.miladheydari.tapsell.view.LoadingLayout
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.layout_empty.*
import javax.inject.Inject

class FirstActivity : BaseActivity(), FirstContract.View, View.OnClickListener {

    @Inject
    lateinit var presenter: FirstContract.Presenter
    private var notes: MutableList<Note> = ArrayList()
    private var adapter = Adapter(notes)

    override fun onGetNotes(t: List<Note>) {
        notes.clear()
        notes.addAll(t)
        adapter.notifyDataSetChanged()
        loading_layout.state = LoadingLayout.STATE_SHOW_DATA

    }
    override fun onClick(p0: View?) {
        if(p0?.id==fab.id){
            startActivity(Intent(this,SecondActivity::class.java))

        }


    }

    override fun getBaseActivity(): BaseActivity {
        return this
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        presenter.attachView(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        recycler.layoutManager = mLayoutManager
        recycler.itemAnimator= DefaultItemAnimator()
        recycler.adapter = adapter
        recycler.emptyView = layout_empty
        fab.setOnClickListener(this)

    }

    override fun onResume() {
        presenter.getNotes()
        super.onResume()
    }

    override fun onError(error: String?) {
        error?.let {
            loading_layout.setError(it)
        }
        super.onError(error)
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

}
