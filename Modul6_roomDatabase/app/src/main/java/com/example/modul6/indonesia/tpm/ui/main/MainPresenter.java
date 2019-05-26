package com.example.modul6.indonesia.tpm.ui.main;

import android.os.AsyncTask;
import android.util.Log;

import com.example.modul6.indonesia.tpm.entity.AppDatabase;
import com.example.modul6.indonesia.tpm.entity.DataPribadi;

import java.util.List;

public class MainPresenter implements MainContract.presenter {
    private MainContract.view view;

    public MainPresenter(MainContract.view view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataPribadi dataPribadi;

        public InsertData(AppDatabase database, DataPribadi dataPribadi) {
            this.database = database;
            this.dataPribadi = dataPribadi;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataPribadi);
        }

        @Override
        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String nama, String alamat, final AppDatabase database) {
        final DataPribadi dataPribadi = new DataPribadi();
        dataPribadi.setAddress(alamat);
        dataPribadi.setName(nama);
        new InsertData(database, dataPribadi).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataPribadi dataPribadi;

        public EditData(AppDatabase database, DataPribadi dataPribadi) {
            this.database = database;
            this.dataPribadi = dataPribadi;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataPribadi);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String nama, String alamat, int id, final AppDatabase database) {
        final DataPribadi dataPribadi = new DataPribadi();
        dataPribadi.setAddress(alamat);
        dataPribadi.setName(nama);
        dataPribadi.setId(id);

        new EditData(database, dataPribadi).execute();
    }

    class DeleteData extends AsyncTask<Void, Void, Void> {
        private AppDatabase database;
        private DataPribadi dataPribadi;

        public DeleteData(AppDatabase database, DataPribadi dataPribadi) {
            this.database = database;
            this.dataPribadi = dataPribadi;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataPribadi);
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(final DataPribadi dataPribadi, final AppDatabase database) {
        new DeleteData(database, dataPribadi).execute();
    }
}
