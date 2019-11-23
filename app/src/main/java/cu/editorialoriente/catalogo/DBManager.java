package cu.editorialoriente.catalogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by yudel on 30/11/2017.
 */
public class DBManager {
    protected DBHelper base_datos;
    protected Context contexto;

    public DBManager(Context c) {
        base_datos = new DBHelper(c, "bdlibrosfavoritos", null, 3);
        contexto = c;
    }

    public boolean BasedatosAbierta()
    {
        return base_datos.BasedatosAbierta();
    }

    public ArrayList<LIBRO> ObtenerListaLibros(){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,null,null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                LIBRO mLibro = new LIBRO();
                mLibro.titulo = c.getString(0);
                String [] auths = {c.getString(1),c.getString(2),c.getString(3)};
                mLibro.autores = auths ;
                mLibro.year = c.getInt(4);
                mLibro.isbn = c.getString(5);
                mLibro.sinopsis = c.getString(6);
                mLibro.genero = c.getString(7);
                mLibro.coleccion = c.getString(8);
                mLibro.megusta = c.getInt(9);
                mLibro.portada = c.getInt(10);
                mLibro.precio = c.getString(11);
               listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }
       public ArrayList<LIBRO> ObtenerListaLibrosYear( int year){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"year=='"+year+"'",null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                LIBRO mLibro = new LIBRO();
                mLibro.titulo = c.getString(0);
                String [] auths = {c.getString(1),c.getString(2),c.getString(3)};
                mLibro.autores = auths ;
                mLibro.year = c.getInt(4);
                mLibro.isbn = c.getString(5);
                mLibro.sinopsis = c.getString(6);
                mLibro.genero = c.getString(7);
                mLibro.coleccion = c.getString(8);
                mLibro.megusta = c.getInt(9);
                mLibro.portada = c.getInt(10);
                mLibro.precio = c.getString(11);
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }




    public ArrayList<LIBRO> ObtenerListaLibrosRelacionados( String titulo){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();
        LIBRO mLibro = new LIBRO();
        Cursor c = db.query("LIBROS", null,"titulo=='"+titulo+"'",null,null,null,null);
        if(c.moveToFirst())
        {
                mLibro.titulo = c.getString(0);
                String [] auths = {
                        c.getString(1),
                        c.getString(2),
                        c.getString(3)
                };
                mLibro.autores = auths ;
                mLibro.year = c.getInt(4);
                mLibro.isbn = c.getString(5);
                mLibro.sinopsis = c.getString(6);
                mLibro.genero = c.getString(7);
                mLibro.coleccion = c.getString(8);
                mLibro.megusta = c.getInt(9);
                mLibro.portada = c.getInt(10);
                mLibro.precio = c.getString(11);
                Log.d("PRECIO",mLibro.precio) ;
        }
        //new String[]{"LIMIT 10"}
        c = db.query("LIBROS", null,"titulo!='"+titulo+"' AND ( autor1=='"+mLibro.autores[0]+"' or coleccion=='" +mLibro.coleccion+"' or generos=='"+mLibro.genero+"')",null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                LIBRO book = new LIBRO();
                book.titulo = c.getString(0);
                String [] auths = {c.getString(1),c.getString(2),c.getString(3)};
                book.autores = auths ;
                book.year = c.getInt(4);
                book.isbn = c.getString(5);
                book.sinopsis = c.getString(6);
                book.genero = c.getString(7);
                book.coleccion = c.getString(8);
                book.megusta = c.getInt(9);
                book.portada = c.getInt(10);
                book.precio = c.getString(11);
                Log.d("PRECIO",mLibro.precio) ;
                listado.add(book);

            }
            while (c.moveToNext());
        }
        return listado;
    }

    public ArrayList<AUTOR> ObtenerListaAutores( ){
        ArrayList<AUTOR> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("AUTORES", null,null,null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                AUTOR mAutor = new AUTOR();
                mAutor.nombre = c.getString(0);
                mAutor.avatar = c.getInt(1);
                mAutor.ciudad = c.getString(2);
                mAutor.fecha = c.getString(3);
                mAutor.biografia = c.getString(4);
                listado.add(mAutor);

            }
            while (c.moveToNext());
        }
        db.close();
        return listado;
    }

    public AUTOR AutorBynombre(String nombre)
    {
        SQLiteDatabase db = base_datos.getWritableDatabase();
        AUTOR mAutor= new AUTOR();
        String name = "" ;
        if(nombre.contains("(compilador)") )
            name = nombre.replace("(compilador)","");
        else if( nombre.contains("(compiladora)"))
            name = nombre.replace("(compiladora)","");
        else
            name = nombre ;

        Cursor c = db.query("AUTORES", null,"nombre LIKE '%"+name+"%'",null,null,null,null);
        if(c.moveToFirst())
        {
                mAutor.nombre = c.getString(0);
                mAutor.avatar = c.getInt(1);
                mAutor.ciudad = c.getString(2);
                mAutor.fecha = c.getString(3);
                mAutor.biografia = c.getString(4);

        }
        db.close();
        return mAutor;
    }


    public int CambiarFavorito(String titulo)
    {
        SQLiteDatabase base_de_datos = base_datos.getWritableDatabase();
        Cursor c = base_de_datos.rawQuery("SELECT megusta FROM LIBROS WHERE titulo=='"+titulo+ "'",null);
        int megusta=0;
        if(c.moveToFirst())
        {
            megusta  = c.getInt(0);
            if(megusta==0)
                megusta = 1;
            else
                megusta = 0;


            ContentValues cv = new ContentValues();
            cv.put("megusta", megusta);
            base_de_datos.update("LIBROS",cv,"titulo=='" +titulo +"'",null);

        }
        base_de_datos.close();
        return megusta;

    }

    public int esFavorito(String titulo)
    {
        SQLiteDatabase base_de_datos = base_datos.getWritableDatabase();
        Cursor c = base_de_datos.rawQuery("SELECT megusta FROM LIBROS WHERE titulo=='"+titulo+ "'",null);
        int megusta=0;
        if(c.moveToFirst())
        {
            megusta  = c.getInt(0);

        }
        base_de_datos.close();
        return megusta;

    }


    public ArrayList<LIBRO> ObtenerFavoritos()
    {
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"megusta!='0'",null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                LIBRO mLibro = new LIBRO();
                mLibro.titulo = c.getString(0);
                String [] auths = {c.getString(1),c.getString(2),c.getString(3)};
                mLibro.autores = auths ;
                mLibro.year = c.getInt(4);
                mLibro.isbn = c.getString(5);
                mLibro.sinopsis = c.getString(6);
                mLibro.genero = c.getString(7);
                mLibro.coleccion = c.getString(8);
                mLibro.megusta = c.getInt(9);
                mLibro.portada = c.getInt(10);
                mLibro.precio = c.getString(11);
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        db.close();
        return listado;
    }

   /* public boolean SaberSimegustaUnLibro(int pos)
    {
        SQLiteDatabase base_de_datos = base_datos.getWritableDatabase();
        Cursor c = base_de_datos.rawQuery("SELECT megus FROM LI WHERE posicion=='"+pos+ "'",null);
        if(c.moveToFirst())
        {
            base_de_datos.close();
            return true;
        }
        base_de_datos.close();
        return false;
    }*/
}

