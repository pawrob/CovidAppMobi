package com.example.covidbook.info;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PersonInfoList implements Serializable {

    private List<PersonInfo> personInfoList;

    public PersonInfoList() {

        personInfoList = new ArrayList<PersonInfo>();
    }

    public List<PersonInfo> getPersonInfoList() {

        return personInfoList;
    }
    public void add(PersonInfo personInfo) {
       personInfoList.add(personInfo);
    }

    public void setPersonInfoList(List<PersonInfo> personInfoList) {
        this.personInfoList = personInfoList;
    }

    @Override
    public String toString() {
        return "PersonInfoList{" +
                "personInfoList=" + personInfoList +
                "count= "+ personInfoList.size() + '}';
    }

    public static String toJson(List<PersonInfo> list) throws IOException {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(list);
        System.out.println("json " + json);
        try (Writer writer = new FileWriter("Output.json")) {
            gson.toJson(list, writer);
        }
        return json;

    }

    public static void saveData(Context context, List<PersonInfo> list) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString("task list", json);
        editor.apply();
    }
    public static List<PersonInfo> loadData(Context context, List<PersonInfo> list) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<PersonInfo>>() {}.getType();
        list = gson.fromJson(json, type);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }
}
