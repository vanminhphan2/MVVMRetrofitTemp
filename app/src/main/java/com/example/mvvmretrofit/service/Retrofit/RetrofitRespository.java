package com.example.mvvmretrofit.service.Retrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.mvvmretrofit.service.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class RetrofitRespository {


    public static  Api getProject()
    {
        return  RetrofitClient.getInstance().create(Api.class);

    }
}
