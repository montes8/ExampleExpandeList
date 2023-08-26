package com.gb.vale.demoexpandelist.presenter

import com.gb.vale.demoexpandelist.model.ExpandeHistory
import com.gb.vale.demoexpandelist.model.ParentMedic

class PresenterMain(private val iPresenterMain: IMainPresenter) {
    fun getListParent(value: Int) {
        //lista padre
        val list: MutableList<ParentMedic> = ArrayList()

        //lista expanded
        val listHistory: MutableList<ExpandeHistory> = ArrayList()
        val listHistoryTwo: MutableList<ExpandeHistory> = ArrayList()
        when (value) {
            3 -> {
                listHistory.add(ExpandeHistory("12/09/2300 ", "hola como estan"))
                listHistory.add(ExpandeHistory("13/09/2300", "hols que hay de nuevo"))
                list.add(
                    ParentMedic(
                        "clinica 5",
                        "buenos aires 5 not tiene historial",
                        ArrayList()
                    )
                )
                list.add(ParentMedic("clinica 6", "buenos aires 6", listHistoryTwo))
            }
            2 -> {
                listHistory.add(ExpandeHistory("12/09/2300 ", "hola como estan"))
                listHistory.add(ExpandeHistory("13/09/2300", "hols que hay de nuevo"))
                listHistoryTwo.add(ExpandeHistory("12/09/2200 ", "hola como estan"))
                listHistoryTwo.add(ExpandeHistory("13/09/2200", "hols que hay de nuevo"))
                listHistoryTwo.add(ExpandeHistory("14/09/2200", "hols que hay de nuevo"))
                list.add(ParentMedic("clinica 1", "buenos aires 1", listHistory))
                list.add(ParentMedic("clinica 2", "buenos aires 2", listHistoryTwo))
            }
            5 -> {
                listHistory.add(ExpandeHistory("12/09/2500 ", "hola como estan"))
                listHistory.add(ExpandeHistory("13/09/2500", "hols que hay de nuevo"))
                listHistoryTwo.add(ExpandeHistory("12/09/2500 ", "hola como estan"))
                listHistoryTwo.add(ExpandeHistory("13/09/2500", "hols que hay de nuevo"))
                listHistoryTwo.add(ExpandeHistory("14/09/2500", "hols que hay de nuevo"))
                list.add(ParentMedic("clinica 3", "buenos aires 3", listHistory))
                list.add(ParentMedic("clinica 4", "buenos aires 4", listHistoryTwo))
            }
        }
        iPresenterMain.successListParent(list, value)
    }
}