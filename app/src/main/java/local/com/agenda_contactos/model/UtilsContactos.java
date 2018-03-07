package local.com.agenda_contactos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import local.com.agenda_contactos.Constantes.Constantes;
import local.com.agenda_contactos.Contacto;

/**
 * Created by user on 05/03/2018.
 */

public class UtilsContactos {
    //Atributos
    private SQLiteDatabase db=null;//Creamos una instancia "db" de tipo SQLiteDataBase, que usaremos
    //a continuacion, este objeto es el que usaremos para poder escribir, buscar o elminar en la
    // base de datos
    private BaseDatosContactos dbcontactos=null;//Lo mismo aqui solo que de tipo de la clase BaseDatosContactos
    //Contexto
    Context context;
    //TODO: Constructor de nuestra clase
    // para instanciar la clase "BaseDatosContactos"
    // y usar los metodos para escribir en nuestra basde de datos
    public UtilsContactos(Context contexto){
        //Esto es para referirno a que el contexto que esta en la clase BaseDatosContactos sera
        // se utilizara en esta clase aqui. Ese "context" es el contexto que creamos en la clase
        // BaseDatosContactos
        this.context=contexto;
        //crea una instancia del helper
        dbcontactos=new BaseDatosContactos(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos, de esta manera podemos escribir en la base de datos
        //agregar contactos.
        db=dbcontactos.getWritableDatabase();
    }
    //TODO: Cerramos la base de datos
    public void close(){
        dbcontactos.close();
    }

    //TODO: Insertamos en la base de datos
    public long InsertarContacto(Contacto c ){
        //TODO: Usamos un objeto de tipo ContentValues para guardar todos las keys de cada campo
        // de nuestro contacto e insertarlo en una tabla.
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());

        //Este metodo lo usas para añadir datos en una tabla de la base de datos. Al invocar el
        // insert(String table, String nullColumnHack, ContentValues values), es necesario definir 3 paramatetros:
        //table: Nombre de la tabla en la que insertamos un registro
        //nullColumHack: solo es necesario en casos muy puntuales, por ejemplo al insertar registros completamnete vacios
        //.Normalmente se debe indicar el valor null en este segundo parametro.
        //values: valores del registro que se inserta.
        return db.insert(Constantes.Contacto_tabla,
                null,
                initialValues);
    }
    //TODO: metodo para recuperar un contacto
    //devolviendo un resultado de tipo query
    //Una QUERY: es una consulta
    public Cursor recuperarContactos(){
        return db.query("contactos",
                new String[]{Constantes.Campo_Id,Constantes.Campo_Nombre,Constantes.Campo_Email,Constantes.Campo_Edad},
                null,
                null,
                null,
                null,
                null);
    }


    public Contacto buscarPorEmail(String email){
        Contacto con=null;
        //creamos un cursor para guardar un query de seleccion y un criterio para el
        //campo email=?
        //Cursor: es un objeto con varias filas. (Referido a tabla de Base de datos)
        Cursor c=db.query(Constantes.Contacto_tabla,
                new String[]{Constantes.Campo_Id,
                        Constantes.Campo_Nombre,
                        Constantes.Campo_Email,
                        Constantes.Campo_Edad},
                //EL "=?" lo ponemos para buscar por Email, es un codigo
                //Se pone el Constantes.Campo_Email, porque aqui se busca el email
                // y debe ir siempre el "=?", El "buscarPorEmail(String email)",
                // "Constantes.Campo_Email+"=?" y el "new String[]{email}," deben tener la misma
                // variable, la primera es el tipo que recibe este metodo, la segunda es la variable
                // o campo que buscamos y la tercera es la misma que la del principio es el valor,
                // que estara dentro del array, ponemos email porque es el valor que recibimos
                // incluso podriamos agregar "new String[]{email, "coche", "mono"}".
                Constantes.Campo_Email+"=?",
                new String[]{email},
                null,
                null,
                null);
        //Va de 1 en 1, pasando contacto a contacto
        if(c.moveToNext()){
            //Pone c.getString(i : 1),c.getString(i :2),c.getInt(i: 3), se refiere a cada columna
            //de la tabla de la base de datos. En la columna 0 va el ID por eso no hacemos caso,
            //la columna 1 es la de nombre por eso es String, la 2 es Email y la 3 es la edad, por
            //eso ponemos int.
            con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
        }
        return con;
    }

}
