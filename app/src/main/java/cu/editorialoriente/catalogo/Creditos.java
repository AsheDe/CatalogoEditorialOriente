package cu.editorialoriente.catalogo;

import android.content.Intent;
import android.net.Uri;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorBlanco));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Créditos");

        TextView creditos = (TextView) findViewById(R.id.textcreditos);
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:yudeelito@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"yudeelito@gmail.com" , "yudel1987@nauta.cu"  });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App - Editorial Oriente");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Email"));
            }
        });

        TextView creditos2 = (TextView) findViewById(R.id.textcreditos2);
        creditos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:yudeelito@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"yudeelito@gmail.com" , "yudel1987@nauta.cu"  });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App - Editorial Oriente");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Email"));
            }
        });

        FloatingActionButton mailyudel = (FloatingActionButton) findViewById(R.id.mail_yudel);
        mailyudel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:yudeelito@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"yudeelito@gmail.com" , "yudel1987@nauta.cu"  });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App - Editorial Oriente");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Email"));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
}
