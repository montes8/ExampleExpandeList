package com.gb.vale.demoexpandelist.presenter;

import com.gb.vale.demoexpandelist.model.ExpandeHistory;
import com.gb.vale.demoexpandelist.model.ParentMedic;

import java.util.ArrayList;
import java.util.List;

public class PresenterMain {

    private final IMainPresenter iPresenterMain;

    public PresenterMain(IMainPresenter iPresenterMain) {
        this.iPresenterMain = iPresenterMain;
    }


    public void getListParent(int value) {
        //lista padre
        List<ParentMedic> list = new ArrayList<>();

        //lista expanded
        List<ExpandeHistory> listHistory = new ArrayList<>();
        List<ExpandeHistory> listHistoryTwo = new ArrayList<>();
        switch (value) {
            case 3: {
                listHistory.add(new ExpandeHistory("12/09/2300 ", "hola como estan"));
                listHistory.add(new ExpandeHistory("13/09/2300", "hols que hay de nuevo"));
                list.add(new ParentMedic("clinica 5", "buenos aires 5 not tiene historial", new ArrayList<>()));
                list.add(new ParentMedic("clinica 6", "buenos aires 6", listHistoryTwo));
            }
            break;
            case 2: {
                listHistory.add(new ExpandeHistory("12/09/2300 ", "hola como estan"));
                listHistory.add(new ExpandeHistory("13/09/2300", "hols que hay de nuevo"));
                listHistoryTwo.add(new ExpandeHistory("12/09/2200 ", "hola como estan"));
                listHistoryTwo.add(new ExpandeHistory("13/09/2200", "hols que hay de nuevo"));
                listHistoryTwo.add(new ExpandeHistory("14/09/2200", "hols que hay de nuevo"));
                list.add(new ParentMedic("clinica 1", "buenos aires 1", listHistory));
                list.add(new ParentMedic("clinica 2", "buenos aires 2", listHistoryTwo));
            }
            break;
            case 5: {
                listHistory.add(new ExpandeHistory("12/09/2500 ", "hola como estan"));
                listHistory.add(new ExpandeHistory("13/09/2500", "hols que hay de nuevo"));
                listHistoryTwo.add(new ExpandeHistory("12/09/2500 ", "hola como estan"));
                listHistoryTwo.add(new ExpandeHistory("13/09/2500", "hols que hay de nuevo"));
                listHistoryTwo.add(new ExpandeHistory("14/09/2500", "hols que hay de nuevo"));
                list.add(new ParentMedic("clinica 3", "buenos aires 3", listHistory));
                list.add(new ParentMedic("clinica 4", "buenos aires 4", listHistoryTwo));
            }
            break;
        }

        iPresenterMain.successListParent(list, value);

    }
}
