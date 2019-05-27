package com.example.modul8.tpm.presenter;

import com.example.modul8.tpm.model.get.GetResponse;
import com.example.modul8.tpm.model.getbyid.GetResponseById;

public interface MainView {
    void getSuccess(GetResponse list);
    void getSuccessById(GetResponseById list);
    void setToast(String message);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
