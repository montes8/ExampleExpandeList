package com.gb.vale.demoexpandelist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gb.vale.demoexpandelist.R
import com.gb.vale.demoexpandelist.adapter.ExpandedHistoryAdapter.ExpandedHistoryViewHolder
import com.gb.vale.demoexpandelist.model.ExpandeHistory

@SuppressLint("NotifyDataSetChanged")
class ExpandedHistoryAdapter : RecyclerView.Adapter<ExpandedHistoryViewHolder>() {
    private var list: List<ExpandeHistory> = ArrayList()
    fun addList(listService: List<ExpandeHistory>) {
        list = listService
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandedHistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_history, parent, false)
        return ExpandedHistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpandedHistoryViewHolder, position: Int) {
        holder.configHistory(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class ExpandedHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val date: TextView
        private val description: TextView

        init {
            date = itemView.findViewById(R.id.textDate)
            description = itemView.findViewById(R.id.textDescription)
        }

        fun configHistory(expandeHistory: ExpandeHistory) {
            date.text = expandeHistory.dateHistory
            description.text = expandeHistory.description
        }
    }
}