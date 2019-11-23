package cu.editorialoriente.catalogo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Utiles.FullScreen(this);
        final ParticleView  mPv1 = (ParticleView) findViewById(R.id.pv_1);
        final Context context= this ;

        mPv1.startAnim();


       final AsyncTask ast = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                DBManager bd = new DBManager(context);
                if(bd.BasedatosAbierta())
                    onProgressUpdate("open".split(""));
                while (bd.BasedatosAbierta())
                    contador++;

                return true;
            }

           @Override
           protected void onProgressUpdate(Object[] values) {
              // super.onProgressUpdate(values);
               Toast.makeText(context,"Creando BD",Toast.LENGTH_SHORT).show();
           }
       };
        ast.execute();

        mPv1.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {

            @Override
            public void onAnimationEnd() {

                Log.d("TAG",contador+"");

                if (ast.getStatus()==AsyncTask.Status.FINISHED)
                {
                    mPv1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent colecciondelibros = new Intent("cu.editorialoriente.catalogo.COLECCION");
                            startActivity(colecciondelibros);
                            overridePendingTransition(R.anim.desplazamiento_lateral,0);
                        }
                    },0);
                }
                else
                {
                    contador++;
                    mPv1.clearAnimation();
                    mPv1.startAnim();
                    if(contador==5)
                        Toast.makeText(context,"Existe demora para crear la Base de Datos. Seguimos trabajando...",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
