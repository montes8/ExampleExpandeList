package com.gb.vale.demoexpandelist.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.vale.demoexpandelist.R;
import com.gb.vale.demoexpandelist.model.ParentMedic;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NotifyDataSetChanged")
public class ParentMedicAdapter extends RecyclerView.Adapter<ParentMedicAdapter.ParentMedicViewHolder>{


    List<ParentMedic> list = new ArrayList<>();
    int positionSelected = -1;
    public void addList(List<ParentMedic> listService){
        list = listService;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ParentMedicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_clinic, parent, false);
        return new ParentMedicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentMedicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.configClinic(list.get(position));


    }

    private void updateList(int positionUpdate){
        for (int i = 0; i < list.size(); i++) {
            if (i==positionUpdate){
                list.get(i).setSelected(!list.get(i).isSelected());
            }else {
                list.get(i).setSelected(false);
            }
        }
       notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

      class ParentMedicViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView address;
        private final ImageView arrow;
        private final RecyclerView rvHistory;


        ExpandedHistoryAdapter adapterHistory = new ExpandedHistoryAdapter();

        public ParentMedicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            address = itemView.findViewById(R.id.textAddress);
            rvHistory =  itemView.findViewById(R.id.rvHistory);
            arrow = itemView.findViewById(R.id.imgArrow);
            rvHistory.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            rvHistory.setAdapter(adapterHistory);
        }

         public  void configClinic(ParentMedic parentMedic){
            title.setText(parentMedic.getNameClinic());
            address.setText(parentMedic.getAddress());
            adapterHistory.addList(parentMedic.getListHistory());
            if (parentMedic.isSelected()){
                rvHistory.setVisibility(View.VISIBLE);
            }else {
                rvHistory.setVisibility(View.GONE);
            }

             arrow.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     positionSelected = getAdapterPosition();
                     updateList(positionSelected);
                 }
             });


        }
    }
}




