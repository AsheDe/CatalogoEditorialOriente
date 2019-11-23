package cu.editorialoriente.catalogo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Perfil_Autor_Actividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil__autor__actividad);


        Utiles.FullScreen(this);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar) ;
        tb.setTitle("");
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final AUTOR autor =   getIntent().getParcelableExtra("autor");

        // TODO BUSCAR MOHAMED MAGHANI


        ImageView avatar_autor = (ImageView) findViewById(R.id.avatar_autor);
       avatar_autor.setImageDrawable( Utiles.ImagenesRedondeadas( autor.avatar,this));
       avatar_autor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder dial = new AlertDialog.Builder(v.getContext());
               ImageView img = new ImageView(v.getContext()) ;
               img.setImageResource(autor.avatar);
               dial.setView(img);
               dial.setTitle(autor.nombre);
               dial.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
               dial.create().show();
           }
       });

        TextView tvnombreautor = (TextView) findViewById(R.id.text_autor);
        String name = autor.nombre ;
        if(name.contains("(compilador)"))
            name =  name.replace("(compilador)","");
        if(name.contains("(compiladora)"))
            name =  name.replace("(compiladora)","");
        tvnombreautor.setText(name);

        TextView biografia = (TextView) findViewById(R.id.biografia);
        biografia.setText(autor.biografia);

        TextView fechanac = (TextView) findViewById(R.id.fechanac);
        fechanac.setText(autor.ciudad  + " -  " + autor.fecha);

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
            {
               // NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
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
