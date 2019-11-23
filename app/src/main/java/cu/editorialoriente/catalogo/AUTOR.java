package cu.editorialoriente.catalogo;

import android.os.Parcel;
import android.os.Parcelable;

public class AUTOR implements Parcelable {
    String nombre,biografia,ciudad,fecha;
    Integer avatar;

    
    public AUTOR() {
    }

    public AUTOR(Parcel parcel) {
        nombre = parcel.readString(  );
        biografia= parcel.readString(  );
        ciudad= parcel.readString(  );
        fecha = parcel.readString(  );
        avatar = parcel.readInt(  );
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
          dest.writeString(nombre  );
         dest.writeString( biografia );
         dest.writeString( ciudad );
          dest.writeString( fecha );
          dest.writeInt(avatar  );
    }

    public static final Parcelable.Creator<AUTOR> CREATOR = new Parcelable.Creator<AUTOR>()
    {
        public AUTOR createFromParcel(Parcel in)
        {
            return new AUTOR(in);
        }
        public AUTOR[] newArray(int size)
        {
            return new AUTOR[size];
        }
    };
}
