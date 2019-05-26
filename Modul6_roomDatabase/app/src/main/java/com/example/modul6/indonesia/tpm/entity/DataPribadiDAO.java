package com.example.modul6.indonesia.tpm.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataPribadiDAO {
    @Insert
    Long insertData(DataPribadi dataPribadi);

    @Query("SELECT * FROM db_users")
    List<DataPribadi> getData();

    @Update
    int updateData(DataPribadi item);

    @Delete
    void deleteData(DataPribadi item);
}
