package com.gb.vale.demoexpandelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.gb.vale.demoexpandelist.adapter.ParentMedicAdapter;
import com.gb.vale.demoexpandelist.model.ParentMedic;
import com.gb.vale.demoexpandelist.presenter.IMainPresenter;
import com.gb.vale.demoexpandelist.presenter.PresenterMain;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainPresenter {

    ParentMedicAdapter adapterParent = new ParentMedicAdapter();
    private  RecyclerView rvParent;

    private RadioGroup rbSelector;
    private PresenterMain presenterMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvParent = findViewById(R.id.rvClinic);
        rbSelector = findViewById(R.id.rgSelected);
        rvParent.setLayoutManager(new LinearLayoutManager(this));
        rvParent.setAdapter(adapterParent);
        presenterMain = new PresenterMain(this);
        selectedDate(1);
        configRadioSelector();
    }

    public void selectedDate(int date){
        presenterMain.getListParent(date);
    }

    @Override
    public void successListParent(List<ParentMedic> list, int value) {
        rvParent.setVisibility(list.isEmpty()?View.GONE : View.VISIBLE);
        adapterParent.addList(list);
    }
    @SuppressLint("NonConstantResourceId")
    private void configRadioSelector() {
        rbSelector.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rbOne: { selectedDate(1);}
                break;
                case R.id.rbTwo : { selectedDate(2);}
                break;
                case R.id.rbThree :{ selectedDate(3);}
                break;
                case R.id.rbFour: { selectedDate(4);}
                break;
                case R.id.rbSix: { selectedDate(5);}
                break;
        }
        });
    }

}