package com.example.covidbook.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonInfoList implements Serializable {
    private List<PersosInfo> persosInfoList;

    public PersonInfoList() {
         persosInfoList = new ArrayList<PersosInfo>();
    }

    public List<PersosInfo> getPersosInfoList() {
        return persosInfoList;
    }

    public void setPersosInfoList(List<PersosInfo> persosInfoList) {
        this.persosInfoList = persosInfoList;
    }
}
