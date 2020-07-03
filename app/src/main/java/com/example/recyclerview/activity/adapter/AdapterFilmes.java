package com.example.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filme;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    private List<Filme> listaFilmes;

    public AdapterFilmes(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public AdapterFilmes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //pega o xml e converte no tipo View
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_listafilmes,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFilmes.MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get( position );
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
        /*
        holder.titulo.setText("titulo teste");
        holder.genero.setText("comedia");
        holder.ano.setText("2019");
         */
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}

