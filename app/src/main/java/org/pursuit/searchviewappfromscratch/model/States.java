package org.pursuit.searchviewappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class States {

    private String name;
    private String capital;
    private String lat;
    @SerializedName("long")
    private String Long;

    public States(String name, String capital, String lat, String aLong) {
        this.name = name;
        this.capital = capital;
        this.lat = lat;
        Long = aLong;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getLat() {
        return lat;
    }

    public String getLong() {
        return Long;
    }


}
