package com.gb.vale.demoexpandelist;

import com.gb.vale.demoexpandelist.model.ExpandeHistory;
import com.gb.vale.demoexpandelist.model.ParentMedic;

import java.util.ArrayList;
import java.util.List;

public class PresenterMain {

    private IMainPresenter iPresenterMain;

    public PresenterMain(IMainPresenter iPresenterMain) {
        this.iPresenterMain = iPresenterMain;
    }

    public void getListParent(int value){
        List<ParentMedic> list = new ArrayList<>();
        switch (value){
            case  0:
            case 2: {
                list.add(new ParentMedic("clinica 1","buenos aires 1", new ArrayList<>()));
                list.add(new ParentMedic("clinica 2","buenos aires 2",new ArrayList<>()));
            }
            break;
        }

        iPresenterMain.successListParent(list,value);

    }

    public void getListHistory(List<ParentMedic> list ,int value){
        List<ExpandeHistory> listHistory = new ArrayList<>();
        List<ExpandeHistory> listHistoryTwo = new ArrayList<>();
        listHistory.add(new ExpandeHistory("12/09/2300 ","hola como estan"));
        listHistory.add(new ExpandeHistory("13/09/2300","hols que hay de nuevo"));
        listHistoryTwo.add(new ExpandeHistory("12/09/2200 ","hola como estan"));
        listHistoryTwo.add(new ExpandeHistory("13/09/2200","hols que hay de nuevo"));
        listHistoryTwo.add(new ExpandeHistory("14/09/2200","hols que hay de nuevo"));

        switch (value){
            case  0:
            case 2: {
                list.get(0).setListHistory(listHistory);
                list.get(1).setListHistory(listHistoryTwo);

            }
            break;
        }


        iPresenterMain.successListHistory(list);
    }
}


interface IMainPresenter {
    void successListParent(List<ParentMedic> list,int value);
    void successListHistory(List<ParentMedic> list);
}
