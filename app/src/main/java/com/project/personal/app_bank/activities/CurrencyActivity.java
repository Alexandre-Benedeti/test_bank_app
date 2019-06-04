package com.project.personal.app_bank.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.project.personal.app_bank.R;
import com.project.personal.app_bank.models.StatementList;


public class CurrencyActivity extends AppCompatActivity {

    private TextView name, bankAccountAgency, balance;
    private RecyclerView listaRecyclerView;
    private StatementList statementList;
    private Fragment recentesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        name = findViewById(R.id.textViewName);
        bankAccountAgency = findViewById(R.id.textViewNumConta);
        balance = findViewById(R.id.textViewTotalSaldo);

        //pega as informações da conta
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            name.setText(bundle.getString("userName"));
            bankAccountAgency.setText(bundle.getString("userAccount"));
            balance.setText("R$ "+bundle.getString("userBalance"));
        }

        //inicia o supporte na View
        recentesFragment = new RecentesFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, recentesFragment).commit();

    }



}
