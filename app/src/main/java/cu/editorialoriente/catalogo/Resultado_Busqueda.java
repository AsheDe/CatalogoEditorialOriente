package cu.editorialoriente.catalogo;

import android.content.Intent;
import android.os.Build;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NavUtils;
import androidx.core.util.Pair;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultado_Busqueda extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado__busqueda);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("RESULTADOS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       ArrayList<LIBRO> libros = getIntent().getParcelableArrayListExtra("resultados");

       RecyclerView lista_resultados = (RecyclerView) findViewById(R.id.recycler_result);

        Libros_Result_Adapter adaptador = new Libros_Result_Adapter(libros,this);


        RecyclerView.LayoutManager mangr = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lista_resultados.setLayoutManager(mangr);
        lista_resultados.setItemAnimator(new DefaultItemAnimator());
        lista_resultados.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            { NavUtils.navigateUpFromSameTask(this);
                break;}
            case R.id.menu_nosotros:
            {
                Intent abrirnosotros = new Intent(this,Nosotros.class) ;
                startActivity(abrirnosotros);
                break;
            }
            case R.id.menu_autores:
            {
                Intent abrirautores = new Intent(this,Lista_Autores.class) ;
                startActivity(abrirautores);
                break;
            }
            case R.id.menu_favoritos:
            {
                Intent abrirfavs = new Intent(this,Favoritos.class) ;
                startActivity(abrirfavs);
                break;
            }
            case R.id.menu_creditos:
            {
                Intent abrircre = new Intent(this,Creditos.class) ;
                startActivity(abrircre);
                break;
            }
        }
        return true;
    }

    public class Libros_Result_Adapter extends RecyclerView.Adapter
    {
        ArrayList<LIBRO> librosamostrar;
        AppCompatActivity actividad;
        public Libros_Result_Adapter( ArrayList<LIBRO> libros, AppCompatActivity act)
        {
            librosamostrar = libros ;
            actividad = act;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v;
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro_list, parent, false);
            Item_Libro vh = new Item_Libro(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final Item_Libro vhold = (Item_Libro)holder ;
            vhold.portada.setImageResource(librosamostrar.get(position).getPortada());
            vhold.titulo.setText(librosamostrar.get(position).getTitulo());
            vhold.autor.setText(librosamostrar.get(position).getAutor()[0]);
            if(Build.VERSION.SDK_INT >= 21)
            {
                vhold.itemView.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_transp_green));
            }
            vhold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent librodetalle = new Intent(getBaseContext(),Detalle_Libro_Actividad.class);
                    librodetalle.putExtra("libromostrar",librosamostrar.get(position));
                    librodetalle.putExtra("posicion",librosamostrar.get(position).getPosicion());
                    startActivity(librodetalle);
                    overridePendingTransition(R.anim.desplazamiento_lateral,0);*/

                    Intent librodetalle = new Intent(getBaseContext(),Detalle_Libro_Actividad.class);
                    librodetalle.putExtra("libromostrar",librosamostrar.get(position));
                    librodetalle.putExtra("posicion",librosamostrar.get(position).getPosicion());
                    if(Build.VERSION.SDK_INT >= 21)
                    {
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(actividad,

                                new Pair(vhold.titulo, "libro_titulo") ,
                                new Pair(vhold.portada, "libro_portada")

                        );
                        startActivity(librodetalle,options.toBundle());
                    }
                    else{
                        startActivity(librodetalle);
                        overridePendingTransition(R.anim.desplazamiento_lateral,0);
                    }

                }

            });
        }

        @Override
        public int getItemCount() {
            return librosamostrar.size();
        }


        public class Item_Libro extends RecyclerView.ViewHolder
        {
            ImageView portada;
            TextView titulo,autor ;

            public Item_Libro(View itemView) {
                super(itemView);

                portada = (ImageView) itemView.findViewById(R.id.portada_libro_item);
                titulo = (TextView) itemView.findViewById(R.id.titulo_libro_item);
                autor = (TextView) itemView.findViewById(R.id.autor_libro_item);

            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    }
