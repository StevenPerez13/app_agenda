package local.com.agenda_contactos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 28/02/2018.
 */
public class Buscarapp extends AppCompatActivity {
    ArrayList<Contacto>miagenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hacemos lo del set para poder visualizar el layout.
        setContentView(R.layout.layout_buscar);
        //Creamos el intent para pasar los datos del array que esta en el principal al array que
        //creamos aqui. Lo mismo que en el boton Agregar
        Intent intent = this.getIntent();
        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda_B");
    }
    public void buscar(View v){
        //Pasamos los datos ingresado en el email de buscar a la variable creada "emailb"
        String emailb=((EditText)findViewById(R.id.txte_email2)).getText().toString();
        Contacto contactoencontrado =null;
        //Con este for mejorado recorremos el array de tipo Contacto, para buscar el contacto deseado
        //Este es un array de tipo contacto??
        //Como se guardan los datos, en el array o en Contacto?
        for(Contacto c: miagenda){
            //Con el if preguntamos si el contacto guardado en el array, el cual estamos recorriendo,
            //es igual al email ingresado "emailb".
            if(c.getEmail().equals(emailb)){
                //Si es igual guardamos el contacto encontrado o el c[i], en el objeto "contactoencontrado"
                contactoencontrado=c;
                //Escribimos el break para salir del if y el for al encontrarlo
                break;
            }
        }
        MostrarDatos(contactoencontrado);

    }
    //Porque ponemos lo del view?
    public void salir(View v){
        this.finish();
    }
    //Creamos un metodo donde vamos a mostrar el contacto encontrado en un cuadro de dialogo
    public void MostrarDatos(Contacto contactoencontrado ){
        //Primero preguntamos si el contacto encontrado existo o no,
        //Si es nulo. mostramos un mensaje como un toast
        if(contactoencontrado==null){
            //Si es nulo creamos un dialogo de alerta, el cual se escribe AlertDialog que es una
            //clase por defecto y ponemos el AlertDialog.Builder para poder crear un dialogo de
            //alerta y le ponemos el nombre a la instancia, en este caso "mensaje"
            AlertDialog.Builder mensaje = new AlertDialog.Builder(
            this);
            //en esta linea al objeto creado, le agregamos el mensaje que se mostrara en el cuadro
            //de dialogo
            mensaje.setMessage("Esta contacto no se encuentra, ¿Repetimos?");
            //en caso de que diga que no, salimos de la actividad y debemos poner el "android.R.string.no"
            //para mostrar esta opcion en el cuadro de dialogo
            //osea el "android.R.string.no" es para mostrar en el cuadro de dialogo "Cancel", si queremos mostrar
            //"mejor ahora no" en lugar de poner "android.R.string.no" ponemos "mejor ahora no" y nos los mostrara en
            //el cuadro de dialogo
            //a continuacion con el " ,new DialogInterface.OnClickListener()" le estamos añadiendo un funcion
            //o un proceso que debe realizar al pulsar este boton, en este caso cerrariamos el layout con
            //el "Buscarapp.this.finish();"
            mensaje.setNegativeButton("Mejor ya no",
            //mensaje.setNegativeButton(android.R.string.no
            new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Buscarapp.this.finish();
                    Log.d("RESULTADO::","sI FUNCIONA");
                }
                //y todo este proceso va dentro de mensaje.setNegativeButton() por eso cerramos con
                //el parentesis y luego va el ;
            });
            //Y en caso de que sea positivo no hacemos ningun proceso sino que vuelve a
            //reiniciar el layout, por eso ponemos el "null" porque no le agregamos niguna actividad
            mensaje.setPositiveButton("Bueno wey!!",null);
            mensaje.show();
        }
        //Ahora si lo encuentra al contacto
        else {
            //Creamos un string datos donde vamos a almacenar lo que vamos a presentar, como cuando
            //se lo quiere hacer con el JOptionPane y de ahi en lugar de añadir a un JOptionPane como
            //seria con eclipse, lo agregamos a un toast
            String datos="Nombre: " + contactoencontrado.getNombre()
                    +"\nEmail: "+contactoencontrado.getEmail()
                    +"\nEdad: "+contactoencontrado.getEdad();
            //El toast es un mensaje flotante que dura un cierto tiempo.
            //El Toast.makeText
            //en el "context: this" nos referimos a que trabajamos con este layout,
            //y el get.AplicationContext() se refiere a que trabaja con todos los layouts o todas
            //clases
            //",datos" lo ponemos porque ese es el mensaje que mostrara, en este caso hacemos referencia
            //a la variable creada datos
            //EL "Toast.LENGTH_LONG" hace referencia a el tiempo que se mostrara el Toast
            //y ponemos al final ".show" para mostrar el Toast
            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();
        }


    }
}
