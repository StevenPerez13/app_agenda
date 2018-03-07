package local.com.agenda_contactos;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import java.util.ArrayList;

public class AgendaContactos extends AppCompatActivity  implements View.OnClickListener{

    //Creamos variables donde almacenaremos los datos de los botones, que aparecene
    //en el Layout
    Button btnAñadir;
    Button btnBuscar;
    Button btnMostrartodo;

    //Creamos un array donde se almacenaran todos los contactos ingresados
    //y el array que creamos en vez de ser de tipo String, crearemos un array de tipo
    //Contacto, el cual es la clase que creamos anteriormente

    //Creamos un array llamado "agenda" en el principal y en el resto de ventanas crearemos
    //otro array pero con distinto nombre, para cuando reiniciemos la app, los valores que se
    //guardan en el array no se borren, porque cuando cambiamos de layout, el array borra todos
    //sus datos, entonces antes de pasar al menu otra vez, pasamos los datos del array del layout al
    //array del principal.
    ArrayList<Contacto> agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Con este setContentView(R.layout.activity_agenda_contactos)
        //mostramos lo que se encuentra en este layout
        //La línea setContentView(R.layout.activity_agenda_contactos); señala que hay una clase estática llamada R.layout y,
        // que dentro de esa clase hay una constante entera llamada activity_agenda_contactos que apunta a una vista definida
        // por un  fichero de recursos layout xML. El nombre del fichero XML es activity_agenda_contactos.xml,
        // el cual debe estar en el directorio ./res/layout.
        setContentView(R.layout.activity_agenda_contactos);
        //Agregamos lo del boton en la variable creada
        btnAñadir=findViewById(R.id.btnAñadirp);
        //Tengo que hacer obligado esto, para poder
        //conseguir que el boton corra o se ejecute al hacer click,
        //si no ponemos este .setOnCliclListener(this), el boton no hara nada
        //cuando hagamos Click, el this lo ponemos apra referirnos a este boton. que esta en este
        // Layout
        btnAñadir.setOnClickListener(this);

        //Hacemos lo mismo con el resto de botones
        btnBuscar=findViewById(R.id.btnBuscarp);
        btnBuscar.setOnClickListener(this);

        btnMostrartodo=findViewById(R.id.btnMostrarp);
        btnMostrartodo.setOnClickListener(this);

        //Hacemos la instancia del array, o mejor dicho lo creamos para poder usarlo
        //Este seria como cuando hacemos una instancia de objeto en Java
        //Con el new Arraylist<Contacto>() Creamos el array de tipo Contacto, entre < >,
        //ahi que poner el tipo
        agenda = new ArrayList<Contacto>();
    }

    @Override
    public void onClick(View view) {
        //Hacemos un switch para hacer la operacion o el proceso dependiendo del
        //boton que escogamos, ponemos el view.getId(), en referencia al view, el
        //cual es una instancia que creamos al principio de este metodo con el View view
        //y el .getId(), para escoger dependiendo del id que tenga cada boton, el id es lo
        //que diferencia los botones, textos, etc. El id se lo pone en el proceso de
        //creacion en el Layout, en cada elemento que usemos
        switch (view.getId()){
            //Aqui hacemos un cierto proceso en caso de que el boton pulsado sea Añadir,
            //Sabemos que es el boton Añadir, por su id, para hacer referencia a un
            //objeto del layout debemos poner siempre R.id.NombredelObjeto.
            case R.id.btnAñadirp:
                //Crearemos un metodo para abrir el activity agregar, y guardar en Base de Datos,
                //Usaremos el intent pero no pasaremos ni valores ni nada no usaremos arralist

                //No usamos el startActivityForResult, porque ya no vamos a recibir datos
                //de ningun array.
                /*Intent intent = new Intent(this, AgregarContactosapp.class);
                intent.putExtra("agenda_A",agenda);
                this.startActivityForResult(intent,1);
                for (Contacto contacto : agenda){
                    if(contacto!=null){
                        Log.d("TAG:", "nOMBRE: "+contacto.getNombre());
                    }
                    else{
                        Log.d("TAG", "Agenda o contactos ingresados son nulos " );
                    }
                }*/
                abrirParaInsertarEnBaseDatos();

                break;
            case R.id.btnBuscarp:
                //Se le pone otro nombre al intent creado, porque en un mismo proceso, no
                //puedes tener dos o mas intent con el mismo nombre
                Intent intent = new Intent(this, Buscarapp.class);
                //Ponemos otro nombre para diferenciarlos del resto, si pones el mismo name, no pasa nada
                //no sale error
                intent.putExtra("agenda_B",agenda);
                this.startActivity(intent);
                break;
            case R.id.btnMostrarp:
                //Lo mismo que antes
                intent = new Intent(this,MostrarApp.class);
                intent.putExtra("agenda_M",agenda);
                this.startActivity(intent);
                break;
        }

    }
    //Creamos  el protected void onActivityResult(int requestCode, int resultCode, Intent data)
    //el cual es un metodo que nos devuelve un resultado, en este caso nos devolvera el resultado
    //de los layouts con los que trabajemos, es decir con Agregar, Buscar, Mostrar, mas abajo explico esto.
    //El int requestCode es el código de solicitud que pasaste a startActivityForResult(). o mejor dicho
    //el codigo del StartActivity  es el resultado que nos lanzan desde las otras actividades o layouts
    //El resultCode es un código de resultado especificado por la segunda actividad. Este código puede ser
    // RESULT_OK si la operación se realizó correctamente o RESULT_CANCELED si el usuario canceló la
    // operación o esta falló por algún motivo.
    //El Intent data es un Intent con la información del resultado

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //En esta linea estamos diciendo que mi array Agenda sera = a los datos que tenga en el Itent creado
        //en los otros layouts, en este caso el Itent se llama "mi agenda", el cual sera el array que crearemos
        //en los otros layouts o clases.
        //El data.getSerializableExtra("mi agenda"), me consigue los datos que tengo en ese Itent.
        //El getSerializableExtra es lo mismo que getExtra, solo que con el Serializable porque los datos estan en Bytes?
        //El SerializableExtra ccnvierte los datos de "mi agenda" en Bytes, para que sea mas facil el pase de datos
        //El (ArrayList<Contacto>) convierte los datos que estan en bytes a los tipos de datos que esta el array.
        //El data. es el intent creado al principio (int requestCode, int resultCode, Intent data), lo usamos para
        //pasar los datos.
        agenda= (ArrayList<Contacto>)data.getSerializableExtra("miagenda");
    }*/
    public void abrirParaInsertarEnBaseDatos(){
        Intent intent = new Intent(this,AgregarContactosapp.class);
        startActivity(intent);

    }
}
