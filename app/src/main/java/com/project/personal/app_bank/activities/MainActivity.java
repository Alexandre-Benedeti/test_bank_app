package com.project.personal.app_bank.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.personal.app_bank.API.APIInterface;
import com.project.personal.app_bank.API.RetrofitClient;
import com.project.personal.app_bank.models.LoginRequest;
import com.project.personal.app_bank.R;
import com.project.personal.app_bank.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText user, password;
    private Button buttonLogin;
    private APIInterface apiInterface;
    private Intent intent;
    private String userName, userAccount, userBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = null; //se não iniciar com null acontece erro na passagem dos valores para outra activity;
        userAccount = null;
        userBalance = null;

        apiInterface = RetrofitClient.getInstance().create(APIInterface.class);

        user = findViewById(R.id.editUser);
        password = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login();

                //AINDA TENHO QUE CRIAR O VALIDADOR DE SENHA
                intent = new Intent(MainActivity.this, CurrencyActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("userName", userName);
                bundle.putString("userAccount", userAccount);
                bundle.putString("userBalance", userBalance);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUser(user.toString());
        loginRequest.setPassword(password.toString());
        Call<UserResponse> userResponse = apiInterface.createPost(loginRequest);

        userResponse.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                UserResponse userResponse = response.body();

                userName = userResponse.getUserAccount().getName();
                userAccount = userResponse.getUserAccount().getBankAccount() +" / "+userResponse.getUserAccount().getAgency();
                userBalance = String.valueOf(userResponse.getUserAccount().getBalance());

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("test_post", t.getMessage());

            }
        });

    }
}
