package local.com.agenda_contactos;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

import local.com.agenda_contactos.model.UtilsContactos;
import local.com.agenda_contactos.utils.Utilidades;

/**
 * Created by user on 28/02/2018.
 */


public class AgregarContactosapp   extends AppCompatActivity {
    //ArrayList<Contacto>miagenda;
    EditText nombre_a;
    EditText email_a;
    EditText edad_a;
    //Creamos referencia para usar los metodos de la clase utilidades.
    Utilidades u = new Utilidades();
    //Para que no salga error al llamar al String campos_vacios en el Toast, mirar en el
    //metodo AgregarContactosBD()
    //Al crear este objeto podemos acceder a las Strings que hemos creado.
    //Resources rs= getResources();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agregar);

        //Intent intent = this.getIntent();
        //miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda_A");
        //Creamos la variable donde almacenaremos los datos que ingresamos en el edittext
        nombre_a=(EditText)findViewById(R.id.txte_Nombre1);
        email_a=(EditText)findViewById(R.id.txte_email1);
        edad_a =(EditText) findViewById(R.id.txte_edad1);
    }
   /* public void guardar(View v){

        String nombre= nombre_a.getText().toString();
        String emailnuevo=email_a.getText().toString();

        int edad= Integer.parseInt(edad_a.getText().toString());

        Contacto c= new Contacto(nombre,emailnuevo,edad);

        miagenda.add(c);

        Intent intent = new Intent();

        intent.putExtra("miagenda",miagenda);

        this.setResult(0,intent);
        this.finish();
    }*/
    /*public void volver(View v){
        //Ponemos el this.finish(); para finalizar esta clase o layout y volver al principal
        this.finish();
    }*/
    //TODO: vamos a crear un metodo para insertar registro en la Base de Datos
    public void AgregarContactosBD(View v){
        //Compruebo si los valores ingresado en los edittext no esten vacios
        //Consulta lo del TextUtils.isEmpty, aunque tu grandioso profe dice que es para comprobar
        //si los edittext estan vacios
        if(TextUtils.isEmpty(nombre_a.getText())
                || TextUtils.isEmpty(email_a.getText())
                || TextUtils.isEmpty(edad_a.getText()) ){
            //Mostramos los mensajes que hemos creado en la carpeta res/values/strings.xml y del
            //cual hemos sacado la traduccion en español que esta en la misma carpeta res/values-es/
            //strings.xml. Comprueba el google Keep en SQL.

            //Mostramos mensajes de error "Campos Vacios"
            //De esta manera nos mostrara el mensaje en ingles o español dependiendo del idioma en
            //que tenga el usuario el idioma de su movil
               // u.mostrarToast(this, rs.getString(R.string.campos_vacios));
        }
        else{
            //Variables para recoger valores
            String nombre= nombre_a.getText().toString();
            String email = email_a.getText().toString();
            int edad = Integer.parseInt(edad_a.getText().toString());
            //creamos objeto contacto
            Contacto c=new Contacto(nombre, email, edad);
            //creamos un UtilsContactos y añadimos
            //el nuevo contacto
            UtilsContactos gestion=new UtilsContactos(this);
            gestion.InsertarContacto(c);
            //cerramos la base de datos
            gestion.close();
            //finalizamos la act
            this.finish();
        }
    }
}
