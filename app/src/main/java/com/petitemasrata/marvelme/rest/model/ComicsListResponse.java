package com.petitemasrata.marvelme.rest.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.petitemasrata.marvelme.model.Comic;
import com.petitemasrata.marvelme.rest.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains the structure of the response for the
 * {@link  # requestHeroesList(int, int, String, long, String, retrofit.Callback)}
 * */
public class ComicsListResponse {
    @SerializedName(Constants.CODE_KEY)
    private int code;

    @SerializedName(Constants.STATUS_KEY)
    private String status;

    //We expose these fields because we gonna parse them manually with a deserializer
    @Expose
    private int offset;

    @Expose
    List<Comic> comics;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
}
