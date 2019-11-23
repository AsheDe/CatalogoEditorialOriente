package cu.editorialoriente.catalogo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.AlertDialog;

import android.widget.Toast;


/**
 * Created by renier on 21/11/2016.
 */
public class Correo_Enviar_AsyncTask extends AsyncTask {
    private ProgressDialog statusDialog;
    private Activity sendMailActivity;
    private Context context;
   // String asunto="";

    public Correo_Enviar_AsyncTask(Activity activity) {
        sendMailActivity = activity;

        context = (Context)activity;
    }

    protected void onPreExecute() {
        statusDialog = new ProgressDialog(context);
        statusDialog.setMessage("Abriendo Conexion...");
        statusDialog.setIndeterminate(false);
        statusDialog.setCancelable(false);
        statusDialog.show();
        statusDialog.setMessage("Intentando Enviar...");



    }

    @Override
    protected Object doInBackground(Object... args) {

            try {

                publishProgress("Procesando....");
                Correo_Enviar androidEmail;
                androidEmail = new Correo_Enviar((String) args[0], args[1].toString(), args[2].toString(), (Context) args[3]);
                publishProgress("Preparando ....");
                androidEmail.createEmailMessage();
                publishProgress("Enviando ....");
                androidEmail.Enviar_Correo();
               // publishProgress("Enviado.");
            } catch (Exception e) {
               //  publishProgress(e.getMessage());
                return e.getMessage();
            }
        // asunto=args[1].toString();
            return "Mensaje Enviado";

    }

    @Override
    public void onProgressUpdate(Object... values) {
        statusDialog.setMessage(values[0].toString());
    }

    @Override
    public void onPostExecute(Object result) {
            statusDialog.dismiss();
        Toast.makeText(sendMailActivity.getBaseContext(),result.toString(),Toast.LENGTH_LONG).show();
    }




}

