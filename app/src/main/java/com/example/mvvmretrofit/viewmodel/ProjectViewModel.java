package com.example.mvvmretrofit.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mvvmretrofit.service.Retrofit.Api;
import com.example.mvvmretrofit.service.model.Project;
import com.example.mvvmretrofit.service.Retrofit.RetrofitRespository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectViewModel extends AndroidViewModel {

    public MutableLiveData<String> data;
    private Api mService;

    public ProjectViewModel(@NonNull Application application) {
        super(application);


    }
    
    public void getdata(){
        mService = RetrofitRespository.getProject();
        mService.getGithubProject().enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(@NonNull Call<List<Project>> call, @NonNull Response<List<Project>> response) {

                if(response.isSuccessful()) {
                    assert response.body() != null;
                    Log.e("Rio", "response.body()-->"+response.body().toString());
                    data.setValue(response.body().toString());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

                Log.e("Rio", "error loading from API");

            }
        });
    }

//    public LiveData<List<Project>> getProject()
//    {
//        return data;
//    }

}
