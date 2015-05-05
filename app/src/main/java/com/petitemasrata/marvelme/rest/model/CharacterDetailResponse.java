package com.petitemasrata.marvelme.rest.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.petitemasrata.marvelme.model.CharacterDetailCompose;
import com.petitemasrata.marvelme.rest.Constants;

import java.util.List;


public class CharacterDetailResponse {
    @SerializedName(Constants.CODE_KEY)
    private int code;

    @SerializedName(Constants.STATUS_KEY)
    private String status;

    @Expose
    List<CharacterDetailCompose> characterDetailComposes;

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

    public List<CharacterDetailCompose> getCharacterDetailComposes() {
        return characterDetailComposes;
    }

    public void setCharacterDetailComposes(List<CharacterDetailCompose> characterDetailComposes) {
        this.characterDetailComposes = characterDetailComposes;
    }
}