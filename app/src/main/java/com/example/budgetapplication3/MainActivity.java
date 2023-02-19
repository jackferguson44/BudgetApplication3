package com.example.budgetapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText budgetEdit;
    private Button addBudgetButton;
    private TextView budgetText;
    private EditText itemEdit;
    private EditText costEdit;
    private Button addItemButton;


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

        addBudgetButton.setOnClickListener(this);
        addItemButton.setOnClickListener(this);
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
        }
    }
}