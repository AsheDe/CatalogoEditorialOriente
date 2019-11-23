package cu.editorialoriente.catalogo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.StackView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yudel on 12/09/2017.
 */
public class Coleccion_Libros_Pager extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    // fuente a utilizar para el título de la app
    Typeface fuentepropia;
    // va de false a  true la primera vez que presione atrás y sale de la app y se presiona de nuevo.
    boolean intentandosalir = false;
    private RevealFAB revealFAB;
    boolean reveal_state = false;
    private ViewPager pager;
    private SeekBar barrabusqueda;
    private Toolbar toolbar ;
    private StackView stackyear;
    Libros_PagerAdapter libros_pagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coleccion__libros__telefono);
        Utiles.FullScreen(this);
        setToolBar("Catálogo 2019");
//// ----------DRAWER LAYOUT
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //----------------

        setupViewpager();
        setupFiltros();

        barrabusqueda = (SeekBar) findViewById(R.id.seekbar);
       // barrabusqueda.setMax(45);
        barrabusqueda.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pager.setCurrentItem(seekBar.getProgress());
            }
        });

         if(getIntent().hasExtra("pos"))
            pager.setCurrentItem(getIntent().getIntExtra("pos",0));

             stackyear = (StackView) findViewById(R.id.stackyears);
            stackyear.setAdapter(new StackYearsAdapter());
          //  stackyear.setInAnimation(this,android.R.animator.fade_in);
           // stackyear.setOutAnimation(this,android.R.animator.fade_out);


         findViewById(R.id.selector_year).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 revealFAB.getFab().hide();
                stackyear.setVisibility(View.VISIBLE);
             }
         });

         findViewById(R.id.actividadtitulo).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 revealFAB.getFab().hide();
                stackyear.setVisibility(View.VISIBLE);
             }
         });

    }



    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        if(stackyear.getVisibility()==View.VISIBLE)
            stackyear.setVisibility(View.INVISIBLE);
        else if(!intentandosalir)
        {
            intentandosalir=true; /// poner un timer para que vuelva a false
            Toast.makeText(this,R.string.pressback,Toast.LENGTH_LONG).show();
            //////////////timer para salida
            final Handler manejador = new Handler();
            final Timer timer = new Timer();
            final TimerTask cicloespera = new TimerTask() {
                @Override
                public void run() {
                    manejador.post(new Runnable() {
                        @Override
                        public void run() {
                            intentandosalir =false;
                        }
                    });

                }
            };

            timer.schedule(cicloespera, 5000);
        }
        else
        {
            finish();
        }

    }



    public void setToolBar(String title){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorBlanco));
        toolbar.setBackgroundColor( getResources().getColor(android.R.color.transparent));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //  getSupportActionBar().setTitle(title);
      //  getSupportActionBar().setIcon(R.mipmap.logomini);

        fuentepropia = Typeface.createFromAsset(getAssets(),"BOOKOS.TTF");
        TextView titulo = (TextView) findViewById(R.id.actividadtitulo);
        titulo.setTypeface(fuentepropia);
        titulo.setText(title);

    }

    private void setupViewpager()
    {
       pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setPageTransformer(true,new PageTransformer(this));
        libros_pagerAdapter = new Libros_PagerAdapter(getSupportFragmentManager(),this,2019) ;
        pager.setAdapter(libros_pagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                   barrabusqueda.setProgress(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);

       // getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // return super.onOptionsItemSelected(item);
     /*   switch (item.getItemId())
        {
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
 */        return true;
    }



    private void setupFiltros() {

        final ViewPager pager_filtros = (ViewPager) findViewById(R.id.pager_filtros);
        final TabLayout tabs = (TabLayout) findViewById(R.id.tabs_filtros);
        pager_filtros.setAdapter(new PagerFiltrosconFragments(getSupportFragmentManager()));
        pager_filtros.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabs.setScrollPosition(position,0,true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager_filtros.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        revealFAB = (RevealFAB) findViewById(R.id.reveal_fab);
        revealFAB.setOnClickListener(new RevealFAB.OnClickListener() {
            @Override
            public void onClick(RevealFAB button, View v) {
                if(!reveal_state)
                {
                    button.startActivityWithAnimation();
                    button.getFab().setImageDrawable(getResources().getDrawable(R.drawable.icerrar) );
                    reveal_state = true;
                    barrabusqueda.setVisibility(View.INVISIBLE);

                }
                else
                {
                    button.recogerAnimacion();
                    button.getFab().setImageDrawable(getResources().getDrawable(R.drawable.ibuscar) );
                    reveal_state = false;
                    barrabusqueda.setVisibility(View.VISIBLE);
                }
            }

        });

    }



    @Override
    protected void onResume() {
        super.onResume();
        revealFAB.onResume();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
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


    // private class StackView

    public class StackYearsAdapter extends BaseAdapter {

        public StackYearsAdapter() {
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            if(position==0)
                return 2019;
            return 2018;
        }

        @Override
        public long getItemId(int position) {
            if(position==0)
                return 2019;
            return 2018;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Integer img ;
            int year  ;
                if(position == 0) {
                    img = R.mipmap.noaptoparamayores ;
                    year = 2019 ;
                 //   barrabusqueda.setMax(45);
                   // barrabusqueda.invalidate();

                }
                else{
                    img = R.mipmap.tiendamascotas ;
                    year = 2018 ;

                  //  barrabusqueda.setMax(33);
                   // barrabusqueda.invalidate();

                }


            View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vistayears,null,false);
            ImageView imagen = (ImageView) vista.findViewById(R.id.imgyear);
            imagen.setImageResource( img ) ;

            TextView tvyear = (TextView)  vista.findViewById(R.id.textyear);
            tvyear.setText("Catálogo "+year);

            vista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String texto =   ( (TextView)  v.findViewById(R.id.textyear)).getText().toString();
                    if(texto.contains("2018"))
                    {
                        setToolBar("Catálogo 2018");
                        libros_pagerAdapter.setupYears(2018);
                        barrabusqueda.setMax(32);
                    }
                    else if(texto.contains("2019"))
                    {
                        setToolBar("Catálogo 2019");
                        libros_pagerAdapter.setupYears(2019);
                        barrabusqueda.setMax(44);
                    }
                    pager.setCurrentItem(0);
                    stackyear.setVisibility(View.INVISIBLE);
                    revealFAB.getFab().show();
                }
            });
            return vista ;
        }


    }

}
