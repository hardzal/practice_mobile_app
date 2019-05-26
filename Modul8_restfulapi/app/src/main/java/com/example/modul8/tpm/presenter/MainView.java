package com.example.modul8.tpm.presenter;

import com.example.modul8.tpm.model.get.GetResponse;

public interface MainView {
    void getSucces(GetResponse list);
    void setToast(String message);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
