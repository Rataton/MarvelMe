package com.petitemasrata.marvelme.model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.petitemasrata.marvelme.rest.Constants;


public class CharacterDetailCompose extends Character{
    public static CharacterDetailCompose buildFromJson(JsonObject characterDetailData){
        Gson gson = new Gson();
        CharacterDetailCompose currentCharacterDetailCompose = gson.fromJson(characterDetailData, CharacterDetailCompose.class);
        currentCharacterDetailCompose.setDescription(Constants.DESCRIPTION_KEY);

        return currentCharacterDetailCompose;
    }
}