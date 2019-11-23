package cu.editorialoriente.catalogo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import com.google.android.material.textfield.TextInputEditText;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Administrador on 17/01/2018.
 */
public class Enviar_Mail extends AppCompatActivity {

    HashMap<String,String> links = new HashMap();
    TextInputEditText mNombre,mTexto;
    boolean isBienNombre=false,isBienTexto = false ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        links.put("Aprenda a maquillarse",  "https://editorialoriente.wordpress.com/2017/10/16/aprenda-a-maquillarse/"   );
        links.put("“Americanos” y soldados: Documentos del Ejército de Cuba sobre los Estados Unidos (1957-1958)", "https://editorialoriente.wordpress.com/2017/10/16/americanos-y-soldados-documentos-del-ejercito-de-cuba-sobre-los-estados-unidos-1957-1958/"    );
        links.put("Barbaroja. La historia no contada del jefe de los servicios secretos de Cuba", "https://editorialoriente.wordpress.com/2017/10/16/barbaroja-la-historia-no-contada-del-jefe-de-los-servicios-secretos-de-cuba/"    );
        links.put("Camilo. Las expediciones de junio de 1959", "https://editorialoriente.wordpress.com/2017/10/16/camilo-las-expediciones-de-junio-de-1959/"     );
        links.put("Cuentos de ahora y de luego", "https://editorialoriente.wordpress.com/2017/10/16/cuentos-de-ahora-y-de-luego-2/"    );
        links.put("De la tierra incógnita. El Camagüey visto por forasteros",   "https://editorialoriente.wordpress.com/2017/12/22/de-la-tierra-incognita-el-camaguey-visto-por-forasteros/"  );
        links.put("Derecho de resistencia y revolución en Cuba", "https://editorialoriente.wordpress.com/2017/10/16/derecho-de-resistencia-y-revolucion-en-cuba/"    );
        links.put("El bolero en América Latina. Compositores e intérpretes. Ponencias del Coloquio Internacional Boleros de Oro", "https://editorialoriente.wordpress.com/2017/10/16/el-bolero-en-america-latina-compositores-e-interpretes-ponencias-del-coloquio-internacional-boleros-de-oro/"    );
        links.put("El espejo pintado",  "https://editorialoriente.wordpress.com/2017/10/16/el-espejo-pintado/"   );
        links.put("El exilio según Julia",  "https://editorialoriente.wordpress.com/2017/10/16/el-exilio-segun-julia/"   );
        links.put("El muchacho del chaleco negro",  "https://editorialoriente.wordpress.com/2017/10/17/el-muchacho-del-chaleco-negro/"   );
        links.put("El silencio de los peces",  "https://editorialoriente.wordpress.com/2017/10/17/el-silencio-de-los-peces/"   );
        links.put("Felicidad", "https://editorialoriente.wordpress.com/2017/10/17/felicidad/"    );
        links.put("Guillermón Moncada. El gigante de Oriente",  "https://editorialoriente.wordpress.com/2017/11/27/guillermon-moncada-el-gigante-de-oriente/"   );
        links.put("Grunge",  "https://editorialoriente.wordpress.com/2017/10/17/grunge/"   );
        links.put("Hígado: cirrosis y cáncer. Como evitarlos", "https://editorialoriente.wordpress.com/2017/10/17/higado-cirrosis-y-cancer-como-evitarlos/"    );
        links.put("La cocina canaria en Cuba", "https://editorialoriente.wordpress.com/2017/10/17/la-cocina-canaria-en-cuba/"   );
        links.put("La fonda y sus comidas",  "https://editorialoriente.wordpress.com/2017/10/17/la-fonda-y-sus-comidas/"   );
        links.put("La gallinita mecánica ",   "https://editorialoriente.wordpress.com/2017/10/17/la-gallinita-mecanica/"  );
        links.put("Numerio Negidio, el hombre que se persignaba con la mano izquierda", "https://editorialoriente.wordpress.com/2017/10/17/numerio-negidio-el-hombre-que-se-persignaba-con-la-mano-izquierda/"    );
        links.put("Piratas, corsarios y bucaneros ",  "https://editorialoriente.wordpress.com/2017/12/22/piratas-corsarios-y-bucaneros/"   );
        links.put("Timoteo",  "https://editorialoriente.wordpress.com/2018/01/18/timoteo/"   );
        links.put("Si tu mueres primero", "https://editorialoriente.wordpress.com/2018/01/18/si-tu-mueres-primero/"   );
        links.put("Tú puedes vivir con lupus", "https://editorialoriente.wordpress.com/2018/01/18/tu-puedes-vivir-con-lupus/"    );
        links.put("Un cadáver ideal","https://editorialoriente.wordpress.com/2018/01/18/un-cadaver-ideal/"     );
        links.put("Asir la luz. José Martí y Vasili V. Vereschaguin",  "https://editorialoriente.wordpress.com/2017/12/05/asir-la-luz-jose-marti-y-vasili-v-vereschaguin/"   );
        links.put("El último viaje",  "https://editorialoriente.wordpress.com/2018/01/18/el-ultimo-viaje/"   );
        links.put("Fractura de cadera",  "https://editorialoriente.wordpress.com/2018/01/18/fractura-de-cadera/"   );
        links.put("La yuca. Perla peregrina",  "https://editorialoriente.wordpress.com/2018/01/18/la-yuca-perla-peregrina/"   );
        links.put("Manual del cocinero cubano", "https://editorialoriente.wordpress.com/2018/01/18/manual-del-cocinero-cubano/"    );
        links.put("El nacimiento de una pasión. El cine en Cuba (1897-2014)",   "https://editorialoriente.wordpress.com/2018/01/18/el-nacimiento-de-una-pasion-el-cine-en-cuba-1897-2014/"  );
        links.put("Sembré mariposas para cantarte", "https://editorialoriente.wordpress.com/2018/01/18/sembre-mariposas-para-cantarte/"    );
        links.put("Tienda de mascotas", "https://editorialoriente.wordpress.com/2018/01/18/tienda-de-mascotas/"    );


        setContentView(R.layout.enviar_email);
        /// --- ABRIR DATOS MOVILES
        boolean haydatosmovil = Utiles.datosmovilesEncendidos(this);
        boolean datosmovilesconectando = Utiles.datosmovilesConectando(this);
        if(!haydatosmovil && !datosmovilesconectando) {
            try {
                Utiles.setMobileDataEnabled(this, true);
            } catch (Exception e) {
                // publishProgress(e.getMessage());
                boolean encender = Utiles.EncenderDatosMoviles(this);
                if (!encender)
                    Toast.makeText(this, "No se han podido encender los datos móviles, por favor, hágalo manualmente", Toast.LENGTH_LONG);
            }
        }
        ////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String titulo = getIntent().getStringExtra("titulo");

        int val = PreferenceManager.getDefaultSharedPreferences(this).getInt("datos",0);
        Log.d("dar",val+"");
        if(val<3) {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setMessage("Este mensaje se transmitirá a nuestra página web, para ser publicado en ella. Si no estás conectado a la wifi, el envío se realiza por datos móviles. Puedes ver tu comentario en \n https://editorialoriente.wordpress.com");
            b.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .setNeutralButton("Visitar nuestra WEB", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri uri = Uri.parse("https://editorialoriente.wordpress.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

            b.create().show();
            PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("datos",++val).commit();
        }


        final AppCompatActivity actividad = this;
        final Context contexto = this;
        mNombre = (TextInputEditText) findViewById(R.id.mail_nombre) ;
        mTexto = (TextInputEditText) findViewById(R.id.textocorreo) ;


        TextView titulotv = (TextView) findViewById(R.id.titulo_pub) ;
        titulotv.setText("Vas a comentar en: \n" +titulo);
        Button enviar = (Button) findViewById(R.id.botonenviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isBienNombre==true && isBienTexto==true) {
                    String link = links.get(titulo);
                    final String texto = "Acerca de <a href='" + link + "'>" + titulo + " </a>" + ", debo decir que:</br> </br> " + mTexto.getText().toString() + "</br> </br> Vía App Android -Catálogo Editorial Oriente.- [category App] [status draft] [tags " + titulo + "]</br></br>[end]";
                    String nombre = mNombre.getText().toString();
                    final String subject = "Opinión de " + nombre + " en " + titulo;
                    new Correo_Enviar_AsyncTask(actividad).execute(getResources().getString(R.string.mailwordpress), subject, texto, contexto);
                }
                else {
                    Toast.makeText(contexto,"El nombre debe tener entre 3 y 30 caracteres y el texto mas de 5 caracteres", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button borrar = (Button) findViewById(R.id.botonborrar);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNombre.setText("");
                mTexto.setText("");
            }
        });

        mNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length()<3 && s.length()>0)
                    {
                        mNombre.setError("El nombre es muy corto.");
                        isBienNombre = false;
                    }
                else if(s.length()>30)
                    {
                        mNombre.setError("El nombre es muy largo.");
                        isBienNombre = false;
                    }
                else {isBienNombre = true;}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mTexto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<5 && s.length()>0)
                {
                    mTexto.setError("El texto es muy corto.");
                    isBienTexto = false;
                }
                else {
                    isBienTexto = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(Build.VERSION.SDK_INT >= 21) {
            borrar.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_negro_rojo));
            enviar.setBackground(getResources().getDrawable(R.drawable.efecto_ripple_negro_rojo));
        }

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
               onBackPressed();
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


}
