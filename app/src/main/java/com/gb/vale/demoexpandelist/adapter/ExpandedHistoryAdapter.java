package com.gb.vale.demoexpandelist.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.vale.demoexpandelist.R;
import com.gb.vale.demoexpandelist.model.ExpandeHistory;
import com.gb.vale.demoexpandelist.model.ParentMedic;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NotifyDataSetChanged")
public class ExpandedHistoryAdapter extends   RecyclerView.Adapter<ExpandedHistoryAdapter.ExpandedHistoryViewHolder> {


    List<ExpandeHistory> list = new ArrayList<>();


    public void addList(List<ExpandeHistory> listService){
        list = listService;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ExpandedHistoryAdapter.ExpandedHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_history, parent, false);
        return new ExpandedHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandedHistoryAdapter.ExpandedHistoryViewHolder holder, int position) {
          holder.configHistory(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ExpandedHistoryViewHolder extends RecyclerView.ViewHolder{

        private final TextView date ;
        private final TextView description;

        public ExpandedHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textDate);
            description = itemView.findViewById(R.id.textDescription);
        }

        public void configHistory(ExpandeHistory expandeHistory){
            date.setText(expandeHistory.getDateHistory());
            description.setText(expandeHistory.getDescription());
        }
    }
}
