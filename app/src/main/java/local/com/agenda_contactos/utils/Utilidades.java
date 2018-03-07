package local.com.agenda_contactos.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 06/03/2018.
 */
//En esta clase crearemos metodos para mensajes de tipo Toast o otros para mostrar en cualquiera de
    //las otras clases
public class Utilidades {
    /**
     * Muesttra un toast con un mensaje para el usuario
     * @param context (Representa el contexto donde se va a mostrar el mensaje
     * @param mensaje (Mensaje del usuario)
     */
    /**
     *
     * @param context
     * @param mensaje
     */
    //El "context" es el nombre con el que se reconoces este Contexto, para poder
    //mostrarlo en diferentes layouts
    public void mostrarToast(Context context, String mensaje){
        Toast.makeText(context,mensaje,Toast.LENGTH_LONG).show();
    }
}
