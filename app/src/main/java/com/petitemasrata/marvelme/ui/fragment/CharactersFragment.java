package com.petitemasrata.marvelme.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petitemasrata.marvelme.model.Character;
import com.petitemasrata.marvelme.R;
import com.petitemasrata.marvelme.rest.MarvelApiClient;
import com.petitemasrata.marvelme.rest.model.CharactersListResponse;
import com.petitemasrata.marvelme.ui.adapter.CharactersListAdapter;
import com.petitemasrata.marvelme.ui.interfaces.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CharactersFragment extends Fragment{

    private static final String LOG_TAG = CharactersFragment.class.getCanonicalName();
    public Context CONTEXT;

    @InjectView(R.id.list_characters)
    RecyclerView mListCharacters;

    CharactersListAdapter adapter;

    public CharactersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.inject(this, rootView);

        initListCharacters();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        MarvelApiClient.getInstance(CONTEXT).requestCharactersList(20, 300, new Callback<CharactersListResponse>() {
            @Override
            public void success(CharactersListResponse charactersListResponse, Response response) {
                adapter.updateList(charactersListResponse.getCharacters());
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });

    }

    //================================================================================
    //Init Methods
    //================================================================================
    private void initListCharacters() {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        adapter = new CharactersListAdapter(CONTEXT);

       mListCharacters.addOnScrollListener(new EndlessRecyclerOnScrollListener(lm) {
           @Override
           public void onLoadMore(int current_page) {
               adapter.requestForMoreCharacters();
           }
       });

        mListCharacters.setLayoutManager(lm);
        mListCharacters.setAdapter(adapter);

    }

}