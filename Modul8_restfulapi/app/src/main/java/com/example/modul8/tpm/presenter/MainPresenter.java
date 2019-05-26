package com.example.modul8.tpm.presenter;

import com.example.modul8.tpm.model.get.GetResponse;
import com.example.modul8.tpm.model.post.PostResponse;
import com.example.modul8.tpm.remote.BaseApp;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getAllItems() {
        BaseApp.service.getAllItems().enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                if(response.isSuccessful()) {
                    mainView.getSucces(response.body());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void updateItems(String id, String name, String description) {
        BaseApp.service.updateDataItems(id, name, description).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()) {
                    mainView.setToast(response.message());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void deleteItems(String id) {
        BaseApp.service.deleteDataItems(id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()) {
                    mainView.setToast(response.message());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void createItems(String name, String description) {
        BaseApp.service.createItems(name, description).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response.isSuccessful()) {
                    mainView.setToast(response.message());
                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
