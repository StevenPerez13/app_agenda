package local.com.agenda_contactos.Constantes;

/**
 * Created by user on 05/03/2018.
 */

public class Constantes {
    //TODO: Constantes para nuestra base de datos
    //EL DATABASE_NAME hace referencia al nombre de la base de datos
    //El DATABASE_VERSION hacer referencia a la version de la base de datos
    // como es la primera la version es 1
    // public static final String DATABASE_NAME es una varible constante, es decir que nunca cambia
    public static final String DATABASE_NAME ="BaseDatosContactos";
    public static final int DATABASE_VERSION =1;

    //TODO: Nombre de las tablas de la base de datos
    public static final String Contacto_tabla = "TablaContactos";

    //TODO: Campos de la Tabla, estos son literales, no son valores, mejor dicho son los encabezados
    //de las columna de la tabla, una va a ser para nombre, edad y email.
    public static final String Campo_Nombre = "Nombre";
    public static final String Campo_Email = "Email";
    public static final String Campo_Edad = "Edad";
    public static final String Campo_Id ="Id";
}
