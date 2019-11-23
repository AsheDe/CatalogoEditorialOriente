package cu.editorialoriente.catalogo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yudel on 12/09/2017.
 */
public class Libros_PagerAdapter extends FragmentStatePagerAdapter {

   // String [] titulos , autores , sinopsis , generos , colecciones , isbn ;
    //int[] portadas,autoresfotos;
   // int mYear;
    Context contexto;
    ArrayList<LIBRO> TODOSLIBROS;
    DBManager basedatos;
    public Libros_PagerAdapter(FragmentManager fm, Context context, int year) {
        super(fm);
        this.contexto = context ;
        //setupYears(year);
       // mYear = year ;
        basedatos = new DBManager(context) ;
        //TODOSLIBROS = basedatos.ObtenerListaLibros();
        setupYears(year);

    }

    public void setupYears(int year)
    {

        TODOSLIBROS = basedatos.ObtenerListaLibrosYear(year);
        notifyDataSetChanged();
    }

   /* public void setupYears(int year)
    {
        if(year==2018) {

            titulos = contexto.getResources().getStringArray(R.array.titulos);
            autores = contexto.getResources().getStringArray(R.array.autores);
            sinopsis = contexto.getResources().getStringArray(R.array.sinopsis);
            generos = contexto.getResources().getStringArray(R.array.generos);
            colecciones = contexto.getResources().getStringArray(R.array.colecciones);
            isbn = contexto.getResources().getStringArray(R.array.isbn);

            
            portadas = Utiles.portadas ;
            autoresfotos = Utiles.autores_fotos ;

        }
        else if (year ==2019)  {
            titulos = contexto.getResources().getStringArray(R.array.titulos_2019);
            autores = contexto.getResources().getStringArray(R.array.autores_2019);
            sinopsis = contexto.getResources().getStringArray(R.array.sinopsis_2019);
            generos = contexto.getResources().getStringArray(R.array.generos_2019);
            colecciones = contexto.getResources().getStringArray(R.array.colecciones_2019);
            isbn = contexto.getResources().getStringArray(R.array.isbn_2019);
            portadas = Utiles.portadas_2019 ;
            autoresfotos = Utiles.autores_fotos_2019 ;

        }

        mYear = year ;

        notifyDataSetChanged();
    }*/


    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
       /* boolean multiplesautores;
        multiplesautores = autores[position].contains(";");

        Bundle libroenpos = new Bundle();
        libroenpos.putParcelable("libroactual",
        new LIBRO(titulos[position], autores[position], colecciones[position], generos[position], sinopsis[position],
                isbn[position], portadas[position], autoresfotos[position],position,mYear));
        libroenpos.putInt("posicion",position);
      //  libroenpos.putInt("year",mYear);

        Fragment libro_fragmento;
        if(contexto.getResources().getBoolean(R.bool.horizontal))
            libro_fragmento = new Fragmento_Libro_Horizontal();
        else
             libro_fragmento = new Fragmento_Libro();

        libro_fragmento.setArguments(libroenpos);
        return libro_fragmento;*/

        Fragment libro_fragmento;
        if(contexto.getResources().getBoolean(R.bool.horizontal))
            libro_fragmento = new Fragmento_Libro_Horizontal();
        else
            libro_fragmento = new Fragmento_Libro();
        Bundle libroenpos = new Bundle();
        libroenpos.putParcelable("libroactual",TODOSLIBROS.get(position));
        libroenpos.putInt("posicion",position);
        libro_fragmento.setArguments(libroenpos);
        return libro_fragmento;
    }

    @Override
    public int getCount() {

       // return titulos.length;
        return TODOSLIBROS.size() ;
    }

    static public class Fragmento_Libro extends Fragment implements DragLayout.GotoDetailListener{

        LIBRO libroactual;
        ImageView portada_libro,megusta,avatar_autor,avatar_autor1;
        TextView texto_titulo,texto_autor;
        LinearLayout contenedor_titulo;
        int posicion;
        int knowlike;
        int year;
        DBManager basedatos ;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           View fragmentolibro =  inflater.inflate(R.layout.libros_telefono_fragmento,null);
            libroactual = getArguments().getParcelable("libroactual");
            basedatos = new DBManager(getContext());
            posicion = getArguments().getInt("posicion");
            portada_libro = ((ImageView)  fragmentolibro.findViewById(R.id.img_portada_libro));
            portada_libro.setImageResource(libroactual.getPortada());
            if(!getResources().getBoolean(R.bool.horizontal)) {
                DragLayout dragger = (DragLayout) fragmentolibro.findViewById(R.id.drag_layout);
                texto_autor = ((TextView) fragmentolibro.findViewById(R.id.dragautor));
                texto_autor.setText(libroactual.getAutor()[0]);
                ((TextView) fragmentolibro.findViewById(R.id.draggenero)).setText(libroactual.getGenero());
                //((TextView) fragmentolibro.findViewById(R.id.dragdesc)).setText(libroactual.getSinopsis());
                avatar_autor = (ImageView) fragmentolibro.findViewById(R.id.avatar_autor);
                AUTOR autor =  basedatos.AutorBynombre(libroactual.getAutor()[0]);
                Log.d("aut",autor.nombre + autor.avatar);
                if(autor!=null && autor.avatar!=null)
                    avatar_autor.setImageDrawable(Utiles.ImagenesRedondeadas(autor.avatar , getContext()));
                dragger.setGotoDetailListener(this);

                avatar_autor1 = (ImageView) fragmentolibro.findViewById(R.id.avatar_autor1);
                if(!libroactual.autores[1].isEmpty())
                {
                    AUTOR autor2 =  basedatos.AutorBynombre(libroactual.getAutor()[1]);
                    if(autor2!=null && autor2.avatar!=null)
                    avatar_autor1.setImageDrawable(Utiles.ImagenesRedondeadas(autor2.avatar , getContext()));

                }

        /*         year = libroactual.year;
                if(year==2018)
                {
                    switch (posicion)
                    {
                        case 16:
                        {
                            avatar_autor1.setVisibility(View.VISIBLE);
                            avatar_autor1.setImageDrawable( Utiles.ImagenesRedondeadas( R.mipmap.ester_lidia_vzquez_eara ,getContext()));
                            break;
                        }
                        default:
                        {
                            avatar_autor1.setVisibility(View.GONE);
                        }
                    }
                }
                else{
                    switch (posicion)
                    {
                        case 5:
                        {
                            avatar_autor1.setVisibility(View.VISIBLE);
                            avatar_autor1.setImageDrawable( Utiles.ImagenesRedondeadas( R.mipmap.mario_naito ,getContext()));
                            break;
                        }
                        case 26:
                        {
                            avatar_autor1.setVisibility(View.VISIBLE);
                            avatar_autor1.setImageDrawable( Utiles.ImagenesRedondeadas( R.mipmap.dayron_serpa ,getContext()));
                            break;
                        }
                        default:
                        {
                            avatar_autor1.setVisibility(View.GONE);
                        }
                    }
                }*/
            }


            texto_titulo = (TextView)  fragmentolibro.findViewById(R.id.text_titulo_libro);
            texto_titulo.setText(libroactual.getTitulo());

            megusta = (ImageView) fragmentolibro.findViewById(R.id.marcado_favorito);

            knowlike = basedatos.esFavorito(libroactual.titulo) ;
            if(libroactual.megusta!=0)
                megusta.setImageResource(R.drawable.megusta);
            else
                megusta.setImageResource(R.drawable.icorazon);

                megusta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        knowlike = basedatos.CambiarFavorito(libroactual.titulo);
                        libroactual.megusta = knowlike;
                        // de ahi animar y cambiar de imagen y no aceptar mas click

                        if(knowlike!=0)
                            megusta.setImageResource(R.drawable.megusta);
                        else
                            megusta.setImageResource(R.drawable.icorazon);
                        megusta.invalidate();
                    }
                });





            contenedor_titulo = (LinearLayout) fragmentolibro.findViewById(R.id.contenedor_titulo);
           Utiles.ColorPredominante(getContext(),libroactual.getPortada(),contenedor_titulo);
           return fragmentolibro;
        }

        @Override
        public void gotoDetail() {
            if(Build.VERSION.SDK_INT >=21 )
            {
                //// share content animation
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),

                        new Pair(texto_titulo, "libro_titulo") ,
                        new Pair(contenedor_titulo, "libro_titulo_contenedor") ,
                        new Pair(portada_libro, "libro_portada"),
                        new Pair(texto_autor, "libro_autor"),
                        new Pair(megusta, "megusta"),
                        new Pair(avatar_autor, "avatar_autor")

                );
                Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.LIBRO");
                colecciondelibros.putExtra("libromostrar",libroactual);
                colecciondelibros.putExtra("posicion",posicion);
                colecciondelibros.putExtra("year",year);
                startActivity( colecciondelibros, options.toBundle());

            }//// sino otro tipo de animacion
            else
            {
                Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.LIBRO");
                colecciondelibros.putExtra("libromostrar",libroactual);
                colecciondelibros.putExtra("posicion",posicion);
                startActivity(colecciondelibros);
                getActivity().overridePendingTransition(R.anim.desplazamiento_lateral,0);
            }
        }


    }

    static public class Fragmento_Libro_Horizontal extends Fragment {

        LIBRO libroactual;
        ImageView portada_libro,megusta;
        TextView texto_titulo;
        LinearLayout contenedor_titulo;
        int posicion;
        int knowlike;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View fragmentolibro =  inflater.inflate(R.layout.libros_telefono_fragmento,null);
            libroactual = getArguments().getParcelable("libroactual");
            posicion = getArguments().getInt("posicion");
            portada_libro = ((ImageView)  fragmentolibro.findViewById(R.id.img_portada_libro));
            portada_libro.setImageResource(libroactual.getPortada());

            texto_titulo = (TextView)  fragmentolibro.findViewById(R.id.text_titulo_libro);
            texto_titulo.setText(libroactual.getTitulo());

            megusta = (ImageView) fragmentolibro.findViewById(R.id.marcado_favorito);
            final DBManager basedatos = new DBManager(getContext());
            knowlike = libroactual.megusta ;  //basedatos.SaberSimegustaUnLibro(posicion) ;
            if(knowlike!=0)
                megusta.setImageResource(R.drawable.megusta);
            else
                megusta.setImageResource(R.drawable.icorazon);

            megusta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    knowlike =  basedatos.CambiarFavorito(libroactual.titulo);
                    // de ahi animar y cambiar de imagen y no aceptar mas click

                    if(knowlike!=0)
                        megusta.setImageResource(R.drawable.megusta);
                    else
                        megusta.setImageResource(R.drawable.icorazon);
                    megusta.invalidate();
                }
            });

            contenedor_titulo = (LinearLayout) fragmentolibro.findViewById(R.id.contenedor_titulo);
            Utiles.ColorPredominante(getContext(),libroactual.getPortada(),contenedor_titulo);


            fragmentolibro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Build.VERSION.SDK_INT >=21 )
                    {
                        //// share content animation
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),

                                new Pair(texto_titulo, "libro_titulo") ,
                                new Pair(contenedor_titulo, "libro_titulo_contenedor") ,
                                new Pair(portada_libro, "libro_portada"),
                                new Pair(megusta, "megusta")



                        );
                        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.LIBRO");
                        colecciondelibros.putExtra("libromostrar",libroactual);
                        colecciondelibros.putExtra("posicion",posicion);
                        startActivity( colecciondelibros, options.toBundle());

                    }//// sino otro tipo de animacion
                    else
                    {
                        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.LIBRO");
                        colecciondelibros.putExtra("libromostrar",libroactual);
                        colecciondelibros.putExtra("posicion",posicion);
                        startActivity(colecciondelibros);
                        getActivity().overridePendingTransition(R.anim.desplazamiento_lateral,0);
                    }
                }
            });

            return fragmentolibro;
        }




    }
}
