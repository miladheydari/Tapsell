package io.github.miladheydari.tapsell.screens.first

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.miladheydari.hferecyclerview.HFEAdapter
import io.github.miladheydari.tapsell.R
import io.github.miladheydari.tapsell.repository.db.entities.Note

class Adapter(_data: List<Note>?) : HFEAdapter<Note>(_data) {
    override fun getItemView(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolder(inflater.inflate(R.layout.row, parent, false))

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.tv.text = getItem(position).note


            }
            else -> {
            }

        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv: TextView = view.findViewById(R.id.tv)

    }
}