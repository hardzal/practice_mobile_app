package com.example.modul6.indonesia.tpm.ui.main;

import android.view.View;

import com.example.modul6.indonesia.tpm.entity.AppDatabase;
import com.example.modul6.indonesia.tpm.entity.DataPribadi;

import java.util.List;

public interface MainContract {
    interface view extends View.OnClickListener {
       void successAdd();
       void successDelete();
       void resetForm();
       void getData(List<DataPribadi> list);
       void editData(DataPribadi item);
       void deleteData(DataPribadi item);
    }

    interface presenter {
        void insertData(String nama, String alamat, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String alamat, int id, AppDatabase database);
        void deleteData(DataPribadi dataPribadi, AppDatabase database);

    }
}
