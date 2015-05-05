package com.petitemasrata.marvelme.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.petitemasrata.marvelme.R;
import com.petitemasrata.marvelme.model.Comic;
import com.petitemasrata.marvelme.rest.Constants;
import com.petitemasrata.marvelme.rest.MarvelApiClient;
import com.petitemasrata.marvelme.rest.model.ComicsListResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListAdapter.ComicViewHolder> {

//    private static final int VIEW_PROGRESS = 0;
//    private static final int VIEW_COMIC = 1;



    private Context context;
    private LayoutInflater layoutInflater;
    private List<Comic> comics;

    public ComicsListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        comics = new ArrayList<>();
        comics.add(null);
        comics.add(null);
    }

    @Override
    public int getItemViewType(int position) {
        return comics.get(position) != null ? R.layout.item_comic : R.layout.item_comic_progress;

    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(viewType, parent, false);
        return new ComicViewHolder(itemView, viewType);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {

        if (position < getItemCount() - 2)
            holder.setComicData(comics.get(position));
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public void requestForMoreComics() {
        MarvelApiClient.getInstance(context)
                .requestComicsList(Constants.CHARACTERS_LIMIT, getComicsItemsCount(), new Callback<ComicsListResponse>() {
                    @Override
                    public void success(ComicsListResponse comicsListResponse, Response response) {
                        updateList(comicsListResponse.getComics());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                        Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void updateList(List<Comic> comics) {
        this.comics.addAll(getComicsItemsCount(), comics);
        notifyDataSetChanged();
    }

    private int getComicsItemsCount() {
        return comics.size() - 2;
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.img_comic)
        SimpleDraweeView imgComic;

        @InjectView(R.id.textViewTitleComic)
        TextView txtTItle;


        @InjectView(R.id.textViewPagesComic)
        TextView txtPages;

        @InjectView(R.id.textViewIssueComic)
        TextView txtIssue;


        public ComicViewHolder(View itemView, int type) {
            super(itemView);

            if (type == R.layout.item_comic) {
                ButterKnife.inject(this, itemView);
            }
        }

        public void setComicData(Comic comic) {

            Uri urlImage = comic.getUrlImage();
            if (!urlImage.equals(Uri.EMPTY))
                imgComic.setImageURI(urlImage);

            txtTItle.setText(comic.getTitle());

            txtIssue.setText("Issue # " + comic.getIssues());

            txtPages.setText("Pag. " + comic.getPages());

        }

    }
}