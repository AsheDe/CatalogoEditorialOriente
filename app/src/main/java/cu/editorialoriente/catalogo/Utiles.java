package cu.editorialoriente.catalogo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yudel on 31/07/2017.
 */
public class Utiles {

    static public void FullScreen(AppCompatActivity actividad)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                actividad.getWindow().setStatusBarColor(Color.TRANSPARENT);
                actividad.getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            } else {
                actividad.getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }




    static  public Drawable ImagenesRedondeadas(Integer recurso, Context contexto) {

        if(recurso==null)
            recurso = R.mipmap.logoeditorial;

        Bitmap originalBitmap = BitmapFactory.decodeResource(contexto.getResources(),recurso);

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(contexto.getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());
        return roundedDrawable;

    }


    static public void ColorPredominante(final Context contexto, int recurso,final View vista_a_modificar)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(contexto.getResources(),recurso);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int color_default = contexto.getResources().getColor(R.color.colornegro_300) ;
                if  (palette.getDarkMutedSwatch()!= null)
                {
                    int value = palette.getDarkMutedColor(color_default);
                    vista_a_modificar.setBackgroundColor(value);
                }

                else if(palette.getDarkVibrantSwatch()!= null)
                {
                    int value = palette.getDarkVibrantColor(color_default) ;
                    vista_a_modificar.setBackgroundColor(value);

                }
                else if(palette.getVibrantSwatch()!= null)
                {
                    int value = palette.getVibrantColor(color_default) ;
                    vista_a_modificar.setBackgroundColor(value);

                }
            }
        });

        vista_a_modificar.setBackgroundColor(contexto.getResources().getColor(R.color.colornegro_300));

    }





    static  public boolean datosmovilesEncendidos(Activity actividad)
    {
        ConnectivityManager conMgr =  (ConnectivityManager) actividad.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null)
            return false;
        return true;


    }

    static public void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final Class conmanClass = Class.forName(conman.getClass().getName());
        final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
        connectivityManagerField.setAccessible(true);
        final Object connectivityManager = connectivityManagerField.get(conman);
        final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);

        setMobileDataEnabledMethod.invoke(connectivityManager, enabled);
    }

    static  public boolean datosmovilesConectando(Activity actividad)
    {
        ConnectivityManager conMgr =  (ConnectivityManager) actividad.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null)
            return false;
        else if(netInfo.getState() == NetworkInfo.State.CONNECTING)
            return true;
        return false;

    }

    static public void ApagarDatosMoviles(Context contexto) {
        try {
            setMobileDataEnabled(contexto, false);
        } catch (Exception excep) {
            Toast.makeText(contexto, excep.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    static public boolean EncenderDatosMoviles(Context contexto)
    {
        Method dataConnSwitchmethod;
        Class telephonyManagerClass;
        Object ITelephonyStub;
        Class ITelephonyClass;
        boolean isEnabled;
        TelephonyManager telephonyManager = (TelephonyManager) contexto
                .getSystemService(Context.TELEPHONY_SERVICE);

        if(telephonyManager.getDataState() == TelephonyManager.DATA_CONNECTED){
            isEnabled = true;
        }else{
            isEnabled = false;
        }
        try {
            telephonyManagerClass = Class.forName(telephonyManager.getClass().getName());
            Method getITelephonyMethod = telephonyManagerClass.getDeclaredMethod("getITelephony");
            getITelephonyMethod.setAccessible(true);
            ITelephonyStub = getITelephonyMethod.invoke(telephonyManager);
            ITelephonyClass = Class.forName(ITelephonyStub.getClass().getName());

            if (!isEnabled) {
                //  dataConnSwitchmethod = ITelephonyClass
                //        .getDeclaredMethod("disableDataConnectivity");
                // } else {
                dataConnSwitchmethod = ITelephonyClass
                        .getDeclaredMethod("enableDataConnectivity");
                dataConnSwitchmethod.setAccessible(true);
                dataConnSwitchmethod.invoke(ITelephonyStub);
            }

        }
        catch (Exception exc)
        {
            return false;
        }
        return true;
    }



}
