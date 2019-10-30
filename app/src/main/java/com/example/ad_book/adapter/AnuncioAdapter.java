package com.example.ad_book.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad_book.R;
import com.example.ad_book.model.Anuncio;

import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.MyViewHolder> {

    private List<Anuncio> anuncios;

    public AnuncioAdapter(List<Anuncio> anuncios){
        this.anuncios = anuncios;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_anuncio, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Anuncio ad = anuncios.get(position);
        holder.nomeAnuncio.setText(ad.getNomeAnuncio());
        holder.descricao.setText(ad.getDescricao());
        holder.endereco.setText(ad.getEndereco());
        holder.imagem.setImageResource(ad.getImagem());
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeAnuncio;
        private TextView descricao;
        private TextView endereco;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeAnuncio = itemView.findViewById(R.id.txtNomeAnuncio);
            descricao = itemView.findViewById(R.id.txtDescricao);
            endereco = itemView.findViewById(R.id.txtEndereco);
            imagem = itemView.findViewById(R.id.imgEvento);
        }
    }



}
