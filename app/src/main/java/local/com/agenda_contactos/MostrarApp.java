package local.com.agenda_contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 28/02/2018.
 */
public class MostrarApp extends AppCompatActivity {
ArrayList<Contacto>agendam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_salir);
        //Creamos el intent para pasar los datos del array del principal a el array de este layout
        Intent intent = this.getIntent();
        agendam=(ArrayList<Contacto>)intent.getSerializableExtra("agenda_M");
        //Creamos la variable datos para mostrar todos los datos juntos, como en JOptionPane
        String datos ="";
        //Creamos una variable de tipo TextView para recoger los datos que hay en en el txtviewMostrarDatos
        TextView txtvListado=findViewById(R.id.txtviewMostrarDatos);
        //Hacemos un for para recorrer el array, que hemos creado para este layout,
        //donde hemos pasado los datos o contactos
        for(Contacto listado:agendam){
            //Almacenamos cada dato del contacto para mostrar
            datos+="Nombre: "+listado.getNombre()+"\nEmail: "+listado.getEmail()+"\nEdad: "+listado.getEdad()+"\n";
        }
        //En el textview mostramos los datos
        txtvListado.setText(datos);
    }
//Con este salimos del layout o clase
    public void Salirlistado(View v){
        this.finish();
    }
}
