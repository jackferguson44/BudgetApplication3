package com.example.budgetapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText budgetEdit;
    private Button addBudgetButton;
    private TextView budgetText;
    private EditText itemEdit;
    private EditText costEdit;
    private Button addItemButton;
    private ArrayList<Budget> budgetList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budgetEdit = findViewById(R.id.budgetEdit);
        addBudgetButton = findViewById(R.id.addBudgetButton);
        budgetText = findViewById(R.id.budgetText);
        itemEdit = findViewById(R.id.itemEdit);
        costEdit = findViewById(R.id.costEdit);
        addItemButton = findViewById(R.id.addItemButton);
        budgetList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        addBudgetButton.setOnClickListener(this);
        addItemButton.setOnClickListener(this);

        setAdapter();


    }


    @Override
    public void onClick(View v) {
        if(v == addBudgetButton)
        {
            String budget = budgetEdit.getText().toString().trim();
            budgetText.setText(budget);
        }
        if(v == addItemButton)
        {
            int budget = Integer.parseInt(budgetText.getText().toString().trim());
            budget -= Integer.parseInt(costEdit.getText().toString().trim());
            budgetText.setText(Integer.toString(budget));

            String budgetItem = itemEdit.getText().toString().trim();
            String budgetCost = costEdit.getText().toString().trim();
            addBudgetInfo(budgetItem, budgetCost);

            itemEdit.getText().clear();
            costEdit.getText().clear();
        }
    }

    private void addBudgetInfo(String item, String cost){
        budgetList.add(new Budget(item, cost));
    }

    private void setAdapter(){
        recyclerAdapter adapter = new recyclerAdapter(budgetList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}