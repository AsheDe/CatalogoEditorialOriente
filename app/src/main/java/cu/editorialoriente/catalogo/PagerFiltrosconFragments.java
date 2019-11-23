package cu.editorialoriente.catalogo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by yudel on 30/09/2017.
 */
public class PagerFiltrosconFragments extends FragmentStatePagerAdapter {
    PagerFiltrosconFragments(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        AyudanteBusqueda fragment0=null;
        switch (position)
        {
            case 0:
            {
                fragment0 = new FragmentTitulo();
               break;
            }
            case 1:
            {
                fragment0 = new FragmentAutor();
                break;
            }
            case 2:
            {
                fragment0 = new FragmentGenero();
                break;
            }
            case 3:
            {
                fragment0 = new FragmentColeccion();
                break;
            }
        }

        return fragment0;
    }

    @Override
    public int getCount() {
        return 4;
    }


    static public class AyudanteBusqueda extends Fragment
    {
        /*  String []  todos_titulos ;
         String [] todos_autores ;
         String [] todos_sinopsis;
         String [] todos_generos ;
         String[] todos_colecciones;
         String [] todos_isbn ;
    /*  String []  titulos2019 ;
         String [] autores2019 ;
         String [] sinopsis2019;
         String [] generos2019 ;
         String[] colecciones2019;
         String [] isbn2019 ;*/
        ArrayList<LIBRO>  lista_resultado = new ArrayList<LIBRO>();
        ArrayList<LIBRO>  lista_LIBROS = new ArrayList<LIBRO>();
        Context context ;
        Activity actividad;
        DBFiltros basededatos;
        public AyudanteBusqueda() {


        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            context = getContext();
            actividad = getActivity();
            basededatos = new DBFiltros(context) ;

   /*         todos_titulos = context.getResources().getStringArray(R.array.todos_titulos);
            todos_autores = context.getResources().getStringArray(R.array.todos_autores);
            todos_sinopsis = context.getResources().getStringArray(R.array.todas_sinopsis);
            todos_generos = context.getResources().getStringArray(R.array.todos_generos);
            todos_colecciones = context.getResources().getStringArray(R.array.todas_colecciones);
            todos_isbn = context.getResources().getStringArray(R.array.todos_isbn);



            titulos2019 = context.getResources().getStringArray(R.array.titulos_2019);
            autores2019 = context.getResources().getStringArray(R.array.autores_2019);
            sinopsis2019 = context.getResources().getStringArray(R.array.sinopsis_2019);
            generos2019 = context.getResources().getStringArray(R.array.generos_2019);
            colecciones2019 = context.getResources().getStringArray(R.array.colecciones_2019);
            isbn2019 = context.getResources().getStringArray(R.array.isbn_2019);

*/
            return super.onCreateView(inflater, container, savedInstanceState);
        }

       /* public LIBRO CrearLibro(int i)
        {
            return  new LIBRO(titulos[i], autores[i], colecciones[i], generos[i], sinopsis[i], isbn[i], Utiles.portadas[i], Utiles.autores_fotos[i]);
        }*/

        public void EnviarIntent(){
            RevealFAB revbuscar =   ( (RevealFAB) actividad.findViewById(R.id.reveal_fab));
            revbuscar.recogerAnimacion();
            revbuscar.getFab().setImageDrawable(getResources().getDrawable(R.drawable.ibuscar) );
            actividad.findViewById(R.id.seekbar).setVisibility(View.VISIBLE);

            if(lista_resultado.size() > 0)
            {
                Intent resultadobusq = new Intent(getActivity(),Resultado_Busqueda.class);
                resultadobusq.putExtra("resultados",lista_resultado);
                startActivity(resultadobusq);
                lista_resultado.clear();
            }
            else
            {

                Toast.makeText(context,"No hay resultados para su búsqueda ",Toast.LENGTH_LONG).show();
            }

        }

    }

   static public class FragmentTitulo extends AyudanteBusqueda
    {


        public FragmentTitulo() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater,container,savedInstanceState);

            View buscartitulo = inflater.inflate(R.layout.searchview,null);
            SearchView buscador = (SearchView) buscartitulo.findViewById(R.id.search_titulo);

            buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                  lista_resultado =  basededatos.BuscarLibrosTitulos(query);

                    EnviarIntent();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            return buscartitulo;
        }
    }


    static public class FragmentAutor extends AyudanteBusqueda
    {

        public FragmentAutor() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          super.onCreateView(inflater, container, savedInstanceState);
            View vista = inflater.inflate(R.layout.recycler_autores,null);

            AutoresList_Adapter adaptador = new AutoresList_Adapter();
            RecyclerView list_autores = (RecyclerView) vista.findViewById(R.id.recycler_list_autores);
            RecyclerView.LayoutManager mangr = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
            list_autores.setLayoutManager(mangr);
            list_autores.setItemAnimator(new DefaultItemAnimator());
            list_autores.setAdapter(adaptador);

            return vista;

        }

        public class AutoresList_Adapter extends RecyclerView.Adapter
        {
            ArrayList<AUTOR> mlist_autores;
            public AutoresList_Adapter()
            {

               mlist_autores =  basededatos.ObtenerListaAutores() ; // getResources().getStringArray(R.array.todos_autores_listado);
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v;
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.autor_item_filtro, parent, false);
                Item_Autor vh = new Item_Autor(v);
                return vh;
            }

            @Override
            public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
                final Item_Autor vhold = (Item_Autor)holder ;
                vhold.avatar.setImageResource(mlist_autores.get(position).avatar);
                vhold.nombre.setText(mlist_autores.get(position).nombre);


                if(Build.VERSION.SDK_INT >= 21)
                {
                    vhold.itemView.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_transp_blanco));
                }

                vhold.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        lista_resultado = basededatos.BuscarLibrosAutor(mlist_autores.get(position).nombre);
                        EnviarIntent();

                    }
                });
            }

            @Override
            public int getItemCount() {
                return mlist_autores.size();
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
    }

    static public class FragmentGenero extends AyudanteBusqueda implements View.OnClickListener
    {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          super.onCreateView(inflater, container, savedInstanceState);
        View vista = inflater.inflate(R.layout.vista_generos,null);
            vista.findViewById(R.id.gnovela).setOnClickListener(this);
            vista.findViewById(R.id.gnovelainf).setOnClickListener(this);
            vista.findViewById(R.id.gnovelainfjuv).setOnClickListener(this);
            vista.findViewById(R.id.gcuento).setOnClickListener(this);
            vista.findViewById(R.id.gcuentoinf).setOnClickListener(this);
            vista.findViewById(R.id.gpoesia).setOnClickListener(this);
            vista.findViewById(R.id.gpoesiainfjuv).setOnClickListener(this);
            vista.findViewById(R.id.gensayo).setOnClickListener(this);
            vista.findViewById(R.id.gtestimhist).setOnClickListener(this);
            vista.findViewById(R.id.gensayohist).setOnClickListener(this);
            vista.findViewById(R.id.ghistorieta).setOnClickListener(this);
            vista.findViewById(R.id.gdivulg).setOnClickListener(this);
            vista.findViewById(R.id.gdivulgcient).setOnClickListener(this);
            vista.findViewById(R.id.gdivulgpop).setOnClickListener(this);
            vista.findViewById(R.id.gdivulginfjuv).setOnClickListener(this);
            vista.findViewById(R.id.gensayobio).setOnClickListener(this);
            vista.findViewById(R.id.gtestimhist).setOnClickListener(this);
            vista.findViewById(R.id.gpasatiempos).setOnClickListener(this);
            vista.findViewById(R.id.gtestimonio).setOnClickListener(this);
            vista.findViewById(R.id.gbiografia).setOnClickListener(this);
            vista.findViewById(R.id.garticulo).setOnClickListener(this);
            vista.findViewById(R.id.gdiccionario).setOnClickListener(this);
            vista.findViewById(R.id.gentrevista).setOnClickListener(this);
            vista.findViewById(R.id.gcronica).setOnClickListener(this);
            vista.findViewById(R.id.genspolitico).setOnClickListener(this);
            vista.findViewById(R.id.gnovtestimonio).setOnClickListener(this);
        return vista;
        }

        @Override
        public void onClick(View v) {


            AlgBuscarGenero(((CheckBox)v).getText().toString());
                EnviarIntent();
                ((CheckBox)v).setChecked(false);

        }

        private void AlgBuscarGenero(String genero)
        {

            lista_resultado =  basededatos.BuscarLibrosGeneros(genero);

        }
    }

    static public class FragmentColeccion extends AyudanteBusqueda implements View.OnClickListener
    {


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View vista = inflater.inflate(R.layout.vista_colecciones,null);
            vista.findViewById(R.id.coleccion1).setOnClickListener(this);
            vista.findViewById(R.id.coleccion2).setOnClickListener(this);
            vista.findViewById(R.id.coleccion3).setOnClickListener(this);
            vista.findViewById(R.id.coleccion4).setOnClickListener(this);
            vista.findViewById(R.id.coleccion5).setOnClickListener(this);
            vista.findViewById(R.id.coleccion6).setOnClickListener(this);
            vista.findViewById(R.id.coleccion7).setOnClickListener(this);
            vista.findViewById(R.id.coleccion9).setOnClickListener(this);
            vista.findViewById(R.id.coleccion10).setOnClickListener(this);
            vista.findViewById(R.id.coleccion11).setOnClickListener(this);
            vista.findViewById(R.id.coleccion12).setOnClickListener(this);

            return vista;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.coleccion1: {
                    AlgBuscarColeccion("Ficciones");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion2: {
                    AlgBuscarColeccion("Mariposa");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion3: {
                    AlgBuscarColeccion("Autoayuda");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion4: {
                    AlgBuscarColeccion("Bronce");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion5: {
                    AlgBuscarColeccion("Diálogo");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion6: {
                    AlgBuscarColeccion("-");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion7: {
                    AlgBuscarColeccion("Heredia");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion9: {
                    AlgBuscarColeccion("En Casa");
                    EnviarIntent();

                    break;
                }

                case R.id.coleccion10: {
                    AlgBuscarColeccion("Ala y Espuela");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion11: {
                    AlgBuscarColeccion("Letras de Oriente");
                    EnviarIntent();

                    break;
                }
                case R.id.coleccion12: {
                    AlgBuscarColeccion("Sic");
                    EnviarIntent();

                    break;
                }

            }
        }

            private void AlgBuscarColeccion(String coleccion)
            {

                lista_resultado =  basededatos.BuscarLibrosColeccion(coleccion);

            }

    }




}
