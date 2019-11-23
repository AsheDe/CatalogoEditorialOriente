package cu.editorialoriente.catalogo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NavUtils;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Detalle_Libro_Actividad extends AppCompatActivity implements View.OnClickListener{

    LIBRO libroamostrar;
    TextView text_autor,text_autor1;
    ImageView avatar,avatar1;
    int posautor;
    DBManager basedatos;
    int sabersimegusta;
    FloatingActionButton fabcomentar;
    ImageView portada_libro;
    int year;
    boolean cambiofavorito;
    AUTOR [] mAutores = new AUTOR[2] ;
    @Override
    public void onBackPressed() {
        if(cambiofavorito){
            Intent i =new Intent(this,
                    Coleccion_Libros_Pager.class);
            i.putExtra("favchange",true) ;
            NavUtils.navigateUpTo(this,i);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle__libro__actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if( getIntent().hasExtra("libromostrar"))
        {
            basedatos = new DBManager(this) ;
            libroamostrar =   getIntent().getParcelableExtra("libromostrar");
            mAutores[0] = basedatos.AutorBynombre(libroamostrar.autores[0]);
            if(!libroamostrar.autores[1].isEmpty()){
                mAutores[1] = basedatos.AutorBynombre(libroamostrar.autores[1]);
            }
            //posautor =  getIntent().getIntExtra("posicion",0);
            portada_libro = ((ImageView)findViewById(R.id.img_portada_libro));
            WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            int height = display.getHeight();

            Glide.with(this).load(libroamostrar.getPortada()).into(portada_libro);
           // portada_libro.setImageResource(libroamostrar.getPortada());
            portada_libro.setOnClickListener(this);
            float factor = getResources().getFraction(R.fraction.factor_portadas,1,1);
            portada_libro.getLayoutParams().height = (int)(height * factor) ;
            final FrameLayout contenedor_titulo = ((FrameLayout)findViewById(R.id.contenedor_titulo)) ;
            ((TextView)findViewById(R.id.text_titulo_libro)).setText(libroamostrar.getTitulo());
            text_autor = ((TextView)findViewById(R.id.text_autor));

            text_autor.setText(libroamostrar.autores[0]);
            LinearLayout linearautor2= (LinearLayout) findViewById(R.id.liner2doautor);
            linearautor2.setVisibility(View.GONE);
            linearautor2.setOnClickListener(this);


            //text_autor.setOnClickListener(this);
            ((TextView)findViewById(R.id.text_coleccion)).setText("Colección:  " + libroamostrar.getColeccion());
            ((TextView)findViewById(R.id.text_sinopsis)).setText(libroamostrar.getSinopsis());
            ((TextView)findViewById(R.id.text_genero)).setText("Género:  " + libroamostrar.getGenero());
            ((TextView)findViewById(R.id.text_year)).setText("Año:  " + libroamostrar.year);
          if(libroamostrar.precio!=null)
            if(!libroamostrar.precio.isEmpty())
            {
                ((TextView)findViewById(R.id.text_price)).setText(  libroamostrar.getPrecio());
            }
            else
            {
                findViewById(R.id.text_price).setVisibility(View.GONE);
                findViewById(R.id.existprice).setVisibility(View.GONE);
            }
            ((TextView)findViewById(R.id.text_isbn)).setText( libroamostrar.isbn);

             Utiles.ColorPredominante(this,libroamostrar.getPortada(),contenedor_titulo);

            avatar =  ((ImageView)findViewById(R.id.avatar_autor));

            avatar.setImageDrawable(Utiles.ImagenesRedondeadas( mAutores[0].avatar ,this));
            avatar.setOnClickListener(this);
           // LinearLayout linearautor2= (LinearLayout) findViewById(R.id.liner2doautor);
            View vist_autor1 =  findViewById(R.id.engloba_autor);
            vist_autor1.setOnClickListener(this);

            if(!libroamostrar.autores[1].isEmpty()){
                linearautor2.setVisibility(View.VISIBLE);
                avatar1 =  ((ImageView)findViewById(R.id.avatar_autor1));
                avatar1.setImageDrawable(Utiles.ImagenesRedondeadas( mAutores[1].avatar ,this));

                //avatar1.setOnClickListener(this);
                text_autor1 = ((TextView)findViewById(R.id.text_autor1));
                text_autor1.setText(libroamostrar.autores[1]);

            }
            if(Build.VERSION.SDK_INT >= 21)
            {
                linearautor2.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_transp_blanco));
                vist_autor1.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_transp_blanco));
            }
            }




            //// RELACIONADOS



            RecyclerView lista_resultados = (RecyclerView) findViewById(R.id.titulos_relacionados);


           // String[] colecciones = getResources().getStringArray(R.array.todas_colecciones);
            //String[] generos = getResources().getStringArray(R.array.todos_generos);
            //String[] titulos = getResources().getStringArray(R.array.todos_titulos);

          /*  for(int i = 0;i < titulos.length ;i++)
            {
                if(colecciones[i].compareTo(libroamostrar.getColeccion())==0    && i!= posautor && titulos[i].compareTo(libroamostrar.getTitulo())!=0 && colecciones[i].contains("-")==false)
                {
                   LIBRO l = Utiles.CrearTodosLibros(this,i,Utiles.PosicionAutor(i)) ;
                    if(i>32)
                        l.year = 2019 ;
                    else
                        l.year = 2018 ;
                   libros.add(l);

                }
                else if(generos[i].compareTo(libroamostrar.getGenero())==0  && i!= posautor && titulos[i].compareTo(libroamostrar.getTitulo())!=0){
                    int j = Utiles.PosicionAutor(i);
                    LIBRO l = Utiles.CrearTodosLibros(this,i,j) ;
                    if(i>32)
                        l.year = 2019 ;
                    else
                        l.year = 2018 ;
                    libros.add(l);
                }

                if(libros.size()==10)
                    break;
            }*/
            basedatos = new DBManager(this);
            ArrayList<LIBRO> libros = basedatos.ObtenerListaLibrosRelacionados(libroamostrar.titulo);
            Libros_Result_Adapter adaptador = new Libros_Result_Adapter(libros,this);
            RecyclerView.LayoutManager mangr = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            ((LinearLayoutManager) mangr).setOrientation(LinearLayoutManager.HORIZONTAL);
            lista_resultados.setLayoutManager(mangr);
            lista_resultados.setItemAnimator(new DefaultItemAnimator());
            lista_resultados.setAdapter(adaptador);

           ImageView megusta =  (ImageView) findViewById(R.id.megusta);

            sabersimegusta =  basedatos.esFavorito(libroamostrar.titulo) ;
            if(sabersimegusta!=0)
                megusta.setImageResource(R.drawable.megusta);
            else
                megusta.setImageResource(R.drawable.icorazonnegro);

                megusta.setOnClickListener(this);
          /*  else
            {
                megusta.setImageResource(R.drawable.icorazon);
                Log.d("like","no");
           // }*/
            fabcomentar = (FloatingActionButton) findViewById(R.id.comentar);
            fabcomentar.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // return super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                Intent abrirportada = new Intent(this,Coleccion_Libros_Pager.class) ;
                abrirportada.putExtra("pos",posautor);
                startActivity(abrirportada);
                break;
            }
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

private void VerAutor(int pos)
{
    if(Build.VERSION.SDK_INT >=21 )
    {
        //// share content animation
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,

                new Pair(text_autor, "libro_autor"),
                new Pair(avatar, "avatar_autor")

        );
        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");
        colecciondelibros.putExtra("autor",mAutores[pos]);

        startActivity( colecciondelibros, options.toBundle());

    }//// sino otro tipo de animacion
    else
    {
        Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");

        colecciondelibros.putExtra("autor",mAutores[pos]);
        startActivity(colecciondelibros);
        overridePendingTransition(R.anim.desplazamiento_lateral,0);
    }
}

    @Override
    public void onClick(View v) {

       // Log.d("click","engloba_autor" + v.getId() + " .... " + R.id.engloba_autor + " .... " + R.id.text_autor );
        if(v.getId() == R.id.engloba_autor)
        {
            VerAutor(0);
        }
        if(v.getId() == R.id.liner2doautor)
        {
            VerAutor(1);
        }

     /*   if(v.getId() == R.id.liner2doautor)
        {
            String nombreautor = libroamostrar.getAutor() ;


            if(Build.VERSION.SDK_INT >=21 )
            {
                //// share content animation
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,

                        new Pair(text_autor, "libro_autor"),
                        new Pair(avatar, "avatar_autor")

                );
                Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");
                if (nombreautor.contains(";")) {
                    nombreautor = nombreautor.split(";")[1];
                }

                if(year==2018) {
                    if (posautor == 1) {
                        colecciondelibros.putExtra("posautor", 33);
                    } else if (posautor == 13) {
                        colecciondelibros.putExtra("posautor", 34);
                    } else if (posautor == 16) {
                        colecciondelibros.putExtra("posautor", 35);
                    } else if (posautor == 8) {
                        colecciondelibros.putExtra("posautor", 36);
                        nombreautor = "Carlos Espinosa Domínguez";
                    }
                }
                else if(year==2019){
                    Log.d("posaut",posautor+"");
                    if (posautor == 5) {
                        colecciondelibros.putExtra("posautor", 45);
                    } else if (posautor == 26) {
                        colecciondelibros.putExtra("posautor", 46);
                    }
                }

                colecciondelibros.putExtra("nombreautor",nombreautor);
                colecciondelibros.putExtra("year",year);
                startActivity( colecciondelibros, options.toBundle());

            }//// sino otro tipo de animacion
            else
            {

                Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.AUTOR");
                if(nombreautor.contains(";")) {
                    nombreautor = nombreautor.split(";")[1];
                }
                if (posautor == 1) {
                    colecciondelibros.putExtra("posautor",33);
                }
                if (posautor == 13) {
                    colecciondelibros.putExtra("posautor",34);
                }
                if (posautor == 16) {
                    colecciondelibros.putExtra("posautor",35);
                }
                else if (posautor == 8)
                {
                    colecciondelibros.putExtra("posautor",36);
                    nombreautor = "Carlos Espinosa Domínguez" ;
                }
              //  colecciondelibros.putExtra("posautor",posautor);
                colecciondelibros.putExtra("nombreautor",nombreautor);
                startActivity(colecciondelibros);
                overridePendingTransition(R.anim.desplazamiento_lateral,0);
            }
        }
*/

        if(v.getId() == R.id.img_portada_libro)
        {
            Intent libroafull =new Intent(this,Foto_Libro.class);
            libroafull.putExtra("recurso",libroamostrar.getPortada());
            libroafull.putExtra("libromostrar",libroamostrar);
            //libroafull.putExtra("posicion",Utiles.PosicionAutor(posautor));
            if(Build.VERSION.SDK_INT >=21){
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        new Pair(portada_libro, "libro_portada")
                );
                startActivity(libroafull,options.toBundle());
            }
            else {
                startActivity(libroafull);
                overridePendingTransition(R.anim.desplazamiento_lateral, 0);
            }
        }
        if(v.getId()==R.id.megusta)
        {

            sabersimegusta   = basedatos.CambiarFavorito(libroamostrar.titulo);
            // de ahi animar y cambiar de imagen y no aceptar mas click
            libroamostrar.megusta = sabersimegusta ;
            if(sabersimegusta!=0)
            ((ImageView)v).setImageResource(R.drawable.megusta);
            else
                ((ImageView)v).setImageResource(R.drawable.icorazonnegro);

            cambiofavorito=true;
        }

        if(v.getId() == fabcomentar.getId() )
        {
            Intent enviarmail =new Intent(this,Enviar_Mail.class);
            enviarmail.putExtra("titulo",libroamostrar.getTitulo());
            startActivity(enviarmail);
        }
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
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro_list_hor, parent, false);
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
                    Intent librodetalle = new Intent(getBaseContext(),Detalle_Libro_Actividad.class);
                    librodetalle.putExtra("libromostrar",librosamostrar.get(position));


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
}
