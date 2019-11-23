package cu.editorialoriente.catalogo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/**
 * Created by yudel on 11/09/2017.
 */
public class LIBRO implements Parcelable{
    String titulo,coleccion,genero,sinopsis,precio,isbn;
    int portada;
    //int[] img_autores;
    int year;
    String [] autores;
    int megusta;


    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    int posicion=0;

   /* public LIBRO(String titulo, String [] autor, String coleccion, String genero, String sinopsis, String precio, int portada,int iautor, int pposicion ) {
        this.titulo = titulo;
        this.autores = autor;
        this.coleccion = coleccion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.portada = portada;
        this.img_autor = iautor;
        this.posicion = pposicion;
        this.year = 2019 ;
    }*/

   /* public LIBRO(String titulo, String autor, String coleccion, String genero, String sinopsis, String precio, int portada,int iautor, int pposicion,  int pyear ) {
        this.titulo = titulo;
        this.autor = autor;
        this.coleccion = coleccion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.portada = portada;
        this.img_autor = iautor;
        this.posicion = pposicion;
        this.year = pyear ;
    }*/


    public LIBRO() {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutor() {
        return autores;
    }

    public void setAutor(String[] autor) {
        this.autores = autor;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

   /* public int[] getImg_autor() {
        return img_autores;
    }*/

    /*public void setImg_autor(int[] img_autor) {
        this.img_autores = img_autor;
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    public LIBRO(Parcel parcel) {
        this.titulo = parcel.readString(  );
        this.autores = parcel.createStringArray(  );
        this.coleccion = parcel.readString(  );
        this.genero = parcel.readString(  );
        this.sinopsis = parcel.readString(  );
        this.precio = parcel.readString(  );
        this.portada = parcel.readInt(  );
     //   parcel.readIntArray(this.img_autores);
        this.posicion = parcel.readInt();
        this.year = parcel.readInt() ;
        this.isbn = parcel.readString();
        this.megusta = parcel.readInt();
        this.precio = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(  this.titulo);
        dest.writeStringArray(  this.autores);
        dest.writeString(  this.coleccion);
        dest.writeString(  this.genero);
        dest.writeString(  this.sinopsis);
        dest.writeString(  this.precio);
        dest.writeInt(  this.portada);
       // dest.writeIntArray(  this.img_autores);
        dest.writeInt(  this.posicion);
        dest.writeInt(this.year);
        dest.writeString(this.isbn);
        dest.writeInt(this.megusta);
        dest.writeString(this.precio);
    }

    public static final Parcelable.Creator<LIBRO> CREATOR = new Parcelable.Creator<LIBRO>()
    {
        public LIBRO createFromParcel(Parcel in)
        {
            return new LIBRO(in);
        }
        public LIBRO[] newArray(int size)
        {
            return new LIBRO[size];
        }
    };

}
