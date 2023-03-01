package com.example.budgetapplication3;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Budget> budgetList;

    public recyclerAdapter(ArrayList<Budget> budgetList){
        this.budgetList = budgetList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView itemText;
        private TextView costText;
        private Button deleteButton;

        public MyViewHolder(final View view){
            super(view);
            itemText = view.findViewById(R.id.itemText);
            costText = view.findViewById(R.id.costText);
            deleteButton = view.findViewById(R.id.deleteButton);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View budgetItems = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_items, parent, false);
        return new MyViewHolder(budgetItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String item = budgetList.get(position).getBudgetItem();
        String cost = budgetList.get(position).getBudgetCost();
        holder.itemText.setText(item);
        holder.costText.setText(cost);
    }


    @Override
    public int getItemCount() {
        return budgetList.size();
    }
}
