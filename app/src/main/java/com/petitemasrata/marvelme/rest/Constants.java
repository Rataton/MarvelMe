package com.petitemasrata.marvelme.rest;

public class Constants {
    public static final String API_PUBLIC_KEY = "ea6e91f2f67dfbb30cc8d6c89dc04df3";
    public static final String API_PRIVATE_KEY = "dd12e0a3ffcf27a9fcc2f8ebfeb81f4f9be36588";

    //This constants are the key for each param in the URL query
    public static final String API_KEY_PARAM = "apikey";
    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset" ;
    public static final String TS_PARAM = "ts";
    public static final String HASH_PARAM = "hash";
    public static final int CHARACTERS_LIMIT = 20;

    //This constants are the key for each object found in a JSON response
    public static final String CODE_KEY = "code";
    public static final String STATUS_KEY = "status";
    public static final String DATA_KEY = "data";
    public static final String OFFSET_KEY = "offset";
    public static final String RESULTS_KEY = "results";
    public static final String ID_KEY = "id";
    public static final String NAME_KEY = "name";
    public static final String DESCRIPTION_KEY = "description";
    public static final String THUMBNAIL_KEY = "thumbnail";
    public static final String PATH_KEY = "path";
    public static final String EXTENSION_KEY = "extension";
    public static final String COMICS_KEY = "comics";
    public static final String SERIES_KEY = "series";
    public static final String STORIES_KEY = "stories";
    public static final String AVAILABLE_KEY = "available";

    //URLs for requests
    public static final String MAIN_URL = "http://gateway.marvel.com:80/v1/public";
    public static final String CHARACTERS_URL = "/characters";

}