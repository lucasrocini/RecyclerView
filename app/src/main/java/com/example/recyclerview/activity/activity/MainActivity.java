package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.AdapterFilmes;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilmes = findViewById(R.id.recyclerViewFilmes);

        //criar listagem de filmes
        this.criarFilmes();

        //configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes( listaFilmes );

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFilmes.setLayoutManager(layoutManager);
        recyclerViewFilmes.setHasFixedSize(true); //otimiza o recylerView
        recyclerViewFilmes.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL)); // divisor grafico entre itens
        recyclerViewFilmes.setAdapter( adapterFilmes );

        //evento de clique
        recyclerViewFilmes.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerViewFilmes,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item Pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Clique Longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("titulo", "genero", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo2", "genero2", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo3", "genero3", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo4", "genero4", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo5", "genero5", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo6", "genero6", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo7", "genero7", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo8", "genero8", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo9", "genero9", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo10", "genero10", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo11", "genero11", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("titulo12", "genero12", "2017");
        this.listaFilmes.add(filme);
    }

}