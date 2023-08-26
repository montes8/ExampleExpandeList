package com.gb.vale.demoexpandelist.presenter

import com.gb.vale.demoexpandelist.model.ParentMedic

interface IMainPresenter {
    fun successListParent(list: List<ParentMedic>, value: Int)
}