package com.example.modul8.tpm.presenter;

public interface MainInterface {
    void getAllItems();
    void getItemById(String id);
    void updateItems(String id, String name, String description);
    void deleteItems(String id);
    void createItems(String name, String description);
}
