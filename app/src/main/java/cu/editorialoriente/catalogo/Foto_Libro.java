package cu.editorialoriente.catalogo;

import android.content.Intent;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Foto_Libro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foto__libro);
        Utiles.FullScreen(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(getIntent().hasExtra("recurso")) {
            int recurso = getIntent().getIntExtra("recurso", R.mipmap.aprendaamaquillarsa);
          final LIBRO libroamostrar =   getIntent().getParcelableExtra("libromostrar");
          //final int posautor =  getIntent().getIntExtra("posicion",0);
            ((ImageView) findViewById(R.id.libro_completo)).setImageResource(recurso);
            ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent libroafull =new Intent(getBaseContext(),Detalle_Libro_Actividad.class);
                    libroafull.putExtra("libromostrar",libroamostrar);
                    //libroafull.putExtra("posicion",posautor);
                    startActivity(libroafull);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}
