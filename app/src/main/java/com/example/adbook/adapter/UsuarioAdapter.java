package com.example.adbook.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adbook.R;
import com.example.adbook.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.MyViewHolder> {

    private Context context;
    private List<Usuario> usuarios;

    public UsuarioAdapter(Context context){
        this.context = context;
    }

    public void addUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_geolocalizador, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Usuario u = usuarios.get(position);
        holder.nome.setText(u.getNome());
        holder.telefone.setText(u.getTelefone());
        holder.endereco.setText(u.getEndereco());
        holder.categoria.setText(u.getCategoria());
        //holder.imagem.setImageURI();
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView categoria;
        TextView endereco;
        TextView telefone;
        //ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNome);
            categoria = itemView.findViewById(R.id.textViewCategoria);
            endereco = itemView.findViewById(R.id.textViewEndereco);
            telefone = itemView.findViewById(R.id.textViewTelefone);
            //imagem = itemView.findViewById(R.id.imageViewUSer);
        }
    }
}
