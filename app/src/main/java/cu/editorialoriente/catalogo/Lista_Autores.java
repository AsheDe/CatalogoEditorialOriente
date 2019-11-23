package cu.editorialoriente.catalogo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NavUtils;
import androidx.core.util.Pair;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.SearchView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista_Autores extends AppCompatActivity {

    ArrayList<AUTOR> autores;
    DBManager bd;
    AutoresList_Adapter adaptador;
    RecyclerView list_autores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_autores_actividad);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitleTextColor(getResources().getColor(R.color.colorBlanco));
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Autores");

        bd= new DBManager(this);

        autores = bd.ObtenerListaAutores(); //getResources().getStringArray(R.array.todos_autores_listado);
        adaptador = new AutoresList_Adapter(this);
        list_autores = (RecyclerView) findViewById(R.id.recycler_list_autores);
        int columnas = getResources().getInteger(R.integer.columnasautor);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(columnas,StaggeredGridLayoutManager.VERTICAL);
         mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
       // RecyclerView.LayoutManager mangr = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        list_autores.setLayoutManager(mLayoutManager);
        list_autores.setItemAnimator(new DefaultItemAnimator());
        list_autores.setAdapter(adaptador);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_opciones_autores,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchMenuItem = menu.findItem(R.id.buscar) ;
       SearchView searchView = (SearchView) searchMenuItem.getActionView();
      //  searchView.setBackgroundColor(getResources().getColor(R.color.colorVerde));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName())) ;
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(querylistener) ;

        return true;

    }

    private SearchView.OnQueryTextListener querylistener = new SearchView.OnQueryTextListener(){

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adaptador.getFilter().filter(newText);
            return true;
        }
    };



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

    public class AutoresList_Adapter extends RecyclerView.Adapter implements Filterable
    {
        AppCompatActivity actividad;
        public AutoresList_Adapter(AppCompatActivity act)
        {
            actividad = act;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v;
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.autor_item_actividad, parent, false);
            Item_Autor vh = new Item_Autor(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final Item_Autor vhold = (Item_Autor)holder ;

            vhold.avatar.setImageDrawable( Utiles.ImagenesRedondeadas(autores.get(position).avatar,getBaseContext()));
            String name = autores.get(position).nombre ;
            if(name.contains("(compilador)"))
              name =  name.replace("(compilador)","");
            if(name.contains("(compiladora)"))
              name =  name.replace("(compiladora)","");
            vhold.nombre.setText(name);
            if(Build.VERSION.SDK_INT >= 21)
            {
                vhold.itemView.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_transp_blanco));
            }
            vhold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int finalrad = (int)Math.hypot(v.getHeight()/2,v.getWidth()/2);

                    if(Build.VERSION.SDK_INT >=21 )
                    {
                        //// share content animation
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(actividad,

                                new Pair(vhold.nombre, "libro_autor"),
                                new Pair(vhold.avatar, "avatar_autor")

                        );
                        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");
                        colecciondelibros.putExtra("autor",autores.get(position));
                        startActivity( colecciondelibros, options.toBundle());

                    }//// sino otro tipo de animacion
                    else
                    {
                        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");
                        colecciondelibros.putExtra("autor",autores.get(position));
                        startActivity(colecciondelibros);
                        overridePendingTransition(R.anim.desplazamiento_lateral,0);
                    }

                }
            });
        }

       // @Override
       // public int getItemCount() {
         //   return Utiles.autores_fotos_todos.length;
       // }

        @Override
        public int getItemCount() {
            return autores.size();
        }

        @Override
        public Filter getFilter() {
            return new Filtro();
        }


        public class Item_Autor extends RecyclerView.ViewHolder
        {
            ImageView avatar;
            TextView nombre;

            public Item_Autor(View itemView) {
                super(itemView);

                avatar = (ImageView) itemView.findViewById(R.id.avatar_autor_item);
                nombre = (TextView) itemView.findViewById(R.id.nombre_autor_item);


            }
        }
    }

     class Filtro extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            DBFiltros filt = new DBFiltros(getBaseContext());
            ArrayList<AUTOR> autoresFILTRADOS = filt.FiltrarAutores(constraint.toString());
            FilterResults ft =  new FilterResults();
            ft.values = autoresFILTRADOS ;
            return ft;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            autores = (ArrayList<AUTOR>)results.values ;
            adaptador.notifyDataSetChanged();
        }
    }
}
