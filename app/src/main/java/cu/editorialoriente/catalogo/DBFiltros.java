package cu.editorialoriente.catalogo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBFiltros extends DBManager {


    public DBFiltros(Context c) {
        super(c);

    }

    public ArrayList<LIBRO> BuscarLibrosTitulos(String titulo){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"titulo LIKE '%"+titulo+"%'",null,null,null,null);
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
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }

    public ArrayList<LIBRO> BuscarLibrosGeneros(String genero){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"generos LIKE '%"+genero+"%'",null,null,null,null);
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
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }

    public ArrayList<LIBRO> BuscarLibrosColeccion(String coleccion){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"coleccion LIKE '%"+coleccion+"%'",null,null,null,null);
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
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }

    public ArrayList<LIBRO> BuscarLibrosAutor(String autor){
        ArrayList<LIBRO> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("LIBROS", null,"autor1 LIKE '%"+autor+"%' OR autor2 LIKE '%"+autor+"%'",null,null,null,null);
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
                listado.add(mLibro);


            }
            while (c.moveToNext());
        }
        return listado;
    }

    public ArrayList<AUTOR> FiltrarAutores(String mautor){
        ArrayList<AUTOR> listado = new ArrayList<>();
        SQLiteDatabase db = base_datos.getWritableDatabase();

        Cursor c = db.query("AUTORES", null,"nombre LIKE '%"+mautor+"%'",null,null,null,null);
        if(c.moveToFirst())
        {

            do{
                AUTOR mAutor= new AUTOR();
                mAutor.nombre = c.getString(0);
                mAutor.avatar = c.getInt(1);
                mAutor.ciudad = c.getString(2);
                mAutor.fecha = c.getString(3);
                mAutor.biografia = c.getString(4);

                listado.add(mAutor);


            }
            while (c.moveToNext());
        }
        return listado;
    }
}
