package cu.editorialoriente.catalogo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Nosotros extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nosotros_actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:editorialoriente.scu@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"editorialoriente.scu@gmail.com","girasolana@nauta.cu"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Desde App - \"Catálogo Editorial Oriente\"");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Email"));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        findViewById(R.id.facebook).setOnClickListener(this);
        findViewById(R.id.twitter).setOnClickListener(this);
        findViewById(R.id.cubava).setOnClickListener(this);
        findViewById(R.id.wordpress).setOnClickListener(this);

        findViewById(R.id.btncubava).setOnClickListener(this);
        findViewById(R.id.btntweet).setOnClickListener(this);
        findViewById(R.id.btnwface).setOnClickListener(this);
        findViewById(R.id.btnwpress).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        String openweb = "";
        switch (v.getId())
        {
            case R.id.wordpress :
            {
                openweb = "http://editorialoriente.wordpress.com";
                break;
            }
            case R.id.btnwpress:
            {
                openweb = "http://editorialoriente.wordpress.com";
                break;
            }
            case R.id.facebook :
        {
            openweb = "http://www.facebook.com/editorialoriente.scu/" ;
            break;
        }
            case R.id.btnwface:
            {
                openweb = "http://www.facebook.com/editorialoriente.scu/" ;
                break;
            }
            case R.id.twitter:
            {
                openweb = "https://mobile.twitter.com/editorialorient" ;
                break;
            }
            case R.id.btntweet:
            {
                openweb = "https://mobile.twitter.com/editorialorient" ;
                break;
            }
            case R.id.cubava:
            {
                openweb = "http://editorialoriente.cubava.cu" ;
                break;
            }
            case R.id.btncubava:
            {
                openweb = "http://editorialoriente.cubava.cu" ;
                break;
            }

        }

        Uri uri = Uri.parse(openweb);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
