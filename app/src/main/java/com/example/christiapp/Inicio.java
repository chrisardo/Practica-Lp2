package com.example.christiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    private TextView txtusuario;
    //ListView
    private TextView tv1;
    private ListView lv1;

    //Creando vectores y llenando datos al listView
    String nombres[] = {"Christian", "Eduardo", "Alejandro", "Melannie", "Martha", "Katia"};
    String edades[] = {"20", "20", "10", "23", "17", "40"};

    //Spinner
    private Spinner spinner;
    private TextView TV2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Poner en el action bar: icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.images);//indicando en donde esta la imagen

        txtusuario = (TextView)findViewById(R.id.Inicio);
        //Obteniendo datos del primer MainActivity
        String nombre = getIntent().getStringExtra("DatoUsuario");
        String Etusuario = getIntent().getStringExtra("DatoUsuario");
        setTitle(nombre);
        //txtusuario.setText("Bienvenido: " + nombre);
       //txtusuario.setText("Bienvenido: "+ Etusuario);

        //Para el listView
        tv1 = (TextView)findViewById(R.id.textView);
        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item_christian, nombres );
        lv1.setAdapter(adapter);//Mostrandotodo lo configurado en el objeto adapter
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText(" Nombre: "+ lv1.getItemAtPosition(position) +"\n" + " Edad: " + edades[position]);
            }
        });





        //Spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        TV2 = (TextView)findViewById(R.id.tV2);
        String SpinnerSemana[] = {"Seleccion día", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};

        ArrayAdapter <String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_christian, SpinnerSemana);
        spinner.setAdapter(spinnerAdapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //Toast.makeText(parent.getContext(), "Dia: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
               TV2.setText("Seleccion: "+ parent.getItemAtPosition(position).toString());
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }

    //Metodo para mostrar los botones de accion
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Metodo para asignar las funciones coreespondientes a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.Editar){
            Toast.makeText(getApplicationContext(),"Editar", Toast.LENGTH_LONG).show();
        }else if (id == R.id.salir){
            Toast.makeText(getApplicationContext(), "Salir", Toast.LENGTH_LONG).show();
            Intent IrMainCativity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(IrMainCativity);
        }else if(id == R.id.buscar){
            Toast.makeText(getApplicationContext(), "Buscar", Toast.LENGTH_LONG).show();
           // Intent recycleView = new Intent(getApplicationContext(), RecyclerVewActivity.class);

        }else if (id == R.id.compartir){
            Toast.makeText(getApplicationContext(), "Compartir", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
