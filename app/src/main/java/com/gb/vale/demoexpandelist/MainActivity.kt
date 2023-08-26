package com.gb.vale.demoexpandelist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gb.vale.demoexpandelist.adapter.ParentMedicAdapter
import com.gb.vale.demoexpandelist.model.ParentMedic
import com.gb.vale.demoexpandelist.presenter.IMainPresenter
import com.gb.vale.demoexpandelist.presenter.PresenterMain

class MainActivity : AppCompatActivity(), IMainPresenter {
    var adapterParent = ParentMedicAdapter()
    private var rvParent: RecyclerView? = null
    private var rbSelector: RadioGroup? = null
    private var presenterMain: PresenterMain? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvParent = findViewById(R.id.rvClinic)
        rbSelector = findViewById(R.id.rgSelected)
        rvParent?.layoutManager = LinearLayoutManager(this)
        rvParent?.adapter = adapterParent
        presenterMain = PresenterMain(this)
        selectedDate(1)
        configRadioSelector()
    }

    private fun selectedDate(date: Int) {
        presenterMain!!.getListParent(date)
    }

    override fun successListParent(list: List<ParentMedic>, value: Int) {
        rvParent?.visibility =
            if (list.isEmpty()) View.GONE else View.VISIBLE
        adapterParent.addList(list)
    }

    @SuppressLint("NonConstantResourceId")
    private fun configRadioSelector() {
        rbSelector!!.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            when (checkedId) {
                R.id.rbOne -> {
                    selectedDate(1)
                }
                R.id.rbTwo -> {
                    selectedDate(2)
                }
                R.id.rbThree -> {
                    selectedDate(3)
                }
                R.id.rbFour -> {
                    selectedDate(4)
                }
                R.id.rbSix -> {
                    selectedDate(5)
                }
            }
        }
    }
}