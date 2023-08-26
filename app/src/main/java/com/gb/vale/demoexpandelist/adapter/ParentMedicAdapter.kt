package com.gb.vale.demoexpandelist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gb.vale.demoexpandelist.R
import com.gb.vale.demoexpandelist.adapter.ParentMedicAdapter.ParentMedicViewHolder
import com.gb.vale.demoexpandelist.model.ParentMedic

@SuppressLint("NotifyDataSetChanged")
class ParentMedicAdapter : RecyclerView.Adapter<ParentMedicViewHolder>() {
    var list: List<ParentMedic> = ArrayList()
    var positionSelected = -1
    fun addList(listService: List<ParentMedic>) {
        list = listService
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentMedicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_clinic, parent, false)
        return ParentMedicViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ParentMedicViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.configClinic(list[position])
    }

    private fun updateList(positionUpdate: Int) {
        for (i in list.indices) {
            if (i == positionUpdate) {
                list[i].isSelected = !list[i].isSelected
            } else {
                list[i].isSelected = false
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

     inner class ParentMedicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView
        private val address: TextView
        private val arrow: ImageView
        private val rvHistory: RecyclerView
        var adapterHistory = ExpandedHistoryAdapter()

        init {
            title = itemView.findViewById(R.id.textTitle)
            address = itemView.findViewById(R.id.textAddress)
            rvHistory = itemView.findViewById(R.id.rvHistory)
            arrow = itemView.findViewById(R.id.imgArrow)
            rvHistory.layoutManager = LinearLayoutManager(itemView.context)
            rvHistory.adapter = adapterHistory
        }

        fun configClinic(parentMedic: ParentMedic) {
            title.text = parentMedic.nameClinic
            address.text = parentMedic.address
            adapterHistory.addList(parentMedic.listHistory)
            if (parentMedic.isSelected) {
                rvHistory.visibility = View.VISIBLE
            } else {
                rvHistory.visibility = View.GONE
            }
            arrow.setOnClickListener {
                positionSelected = adapterPosition
                updateList(positionSelected)
            }
        }
    }
}