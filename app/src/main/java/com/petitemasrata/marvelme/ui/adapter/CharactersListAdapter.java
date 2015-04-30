package com.petitemasrata.marvelme.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.petitemasrata.marvelme.R;
import com.petitemasrata.marvelme.model.Character;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static java.util.Collections.EMPTY_LIST;

public class CharactersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List <Character> characters = EMPTY_LIST;
    Context context;

    /**
     * @param context Context needed to access {@link android.view.LayoutInflater}
     * */
    public CharactersListAdapter(Context context) {
        this.context = context;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_character, viewGroup, false);

        return new CharacterViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof CharacterViewHolder) {

            Character currentCharacter = characters.get(position);
            ((CharacterViewHolder)viewHolder).setName(currentCharacter.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (characters == null)
            return 0;

        return characters.size();
    }

    /**
     * Replace the current adapter data and replace it with a new collection.
     * @param characters New {@link Character} collection
     * */
    public void updateList(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    /**
     * Add a bunch of items to the current characters list
     * @param characters items to add
     * */
    public void addItemCollection(List<Character> characters) {
        this.characters.addAll(characters);
        notifyDataSetChanged();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.img_character)
        SimpleDraweeView imgCharacter;

        @InjectView(R.id.txt_character_name)
        TextView txtName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }

        public void setImg(Uri urlImage) {
            if(!urlImage.equals(Uri.EMPTY))
                imgCharacter.setImageURI(urlImage);
        }

        public void setName(String name){
            txtName.setText(name);
        }
    }

}