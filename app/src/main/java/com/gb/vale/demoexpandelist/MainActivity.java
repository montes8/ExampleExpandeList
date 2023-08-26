package com.gb.vale.demoexpandelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.gb.vale.demoexpandelist.adapter.ParentMedicAdapter;
import com.gb.vale.demoexpandelist.model.ParentMedic;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainPresenter {

    ParentMedicAdapter adapterParent = new ParentMedicAdapter();
    private  RecyclerView rvParent;
    private PresenterMain  presenterMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvParent = findViewById(R.id.rvClinic);
        rvParent.setLayoutManager(new LinearLayoutManager(this));
        rvParent.setAdapter(adapterParent);
        presenterMain = new PresenterMain(this);
        selectedDate(2);
    }

    public void selectedDate(int date){
        presenterMain.getListParent(date);
    }

    @Override
    public void successListParent(List<ParentMedic> list, int value) {
        presenterMain.getListHistory(list,value);
    }

    @Override
    public void successListHistory(List<ParentMedic> list) {
        rvParent.setVisibility(list.isEmpty()?View.GONE : View.VISIBLE);
        adapterParent.addList(list);
    }
}