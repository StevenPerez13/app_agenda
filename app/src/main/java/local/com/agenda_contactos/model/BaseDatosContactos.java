package local.com.agenda_contactos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import local.com.agenda_contactos.Constantes.Constantes;

/**
 * Created by user on 05/03/2018.
 */
//SQLiteOpenHelper: es una clase de Android, la cual tiene varios metodos para Bases de Datos y
// nuesta clase hereda de SQLiteOpenHelper.
//En esta clase vamos a crear la base de datos, las cuales son SQL por eso ponemos el SQL y
public class BaseDatosContactos extends SQLiteOpenHelper{
    //TODO:Vamos a crear nuestrar constantes para eliminar y crear tabla de Contactos
    //Lo que esta en comillas y en Ingles, se debe escribir de esta manera porque esto va ir
    //al SQL.
    private static final String CREAR_TABLA_CONTACTOS =
            "CREATE TABLE "+Constantes.Contacto_tabla +
                    " ("+Constantes.Campo_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +Constantes.Campo_Nombre+" TEXT NOT NULL, "
            +Constantes.Campo_Email+  " TEXT NOT NULL, "
            +Constantes.Campo_Edad +  " INTEGER NOT NULL)";

    private static final String ELIMINAR_TABLA_CONTACTOS =
            "DROP TABLE IF EXISTS "+Constantes.Contacto_tabla;
    //TODO: Vamos a implementar el Constructor

    //Context context Es para poder llamar a esta clase a partir de cualquier otra y usarlo y cuando
    //queremos usarla por ejemplo en la clase principal, para llamar al context ponemos "this"
    public BaseDatosContactos(Context context) {
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
    }

    //TODO: El metodo onCreate se llama al crear
    //Creamos estos metodos dentro de la base de datos. Este metodo es para crear en la Base de DATOS
    @Override
    public void onCreate(SQLiteDatabase db) {
    //Invocamos al metodo createTables
        createTables(db);

    }

    //Creamos estos metodos dentro de la base de datos. Este es para actualizar
    //este método es llamado si a la hora de crear el DataBaseHelper
    //se pasa una versión superior a la ya existente
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //reconstruimos la tabla, primero eliminamos y luego creamos
        deleteTables(db);
        createTables(db);
    }

    //TODO: usamos un metodo para crear nuestra tabla
    //EL "db" es un objeto de tipo SQLiteDatabase, la cual es una clase de Android
    //con el "db" ejecutamos un instruccion SQL para crear nuestra tabla en este caso "db.execSQL"
    private void createTables(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CONTACTOS);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(ELIMINAR_TABLA_CONTACTOS);

    }
}
