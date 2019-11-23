package cu.editorialoriente.catalogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yudel on 30/11/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
   // public String crear_tabla_favoritos =
     //       "CREATE TABLE FAVORITOS (posicion INTEGER,year INTEGER)";
   SQLiteDatabase operatingdb;
   
    private String crear_tabla_libros =
            "CREATE TABLE LIBROS (" +
                    "titulo TEXT," +
                    "autor1 TEXT," +
                    "autor2 TEXT," +
                    "autor3 TEXT," +
                    "year INTEGER," +
                    "isbn TEXT," +
                    "sinopsis TEXT," +
                    "generos TEXT," +
                    "coleccion TEXT," +
                    "megusta INTEGER," +
                    "portada INTEGER," +
                    "precio TEXT" +
                    
                    ")";

    private String crear_tabla_autores =
            "CREATE TABLE AUTORES (" +
                    "nombre TEXT," +
                    "avatar INTEGER," +
                    "ciudad TEXT," +
                    "fecha TEXT," +
                    "biografia TEXT" + ")";



    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        operatingdb = db ;
        db.execSQL("DROP TABLE IF EXISTS 'FAVORITOS'");
        db.execSQL(crear_tabla_libros);
        db.execSQL(crear_tabla_autores);
        InsertarLibros();
        InsertarAutores();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        operatingdb = db;
        db.execSQL("DROP TABLE IF EXISTS 'FAVORITOS'");
        db.execSQL(crear_tabla_libros);
        db.execSQL(crear_tabla_autores);
        InsertarLibros();
        InsertarAutores();
    }

    public boolean BasedatosAbierta()
    {
        if(operatingdb==null)
            return false;
       // return operatingdb.isOpen();
        SQLiteDatabase db = getWritableDatabase();
        int valor = 0;
        Cursor q = db.rawQuery("SELECT count(nombre)  FROM  AUTORES",null);
        if(q.moveToFirst())
            valor = q.getInt(0);
        db.close();
        return valor>50;
    }

    private void InsertarLibros() {


        ContentValues cv = new ContentValues();

        cv.put("megusta", 0);

        cv.put("titulo", "Aprenda a maquillarse");
        cv.put("autor1", "Marelis Proenza Brown");
        cv.put("autor2", "");
        cv.put("generos", "Divulgación popular");
        cv.put("sinopsis", "Para toda mujer existe el maquillaje adecuado, sea cual sea su edad. En este libro encontrará las herramientas para realizarlo.");
        cv.put("isbn", "ISBN: 978-959-11-1076-3");
        cv.put("coleccion", "En Casa");
        cv.put("portada", R.mipmap.aprendaamaquillarsa);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "“Americanos” y soldados: Documentos del Ejército de Cuba sobre los Estados Unidos (1957-1958)");
        cv.put("autor1", "José Abreu Cardet ");
        cv.put("autor2", " Marilú Uralde Cancio ");
        cv.put("generos", "Ensayo histórico ");
        cv.put("sinopsis", "Este libro recoge, a través de importantes documentos oficiales de archivo, el apoyo castrense brindado por Washington al régimen de Fulgencio Batista en ese período.");
        cv.put("isbn", "ISBN: 978-959-11-1072-5");
        cv.put("coleccion", "Bronce ");
        cv.put("portada", R.mipmap.americanosysoldadosdocumentos);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "Barbarroja. La historia no contada del jefe de los servicios secretos de Cuba");
        cv.put("autor1", "Luis de la Rosa Valdés ");
        cv.put("autor2", "");cv.put("generos", "Ensayo histórico");
        cv.put("sinopsis", "Este libro no pretende trazar sólo la rica trayectoria revolucionaria y humana de un hombre excepcional: el comandante del Ejército Rebelde Manuel Piñeiro Losada, sino mostrar las aristas que conforman el legado de su vida ejemplar de dimensión universal, desde sus luchas contra la tiranía batistiana, su obligado exilio en territorio de los Estados Unidos de América, luego en plena contienda guerrillera en la Sierra Maestra y el Segundo Frente Oriental Frank País, así como su destacado enfrentamiento a la contrarrevolución interna y externa a partir del triunfo revolucionario de enero de 1959, cuando realiza un profundo trabajo en la especialidad de los Servicios de Inteligencia cubanos.");
        cv.put("isbn", "ISBN: 978-959-11-1082-4");
        cv.put("coleccion", "Bronce ");
        cv.put("portada", R.mipmap.barbarojalahistorianocontada);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Camilo. Las expediciones de junio de 1959");
        cv.put("autor1", "Oscar Larralde Otero ");
        cv.put("autor2", "");cv.put("generos", "Ensayo histórico");
        cv.put("sinopsis", "Del legendario Señor de la Vanguardia, jefe de la Columna Invasora no. 2 Antonio Maceo, héroe de tantas acciones gloriosas, nos hablan en forma testimonial estas páginas para rescatar el suceso registrado en la primera quincena de junio de 1959, cuando inesperadamente visitara los poblados de Antilla y Banes y algunas comunidades cercanas, así como la ciudad de Holguín.");
        cv.put("isbn", "ISBN: 978-959-11-1093-0");
        cv.put("coleccion", "Bronce ");
        cv.put("portada", R.mipmap.camilolasexpediciones);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "Cuentos de ahora y de luego");
        cv.put("autor1", "Alberto Peraza Ceballos ");
        cv.put("autor2", "");cv.put("generos", "Cuento infantil");
        cv.put("sinopsis", "De la mano de Canek, recorre estos cuentos, pensados para leerse en lo que cae una gota, un meteorito o un camino montaña abajo. ");
        cv.put("isbn", "ISBN: 978-959-11-1087-9");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.cuentosdeahorayeluiego);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "De la tierra incógnita. El Camagüey visto por forasteros");
        cv.put("autor1", "Elda Cento Gómez ");
        cv.put("autor2", "");cv.put("generos", "Testimonio histórico");
        cv.put("sinopsis", "El Camagüey del siglo XIX, y aun de principios del XX, se nos presenta en este libro a través de ojos ajenos. Anastasio Orozco, Domingo del Monte, Antonio Bachiller, Samuel Hazard, Hippolyte Piron, José María Abraido, Joseph A. Springer, Julius Muller, figuran entre ellos; así como varios dibujantes y litógrafos.");
        cv.put("isbn", "ISBN: 978-959-11-1089-3");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.delatierraincognitaelcamaguey); /// aqui va libro sobre camaguey
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "Derecho de resistencia y revolución en Cuba");
        cv.put("autor1", "Luis Alberto Pérez Llody");
        cv.put("autor2", "");cv.put("generos", "Ensayo histórico");
        cv.put("sinopsis", "Este libro constituye un valioso instrumento para la ciencia jurídica en Cuba, pues su contenido constituye un aporte a la ciencia del Derecho, al mismo tiempo que a un conocimiento más profundo de la historia nacional, y con su proceso de investigación brinda un ejemplo muy notable de ejercicio eficaz y creativo en el campo de las ciencias jurídicas y de lo que puede obtenerse del trabajo interdisciplinario.");
        cv.put("isbn", "ISBN: 978-959-11-1042-8");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.derechoderesistenciayliberac);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El bolero en América Latina. Compositores e intérpretes. Ponencias del Coloquio Internacional Boleros de Oro");
        cv.put("autor1", "Alicia Valdés Cantero  ");
        cv.put("autor2", "");cv.put("generos", "Ensayo  ");
        cv.put("sinopsis", "El protagonista de este libro es el bolero, que más que género musical es un fenómeno cultural complejo capaz de atraer, aún hoy, gran cantidad de admiradores.");
        cv.put("isbn", "ISBN: 978-959-11-1074-9");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.elboleroen);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El espejo pintado");
        cv.put("autor1", "Eduardo Manet");
        cv.put("autor2", "Carlos Espinoza");
        cv.put("generos", "Ensayo   ");
        cv.put("sinopsis", "Con este volumen se rescatan, para el lector actual, las críticas de cine publicadas por Eduardo Manet (Santiago de Cuba, 1930) en el periódico Granma desde enero de 1966 hasta mediados de 1967, período en que estuvo encargado, junto con Mario Rodríguez Alemán y otros, de la sección cinematográfica de esa publicación periódica.");
        cv.put("isbn", "ISBN: 978-959-11-1065-7");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.elespejopintado);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "El exilio según Julia");
        cv.put("autor1", "Giséle Pineau ");
        cv.put("autor2", "");cv.put("generos", "Novela ");
        cv.put("sinopsis", "En este texto la narradora trata de reconstruir la etapa de su infancia junto a la abuela Julia, quien, anciana, negra y analfabeta es incapaz de hablar francés, y víctima, como sus nietos, del racismo y la intolerancia.");
        cv.put("isbn", "ISBN: 978-959-11-1063-3");
        cv.put("coleccion", "Mariposa");
        cv.put("portada", R.mipmap.elexiliosegnjulia);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El muchacho del chaleco negro");
        cv.put("autor1", "Luis Carlos Suárez  ");
        cv.put("autor2", "");cv.put("generos", "Novela infantojuvenil  ");
        cv.put("sinopsis", "Esta novela narra la historia de Gúmer, quien en el cumpleaños de Dorita, queda deslumbrado a ver a la preciosa  Estrellita y más cuando ¡le sonríe! ");
        cv.put("isbn", "ISBN: 978-959-11-1064-0");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.elmuchachodelchaleconegro);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "El silencio de los peces");
        cv.put("autor1", "Eduard Encina   ");
        cv.put("autor2", "");cv.put("generos", "Poesía infantojuvenil   ");
        cv.put("sinopsis", "Libro en el que los peces, como criaturas mágicas, hablan, mueven la cola, hacen burbujas de tristeza y de felicidad.    ");
        cv.put("isbn", "ISBN: 978-959-11-1062-6");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.elsilenciodelospeces);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Felicidad");
        cv.put("autor1", "Aida Bahr   ");
        cv.put("autor2", "");cv.put("generos", "Novela   ");
        cv.put("sinopsis", "Susana despierta con la premonición de que todo saldrá mal. Así se inicia esta novela, retrato de una familia santiaguera actual.  ");
        cv.put("isbn", "ISBN: 978-959-11-1081-7");
        cv.put("coleccion", "Ficciones  ");
        cv.put("portada", R.mipmap.felicidad);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Guillermón Moncada. El gigante de Oriente");
        cv.put("autor1", "Omar Felipe Mauri Sierra");
        cv.put("autor2", "Dick Manresa Arencibia");cv.put("generos", "Historieta  ");
        cv.put("sinopsis", "Con esta atractiva historieta, conocerán momentos importantes de la vida de Guillermo Moncada Veranes, Guillermón, mayor general del Ejército Libertador.");
        cv.put("isbn", "ISBN: 978-959-11-1066-4");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.guillermonoriente);  /// aqui va guillermon mnoncada
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "Grunge");
        cv.put("autor1", "Alejandro Rama");
        cv.put("autor2", "");cv.put("generos", "Cuento");
        cv.put("sinopsis", "Grunge es, ante todo, un género musical cuyo representante más reconocido, quizá, sea Nirvana. Derivo además en una subcultura que apelaba a un extrañamiento crítico de la sociedad y su burla. Y resulta interesante que este libro, sea una especie de recopilatorio sonoro de ese movimiento, tal vez, recontextualizado en nuestra realidad: tramas donde los personajes, prisioneros de una realidad asfixiante, sienten su entorno distorsionado o grotesco; empeñosos intentos en denostar la guerra, llámese como se llame y en nombre de lo que fuere, desde la perspectiva pura de la amistad y singularidad del individuo, hasta historias que se acercan a la ciencia ficción para explorar conceptos como el sexo. ");
        cv.put("isbn", "ISBN: 978-959-11-1073-0");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.grunge);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Hígado: cirrosis y cáncer. Como evitarlos");
        cv.put("autor1", "Ángel Píriz Momblant");
        cv.put("autor2", "");cv.put("generos", "Divulgación científica  ");
        cv.put("sinopsis", "Aquí conocerá los elementos básicos sobre el hígado: su anatomía, sus funciones, sus enfermedades más frecuentes como los diferentes tipos de cirrosis hepática y cáncer hepático.");
        cv.put("isbn", "ISBN: 978-959-11-1073-2");
        cv.put("coleccion", "Autoayuda");
        cv.put("portada", R.mipmap.higadocirrosisycncercomoevitarlos);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "La cocina canaria en Cuba");
        cv.put("autor1", "Mario Luis López Isla   ");
        cv.put("autor1", " Ester Lidia Vázquez Seara   ");
        cv.put("generos", "Divulgación");
        cv.put("sinopsis", "Más que una recopilación de recetas, este libro es una investigación de varios años y en él sus autores ofrecen información interesante y valiosa sobre el recorrido realizado por los inmigrantes canarios, desde su llegada a Cuba hasta la actualidad. ");
        cv.put("isbn", "ISBN: 978-959-11-1083-1");
        cv.put("coleccion", "En Casa");
        cv.put("portada", R.mipmap.lacocinacanariaencuba);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", "La fonda y sus comidas");
        cv.put("autor1", "Silvia Mayra Gómez Fariñas     ");
        cv.put("autor2", "");cv.put("generos", "Divulgación     ");
        cv.put("sinopsis", "Atractivas recetas, tradiciones culinarias y nuevas historias sobre el decursar de la fonda cubana y sus principales protagonistas, se dan cita en estas páginas. ");
        cv.put("isbn", "ISBN: 978-959-11-1084-8");
        cv.put("coleccion", "En Casa");
        cv.put("portada", R.mipmap.lafondaysuscomidas);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "La gallinita mecánica");
        cv.put("autor1", "Iliana Núñez Rodríguez   ");
        cv.put("autor2", "");cv.put("generos", "Cuento infantil ");
        cv.put("sinopsis", "Esta es la historia de un hallazgo en el que la realidad supera nuestros más preciados sueños. ");
        cv.put("isbn", "ISBN: 978-959-11-1067-1");
        cv.put("coleccion", "- ");
        cv.put("portada", R.mipmap.lagallinitamecanica);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Numerio Negidio, el hombre que se persignaba con la mano izquierda");
        cv.put("autor1", "Alberto Rodríguez Tosca ");
        cv.put("autor2", "");cv.put("generos", "Novela ");
        cv.put("sinopsis", "El sonido de un disparo reúne a los vecinos alrededor del apartamento 301. Así comienza esta novela donde se dan cita personajes pintorescos e igualmente cotidianos. ");
        cv.put("isbn", "ISBN: 978-959-11-1085-5");
        cv.put("coleccion", "Ficciones  ");
        cv.put("portada", R.mipmap.numerionegidioel);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);
        cv.put("titulo", "Piratas, corsarios y bucaneros");
        cv.put("autor1", "Juan J. Guarch Rodríguez  ");
        cv.put("autor2", "");cv.put("generos", "Divulgación infantojuvenil");
        cv.put("sinopsis", "Con este libro, su autor hace otro regalo al gran público lector. A través de éstas páginas nos adentramos en las peligrosas aguas del Caribe colonial, donde pululan criminales de toda laya. ");
        cv.put("isbn", "ISBN: 978-959-11-1075-6");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.piratasbucaneros);  /// aqui va pitaras corsarios y bucaneros
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Timoteo");
        cv.put("autor1", "Felipe Oliva");
        cv.put("autor2", "");cv.put("generos", "Cuento infantil");
        cv.put("sinopsis", "Este personaje, va como un fantasma espantando a todos los que encuentra a su paso, primero por ser un gato negro, y luego por pintarse de blanco y deambular, como un loco, por los oscuros basureros de la ciudad. ");
        cv.put("isbn", "ISBN: 978-959-11-1068-8");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.timoteo);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Si tu mueres primero");
        cv.put("autor1", "Aminta Buenaño Rugel");
        cv.put("autor2", "");cv.put("generos", "Novela ");
        cv.put("sinopsis", "Real Ciudad de la Caridad, a pesar de su pomposo nombre, es un pueblito rural con una vida de “buenas costumbres” aparentemente tranquilo, hundido en una cotidianidad inalterable. En torno a los personajes que lo habitan transcurre la trama de esta novela.");
        cv.put("isbn", "ISBN: 978-959-11-1091-6");
        cv.put("coleccion", "Mariposa");
        cv.put("portada", R.mipmap.situmueresprimero);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Tú puedes vivir con lupus");
        cv.put("autor1", "José Ricardo Morasén Cuevas ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular");
        cv.put("sinopsis", "¿Es el lupus una forma de cáncer? ¿Solo afecta a las mujeres? ¿Se puede heredar o contagiar? ¿Es posible sobrevivir al lupus, y por cuánto tiempo? ¿Tiene una cura? Este libro se propone desterrar algunos mitos que han surgido alrededor del lupus, provocados por el desconocimiento de la población.");
        cv.put("isbn", "ISBN: 978-959-11-0640-7");
        cv.put("coleccion", "Autoayuda");
        cv.put("portada", R.mipmap.tupuedesvivirconellupus);  /// aqui va se puede vivir con lupus
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Un cadáver ideal");
        cv.put("autor1", "Jorge Labañino Legrá ");
        cv.put("autor2", "");cv.put("generos", "Poesía   ");
        cv.put("sinopsis", "Suceda lo que suceda, Anselmo, golpeado, siempre será ese cadáver crítico que mira a una sociedad a ratos agresiva, a ratos doliente. Por eso nada puede salvarlo a él ni a los suyos. ");
        cv.put("isbn", "ISBN: 978-959-11-1092-3 ");
        cv.put("coleccion", "Heredia  ");
        cv.put("portada", R.mipmap.uncadaverideal);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Asir la luz. José Martí y Vasili V. Vereschaguin");
        cv.put("autor1", "Blas Nabel Pérez Camejo");
        cv.put("autor2", "");cv.put("generos", "Ensayo ");
        cv.put("sinopsis", "Este libro va dirigido al público que guste de admirar obras pictóricas de un excelente realismo y de la palabra crítica y certera de nuestro Apóstol.");
        cv.put("isbn", "ISBN: 978-959-11-1097-8");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.asirlaluz);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El último viaje");
        cv.put("autor1", "Emerio Medina   ");
        cv.put("autor2", "");cv.put("generos", "Novela infantil  ");
        cv.put("sinopsis", "Después de evitar el secuestro de la luna, sólo queda traer a Suné de los pantanos peligrosos para restaurar el orden en el mundo. ");
        cv.put("isbn", "ISBN: 978-959-11-1102-9");
        cv.put("coleccion", "Ala y Espuela ");
        cv.put("portada", R.mipmap.elultimoviaje);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Fractura de cadera      ");
        cv.put("autor1", "Eraclio Delgado Rifá  ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular   ");
        cv.put("sinopsis", "Esta obra expone, desde una perspectiva integradora, una realidad que acecha a cada paso como algo accidental, en especial y con mayor profusión, el adulto mayor: la fractura de cadera.  ");
        cv.put("isbn", "ISBN: 978-959-11-1090-9");
        cv.put("coleccion", "Autoayuda  ");
        cv.put("portada", R.mipmap.fracturadecadera);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "La yuca. Perla peregrina ");
        cv.put("autor1", "José Ignacio Fleites Adán");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular");
        cv.put("sinopsis", "La yuca es una de las raíces más apreciadas en la cocina latinoamericana y caribeña y a ella precisamente va dedicado este texto.");
        cv.put("isbn", "ISBN: 978-959-11-1070-1");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.layucaperla);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Manual del cocinero cubano  ");
        cv.put("autor1", "Eugenio de Coloma y Garcés ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular");
        cv.put("sinopsis", "En 1856, Eugenio de Coloma y Garcés, español residente en Cuba, publicó un libro al que tituló Manual del cocinero cubano, la Editorial Oriente lo ofrece ahora en edición facsimilar. ");
        cv.put("isbn", "ISBN: 978-959-11-1096-1");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.manualdelcocinero);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El nacimiento de una pasión. El cine en Cuba (1897-2014)  ");
        cv.put("autor1", "María Eulalia Douglas ");
        cv.put("autor2", "");cv.put("generos", "Ensayo");
        cv.put("sinopsis", "El variado contenido de este libro, que atiende lo particular y lo general con similar interés, amplía el conocimiento del país a propósito de su cine.");
        cv.put("isbn", "ISBN: 978-959-11-1086-2");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.elnacimientodeunapasion);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Sembré mariposas para cantarte ");
        cv.put("autor1", "Nersis Felipe  ");
        cv.put("autor2", "");cv.put("generos", "Poesía infantil");
        cv.put("sinopsis", "Sobre la magia y el poder de las mariposas nos habla este libro en el que los corazones se enlazan, el paisaje se adorna y encontramos, convertida en poesía, la historia de nuestra isla. ");
        cv.put("isbn", "ISBN: 978-959-11-1101-2");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.sembremariposas);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Tienda de mascotas");
        cv.put("autor1", "Yunier Riquenes Garcia");
        cv.put("autor2", "");
        cv.put("generos", "Cuento infantil");
        cv.put("sinopsis", "Siempre hay una historia para contar sobre las mascotas que llegan a nuestra vida y, una vez más, Tigre, un gato negro muy suspicaz, es el protagonista de las simpáticas anécdotas que se desarrollan en una tienda de mascotas, donde encontraremos perros, gallos, hámsteres y muchos animales que serán la atención de  Tigre y sus amigos. ");
        cv.put("isbn", "ISBN: 978-959-11-1088-6");
        cv.put("coleccion", "-");
        cv.put("portada", R.mipmap.tiendamascotas);
        cv.put("year", 2018);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "69. La sexualidad vigilada");
        cv.put("autor1", "Carlos Esquivel");
        cv.put("autor2", "");cv.put("generos", "Ensayo");
        cv.put("sinopsis", "Este libro pretende corregir y en el mismo orden descarriar las líneas múltiples que unen y desunen arte y sexo.");
        cv.put("isbn", "ISBN: 978-959-11-1124-1");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.f69);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Alcohólicos Anónimos: una puerta a la esperanza");
        cv.put("autor1", "Anselma Betancourt Pulsán  ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular ");
        cv.put("sinopsis", " Nuevas reflexiones, investigaciones y vivencias de alcohólicos anónimos se dan cita en estas páginas. ");
        cv.put("isbn", "ISBN: 978-959-11-1094-7 ");
        cv.put("coleccion", "Autoayuda");
        cv.put("portada", R.mipmap.alcoholicosanonimosunapuertaalaesperanza);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Aprender a vivir con diabetes mellitus ");
        cv.put("autor1", "Dr. Walfrido A. Curbelo Videra ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular ");
        cv.put("sinopsis", " Importantes interrogantes sobre esta enfermedad, responderá este libro, dirigido a la familia cubana. ");
        cv.put("isbn", "ISBN: 978-959-11-1136-4 ");
        cv.put("coleccion", "Autoayuda  ");
        cv.put("portada", R.mipmap.aprenderavivircondiabetes);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Barbarito Diez. Como el arrullo de palmas");
        cv.put("autor1", " Zenovio Hernández Pavón");
        cv.put("autor2", "");cv.put("generos", "Ensayo biográfico ");
        cv.put("sinopsis", " Barbarito Diez es, sin duda, uno de los principales intérpretes de la música cubana. En este libro, su autor ha querido llevar, a los lectores, parte importante de la trayectoria artística de este destacado cantante. ");
        cv.put("isbn", "ISBN: 978-959-11-1126-5 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.barbaritodiezcomoelarrullodepalmas);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Bautismo de sangre. Marighella, los frailes dominicos y la lucha armada en Brasil ");
        cv.put("autor1", "Frei Betto");
        cv.put("autor2", "");cv.put("generos", "Testimonio  ");
        cv.put("sinopsis", " Esta obra obtuvo el Premio Jabuti en 1982 al  mejor libro de memorias del año, en ella se realiza el perfil político de Carlos Marighella así como los episodios alrededor de su muerte, en los que se ven involucrados dos frailes dominicos, aunque la investigación de Frei Betto apunta a otros implicados.  ");
        cv.put("isbn", "ISBN: 978-959-11-1099-2");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.bautismodesangre);
        cv.put("year", 2019);cv.put("precio", "$18.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Cartelera cinematográfica");
        cv.put("autor1", "Sara Vega Miche");
        cv.put("autor2", "Mario Naito López ");
        cv.put("generos", "Divulgación popular   ");
        cv.put("sinopsis", "No estamos ante un simple listado de títulos distribuidos en orden cronológico. Este libro, fruto de la labor realizada por estos estudiosos, constituye un compendio referencial, un banco de datos que abre nuevos caminos para los investigadores. ");
        cv.put("isbn", "ISBN: 978-959-11-1157-9 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.carteleracinematografica);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Chano Pozo. La vida ");
        cv.put("autor1", "Rosa Marquetti Torres  ");
        cv.put("autor2", "");cv.put("generos", "Biografía   ");
        cv.put("sinopsis", " Caminar tras la leyenda, intentando encontrar asideros reales que la reafirmen. Este es el principal objetivo de este libro que intenta recorrer con Chano Pozo el camino de su éxito en Cuba, Estados Unidos y Europa, ese éxito que parecía indetenible hasta que una bala hizo definitivo su constante coqueteo con la muerte.");
        cv.put("isbn", "ISBN: 978-959-11-1100-5 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.chanopozolavida);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Colorea fauna exclusiva de Centro y Suramérica ");
        cv.put("autor1", "Rafael Borroto Galbes ");
        cv.put("autor2", "");cv.put("generos", "Pasatiempos   ");
        cv.put("sinopsis", "Libro de colorear que combina la diversión con el aprendizaje acerca de los animales que habitan esta región del planeta. ");
        cv.put("isbn", "ISBN: 978-959-11-1117-3 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.coloreafaunaexclusivadecentroysuramerica);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Constitución y orden jurídico en la Revolución cubana ");
        cv.put("autor1", "José Walter Mondelo García ");
        cv.put("autor2", "");cv.put("generos", "Ensayo ");
        cv.put("sinopsis", "La cuestión de la unidad del Derecho y el fundamento de su validez y obligatoriedad, junto al debate sobre el papel de la Constitución y su relación con el orden jurídico, ha sido una preocupación central del pensamiento jurídico de los dos últimos siglos. La teoría del Derecho del campo socialista, sin embargo, se mantuvo al margen de estas polémicas. El presente libro se aproxima a estos asuntos con la mirada puesta en su relevancia para el Derecho cubano, lo que resulta vitalmente necesario en estos tiempos de debates y replanteos constitucionales del modelo socialista.");
        cv.put("isbn", "ISBN: 978-959-11-1156-2");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.constitucionyordenjuridicoenlarevolucioncubana);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "  Crono  ");
        cv.put("autor1", " Román Emilio Pérez (Chicho)");
        cv.put("autor2", "");cv.put("generos", " Pasatiempos  ");
        cv.put("sinopsis", "Divertidísimo libro ideal para que los niños desarrollen habilidades de percepción e intuición.  ");
        cv.put("isbn", "ISBN: 978-959-11-1128-9 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.crono);
        cv.put("year", 2019);cv.put("precio", "$8.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Cuba en voz y canto de mujer (TI) ");
        cv.put("autor1", "Mayra Rosa Álvarez Martínez ");
        cv.put("autor2", "");cv.put("generos", "Investigación");
        cv.put("sinopsis", " La música popular cubana ha contado, a través de los años, con intérpretes y compositoras femeninas que han sabido defenderla no solo dentro de la Isla sino también internacionalmente. En este libro, resultado de una rigurosa investigación de más de quince años, tendremos la oportunidad de recordar o conocer esos nombres y esas voces con las que disfrutaron y, en muchos casos, aún disfrutan los cubanos y los amantes de la música de diferentes países.");
        cv.put("isbn", "ISBN: 978-959-11-1134-0 (TI) ");
        cv.put("coleccion", "Mariposa ");
        cv.put("portada", R.mipmap.cubaenvozycantodemujer);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Cuba en voz y canto de mujer (TII) ");
        cv.put("autor1", "Mayra Rosa Álvarez Martínez ");
        cv.put("autor2", "");cv.put("generos", "Investigación");
        cv.put("sinopsis", " La música popular cubana ha contado, a través de los años, con intérpretes y compositoras femeninas que han sabido defenderla no solo dentro de la Isla sino también internacionalmente. En este libro, resultado de una rigurosa investigación de más de quince años, tendremos la oportunidad de recordar o conocer esos nombres y esas voces con las que disfrutaron y, en muchos casos, aún disfrutan los cubanos y los amantes de la música de diferentes países.");
        cv.put("isbn", "ISBN: 978-959-11-1133-3(TII) ");
        cv.put("coleccion", "Mariposa");
        cv.put("portada", R.mipmap.cubaenvozycantodemujer);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);
		
		cv.put("titulo", "De dónde son los cubanos");
        cv.put("autor1", "Graciela de la Caridad Chailloux Laffita (compiladora)");
        cv.put("autor2", "");cv.put("generos", "Ensayo");
        cv.put("sinopsis", "Si alguna vez se ha preguntado acerca de los orígenes de quienes hoy nos llamamos cubanos y acerca de las fuentes que nutren nuestra cultura, tiene usted en sus manos, con este libro, una llave que le adentrará en un camino hacia muchas respuestas.");
        cv.put("isbn", "ISBN: 978-959-11-1139-5");
        cv.put("coleccion", "Diálogo");
        cv.put("portada", R.mipmap.dedondesonloscubanos);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);
		
		

        cv.put("titulo", "Diccionario Básico Escolar 1 ");
        cv.put("autor1", "Colectivo de autores del Centro de Lingüística Aplicada  ");
        cv.put("autor2", "");cv.put("generos", " Diccionario ");
        cv.put("sinopsis", "Contiene más de 12000 entradas y más de 21000 acepciones con ejemplos, distinción de grafías con dificultad ortográfica y presencia de locuciones fraseologismos y refranes, además de muchos otros atractivos.   ");
        cv.put("isbn", "ISBN: 978-959-11-0914-9 (TI) ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.diccionariobasicoescolar1);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "   Diccionario Básico Escolar 2  ");
        cv.put("autor1", "Colectivo de autores del Centro de Lingüística Aplicada  ");
        cv.put("autor2", "");cv.put("generos", " Diccionario ");
        cv.put("sinopsis", "Contiene más de 12000 entradas y más de 21000 acepciones con ejemplos, distinción de grafías con dificultad ortográfica y presencia de locuciones fraseologismos y refranes, además de muchos otros atractivos.   ");
        cv.put("isbn", "ISBN: 978-959-11-0915-6 (TII) ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.diccionariobasicoescolar2);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);
		
		cv.put("titulo", "El año milagroso ");
        cv.put("autor1", "Mohamed Magani");
        cv.put("autor2", "");cv.put("generos", "Novela");
        cv.put("sinopsis", "Un arrebato de deseo lleva a Smaíl a robar una maleta en un aeropuerto. Es parte de su estrategia para rencontrarse con una mujer cuya imagen lo obsesiona desde el primer instante.");
        cv.put("isbn", "ISBN: 978-959-11-1168-5");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.elyearmilagroso );
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


        cv.put("titulo", " El chapucerito      ");
        cv.put("autor1", "Reinaldo Álvarez Lemus");
        cv.put("autor2", "");cv.put("generos", "Poesía infantil");
        cv.put("sinopsis", " Este  es un libro dedicado a niños de todas las edades, en especial a aquellos que se sonrojan porque les sobran dedos cuando intentan contar hasta diez.");
        cv.put("isbn", "ISBN: 978-959-11-1141-3");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.elchapucerito);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);
		
		cv.put("titulo", "El cultivo de los helechos  ");
        cv.put("autor1", "Manuel G. Caluff ");
        cv.put("autor2", "Gustavo Shelton Serrano");cv.put("generos", "Divulgación popular");
        cv.put("sinopsis", " Este  es un libro dedicado a niños de todas las edades, en especial a aquellos que se sonrojan porque les sobran dedos cuando intentan contar hasta diez.");
        cv.put("isbn", "ISBN: 978-959-11-1141-3");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.elcultivodeloshelechos);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " El libro de las presentaciones      ");
        cv.put("autor1", "Eduardo Heras León ");
        cv.put("autor2", "");cv.put("generos", "Artículo ");
        cv.put("sinopsis", "Sinopsis: La hechizante oralidad de Eduardo Heras León se despliega en los textos que conforman este volumen ");
        cv.put("isbn", "ISBN: 978-959-11-1167-8 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.ellibrodelaspresentaciones);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " El mundo de Daniela    ");
        cv.put("autor1", " Teresa Melo");
        cv.put("autor2", "");cv.put("generos", "Poesía infantil ");
        cv.put("sinopsis", "Cada uno de nosotros lleva un mundo dentro. Daniela te invita al suyo de la mano de su mamá, quien, como suelen hacer las madres, la guía en el conocimiento de cada imagen, palabra o sensación. ");
        cv.put("isbn", "ISBN: 978-959-11-1144-9 ");
        cv.put("coleccion", "Ala y Espuela  ");
        cv.put("portada", R.mipmap.elmundodedaniela);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "El Rey de La Habana   ");
        cv.put("autor1", "Pedro Juan Gutiérrez  ");
        cv.put("autor2", "");cv.put("generos", "Novela  ");
        cv.put("sinopsis", " Corre el año 1998 y en una azotea de un edificio centrohabanero, un evento fortuito da un giro trágico a la vida ya miserable de una madre soltera y sus dos hijos adolescentes.");
        cv.put("isbn", "ISBN: 978-959-11-1116-6 ");
        cv.put("coleccion", "Ficciones  ");
        cv.put("portada", R.mipmap.elreydelahabana);
        cv.put("year", 2019);cv.put("precio", "$12.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Emilio Bacardí Moreau. De apasionado humanismo cubano (TI)");
        cv.put("autor1", "Olga Portuondo Zúñiga");
        cv.put("autor2", "");cv.put("generos", "Biografía");
        cv.put("sinopsis", "Resulta imprescindible en los inicios del tercer milenio la biografía de quien fuera patriota, intelectual, político e industrial.");
        cv.put("isbn", "ISBN: 978-959-11-1162-3 (TI) ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.emiliobacardimoreaudeapasionadohumanismocubano);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Emilio Bacardí Moreau. De apasionado humanismo cubano (TII)");
        cv.put("autor1", "Olga Portuondo Zúñiga");
        cv.put("autor2", "");cv.put("generos", "Biografía");
        cv.put("sinopsis", "Resulta imprescindible en los inicios del tercer milenio la biografía de quien fuera patriota, intelectual, político e industrial.");
        cv.put("isbn", "ISBN: 978-959-11-1163-0 (TII)");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.emiliobacardimoreaudeapasionadohumanismocubano);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Empacho: ¿síndrome o mito?   ");
        cv.put("autor1", " Agustín M. Mulet Pérez");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular ");
        cv.put("sinopsis", " Después de una exitosa primera edición de esta obra, el doctor Agustín Mulet entrega una segunda versión, ampliada y corregida, en la que describe el funcionamiento del estómago, nuestra “batidora natural”, y detalla la percepción popular y científica del empacho, desde un lenguaje sencillo y ameno.");
        cv.put("isbn", "ISBN: 978-959-11-1095-4  ");
        cv.put("coleccion", " Autoayuda");
        cv.put("portada", R.mipmap.empacho1);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Enfermedades de José Martí ");
        cv.put("autor1", "Ricardo Hodelín Tablada  ");
        cv.put("autor2", "");cv.put("generos", "Ensayo histórico   ");
        cv.put("sinopsis", "Este libro, sustentado en un profundo estudio dotado de rigor científico, es una obra indispensable realizada por su autor de forma pormenorizada y cronológica en medio de un intenso rastreo y pesquisas en los archivos de Cuba, España y México, donde residiera el Apóstol. ");
        cv.put("isbn", "ISBN: 978-959-11-1103-6 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.enfermedadesdejosemarti);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Frases célebres para crecer");
        cv.put("autor1", "Teresita Madlum Payás (compiladora) ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular   ");
        cv.put("sinopsis", "Esta selección de frases pretende poner en manos de los lectores un amplio compendio de la sabiduría de la humanidad. ");
        cv.put("isbn", "ISBN: 978-959-11-1146-3 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.frasescelebresparacrecer);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Grimorium");
        cv.put("autor1", "Antonio López Sánchez ");
        cv.put("autor2", "");cv.put("generos", "Novela   ");
        cv.put("sinopsis", "El lector que se adentre en este libro tiene que estar dispuesto a arriesgarlo todo, a vivirlo todo y especialmente a sumergirse en algo maldito, pues el Grimorium lo espera.");
        cv.put("isbn", "ISBN: 978-959-11-1142-5");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.grimorium1);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Historias de casi todo ");
        cv.put("autor1", " Alfonso Silva Lee ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular   ");
        cv.put("sinopsis", "Historias de casi todo viene siendo como El tesoro de la juventud de estos tiempos. Desea poner en manos de niños y adolescentes la estimulante y nunca satisfecha semilla del conocimiento. ");
        cv.put("isbn", "ISBN: 978-959-11-1111-1 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.historiasdecasitodo);      //////// aqui Historias de casi to do
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Hospital para gatos locos ");
        cv.put("autor1", "Mildre Hernández ");
        cv.put("autor2", "");cv.put("generos", "Novela juvenil   ");
        cv.put("sinopsis", ": El complejo de inferioridad por el color del pelaje, la incapacidad para caer de pie y el consumo compulsivo de ratones electrónicos son algunos de los trastornos siquiátricos de estos pacientes que se presentan ante el doctor Miaus en busca de una cura. ");
        cv.put("isbn", "ISBN: 978-959-11-1147-0 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.hospitalparagatoslocos);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);
        cv.put("titulo", "Independencia ");
        cv.put("autor1", "Oscar Lorenzo Calzado");
        cv.put("autor2", "Dayron Serpa Valcárcel");
        cv.put("generos", "Historieta   ");
        cv.put("sinopsis", "La guerra ha comenzado y dos heroínas deciden ayudar al ejército de su pueblo, pese al peligro, que en cada momento las rodea.  ");
        cv.put("isbn", "ISBN: 978-959-11-1149-4 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.independencia);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "La intranquilidad caracteriza la infancia ");
        cv.put("autor1", "María Antonieta Rodríguez Arce ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular ");
        cv.put("sinopsis", "La infancia es una etapa de crucial importancia en la vida de cada ser humano. Por tal motivo, las vivencias positivas o negativas de la niñez constituyen un eslabón decisivo durante el proceso de formación de la personalidad de cada individuo. En el presente libro, su autora revela cómo manejar uno de los comportamientos más comunes durante esta etapa de la vida: la intranquilidad.");
        cv.put("isbn", "ISBN: 978-959-11-1151-9");
        cv.put("coleccion", "Autoayuda");
        cv.put("portada", R.mipmap.laintranquilidadcaracterizaalainfancia);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " La magia del Caribe en la cocina cubana ");
        cv.put("autor1", "Acela V. Matamoros Traba  ");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular  ");
        cv.put("sinopsis", "La mejor manera de disfrutar el arte de cocinar es la innovación continua de platos. La magia del Caribe en la cocina cubana presenta una recopilación de recetas, testimonios y anécdotas, donde se nos obsequia esa apetitosa mezcla de lo autóctono y lo caribeño. ");
        cv.put("isbn", "ISBN: 978-959-11-1118-0 ");
        cv.put("coleccion", "En casa ");
        cv.put("portada", R.mipmap.lamagiadelcaribeenlacocinacubana);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " La retataranieta del vikingo      ");
        cv.put("autor1", "Rubén Rodríguez González ");
        cv.put("autor2", "");cv.put("generos", " Novela infantil ");
        cv.put("sinopsis", "Un extraño barco aparece en Garabulla, tripulado por Erik con sus cuarenta hijos. Nuevas aventuras pondrán a prueba al escritor Ernesto y su familia, cuando se revele un antiguo secreto. ");
        cv.put("isbn", "ISBN: 978-959-11-1150-0 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.retataranieta_del_vikingo); /// la retataranieta del vikingo
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Las campanas de Juana la Loca ");
        cv.put("autor1", "Marta Rojas ");
        cv.put("autor2", "");cv.put("generos", "Novela  ");
        cv.put("sinopsis", "Momentos delirantes del Nuevo Mundo, cuyo telón de fondo despliega la inteligente y transgresora reina Juana la Loca, conforman esta novela atribuida a Autor Anónimo, iniciada en los anales de la imprenta, por un antiguo paje alemán de la reina, en el Sacro Imperio Romano Germánico. ");
        cv.put("isbn", "ISBN: 978-959-11-1115-9 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.lascampanasdejuanalaloca);
        cv.put("year", 2019);cv.put("precio", "$20.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Movimiento obrero revolucionario  ");
        cv.put("autor1", "Steve Cushion  ");
        cv.put("autor2", "");cv.put("generos", "Ensayo histórico");
        cv.put("sinopsis", "Resultado de una extensa y profunda investigación, esta obra de Steve Cushion —admirador y amigo de la Revolución cubana— incursiona en un tema no tratado antes con la rigurosidad que nos muestran sus páginas, en las cuales se proyectan nuevas luces acerca de la contribución de los trabajadores cubanos al derrocamiento del sangriento régimen tiránico de Fulgencio Batista en la década de los cincuenta del pasado siglo.");
        cv.put("isbn", "ISBN: 978-959-11-1122-7");
        cv.put("coleccion", " Bronce ");
        cv.put("portada", R.mipmap.movimientoobrerorevolucionario);
        cv.put("year", 2019);cv.put("precio", "$12.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " No apto para Mayores  ");
        cv.put("autor1", "Yunier Riquenes Garcia");
        cv.put("autor2", "");
        cv.put("generos", "Cuento ");
        cv.put("sinopsis", "Los menores se revelan y forman un ejército contra los adultos en estas dieciséis historias relacionadas entre sí, que pueden ser leídas lo mismo como una noveleta que de forma independiente, pero todas contadas desde la perspectiva de un niño, conformando un libro deliciosamente narrado. ");
        cv.put("isbn", "ISBN: 978-959-11-1151-7 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.noaptoparamayores);
        cv.put("year", 2019);cv.put("precio", "$8.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " No es país para perros ");
        cv.put("autor1", " Miguel Terry Valdespino  ");
        cv.put("autor2", "");cv.put("generos", "Cuento ");
        cv.put("sinopsis", "Ni la Alemania nazi, ni el sexo o la pornografía, ni los vampiros, ni el escenario rural con sus personajes típicos, ni el béisbol, ni el racismo ni la poesía son, en estado puro, los temas de los cuentos que nos presenta el autor. Estos asuntos cosmopolitas son el pretexto para profundizar en los principales problemas de la sociedad y la cultura cubanas de los últimos cincuenta años, a través de una selección de la obra del narrador, conformada por textos escritos en las dos últimas décadas. ");
        cv.put("isbn", "ISBN: 978-959-11-1159-3 ");
        cv.put("coleccion", " Cuento ");
        cv.put("portada", R.mipmap.noespaisparaperros);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Papeles de un naufragio ");
        cv.put("autor1", "Lourdes María González Herrero    ");
        cv.put("autor2", "");cv.put("generos", "Poesía  ");
        cv.put("sinopsis", " Del difícil encuentro entre el poema y el cuento ha nacido este libro en el que cada texto es  el testimonio de una historia, íntima y a la vez plural, que no acaba de convertirse en pasado.");
        cv.put("isbn", "ISBN: 978-959-11-1120-3 ");
        cv.put("coleccion", " Mariposa");
        cv.put("portada", R.mipmap.papelesdeunnaufragio);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Páginas muy bien condimentadas. Crónica de Bohemia (1946-1959)");
        cv.put("autor1", "Rosa Hilda Zell (Adriana Loredo)   ");
        cv.put("autor2", "");cv.put("generos", "Crónica ");
        cv.put("sinopsis", "“El menú de la semana” no fue una simple sección de cocina limitada a dar recetas e ingredientes. Por mostrarnos el oficio periodístico, literario y cultural de esta mujer, mostramos estas Crónica que se encargan lo mismo de orientaciones nutricionales que de los usos de los nuevos equipos electrodomésticos. ");
        cv.put("isbn", "ISBN: 978-959-11-1119-7");
        cv.put("coleccion", " Mariposa");
        cv.put("portada", R.mipmap.paginasmuybiencondimentadas);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Proverbios y cuentos del lejano oriente   ");
        cv.put("autor1", "Jorge Braulio Rodríguez Quintana (compilador)");
        cv.put("autor2", "");cv.put("generos", "Crónica  ");
        cv.put("sinopsis", "Mostrar que se puede comprender el mundo desde la risa es el propósito de esta selección de ficciones y refranes de China, Japón y Corea.  ");
        cv.put("isbn", "ISBN: 978-959-11-1152-4 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.proverbiosycuentosdellejanooriente);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "  Reflexiones de una psicoterapeuta    ");
        cv.put("autor1", "Mariela Góngora Marrero");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular ");
        cv.put("sinopsis", "Imprescindibles valores humanos se dan cita en una obra que persigue hacer reflexionar al lector sobre cómo asumir una actitud diferente al enfrentar los conflictos que marcan la existencia humana. ");
        cv.put("isbn", "ISBN: 978-959-11-1127-2 ");
        cv.put("coleccion", " Autoayuda");
        cv.put("portada", R.mipmap.recomendacionesdeunasicoterapeuta); /// reflexionesde un psicoterap
        cv.put("year", 2019);cv.put("precio", "$8.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Relaciones Cuba- Estados Unidos. ¿Qué ha cambiado? ");
        cv.put("autor1", "Arnold August  ");
        cv.put("autor2", "");cv.put("generos", "Ensayo político ");
        cv.put("sinopsis", "Este libro, del politólogo canadiense Arnold August, es una obra de marcha y desafío, un llamado al riesgo de la opinión inmediata y de participación en los acontecimientos.  ");
        cv.put("isbn", "ISBN: 978-959-11-1112-8 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.relacionescubaestadosunidos);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Retrato de los tigres ");
        cv.put("autor1", "Sindo Pacheco ");
        cv.put("autor2", "");cv.put("generos", "Novela");
        cv.put("sinopsis", "Los tigres es un equipo de pelota formado por niños cubanos en un pueblo del centro de la isla. La novela cuenta la historia de lo que le toca vivir a esos muchachos en la medida en que crecen y se hacen adolescentes y jóvenes. ");
        cv.put("isbn", "ISBN: 978-959-11-1123-4");
        cv.put("coleccion", " Ficciones ");
        cv.put("portada", R.mipmap.retratodelostigres);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Rita Montaner. Testimonio de una época (TI) ");
        cv.put("autor1", " Ramón Fajardo Estrada ");
        cv.put("autor2", "");cv.put("generos", "Biografía ");
        cv.put("sinopsis", "De acuerdo con palabras de la premio Nacional de Literatura, Carilda Oliver Labra, es este un libro hechicero, porque al empezarlo a leer no nos podemos detener, tenemos que seguir y seguir, debido a los valores que posee esta obra.    ");
        cv.put("isbn", "ISBN: 978-959-11-1113-5 (TI) ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.ritamontaner);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", " Rita Montaner. Testimonio de una época (TII) ");
        cv.put("autor1", " Ramón Fajardo Estrada ");
        cv.put("autor2", "");cv.put("generos", "Biografía ");
        cv.put("sinopsis", "De acuerdo con palabras de la premio Nacional de Literatura, Carilda Oliver Labra, es este un libro hechicero, porque al empezarlo a leer no nos podemos detener, tenemos que seguir y seguir, debido a los valores que posee esta obra.    ");
        cv.put("isbn", "ISBN: 978-959-11-1114-2 (TII) ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.ritamontanertomo2);
        cv.put("year", 2019);cv.put("precio", "$15.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Un arte tradicional: bordar a mano  ");
        cv.put("autor1", " Zeila Robert");
        cv.put("autor2", "");cv.put("generos", "Divulgación popular  ");
        cv.put("sinopsis", " La antigua tradición de bordar a mano sigue atrayendo hoy a quienes se dedican a las confecciones textiles, y son un complemento constante tanto en prendas de vestir como en objetos decorativos o de uso diario en el hogar.     ");
        cv.put("isbn", "ISBN: 978-959-11-1106-7 ");
        cv.put("coleccion", " En Casa");
        cv.put("portada", R.mipmap.bordar_a_mano);
        cv.put("year", 2019);cv.put("precio", "$10.00");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "Une los puntos y verás ");
        cv.put("autor1", "Ariel Fonseca Rivero  ");
        cv.put("autor2", "");cv.put("generos", "Novela juvenil ");
        cv.put("sinopsis", "¿Cuál es la mejor manera de hacer amigos?: ¿ser buen estudiante?, ¿saber dibujar corazones?, ¿ser valiente?, ¿tener una gran imaginación? Al leer esta historia descubrirás que no existe un único camino y que tu mejor amigo puede estar donde menos lo esperas. ");
        cv.put("isbn", "ISBN: 978-959-11-1154-8 ");
        cv.put("coleccion", " - ");
        cv.put("portada", R.mipmap.unelospuntos);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);

        cv.put("titulo", "¡Y es bello vivir!  ");
        cv.put("autor1", "Margarita Ruiz Peraza  ");
        cv.put("autor2", "");cv.put("generos", "Novela testimonio ");
        cv.put("sinopsis", "Este es, a un tiempo, un libro de viajes, las memorias de una persona con esclerosis múltiple y el testimonio del pasado reciente y vivo de una nación.");
        cv.put("isbn", "ISBN: 978-959-11-21-0");
        cv.put("coleccion", "Mariposa");
        cv.put("portada", R.mipmap.yesbellovivir);
        cv.put("year", 2019);cv.put("precio", "");
        operatingdb.insert("LIBROS", null, cv);


    }

    private void InsertarAutores()
    {
        
        ContentValues cv = new ContentValues();

        cv.put("nombre", "Marelis Proenza Brown");
        cv.put("ciudad", "Guantánamo");
        cv.put("fecha", "1959");
        cv.put("biografia", "  "+
            "Ficha biográfica: Licenciada en Economía. Peluquera con más de veinte años de experiencia. Es una activa promotora de temas de belleza en la radio y en la televisión"+
        "Algunos de sus títulos: -El arte de la peluquería (Editorial Oriente, 2013)"+
        "-Recetas caseras de belleza (El Mar y la Montaña, 2016) ");
        cv.put("avatar", R.mipmap.marelis_proenza);
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "José Abreu Cardet ");
        cv.put("avatar", R.mipmap.josemiguelabreucardet );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1951");
        cv.put("biografia", " "+
           " Ficha biográfica: Graduado de Historia en el Instituto Pedagógico Superior de la Universidad de La Habana; miembro de la UNEAC, UNHIC, ADHILAC, la Academia de Historia de Cuba y miembro extranjero de la Academia de Historia de República Dominicana. Algunos de sus títulos: -Los resueltos a morir: relatos de la Guerra Grande (Cuba, 1868-1878)"+
            "-La Guerra Grande: Dos puntos de vista -Las fronteras de la guerra: Mujeres, soldados y regionalismo en el 68");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Marilú Uralde Cancio ");
         cv.put("ciudad", "La Habana"); cv.put("fecha", "1966"); cv.put("avatar", R.mipmap.img_avatar );

        cv.put("biografia", " Ficha biográfica: Licenciada en Historia. Máster en Ciencias Históricas. Miembro de la UNHIC, ADHILAC y la UNEAC Algunos de sus títulos: -Guardianes del orden -Voluntarios españoles en Cuba -Voluntarios de Cuba española") ;
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Luis de la Rosa Valdés ");
        cv.put("avatar", R.mipmap.img_avatar );
        cv.put("ciudad", "Contramaestre, Santiago de Cuba");
        cv.put("fecha", "1967");
        cv.put("biografia", " "+
            "Ficha biográfica: Licenciado en Ciencias Sociales. Mayor de las Fuerzas Armadas Revolucionarias. Graduado en la especialidad de Político Militar de Tropas Generales."+
        "Algunos de sus títulos: -Fidelidad (Casa Editorial Verde Olivo, 2011).");

            operatingdb.insert("AUTORES", null, cv);
            cv.put("nombre", "Oscar Larralde Otero ");
            
            cv.put("avatar", R.mipmap.oscarlarraldeotero );
        cv.put("ciudad", "Antilla, Holguín");
        cv.put("fecha", "1944");

        cv.put("biografia", " "+
            "Ficha biográfica: Licenciado en Derecho. Fundador de la Asociación de Jóvenes Rebeldes y de la UJC.  Oficial de la Contrainteligencia Militar."+
            "'Algunos de sus títulos: -Camilo en Antilla"+
        "-Crisis de Octubre: Península del Ramón");


        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Alberto Peraza Ceballos ");
        cv.put("avatar", R.mipmap.alberto_peraza_ceballos2 );
        cv.put("ciudad", "Río Seco, San Juan y Martínez");
        cv.put("fecha", "1961");

        cv.put("biografia", " "+

            "Ficha biográfica: Poeta y escritor para niños"+

        "Algunos de sus títulos: -Salvar el alba"+
        "-La media vuelta, la vuelta entera"+
        "-El cielo es mucho más grande");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Elda Cento Gómez ");
        cv.put("avatar", R.mipmap.elda_cento );
        cv.put("ciudad", "Camagüey");
        cv.put("fecha", "1952");

        cv.put("biografia", ""+

            "Ficha biográfica: Profesora e investigadora. Académica Correspondiente Nacional de la Academia de la Historia de Cuba. Por su obra ha recibido diversos premios"+

        "Algunos de sus títulos: -De la primera embestida. Correspondencia de Ignacio Agramonte (noviembre 1868 - enero 1871) (Editorial Ciencias Sociales, 2014)"+
        "-Nadie puede ser indiferente. Miradas a las guerras (1868-1898) (Editorial Oriente, 2013)"+
        "-Del látigo y el jornal. Apuntes sobre la esclavitud en el Camagüey (Ediciones Ácana, 2013, 2015)");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Luis Alberto Pérez Llody");
        cv.put("avatar", R.mipmap.luisalbertoprezllody );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1961");

        cv.put("biografia", " "+
            "Ficha biográfica: Licenciado en Derecho por la Universidad de Oriente (2005); Máster en Estudios Cubanos y del Caribe (2007); Doctor en Ciencias Jurídicas (Universidad de Oriente, 2014) y Doctor en Derecho (Universidad Panamericana de México, 2016). Es Profesor Titular de Historia del Estado y el Derecho y decano de la Facultad de Derecho de la Universidad de Oriente; Juez Profesional No Permanente del Tribunal Popular Provincial de Santiago de Cuba; miembro de la UNEAC, de la Unión Nacional de Juristas de Cuba (UNJC), de la Unión de Historiadores de Cuba (UNHIC) y de la Cátedra de Estudios Históricos del Estado y el Derecho Leonardo Griñán Peralta. Ha sido Investigador Meritorio en el Instituto de Investigaciones Jurídicas de la Universidad Nacional Autónoma de México (UNAM), Investigador Agregado del Instituto de Derecho Penal Europeo e Internacional,"+
            " e Investigador Invitado en la Universidad de Castilla-La Mancha, España."+
            "Algunos de sus títulos: ---");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Alicia Valdés Cantero  ");
        cv.put("avatar", R.mipmap.aliciavaldes );
        cv.put("ciudad", "-");
        cv.put("fecha", "-");

        cv.put("biografia", "Musicóloga, historiadora del arte y profesora universitaria. Fundadora y coordinadora general del Festival Internacional Danzón Habana y del Festival Internacional Boleros de Oro. Coordinó el Simposio Cubadisco desde su creación hasta 2013."+

            "Algunos de sus títulos: -El músico en Cuba (1986)"+
            "-Nosotros y el Bolero (2000)"+
            "-Dicccionario de mujeres notables en la música cubana (2011)");


        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Eduardo Manet"); cv.put("avatar", R.mipmap.manet );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1930");

        cv.put("biografia", "Dramaturgo, cineasta y novelista franco'\n' - cubano. En 1948, ganó el premio Prometeo por Scherzo, primera obra de teatro emitida en la televisión cubana.\n" +
                "'\n''\n'Algunos de sus títulos: '\n' - Les étrangers dans la ville, 1960, editorial Julliard\n" +
                "'\n' - Un cri sur le rivage, 1963, editorial Julliard '\n'" +
                "'\n' - La Mauresque, 1982, editorial Gallimard");
        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Carlos Espinoza"); cv.put("avatar", R.mipmap.carlos_espinosa);
        cv.put("ciudad", "Granma");
        cv.put("fecha", "1950");

        cv.put("biografia", "Es graduado del ISA en la especialidad de Teatrología y Dramaturgia, y realizó un doctorado en\n" +
                "Español en la Universidad Internacional de la Florida (FIU por sus siglas en inglés). Tiene publicados numerosos libros en Cuba y en el extranjero. Actualmente reside en España.\n" +
                "\n" +
                "\"\\n\"\"\\n\"Algunos de sus títulos: \"\\n\" ");
        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Giséle Pineau "); cv.put("avatar", R.mipmap.giselepineau );
        cv.put("ciudad", "París, Francia");
        cv.put("fecha", "1956");

        cv.put("biografia", " "+

            "Ficha biográfica: Sus padres son originarios de Guadalupe y trabajó allí como enfermera psiquiátrica durante veinte años. Actualmente reside en Marie-Galante, isla del archipiélago guadalupano. Reconocida como una de las creadoras caribeñas más representativas de la región, fue la primera mujer en obtener el Premio Carbet del Caribe."+

        "Algunos de sus títulos: - Una antigua maldición (Ediciones del Bronce, 1999)"+
        "- Chair piment"+
            "- L'Espérance–Macadam");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Luis Carlos Suárez  ");
        cv.put("avatar", R.mipmap.luiscarlosuarez );
        cv.put("ciudad", "Manzanillo");
        cv.put("fecha", "1955");

        cv.put("biografia", " "+

            "Ficha biográfica: Narrador y poeta. Ha publicado poesía y cuento para adultos. Es miembro de la UNEAC, mereció la Distinción por la Cultura Nacional y el Diploma Nicolás Guillén entre otras condecoraciones."+

        "Algunos de sus títulos: -Claro de luna"+
        "-Las mentiras del rey Arturo"+
        "-El capitán de las arenas");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Eduard Encina   "); cv.put("avatar", R.mipmap.eduardencina );
        cv.put("ciudad", "Baire");
        cv.put("fecha", "1973");

        cv.put("biografia", " "+

            "Ficha biográfica: Poeta, narrador y pintor. Miembro de la AHS, de la UNEAC y del Grupo Literario Café Bonaparte. Ganador del Premio Calendario de literatura para niños, 2002 y poesía, 2004."+

        "Algunos de sus títulos: -Dé ángel y perverso"+
            "-El perdón del agua"+
            "-Lectura de Patmos");


        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Aida Bahr   "); cv.put("avatar", R.mipmap.aidabahr );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1958");

        cv.put("biografia", " "+

            "Ficha biográfica: Narradora, crítica y traductora. Ha trabajado intensamente con talleres literarios, como investigadora y dirigió por más de diez años la Editorial Oriente. Su obra publicada, abarca cuatro libros de cuentos dos ensayos y dos novelas."+
            "Algunos de sus títulos: -Ofelias (Letras cubanas, 2007)");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Omar Felipe Mauri Sierra");
        cv.put("avatar", R.mipmap.omarfelipemauri );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1959");

        cv.put("biografia", " "+

            "Ficha biográfica: Licenciado en Educación en 1982. Tiene numerosos libros publicados. Ha obtenido el premio nacional de literatura infantil La Edad de Oro."+

        "Algunos de sus títulos: - Un patio así"+
        "-Amigos del patio"+
        "-Lunar");
// TODO REVISAR DICK MANRESA
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Dick Manresa Arencibia   ");
        cv.put("avatar", R.mipmap.img_avatar );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1959");

        cv.put("biografia", " "  );

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Alejandro Rama");
        cv.put("avatar", R.mipmap.alejandrorama );
        cv.put("ciudad", "Manatí");
        cv.put("fecha", "1991");
        cv.put("biografia", " "+

            "Ficha biográfica: Narrador y poeta. Egresado del Centro de Formación Literaria “Onelio Jorge Cardoso”. Ha obtenido los premios: Portus Patris de Narrativa, 2016; Segundo Premio en el XVII Concurso Nacional de Poesía Regino Pedroso; Tercer Premio en el Concurso Anual de Poesía “Soy el amor soy el verso”."+

        "Algunos de sus títulos: ---");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Ángel Píriz Momblant");
        cv.put("avatar", R.mipmap.angel_piriz_momblant );
        cv.put("ciudad", "Guantánamo");
        cv.put("fecha", "1939");
        cv.put("biografia", " "+

            "Ficha biográfica: Es especialista de Segundo Grado en Cirugía General, máster en Urgencias Médicas, Profesor Auxiliar y Consultante, e Investigador Auxiliar. Es jefe de la Sección de Cirugía de Hígado, Vías Biliares, Páncreas y Bazo. Miembro de los Consejos Científicos de su provincia y del Hospital General Docente Doctor Agostinho Neto, tiene numerosas publicaciones y trabajos premiados en eventos científicos."+

        "Algunos de sus títulos: - Páncreas. Técnicas quirúrgicas."+
            "-Alcoholismo y pancreatitis (Editorial Oriente)");


        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Mario Luis López Isla  ");
        cv.put("avatar", R.mipmap.marioluis );
        cv.put("ciudad", "Cabaiguán");
        cv.put("fecha", "1955");
        cv.put("biografia", " "+

            "Ficha biográfica: Investigador, historiador y narrador. Graduado de Historia en el Instituto Superior"+
        "Pedagógico Enrique José Varona. Presidente de la filial municipal de la UNEAC en Cabaiguán."+

        "Algunos de sus títulos: ---");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Ester Lidia Vázquez Seara   ");
        cv.put("avatar", R.mipmap.ester_lidia_vzquez_eara );
        cv.put("ciudad", "Zaza del Medio");
        cv.put("fecha", "1959");
        cv.put("biografia", " "+

                "Investigadora, graduada de Licenciatura en Inglés en el Instituto Superior Pedagógico Silverio Blanco de Cabaiguán, ciudad donde reside. Especialista en Bibliotecología e Investigaciones de la biblioteca pública Beremundo Paz.\n" +
                '\n' +
                "'\n''\n''\n'Algunos de sus títulos: '\n' -");

        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Silvia Mayra Gómez Fariñas     ");
        cv.put("avatar", R.mipmap.silviamayragomez );
        cv.put("ciudad", "Cabaiguán");
        cv.put("fecha", "1953");
        cv.put("biografia", " "+

            "Ficha biográfica: Ingeniera agrónoma e investigadora. Tiene publicaciones en las revistas Cubano, Sol y Son; Bohemia; Excelencias; Cuba Plus; Correo de Cuba y La Nueva Réplica, entre otras."+

            "Algunos de sus títulos: -Los pollos de mi cazuela (2008)"+
            "-Las comidas de Lezama Lima (2010)"+
            "-Dulces caseros (2011)");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Iliana Núñez Rodríguez   ");
        cv.put("avatar", R.mipmap.ilianaezodrguez );
        cv.put("ciudad", "Matanzas");
        cv.put("fecha", "1964");
        cv.put("biografia", ""+

            "Ficha biográfica: Máster en Comunicación Social."+

        "Algunos de sus títulos: -Sarabanda no perdona (Editora Política, 2014)"+
        "-La princesa cimarrona (Editorial Oriente, 2015)");



        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Alberto Rodríguez Tosca ");
        cv.put("avatar", R.mipmap.albertorodtosca );
        cv.put("ciudad", "Artemisa");
        cv.put("fecha", "1962 - La Habana, 2015");
        cv.put("biografia", ", "+

            "Ficha biográfica: Poeta. En 1987 obtuvo el Premio David de Poesía y mereció el Premio de la Crítica en 1992 y en 2006. Residía en Colombia desde 1994."+

        "Algunos de sus títulos: -Todas las jaurías del rey (1987)"+
            "-Otros poemas (1992)"+
            "-Las derrotas (2006)");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Juan J. Guarch Rodríguez  ");
        cv.put("avatar", R.mipmap.juanguarch );
        cv.put("ciudad", "Camagüey");
        cv.put("fecha", "1954");
        cv.put("biografia", " "+

            "Ficha biográfica: Arqueólogo, espeleólogo, guionista y escritor. Es vicepresidente de la sociedad espeleológica de Cuba."+

        "Algunos de sus títulos: -La cerámica Baní (1993)"+
            "-Arte rupestre. Los petroglifos cubanos (1994)"+
            "-Los dinosaurios (2002)");


        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Felipe Oliva");
        cv.put("avatar", R.mipmap.felipeoliva );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "Es narrador, dramaturgo, poeta y músico, y ha escrito muchos otros libros para niños y jóvenes Algunos de sus títulos: -Algo para Olga"+
        "-El león vegetariano"+
        "-Sarabanda no perdona");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Aminta Buenaño Rugel");
        cv.put("avatar", R.mipmap.aminta_buenano );
        cv.put("ciudad", "Santa Lucía, Guayas, Ecuador");
        cv.put("fecha", "");
        cv.put("biografia", ""+

            "Ficha biográfica: Es profesora universitaria, comunicadora social, magister en género y diplomática. Actualmente es embajadora del Ecuador en Nicaragua. Fue asambleísta nacional y participó en la redacción de la Constitución del Ecuador de 2008."+

        "Algunos de sus títulos: -La mansión de los sueños"+
        "-La otra piel"+
        "-Mujeres divinas");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "José Ricardo Morasén Cuevas ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1958");
        cv.put("biografia", " "+

            "Ficha biográfica: Doctor en Medicina por la Universidad de Ciencias Médicas de Santiago de Cuba."+
            "Especialista de Segundo Grado en Reumatología, máster en Ciencias Médicas, profesor asistente de la Universidad Médica de Santiago de Cuba. Investigador agregado y miembro fundador de la Sociedad Cubana de Reumatología."+

            "Algunos de sus títulos: -Un médico entre lagos y volcanes");


        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Jorge Labañino Legrá ");
        cv.put("avatar", R.mipmap.jorgelabainolegr );
        cv.put("ciudad", "Baracoa");
        cv.put("fecha", "1970");
        cv.put("biografia", " "+

            "Ficha biográfica:  Actualmente radica en Baire, Contramaestre. Es miembro de la Asociación"+
        "Hermanos Saíz y del Grupo Literario Café Bonaparte. Ha obtenido diversos premios de poesía, entre ellos, premio nacional de poesía Medalla del Soneto Clásico, San Luis, Santiago de Cuba, 2003; premio de la UNEAC en el  concurso de poesía XIII Concurso Literario Viña Joven."+

        "Algunos de sus títulos: -Oración del que traicionan (Ediciones Santiago, 2004)"+
            "-Rumor de higuera (Ediciones Santiago, 2000)");


        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Blas Nabel Pérez Camejo");
        cv.put("avatar", R.mipmap.blasnabelperezcamejo );
        cv.put("ciudad", "Vertientes, Camagüey");
        cv.put("fecha", "1944");
        cv.put("biografia", "  Filólogo, investigador y diplomático. Es graduado de la Facultad de Lenguas Extranjeras de la Universidad de La Habana. Cursó estudios de Derecho Internacional Público de la Universidad de Alicante y en el Instituto Superior de Relaciones Internacionales de Cuba."+

       " '\n''\n'Algunos de sus títulos: '\n''\n' -  Las culturas que encontró colón (Editorial Abya'\n' -  Yala, 1992)"+
       " '\n' - Armenios en el Nuevo Mundo (Editorial Abya'\n' -  Yala, 1998)"+
       " '\n' - Bibliografía del pintor ruso Vasily Vereschaguin en Cuba 1889'\n' - 1992");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Emerio Medina ");
        cv.put("avatar", R.mipmap.emeriomedina );
        cv.put("ciudad", "Mayarí, Holguín");
        cv.put("fecha", "1966");
        cv.put("biografia", " "+
     "Con sus obras ha alcanzado varios de los principales premios literarios que se otorgan en Cuba. Deben destacarse el Premio Iberoamericano de Cuento Julio Cortázar, el Luis Felipe Rodríguez de la UNEAC y el Alejo Carpentier de cuento."+
        " '\n''\n'Algunos de sus títulos:       '\n' - Suné y Rudel, los güijes guardianes (Editorial Oriente, 2011)"+
       " '\n'   - Capul y Aruní visitan el mar (Editorial Oriente, 2015) ");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Eraclio Delgado Rifá  ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "Baracoa, Guantánamo");
        cv.put("fecha", "1962");
        cv.put("biografia", "   "+
   "Graduado de médico en el ISCM de Santiago de Cuba en 1986. Actualmente es especialista de primer y segundo grados en Ortopedia y Traumatología, y profesor asistente en el Hospital General Docente Dr. Ernesto Guevara de la Serna, de Las Tunas. Máster en Medicina Natural y Tradicional e investigador auxiliar.");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "José Ignacio Fleites Adán");
        cv.put("avatar", R.mipmap.joseignaciofleitesadan );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1953");
        cv.put("biografia", "    Es licenciado en Periodismo. Fue redactor y editor de la revista Forestal Baracoa, y redactor de Cuba ForeingTrade. Guionista del programa Ventana al futuro y otros espacios históricos de la División de Programación Variada de la Televisión Cubana, así como guionista y director del programa televisivo De sol a sol."+

       " '\n''\n'Algunos de sus títulos: '\n' -  221 formas de preparar el arroz (Editorial Oriente, 2011)"+
        "'\n' - Maíz… el grano del sol (Editorial Oriente, 2015) ");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "Eugenio de Coloma y Garcés "); cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "España siglo XIX Se radicó en Cuba durante el siglo XIX, y  se interesó por las cuestiones culinarias, además de moverse en diferentes temáticas, en especial las dedicadas a la mujer, la economía doméstica y la agricultura. Adaptó recetas turcas, españolas e inglesas a la manera de la cocina cubana y se ocupó especialmente por aquella comida que debían consumir los enfermos. Además captó las diferencias regionales en la alimentación cubana."+

            "'\n''\n'Algunos de sus títulos: '\n' -  Manual de práctica pedánea (1874)"+
        "'\n' - Manual de jardinería (1857)"+
        "'\n' - Catecismo de la agricultura cubana (1863) ");

        operatingdb.insert("AUTORES", null, cv);cv.put("nombre", "María Eulalia Douglas "); cv.put("avatar", R.mipmap.mariaeulaliadouglas );
        cv.put("ciudad", "Villa Clara");
        cv.put("fecha", "1928");
        cv.put("biografia", "Investigadora e historiadora del cine cubano. Se incorpora a trabajar en el ICAIC en 1962, y en 1965 pasa a la Cinemateca de Cuba, donde desarrolla una intensa labor de investigación y rescate de la memoria fílmica cubana. Textos suyos han aparecido en antologías y selecciones de trabajos sobre nuestra cinematografía."+

            "'\n''\n'Algunos de sus títulos: '\n' '\n' - El cine cubano en la prensa nacional y extranjera (1977),"+
            "'\n' - Guía temática de la producción del ICAIC  (1983)"+
        "'\n' - La tienda negra (El cine en Cuba 1897'\n' - 1990) (1997) ");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Nersis Felipe  ");
        cv.put("avatar", R.mipmap.nersysfelipe );
        cv.put("ciudad", "Pinar del Río");
        cv.put("fecha", "1935");
        cv.put("biografia", " Es una profesora, poetisa y narradora, que con sus libros ha embellecido la niñez de varias generaciones de cubanos. Sus obras resultan imprescindibles dentro del panorama literario de nuestro país."+

            "'\n'Algunos de sus títulos: '\n' -  Me gusta mandar recados (Editorial Oriente, 2014) "+
        "'\n' - Bajo un sol rosado (Editorial Oriente, 2016) ");

        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Yunier Riquenes Garcia");
        cv.put("avatar", R.mipmap.yunier_riquenes_garcia );
        cv.put("ciudad", "Jiguaní,Granma");
        cv.put("fecha", "1982");
        cv.put("biografia", "  Ha escrito varios libros para niños y adultos. Obtuvo en 2015 el Premio Regino E. Boti. Es director de Claustrofobias promociones literarias."+
            "'\n''\n'Algunos de sus títulos: '\n''\n' -  Los cuernos de la luna"+
        "'\n' - No apto para mayores"+
        "'\n' - Las formas del amor"+
        "'\n'  -Tienda de mascotas (Editorial Oriente, 2018)");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Carlos Esquivel");
        cv.put("avatar", R.mipmap.carlos_alberto_esquivel_guerra );
        cv.put("ciudad", "Elia");
        cv.put("fecha", "1968");
        cv.put("biografia", "Poeta, narrador y ensayista. Entre sus premios se encuentran los internacionales Iberoamericano de la Décima (2005 y 2010), Jara Carrillo (España, 2006), El Zorzal (Argentina, 2012) y Ciudad de Oviedo (España, 2012), además, los nacionales Emilio Ballagas (1995), Cuentos de amor (1998), Regino Botti (2000), Oriente (2000 y 2012), Manuel Cofiño (2001), La Gaceta de Cuba (2001), Hermanos Loynaz (2003) y José María Heredia (2004 y 2014). Su novela “La tumba del erizo” fue finalista en el año 2014 del premio Herralde, que convoca la Editorial Anagrama.\n" +
                " Algunos de sus títulos: -Perros ladrándole a Dios (poesía, premio a la Mejor Opera Prima del año en Cuba)\n" +
                "  -Tren de Oriente (poesía, México, 2001)\n" +
                "  -Los animales del cuerpo (cuento, 2001)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Anselma Betancourt Pulsán  ");
        cv.put("avatar", R.mipmap.anselma_betancourt_pulsan );
        cv.put("ciudad", "Las Tunas");
        cv.put("fecha", "1967");
        cv.put("biografia", "Ficha biográfica: Graduado de médico en el Instituto Superior de Ciencias Médicas de Camagüey en 1992. Especialista de segundo grado en Medicina Interna. Máster en Urgencias Médicas.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                " - ¿Consumiendo el futuro? (Centro Nacional de Derecho de Autor, 2004)\n" +
                " -Porque creo en Alcohólicos Anónimos (Editorial A&A, 2005)\n" +
                " -Drogas y... (Editorial El Mar y la Montaña, 2008)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Dr. Walfrido A. Curbelo Videra ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "Guantánamo");
        cv.put("fecha", "1959 ");
        cv.put("biografia", "Doctora en Medicina. Doctora en Ciencias de la Salud. Especialista de II Grado en Fisiología y Profesora Titular de Fisiología.\n" +
                "Algunos de sus títulos:\n" +
                " -  Hipertensión arterial, la asesina silenciosa (Editorial Oriente)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Zenovio Hernández Pavón");
        cv.put("avatar", R.mipmap.zenoviohernandezpavon );
        cv.put("ciudad", "Báguanos, Holguín");
        cv.put("fecha", "1959");
        cv.put("biografia", "Licenciado en Medios de Comunicación por el ISA y Máster en Desarrollo Cultural Comunitario por la Universidad de Las Tunas. Investigador, promotor cultural y realizador radial. Ha ejercido la docencia en diversos niveles de enseñanza, y desde el año 2005 se desempeña como investigador en la Empresa Comercializadora de la Música Faustino Oramas en la Ciudad Cubana de los Parques. Por su labor en la cultura, se ha hecho acreedor de numerosos premios y reconocimientos: Félix B. Caignet, Regino Botti, Premio Memoria Viva de Romerías de Mayo, Premio Memoria del Centro Pablo de la Torriente Brau, Premio de la Ciudad de Holguín, las distinciones Beby Urbino y la Hijo Ilustre, y el Premio Corazón de Oro del Festival Arañando la Nostalgia, entre otros\n" +
                "Algunos de sus títulos: -La música en Holguín (Ediciones Holguín)\n" +
                "  -El Guayabero, rey del doble sentido (Editorial Oriente)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Frei Betto");
        cv.put("avatar", R.mipmap.frei_betto );
        cv.put("ciudad", "Belo Horizonte, Brasil");
        cv.put("fecha", "1944");
        cv.put("biografia", "Estudió periodismo, antropología, filosofía y teología. Es investigador, ensayista, periodista y poeta. Su obra consta de más de cincuenta títulos. \n" +
                "Algunos de sus títulos: -El acuario negro (1986)\n" +
                "  -Fidel y la religión (1985)\n" +
                "  -La obra del artista (1998)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Sara Vega Miche");
        cv.put("avatar", R.mipmap.sara_vega_miche );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1956");
        cv.put("biografia", "Especialista de la Cinemateca de Cuba. Ha impartido conferencias sobre el cartel cubano y curado exposiciones en Biarritz (1999), Estambul (2004), Nueva York (2001), y regularmente en galerías de La Habana. Integra el proyecto alternativo CartelON.\n" +
                "\n" +
                "Algunos de sus títulos en coautoría: -Coordenadas del cine cubano I y II (Editorial Oriente, 2001 y 2005, respectivamente)\n" +
                "               -El cartel de cine cubano. The Cuban Film Poster (2004)\n" +
                "               -Imágenes de cine: Eduardo Muñoz Bachs (2007)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Mario Naito López ");
        cv.put("avatar", R.mipmap.mario_naito );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1948");
        cv.put("biografia", "Crítico e investigador cinematográfico. Especialista de la Cinemateca de Cuba. Es colaborador desde 1991 del programa semanal Cine Paraíso de la emisora CMBF.\n" +
                "\n" +
                "Algunos de sus títulos como compilador: -Coordenadas del cine cubano 2  (Editorial Oriente, 2005) \n" +
                "                              -Coordenadas del cine cubano 3   (Editorial Oriente, 2014)\n" +
                "                              -A cuarenta años... (Cinemateca de Cuba-Ediciones ICAIC)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Rosa Marquetti Torres  ");
        cv.put("avatar", R.mipmap.rosa_marquetti );
        cv.put("ciudad", "-");
        cv.put("fecha", "-");
        cv.put("biografia", "Es licenciada en Filología por la Universidad de La Habana. Investigadora musical por vocación, creó y lleva desde 2014 su blog Desmemoriados. Historia de la música cubana. Una selección de textos del sitio fue publicada en 2016 por La Iguana Ciega de Barranquilla, Colombia.\n" +
                "Algunos de sus títulos: -\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Rafael Borroto Galbes ");
        cv.put("avatar", R.mipmap.rafael_borroto );
        cv.put("ciudad", "Morón ");
        cv.put("fecha", "1947");
        cv.put("biografia", "Diseñador gráfico, ilustrador, cancatunsta y narrador. Graduado en la Academia lnteramericana de Dibujo Comercial, Artístico y Publicitario. Licenciado en Español y Literatura.\n" +
                " Algunos de sus títulos: -\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "José Walter Mondelo García ");
        cv.put("avatar", R.mipmap.jose_walter_mondelo );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1970");
        cv.put("biografia", "Licenciado en Derecho (1993) y Doctor en Ciencias Jurídicas (2003), ambos por la Universidad de Oriente. Trabaja como profesor e investigador en la Facultad de Derecho de la propia Universidad. Ha publicado artículos sobre temas de su campo de investigación en revistas de Cuba y otros países, así como dictado conferencias en universidades cubanas y extranjeras.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                " - \n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Román Emilio Pérez (Chicho)");
        cv.put("avatar", R.mipmap.chicho );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1954");
        cv.put("biografia", "Diseñador, caricaturista, pintor y realizador santiaguero graduado en la Academia de Artes Plásticas \"José Joaquín Tejada Revilla\". En su trayectoria, acumula más de 25 exposiciones personales, participación en unas 30 colectivas y presencia en alrededor de 20 salones internacionales. Es realizador de cartones animados; tiene participaciones en salones provinciales y nacionales de humor gráfico y diseño, con premios en esos ámbitos y una mención internacional. \n" +
                "Algunos de sus títulos:\n" +
                " - \n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Mayra Rosa Álvarez Martínez ");
        cv.put("avatar", R.mipmap.mayrarosaalvarezmartinez );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "-");
        cv.put("biografia", "Licenciada en Periodismo por la Universidad de La Habana. Durante quince años trabajó en la revista Revolución y Cultura, del Ministerio de Cultura, atendiendo la esfera de la música, labor que le permitió profundizar en esta manifestación artística. Desde 1991 se estableció en México DF, y durante años trabajó como editora, correctora de estilo, redactora, fotógrafa o reportera de diversas revistas, así como asesora en varias publicaciones y agencias de prensa.\n" +
                "\n" +
                "Algunos de sus títulos: -Cubanos en la música (Letras Cubanas, 1993 y Unión, 2016) \n" +
                "  - Cuba en voz y canto de mujer (EE.UU., 2015).\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Mohamed Magani");
        cv.put("avatar", R.mipmap.mohamed_magani );
        cv.put("ciudad", "El Attaf, Argelia");
        cv.put("fecha", "1948");
        cv.put("biografia", ": Es considerado una de las voces más prominentes del Magreb. En 1983, ganó el Grand Prix Littéraire de la Ville d'Alger. Ha sido traducido al inglés, al alemán, al italiano, al serbio-croata y ahora al español.\n" +
                "\n" +
                "Algunos de sus títulos: - Le refuge des ruines\n" +
                "                                     -Une guerre se meurtc\n" +
                "                                     -Scène de pêche en Algérie\n\n" +
                "\n" );
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Colectivo de autores del Centro de Lingüística Aplicada  ");
        cv.put("avatar", R.mipmap.centrodelinguisticaaplicada );
        cv.put("ciudad", "-");
        cv.put("fecha", "1971");
        cv.put("biografia", "Es un centro de investigación y generador de proyectos el que ha obtenido resultados científicos de alto impacto lingüístico-pedagógico en todo el país, principalmente en el Sistema Nacional de Educación. Fue reconocido como unos de los centros auspiciadores de la Academia de Ciencias de Cuba, en Santiago de Cuba. Fue fundado el 1 de enero de 1971 por el Dr. Julio Vitelio Ruiz Hernández.");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Reinaldo Álvarez Lemus"); cv.put("avatar", R.mipmap.reinaldo_alvarez_lemus );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "Poeta, actor y narrador multipremiado. \n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                " - El sombrero de mi abuelo (2005)\n" +
                " -Michiringolo (2010)\n" +
                "-Adivinaja (2012)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Eduardo Heras León ");
        cv.put("avatar", R.mipmap.eduardo_heras_leon );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1940");
        cv.put("biografia", "Narrador, periodista, crítico literario y de danza. En 2001 recibió el Premio Nacional de Edición; en 2007 el galardón Maestro de Juventudes de la Asociación Hermanos Saíz, y la Distinción Félix Elmuza de la Upec, y en 2014 el Premio Nacional de Literatura. Es fundador y director del Centro de Formación Literaria Onelio Jorge Cardoso.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "  - La guerra tuvo seis nombres (1970)\n" +
                " -Los pasos en la hierba\n" +
                " -Cuestión de principio (1985)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Teresa Melo");
        cv.put("avatar", R.mipmap.teresa_melo );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "-");
        cv.put("biografia", "Poetisa y promotora cultural, ganadora entre otros premios del integral La Rosa Blanca. \n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "  -La sombra protectora\n" +
                "  -Soy el amor, soy el verso (compiladora)\n" +
                " \n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Pedro Juan Gutiérrez  ");
        cv.put("avatar", R.mipmap.pedro_juan_gutierrez );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1950");
        cv.put("biografia", ": Licenciado en Periodismo por la Universidad de La Habana. Tiene una extensa obra literaria conocida en el panorama internacional desde finales de los años noventa del pasado siglo. \n" +
                "\n" +
                "Algunos de sus títulos: -Anclado en tierra de nadie (1998)\n" +
                "  -Nada que hacer (1998)\n" +
                "  -Sabor a mí  (1998)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Olga Portuondo Zúñiga");
        cv.put("avatar", R.mipmap.olga_portuondo );
        cv.put("ciudad", "Camagüey");
        cv.put("fecha", "1944");
        cv.put("biografia", "Doctora en Ciencias Históricas, Historiadora de la Ciudad de Santiago de Cuba y Miembro de Número de la Academia de la Historia de Cuba. Premio Nacional de Historia (2005), Premio Nacional de Investigación (2006) y Premio Nacional de Ciencias Sociales y Humanísticas (2010).\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "- Una derrota británica en Cuba \n" +
                "- José Antonio Saco, eternamente polémico (Editorial Oriente, 2004)\n" +
                "- Cuba. Constitución y liberalismo (Editorial Oriente, 2008)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", " Agustín M. Mulet Pérez");
        cv.put("avatar", R.mipmap.agustin_mulet );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1955");
        cv.put("biografia", "Médico, escritor, Doctor en Ciencias Médicas y Profesor Titular de Propedéutica Clínica y Medicina Interna de la Universidad de Ciencias Médicas de Holguín. Especialista de II Grado en Gastroenterología y de Medicina Interna del Hospital Universitario V. I. Lenin. Máster en Medicina Natural y Tradicional y en Enfermedades infecciosas.\n" +
                "\n" +
                "Algunos de sus títulos: -Secretos de Juan Candela (Ediciones Holguín, 1993), \n" +
                "  -Digitopuntura (Ediciones Holguín, 1994)\n" +
                "  -Cartas del I Ching, (Ediciones Holguín, 1995, Premio de la Ciudad en cuento)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Ricardo Hodelín Tablada  ");
        cv.put("avatar", R.mipmap.ricardo_hodelin_tabalda );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1964");
        cv.put("biografia", "Doctor en Ciencias Médicas. Máster en Bioética. Profesor Titular.\n" +
                "Algunos de sus títulos: \n" +
                " -Máximo Zertucha, médico de Antonio Maceo, Editorial Verde Olivo\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Teresita Madlum Payás (compiladora) ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1941");
        cv.put("biografia", "Licenciada en Educación. Se ha desempeñado como maestra, museóloga e investigadora.\n" +
                " \n" +
                "Algunos de sus títulos:\n" +
                "- Parque Abel Santamaría (Editorial Oriente)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Antonio López Sánchez ");
        cv.put("avatar", R.mipmap.antonio_lopez_sanchez );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1973");
        cv.put("biografia", "Licenciado en comunicación social por la Universidad de La Habana. Periodista, poeta y narrador. Es graduado del Centro de Formación Literaria Onelio Jorge Cardoso en el año 2007. \n" +
                " \n" +
                "Algunos de sus títulos:\n" +
                "-El otro lado del espejo (Gente Nueva, 2017)\n" +
                "-El escudo de Valnúss (Editorial de la Mujer, 2015)\n" +
                "-Las guerreras de la luz (Editorial de la Mujer, 2011)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Alfonso Silva Lee ");
        cv.put("avatar", R.mipmap.alfonso_silva_lee );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1945");
        cv.put("biografia", "Es biólogo, y ha participado en numerosas expediciones por tierra y mar, de donde han surgido los temas de sus libros.\n" +
                " \n" +
                " Algunos de sus títulos:\n" +
                "-El acuario marino\n" +
                "-Cuba natural,\n" +
                "                                  -Mi mar y yo\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Mildre Hernández ");
        cv.put("avatar", R.mipmap.mildre_hernandez );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "-");
        cv.put("biografia", "Recibió el Premio Casa de las Américas y Premio de la Crítica Literaria 2015. Ha recibido, entro otros, los premios: Eliseo Diego, Pinos Nuevos, Fayad Jamís, Abril (en tres ocasiones), Sed de belleza, La Rosa Blanca, Regino Boti, Hermanos Loynaz, La Edad de Oro, La puerta de papel, y Jara Carrillo y Sin Fronteras (Bilbao), ambos en España. Gran parte de su obra ha sido publicada en Colombia, España y Canadá.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "-El niño congelado (2015)\n" +
                "-Es raro ser niña\n" +
                "                                 -Una niña estadísticamente feliz\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Oscar Lorenzo Calzado");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "-");
        cv.put("fecha", "-");
        cv.put("biografia", "-");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Dayron Serpa Valcárcel");
        cv.put("avatar", R.mipmap.dayron_serpa );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1981");
        cv.put("biografia", "");

        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "María Antonieta Rodríguez Arce ");
        cv.put("avatar", R.mipmap.mariaantonietarodriguezarce );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1950");
        cv.put("biografia", "Psicóloga cubana y profesora de la Universidad de Ciencias Médicas de Holguín. En el contexto internacional también prestigia su quehacer científico e investigativo con publicaciones en formato digital e impreso. Ha publicado varios títulos en la Editorial Oriente.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "                                  -Padres, niños y conductas (2007)\n" +
                "                                 -¿Qué hacer con mi vida? (2010)\n" +
                "                                 -El niño asmático y su familia ante el asma bronquial (2012)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Acela V. Matamoros Traba  ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "");
        cv.put("fecha", "1956");
        cv.put("biografia", "Ingeniera tecnóloga en Alimentación Social. Chef de cocina y profesora de cocina profesional. Tiene diferentes publicaciones como autora y coautora. \n" +
                "\n" +
                "Algunos de sus títulos:   \n" +
                "-La cocina en el Caribe insular\n" +
                "-Cocina cubana y coctelería\n" +
                "-Especias cubanas: una alternativa para el turismo\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Rubén Rodríguez González ");
        cv.put("avatar", R.mipmap.ruben_rodriguez );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1969");
        cv.put("biografia", "Narrador y periodista. Ha obtenido, entre otros, los premios Oriente, La Edad de Oro, Ismaelillo, Abril, La Rosa Blanca y de la Crítica Literaria.\n" +
                "\n" +
                "\n" +
                "Algunos de sus títulos: \n" +
                "                                  - Mimundo (Editorial Oriente, 2005)\n" +
                "                                  -Paca Chacón y la educación moderna (Editorial Oriente, 2007)\n" +
                "                                  -El garrancho de Garabulla (Editorial Oriente, 2009)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Marta Rojas ");
        cv.put("avatar", R.mipmap.marta_rojas );
        cv.put("ciudad", "Santiago de Cuba");
        cv.put("fecha", "1931");
        cv.put("biografia", "Escritora y periodista cubana de larga experiencia. Premio Nacional de Periodismo José Martí del año 1997. Ganadora del Premio Alejo Carpentier de novela 2006.\n" +
                "\n" +
                "Algunos de sus títulos: \n" +
                "                                  - El columpio de Rey Spencer (1993)\n" +
                "-Santa Lujuria (1998)\n" +
                "-El harén de Oviedo  (2003)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Steve Cushion  ");
        cv.put("avatar", R.mipmap.steve_cuschion );
        cv.put("ciudad", "Leyton, Inglaterra");
        cv.put("fecha", "1950");
        cv.put("biografia", "Doctor en Ciencias Históricas. Asociado del Institute of the Americas, University College, Londres. Fue profesor titular de la Universidad Metropolitana de Londres.\n" +
                "\n" +
                "Algunos de sus títulos: -\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", " Miguel Terry Valdespino  ");
        cv.put("avatar", R.mipmap.miguel_terry_valdespino );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1963");
        cv.put("biografia", "Narrador y periodista. Es licenciado en Periodismo por la Universidad de La Habana y trabaja actualmente como redactor jefe de la página cultural del periódico El Artemiseño. Miembro de la Upec y de la Uneac.\n" +
                "Algunos de sus títulos:\n" +
                "  - Ángeles y cenizas (Unicornio)\n" +
                "  - Laberinto de lobos (Unicornio)\n" +
                " -Los duros pierden como Humphrey Bogart (Unicornio)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Lourdes María González Herrero    ");
        cv.put("avatar", R.mipmap.lourdes_gonzalez );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1952");
        cv.put("biografia", "Varios textos suyos han sido traducidos al francés, inglés e italiano. Ostenta la distinción Por la Cultura Nacional. Es escritora de poesía y narrativa y ha obtenido importantes premios en ambos géneros destacándose el nacional de Poesía Julián del Casal, el Especial de Poesía Bicentenario de José María Heredia en 2003, y el Oriente de Novela José Soler Puig en 2005. \n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "-En la orilla derecha del Nilo\n" +
                "- Fijeza del Amor (Ediciones Holguín, 2002)\n" +
                " -Los días del verano (2003)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Rosa Hilda Zell (Adriana Loredo)   ");
        cv.put("avatar", R.mipmap.rosa_hilda_zell );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1910- 1970");
        cv.put("biografia", "Periodista, narradora, poetisa y traductora. En 1946 creó la sección “El menú de la semana”, la que firmaba como Adriana Loredo, en la revista Bohemia. Varios poemas suyos fueron seleccionados por Juan\n" +
                "Ramón Jiménez para su colección La poesía cubana en 1936.\n" +
                "\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "  -Cunda y otros poemas (1960)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Jorge Braulio Rodríguez Quintana (compilador)");
        cv.put("avatar", R.mipmap.jorge_braulio );
        cv.put("ciudad", "- La Habana");
        cv.put("fecha", "1950");
        cv.put("biografia", "Artista visual. Máster en Educación por el Arte. Fue decano de la Facultad de Artes Visuales, de la Universidad de las Artes-ISA.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "  - Todo en tres líneas (Gente Nueva, 2013)  \n" +
                "   -Cuaderno de Lucrecia (Ediciones Samandar, 2015)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Mariela Góngora Marrero ");
        cv.put("avatar", R.mipmap.mariela_gongora );
        cv.put("ciudad", "Holguín");
        cv.put("fecha", "1971");
        cv.put("biografia", "Psicoterapeuta rehabilitadora. Licenciada en Rehabilitación Social y Ocupacional, Máster en Medicina Bioenergética y Natural y en Reiki.\n" +
                "Algunos de sus títulos: -Yoga Manual Práctico (Ediciones Holguín, 2006 y Editorial Oriente, 2010)\n" +
                "  -Hatha Yoga para la ansiedad y las adicciones (Editorial Oriente, 2014) \n" +
                "  -Consejos de una psicoterapeuta (Ediciones Holguín, 2016)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Arnold August  ");
        cv.put("avatar", R.mipmap.arnold_august );
        cv.put("ciudad", "Canadá");
        cv.put("fecha", "");
        cv.put("biografia", "Periodista y conferencista canadiense. \n" +
                "Algunos de sus títulos: - Democracy in Cuba and the 1997-98 eleccions (Editorial José Martí, 1999)\n" +
                "  -Cuba y sus vecinos, democracia en movimiento (Editorial Ciencias Sociales, 2014)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Sindo Pacheco ");
        cv.put("avatar", R.mipmap.sindo_pacheco );
        cv.put("ciudad", "Cabaiguán");
        cv.put("fecha", "1956");
        cv.put("biografia", "Cuentos suyos han aparecido en varias revistas y antologías tanto en cuba como en el extranjero. Sus obras han sido reeditadas en Cuba, España, Colombia, Puerto rico y los Estados Unidos.  \n" +
                "Algunos de sus títulos: -Oficio de hormigas\n" +
                "  -Un pie en lo alto y otras encerronas\n" +
                " -Mañana es Navidad \n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", " Ramón Fajardo Estrada ");
        cv.put("avatar", R.mipmap.ramon_fajardo_estrada );
        cv.put("ciudad", "Bayamo");
        cv.put("fecha", "");
        cv.put("biografia", "Egresó de la Escuela de Periodismo de la Universidad de La Habana en 1976. Ese Año comenzó a trabajar en la emisora Radio Habana Cuba, donde se mantuvo más de tres décadas en la realización de programas culturales. Como resultado de tal labor recibiría cincuenta premios y reconocimientos entre ellos la Distinción por la Cultura Nacional y el Micrófono de la Radio Cubana \n" +
                "Algunos de sus títulos: -Rita Montaner (Letras Cubanas 1993)\n" +
                "  -Yo seré la tentación: María de los Ángeles Santana (Plaza Mayor, Puerto Rico 2003 y Letras cubanas 2013 y 2016)\n" +
                "   -Deja que te cuente de Bola (Ediciones Unión 2005 y Editorial Oriente 2012)\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", " Zeila Robert");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Ariel Fonseca Rivero  ");
        cv.put("avatar", R.mipmap.ariel_fonseca_rivero );
        cv.put("ciudad", "Sancti Spiritus");
        cv.put("fecha", "1986");
        cv.put("biografia", ": Narrador y poeta. Miembro de la Asociación Hermanos Saíz. Graduado del XIII Curso de Técnicas Narrativas Onelio Jorge Cardoso.\n" +
                "\n" +
                "Algunos de sus títulos:\n" +
                "  -…aquí Dios no está (Ediciones Luminaria, 2010)\n" +
                "  -El circo invisible (Editorial Oriente, 2014)                                \n" +
                "  -Hierbas (Ediciones La Luz, 2016)\n");
        operatingdb.insert("AUTORES", null, cv);
        cv.put("nombre", "Margarita Ruiz Peraza  ");
        cv.put("avatar", R.mipmap.margarita_ruiz );
        cv.put("ciudad", "La Habana");
        cv.put("fecha", "1945");
        cv.put("biografia", "Graduada como ingeniera eléctrica en la especialidad de Automática y Telemecánica en el Instituto Energético de Moscú (MEI) en 1969. Es máster en Ciencias Técnicas y en Economía Social, y en Dirección de Entidades sin Ánimo de Lucro. Ha realizado diplomados y postgrados en las especialidades de marketing.\n" +
                "\n" +
                "Algunos de sus títulos: -¡… y es bello vivir! (2005) \n" +
                "  -Historias de la Abuelita Ciencia (2010).\n");
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Graciela de la Caridad Chailloux Laffita (compiladora)");
        cv.put("avatar", R.mipmap.gracieladelacaridadchaillouxlaffita );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "Doctora en Ciencias. Profesora e Investigadora Titular de la Universidad de La Habana desde 1972 en las especialidades de Historia Económica y del Pensamiento Económico de Cuba, Relaciones Cuba-EEUU y Procesos Económicos, Políticos y Sociales en el Caribe. Actualmente se desempeña en la Casa de Altos Estudios de la Facultad de Filosofía e Historia de la misma universidad.\n" );
        operatingdb.insert("AUTORES", null, cv);


        cv.put("nombre", "Manuel G. Caluff ");
        cv.put("avatar", R.mipmap.manuelcaluff );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "Ficha biográfica: Artista de la plástica, ilustrador científico, diseñador y artesano, graduado de la Escuela Provincial de Artes Plásticas de Santiago de Cuba, en 1968. Creador y director, desde su fundación en 1976, del Jardín de los Helechos de Santiago de Cuba. Autor de numerosas publicaciones relacionadas con los helechos y las plantas afines, que tratan tema de sistemática, ecología, etnobotánica, corología, conservación y horticultura de estas plantas. \n" +
                "Algunos de sus títulos: -La magia de mi jardín (Editorial Oriente, 2012) \n" +
                "                       -Conservación de los licófitos y los helechos de las Antillas (Editorial Amigo del Hogar, 2012)\n \n" );
        operatingdb.insert("AUTORES", null, cv);

        cv.put("nombre", "Gustavo Shelton Serrano  ");
        cv.put("avatar", R.mipmap.logoeditorial );
        cv.put("ciudad", "");
        cv.put("fecha", "");
        cv.put("biografia", "Técnico Medio, veterinario de formación, se incorporó al Jardín de los Helechos de Santiago de Cuba en 1986 donde se desempeña como Auxiliar de Investigación y Administrador. Ha colaborado junto a Caluff, en la elaboración de numerosos trabajos científicos. Posee una vasta experiencia en el cultivo de los licófitos y los helechos. \n \n" );
        operatingdb.insert("AUTORES", null, cv);


    }
}



