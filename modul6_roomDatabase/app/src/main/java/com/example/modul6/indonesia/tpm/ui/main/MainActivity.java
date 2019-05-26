package com.example.modul6.indonesia.tpm.ui.main;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.modul6.R;
import com.example.modul6.indonesia.tpm.entity.AppDatabase;
import com.example.modul6.indonesia.tpm.entity.DataPribadi;
import com.example.modul6.indonesia.tpm.ui.main.holder.MainAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.view {
    private AppDatabase appDatabase;
    private MainPresenter presenter;
    private MainAdapter adapter;

    private Button btnOk;
    private RecyclerView recyclerView;
    private EditText tvNama, tvAlamat;

    private boolean edit = false;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.iniDb(getApplicationContext());

        btnOk = findViewById(R.id.btn_submit);
        btnOk.setOnClickListener(this);
        tvNama = findViewById(R.id.et_nama);
        tvAlamat = findViewById(R.id.et_alamat);
        recyclerView = findViewById(R.id.rc_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        presenter = new MainPresenter(this);

        presenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Berhasil Menambahkan!", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Berhasil menghapus data!", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        tvNama.setText("");
        tvAlamat.setText("");
        btnOk.setText("Kirim");
    }

    @Override
    public void getData(List<DataPribadi> list) {
        adapter = new MainAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void editData(DataPribadi item) {
        tvNama.setText(item.getName());
        tvAlamat.setText(item.getAddress());
        id = item.getId();
        edit = true;
        btnOk.setText("Perbaharui!");
    }

    @Override
    public void deleteData(final DataPribadi item) {
        AlertDialog.Builder builder;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setTitle("Menghapus data")
                .setMessage("Kamu yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        presenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onClick(View view) {
        if(view == btnOk) {
            if(tvNama.getText().toString().equals("") || tvAlamat.getText().toString().equals("")) {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_LONG).show();
            } else {
                if(!edit) {
                    presenter.insertData(tvNama.getText().toString(), tvAlamat.getText().toString(), appDatabase);
                } else {
                    presenter.editData(tvNama.getText().toString(), tvAlamat.getText().toString(), id, appDatabase);
                    edit = false;
                }

                resetForm();

            }
        }
    }
}
