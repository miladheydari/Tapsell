package io.github.miladheydari.tapsell.screens.first


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import io.github.miladheydari.tapsell.R
import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.screens.second.SecondActivity
import io.github.miladheydari.tapsell.utils.ViewModelFactory
import io.github.miladheydari.tapsell.utils.base.BaseActivity
import io.github.miladheydari.tapsell.view.LoadingLayout
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.layout_empty.*
import javax.inject.Inject

class FirstActivity : BaseActivity(), View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var notesViewModel: NotesViewModel
    private var notes: MutableList<Note> = ArrayList()
    private var adapter = Adapter(notes)

    private fun onGetNotes(t: List<Note>) {
        notes.clear()
        notes.addAll(t)
        adapter.notifyDataSetChanged()
        loading_layout.state = LoadingLayout.STATE_SHOW_DATA

    }

    override fun onClick(p0: View?) {
        if (p0?.id == fab.id) {
            startActivity(Intent(this, SecondActivity::class.java))

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        notesViewModel = ViewModelProviders.of(this, viewModelFactory).get(NotesViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        recycler.layoutManager = mLayoutManager
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.adapter = adapter
        recycler.emptyView = layout_empty
        fab.setOnClickListener(this)
        observableViewModel()

    }

    private fun observableViewModel() {

        notesViewModel.notes.observe(this, Observer {

            if (it != null) {
                onGetNotes(it)
            }
        })
        notesViewModel.loading.observe(this, Observer {
            if (it == true)
                loading_layout.state = LoadingLayout.STATE_LOADING
        })

        notesViewModel.error.observe(this, Observer {
            if (it?.first == true)
                onError(it.second)
        })

    }

    override fun onResume() {
        super.onResume()
        notesViewModel.fetchData()
    }


    private fun onError(error: String?) {
        error?.let {
            loading_layout.setError(it)
        }
    }

}
