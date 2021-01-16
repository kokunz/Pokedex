package com.jose.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jose.pokedex.models.Pokemon;

import java.util.ArrayList;

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;
    private Context context;

    public ListaPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon ,parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nombreTexview.setText(p.getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                        +p.getNumber()+".png").centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImagenview);


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adiccionarListaPokemon(ArrayList<Pokemon> pokemonArrayList) {
        dataset.addAll(pokemonArrayList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImagenview;
        private TextView nombreTexview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoImagenview = (ImageView) itemView.findViewById(R.id.fotoImagenview);
            nombreTexview = (TextView) itemView.findViewById(R.id.nombreTexview);



        }
    }

}
