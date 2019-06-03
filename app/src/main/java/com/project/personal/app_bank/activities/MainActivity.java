package com.project.personal.app_bank.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.personal.app_bank.API.APIInterface;
import com.project.personal.app_bank.API.RetrofitClient;
import com.project.personal.app_bank.models.LoginRequest;
import com.project.personal.app_bank.models.User;
import com.project.personal.app_bank.R;
import com.project.personal.app_bank.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText password;
    Button buttonLogin;
    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getInstance("https://bank-app-test.herokuapp.com/api/").create(APIInterface.class);

        user = findViewById(R.id.editUser);
        password = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
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

                Log.d("test_post", String.valueOf(response.code()));
                Log.d("test_post", userResponse.getUserAccount().getName());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("test_post", t.getMessage());
            }
        });

    }
}
