package com.project.personal.app_bank.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;

import com.project.personal.app_bank.API.RetrofitClient;
import com.project.personal.app_bank.R;
import com.project.personal.app_bank.models.StatementList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity extends AppCompatActivity {

    private TextView name, bankAccountAgency, balance;
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
            balance.setText(bundle.getString("userBalance"));
        }

        getListStatements();
    }

    private void getListStatements(){
        Call<StatementList> statementListCall = new RetrofitClient().getListService().getList("1");

        statementListCall.enqueue(new Callback<StatementList>() {
            @Override
            public void onResponse(Call<StatementList> call, Response<StatementList> response) {

                StatementList statementList = response.body();
                Log.d("testLista", statementList.getStatements().get(1).getTitle());
            }

            @Override
            public void onFailure(Call<StatementList> call, Throwable t) {

            }
        });

    }

}
